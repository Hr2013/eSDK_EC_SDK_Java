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
package com.huawei.esdk.ec.north.rest.app.resource.ctc;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.ctc.CTCService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.Terminal;
import com.huawei.esdk.ec.north.rest.app.resource.ctc.convert.CTCResourceConvert;
import com.huawei.esdk.ec.north.rest.bean.AddAttendeeResponse;
import com.huawei.esdk.ec.north.rest.bean.ConferenceInfo;
import com.huawei.esdk.ec.north.rest.bean.DelAttendeeResponse;
import com.huawei.esdk.ec.north.rest.bean.ResHeaderBean;
import com.huawei.esdk.ec.north.rest.bean.UpdateAttendeeRequest;
import com.huawei.esdk.ec.north.rest.bean.UpdateAttendeeResponse;
import com.huawei.esdk.ec.north.rest.bean.ctc.QueryAttendenceResBean;
import com.huawei.esdk.ec.north.rest.bean.ctc.QueryAttendenceResBody;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/appserver/ctc_attendee")
public class CTCAttendeeResource
{
    private static final Logger LOGGER = Logger.getLogger(CTCAttendeeResource.class);
    
    private static final CTCResourceConvert ctcResourceConvert = new CTCResourceConvert();
    
    private static final CTCService ctcService = new CTCService();
    
    /**
     * 添加与会者
     * @param confInfo
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AddAttendeeResponse addAttendee(ConferenceInfo confInfo)
    {
        AddAttendeeResponse response = new AddAttendeeResponse();
        
        if (null == confInfo || StringUtils.isEmpty(confInfo.getConfId())
            || null == confInfo.getInvitees() || confInfo.getInvitees().isEmpty())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result = ctcService.addAttendee(ctcResourceConvert.getAttendeeRest2Model(confInfo));
            
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
     * 踢出与会者
     * @param confInfo
     * @return
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public DelAttendeeResponse delAttendee(@QueryParam("confId") String confId, @QueryParam("cee") String cee)
    {
        DelAttendeeResponse response = new DelAttendeeResponse();
        
        if (StringUtils.isEmpty(confId) || StringUtils.isEmpty(cee))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result = ctcService.delAttendee(ctcResourceConvert.getAttendeeRest2Model("", confId, cee));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("delAttendee method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("delAttendee method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 修改与会者会议话语权
     * @param attendee
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UpdateAttendeeResponse updateAttendee(UpdateAttendeeRequest attendee)
    {
        UpdateAttendeeResponse response = new UpdateAttendeeResponse();
        
        if (null == attendee || StringUtils.isEmpty(attendee.getConfId())
            || StringUtils.isEmpty(attendee.getCee()) || StringUtils.isEmpty(attendee.getAuth()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        if(!"0".equals(attendee.getAuth()) && !"1".equals(attendee.getAuth()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        
        try
        {
            int authType = Integer.parseInt(attendee.getAuth());
            SDKErrorCode result =
                ctcService.updateAttendee(attendee.getAccount(), attendee.getConfId(), attendee.getCee(), authType);
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("updateAttendee method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("updateAttendee method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 查询CTC会议与会成员
     * @param confId
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryAttendenceResBean getAttendee(@QueryParam("confId") String confId)
    {
        QueryAttendenceResBean response = new QueryAttendenceResBean();
        ResHeaderBean header = new ResHeaderBean();
        response.setHeader(header);
        
        if (StringUtils.isEmpty(confId))
        {
            header.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            header.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<List<Terminal>> result = ctcService.getAttendee(confId);
            header.setResultCode(String.valueOf(result.getErrCode()));
            header.setResultContext(StringUtils.avoidNull(result.getDescription()));
            QueryAttendenceResBody body = ctcResourceConvert.getAttendeeModel2Rest(result);
            if (null != body)
            {
                response.setBody(body);
            }
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("getAttendee method SDK error", e);
            header.setResultCode(String.valueOf(e.getSdkErrCode()));
            header.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("getAttendee method error", e);
            header.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            header.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
        
    }
    
}
