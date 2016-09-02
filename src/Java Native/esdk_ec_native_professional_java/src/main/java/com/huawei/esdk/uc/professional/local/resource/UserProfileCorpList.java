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
import com.huawei.esdk.uc.professional.local.bean.RestRequestMessage;
import com.huawei.esdk.uc.professional.local.bean.south.QueryEnterpriseRequest;
import com.huawei.esdk.uc.professional.local.bean.south.QueryEnterpriseResponse;
import com.huawei.esdk.uc.professional.local.bean.south.QueryPersonInfoResponse;
import com.huawei.esdk.uc.professional.local.constant.ResultCode;
import com.huawei.esdk.uc.professional.local.constant.UCConstant;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;
import com.huawei.esdk.uc.professional.local.utils.RestUtils;
import com.huawei.esdk.uc.professional.local.utils.StringUtils;

public class UserProfileCorpList
{
    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(UserProfileCorpList.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
    
    /**
     * 查询企业通讯录
     * 
     * @param request
     * @return
     */
    public QueryEnterpriseResponse queryEnterprise(QueryEnterpriseRequest request)
    {
        //拼装请求Map       
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("departmentId", request.getDepartmentId());
        parameters.put("pageCount", request.getPageCount());
        parameters.put("pageNum", request.getPageNum());
        
        QueryEnterpriseResponse result = new QueryEnterpriseResponse();
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_GET);
        restRequestMessage.setParameters(parameters);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage, PropertiesUtils.getValue("enterprise.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result.setResultCode("401");
                }
                else
                {
                    result = GSON.fromJson(responsePayload, QueryEnterpriseResponse.class);
                    result.getEnterpriseList().setDeptId(request.getDepartmentId());
                }
            }
            else
            {
                result.setResultCode("1");
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
        
        return result;
    }
    
    /**
     *  查询个人详情
     * 
     * @param staffAccount
     * @return
     */
    public QueryPersonInfoResponse queryPersonInfo(String staffAccount)
    {
        //拼装请求Map       
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("staffAccount", staffAccount);
        
        QueryPersonInfoResponse result = new QueryPersonInfoResponse();
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_GET);
        restRequestMessage.setParameters(parameters);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage, PropertiesUtils.getValue("person.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result.setResultCode("401");
                }
                else
                {
                    result = GSON.fromJson(responsePayload, QueryPersonInfoResponse.class);
                }
            }
            else
            {
                result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("queryPersonInfo error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("queryPersonInfo error" + e);
        }
        
        return result;
    }
    
}
