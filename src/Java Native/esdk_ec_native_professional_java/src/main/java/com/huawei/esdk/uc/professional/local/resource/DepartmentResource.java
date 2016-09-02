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
package com.huawei.esdk.uc.professional.local.resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.uc.professional.local.bean.RestErrCode;
import com.huawei.esdk.uc.professional.local.bean.RestRequestMessage;
import com.huawei.esdk.uc.professional.local.bean.south.AddDepartmentResponse;
import com.huawei.esdk.uc.professional.local.bean.south.DepartmentRequest;
import com.huawei.esdk.uc.professional.local.bean.south.QueryDepartmentResponse;
import com.huawei.esdk.uc.professional.local.constant.ResultCode;
import com.huawei.esdk.uc.professional.local.constant.UCConstant;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;
import com.huawei.esdk.uc.professional.local.utils.RestUtils;
import com.huawei.esdk.uc.professional.local.utils.StringUtils;


public class DepartmentResource
{
    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(DepartmentResource.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
    
    /** 
    * 新增部门
    * 
    * @param departmentRequest 部门入参，包括操作用户、父部门ID，部门名称
    * @return AddDepartmentResponse 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    public AddDepartmentResponse addDepartment(DepartmentRequest departmentRequest)
    { 
        AddDepartmentResponse result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(departmentRequest);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("department.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new AddDepartmentResponse();
                    result.setResultCode("401");
                }
                else
                {
                    return GSON.fromJson(responsePayload, AddDepartmentResponse.class);
                }
            }
            else
            {
                result = new AddDepartmentResponse();
                result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("addDepartment error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("addDepartment error" + e);
        }
        result = new AddDepartmentResponse();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
    }
    
    /** 
    * 修改部门
    * 
    * @param departmentRequest 部门入参，包括操作用户、部门ID，部门名称
    * @return RestErrCode 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    public RestErrCode modifyDepartment(DepartmentRequest departmentRequest)
    {
        RestErrCode result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_PUT);
        restRequestMessage.setPayload(departmentRequest);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("department.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new RestErrCode();
                    result.setResultCode("401");
                }
                else
                {
                    return GSON.fromJson(responsePayload, RestErrCode.class);
                }
            }
            else
            {
                result = new RestErrCode();
                result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("modifyDepartment error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("modifyDepartment error" + e);
        }
        result = new RestErrCode();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
    }
    
    /** 
    * 删除部门
    * 
    * @param userId 操作用户、
    * @param departmentId 部门ID
    * @return RestErrCode 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    public RestErrCode deleteDepartment(String userId, String departmentId)
    {
        RestErrCode result = null;
        
        //拼装请求Map       
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("userId", userId);
        parameters.put("departmentId", departmentId);
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_DELETE);
        restRequestMessage.setParameters(parameters);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("department.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new RestErrCode();
                    result.setResultCode("401");
                }
                else
                {
                    return GSON.fromJson(responsePayload, RestErrCode.class);
                }
            }
            else
            {
                result = new RestErrCode();
                result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("deleteDepartment error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("deleteDepartment error" + e);
        }
        result = new RestErrCode();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
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
    public QueryDepartmentResponse queryDepartment(String userId, String parentId, String pageCount,
        String pageNum)
    {
        //拼装请求Map       
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("userId", userId);
        parameters.put("parentId", parentId);
        parameters.put("pageCount", pageCount);
        parameters.put("pageNum", pageNum);
        
        QueryDepartmentResponse result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_GET);
        restRequestMessage.setParameters(parameters);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage, PropertiesUtils.getValue("department.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new QueryDepartmentResponse();
                    result.setResultCode("401");
                }
                else
                {
                    return GSON.fromJson(responsePayload, QueryDepartmentResponse.class);
                }
            }
            else
            {
                result = new QueryDepartmentResponse();
                result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("queryEnterprise error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("queryEnterprise error" + e);
        }
        result = new QueryDepartmentResponse();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
    }
}
