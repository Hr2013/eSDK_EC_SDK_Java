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

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.uc.professional.local.bean.RestRequestMessage;
import com.huawei.esdk.uc.professional.local.bean.RestResponse;
import com.huawei.esdk.uc.professional.local.bean.south.AddAccountRequest;
import com.huawei.esdk.uc.professional.local.bean.south.ResHeaderBean;
import com.huawei.esdk.uc.professional.local.constant.ResultCode;
import com.huawei.esdk.uc.professional.local.constant.UCConstant;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;
import com.huawei.esdk.uc.professional.local.utils.RestUtils;
import com.huawei.esdk.uc.professional.local.utils.StringUtils;

public class AccountResource
{
    
    private static final Logger LOGGER = Logger.getLogger(AccountResource.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
    
    /**
     * 添加账号
     * @param acct
     * @return
     */
    public RestResponse<String> addAccount(AddAccountRequest acct)
    {
        RestResponse<String> result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(acct);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("account.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new RestResponse<String>();
                    result.setResultCode("401");
                }
                else
                {
                    return (RestResponse<String>)GSON.fromJson(responsePayload, RestResponse.class);
                }
            }
            else
            {
                result = new RestResponse<String>();
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
        result = new RestResponse<String>();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
        
    }

    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @author wangxiaobo/wWX233376
     * @param acct
     * @return
     * @see [类、类#方法、类#成员]
     */
    public ResHeaderBean modifyAcountPassword(AddAccountRequest acct)
    {
        ResHeaderBean result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_PUT);
        restRequestMessage.setPayload(acct);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("modify_account_password.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new ResHeaderBean();
                    result.setResultCode("401");
                    return result;
                }
                else
                {
                    return GSON.fromJson(responsePayload, ResHeaderBean.class);
                }
            }
            else
            {
                result = new ResHeaderBean();
                result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("modifyAcountPassword error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("modifyAcountPassword error" + e);
        }
        result = new ResHeaderBean();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
        
    }
     
}
