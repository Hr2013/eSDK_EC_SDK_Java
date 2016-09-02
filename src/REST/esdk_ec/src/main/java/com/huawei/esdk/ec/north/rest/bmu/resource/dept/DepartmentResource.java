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
package com.huawei.esdk.ec.north.rest.bmu.resource.dept;

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

import com.huawei.esdk.ec.business.professional.rest.dept.DepartmentService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.Department;
import com.huawei.esdk.ec.domain.model.bean.QueryDepartmentInfoList;
import com.huawei.esdk.ec.north.rest.bean.AddDepartmentResponse;
import com.huawei.esdk.ec.north.rest.bean.DepartmentRequest;
import com.huawei.esdk.ec.north.rest.bean.QueryDepartmentResponse;
import com.huawei.esdk.ec.north.rest.bean.RestErrCode;
import com.huawei.esdk.ec.north.rest.bmu.resource.dept.convert.DepartmentResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 部门资源对象
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK UC V100R003C30]
 */
@Path("ec/bmu/department")
public class DepartmentResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(DepartmentResource.class);
    
    /**
     * 部门服务层对象
     */
    private static final DepartmentService DEPARTMENT_SERVICE = new DepartmentService();
    
    /**
     * 部门资源转换对象
     */
    private static final DepartmentResourceConvert DEPARTMENT_RESOURCE_CONVERT = new DepartmentResourceConvert();
    
    /** 
    * 新增部门
    * 
    * @param departmentRequest 部门入参，包括操作用户、父部门ID，部门名称
    * @return AddDepartmentResponse 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AddDepartmentResponse addDepartment(DepartmentRequest departmentRequest)
    {
        AddDepartmentResponse response = new AddDepartmentResponse();
        
        // 参数判空
        if (null == departmentRequest || StringUtils.isEmpty(departmentRequest.getUserId())
            || StringUtils.isEmpty(departmentRequest.getParentId())
            || StringUtils.isEmpty(departmentRequest.getDepartmentName()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<Department> result =
                DEPARTMENT_SERVICE.addDepartment(departmentRequest.getUserId(),
                    departmentRequest.getParentId(),
                    departmentRequest.getDepartmentName());
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            if (0 == result.getErrCode() && null != result.getResult())
            {
                response.setDepartmentId(result.getResult().getDeptId());
                response.setDepartmentNo(result.getResult().getDeptNo());
            }
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("addDepartment method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("addDepartment method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /** 
    * 修改部门
    * 
    * @param departmentRequest 部门入参，包括操作用户、部门ID，部门名称
    * @return RestErrCode 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode modifyDepartment(DepartmentRequest departmentRequest)
    {
        RestErrCode response = new RestErrCode();
        
        // 参数判空
        if (null == departmentRequest || StringUtils.isEmpty(departmentRequest.getUserId())
            || StringUtils.isEmpty(departmentRequest.getDepartmentId())
            || StringUtils.isEmpty(departmentRequest.getDepartmentName())
            || StringUtils.isEmpty(departmentRequest.getParentId()))//修改部门，新增parentId字段
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result =
                DEPARTMENT_SERVICE.modifyDepartment(departmentRequest.getUserId(),
                    departmentRequest.getDepartmentId(),
                    departmentRequest.getDepartmentName(),
                    departmentRequest.getParentId());
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("modifyDepartment method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("modifyDepartment method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /** 
    * 删除部门
    * 
    * @param userId 操作用户、
    * @param departmentId 部门ID
    * @return RestErrCode 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode deleteDepartment(@QueryParam("userId") String userId,
        @QueryParam("departmentId") String departmentId)
    {
        RestErrCode response = new RestErrCode();
        
        // 参数判空
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(departmentId))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result = DEPARTMENT_SERVICE.deleteDepartment(userId, departmentId);
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteDepartment method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("deleteDepartment method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /** 
    * 查询部门
    * 
    * @param userId 操作用户
    * @param parentId 父部门ID
    * @param pageCount 分页大小
    * @param pageNum 当前分页
    * @return QueryDepartmentResponse 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryDepartmentResponse queryDepartment(@QueryParam("userId") String userId,
        @QueryParam("parentId") String parentId, @QueryParam("pageCount") String pageCount,
        @QueryParam("pageNum") String pageNum)
    {
        QueryDepartmentResponse response = new QueryDepartmentResponse();
        
        // 参数判空
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(parentId) || StringUtils.isEmpty(pageCount)
            || StringUtils.isEmpty(pageNum))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        // 分页大小和当前分页小于1，参数非法
        //if (pageCount < 1 || pageNum < 1)
        //{
        //    response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
        //    response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
        //    return response;
        //}
        
        try
        {
            int pageCountTemp = Integer.parseInt(pageCount);
            int pageNumTemp = Integer.parseInt(pageNum);
            
            SDKResult<QueryDepartmentInfoList> result =
                DEPARTMENT_SERVICE.queryDepartment(userId, parentId, pageCountTemp, pageNumTemp);
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            if (0 == result.getErrCode() && null != result.getResult())
            {
                response.setQueryDepartmentInfoList(DEPARTMENT_RESOURCE_CONVERT.getQueryDepartmentModel2Rest(result.getResult()));
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
            LOGGER.error("queryDepartment method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryDepartment method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
