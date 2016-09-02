/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ec.north.rest.bmu.resource.attendee;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.attendee.AttendeeService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.bean.QueryAttendeeInfoList;
import com.huawei.esdk.ec.north.rest.bean.AttendeeRequest;
import com.huawei.esdk.ec.north.rest.bean.QueryAttendeeResponse;
import com.huawei.esdk.ec.north.rest.bean.RestErrCode;
import com.huawei.esdk.ec.north.rest.bmu.resource.attendee.convert.AttendeeResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/bmu/attendee")
public class AttendeeResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(AttendeeResource.class);
    
    /**
     * 与会人服务层对象
     */
    private static final AttendeeService ATTENDEE_SERVICE = new AttendeeService();
    
    /**
     * 与会人源转换对象
     */
    private static final AttendeeResourceConvert ATTENDEE_RESOURCE_CONVERT = new AttendeeResourceConvert();
    
    /** 
    * 添加与会人
    * 
    * @param attendeeRequest 与会者信息
    * @return RestErrCode 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode addAttendee(AttendeeRequest attendeeRequest)
    {
        RestErrCode response = new RestErrCode();
        
        // 参数判空
        if (isEmptyAttendeeRequest(attendeeRequest))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result =
                ATTENDEE_SERVICE.addAttendee(ATTENDEE_RESOURCE_CONVERT.getAddAttendeeRest2Model(attendeeRequest));
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("addAttendee method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("addAttendee method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /** 
     * 修改与会人
     * 
     * @param attendeeRequest 与会者信息
     * @return RestErrCode 操作结果JSON对象
     * @see [类、类#方法、类#成员]
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode modifyAttendee(AttendeeRequest attendeeRequest)
    {
        RestErrCode response = new RestErrCode();
        
        // 参数判空
        if (isEmptyAttendeeRequest(attendeeRequest))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result =
                ATTENDEE_SERVICE.modifyAttendee(ATTENDEE_RESOURCE_CONVERT.getAddAttendeeRest2Model(attendeeRequest));
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("modifyAttendee method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("modifyAttendee method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /** 
    * 查询与会人列表
    * 
    * @param userId 操作用户
    * @param gwIp 网关IP
    * @param confNo 用户姓名或账号
    * @param pageNum 当前页数
    * @param pageCount 分页大小
    * @return QueryAttendeeResponse 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryAttendeeResponse queryAttendee(@QueryParam("userId") String userId, @QueryParam("gwIp") String gwIp,
        @QueryParam("confId") String confId, @QueryParam("pageNum") String pageNum,
        @QueryParam("pageCount") String pageCount)
    {
        QueryAttendeeResponse response = new QueryAttendeeResponse();
        
        // 参数判空
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(gwIp) || StringUtils.isEmpty(confId)
            || StringUtils.isEmpty(pageCount) || StringUtils.isEmpty(pageNum))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        // 分页大小和当前分页小于1，参数非法
        //if (pageCount < 1 || pageNum < 1)
        //{
        //    response.setResultCode(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE);
        //    response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
        //    return response;
        //}
        
        try
        {
            int pageCountTemp = Integer.parseInt(pageCount);
            int pageNumTemp = Integer.parseInt(pageNum);
            
            SDKResult<QueryAttendeeInfoList> result =
                ATTENDEE_SERVICE.queryAttendee(userId, gwIp, confId, pageCountTemp, pageNumTemp);
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            if (0 == result.getErrCode() && null != result.getResult())
            {
                response.setQueryAttendeeInfoList(ATTENDEE_RESOURCE_CONVERT.getQueryAttendeeModel2Rest(result.getResult()));
            }
            
            return response;
        }
        catch (NumberFormatException e)
        {
            // 参数错误
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryAttendee method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryAttendee method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    private boolean isEmptyAttendeeRequest(AttendeeRequest attendeeRequest)
    {
        if (null == attendeeRequest)
        {
            return true;
        }
        
        if (StringUtils.isEmpty(attendeeRequest.getAccount()) || StringUtils.isEmpty(attendeeRequest.getAttNumber())
            || StringUtils.isEmpty(attendeeRequest.getAttType()) || StringUtils.isEmpty(attendeeRequest.getConfId())
            || StringUtils.isEmpty(attendeeRequest.getSubPbx()) || StringUtils.isEmpty(attendeeRequest.getUserId())
            || StringUtils.isEmpty(attendeeRequest.getGwIp()))
        //|| StringUtils.isEmpty(attendeeRequest.getAttStatus()) 
        //|| StringUtils.isEmpty(attendeeRequest.getEmail()) 
        //|| StringUtils.isEmpty(attendeeRequest.getSpeakStatus())
        {
            return true;
        }
        
        return false;
    }
}
