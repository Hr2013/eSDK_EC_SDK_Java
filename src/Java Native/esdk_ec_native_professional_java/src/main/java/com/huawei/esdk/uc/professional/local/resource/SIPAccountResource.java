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
import com.huawei.esdk.uc.professional.local.bean.south.SipQueryRequest;
import com.huawei.esdk.uc.professional.local.bean.south.SipQueryResponse;
import com.huawei.esdk.uc.professional.local.bean.south.SipRequest;
import com.huawei.esdk.uc.professional.local.bean.south.SipResponse;
import com.huawei.esdk.uc.professional.local.constant.ResultCode;
import com.huawei.esdk.uc.professional.local.constant.UCConstant;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;
import com.huawei.esdk.uc.professional.local.utils.RestUtils;
import com.huawei.esdk.uc.professional.local.utils.StringUtils;

public class SIPAccountResource
{
    private static final Logger LOGGER = Logger.getLogger(SIPAccountResource.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
    
    /**
     * 添加SIP号码
     * @param acct
     * @return
     */
    public SipResponse addSIP(SipRequest acct)
    {
        SipResponse result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(acct);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("sip.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new SipResponse();
                    result.setResultCode("401");
                }
                else
                {
                    return GSON.fromJson(responsePayload, SipResponse.class);
                }
            }
            else
            {
                result = new SipResponse();
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
        result = new SipResponse();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
    }
    
    /**
     * 修改SIP号码
     * @param acct
     * @return
     */
    public SipResponse modifySIP(SipRequest acct)
    {
        SipResponse result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_PUT);
        restRequestMessage.setPayload(acct);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("sip.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new SipResponse();
                    result.setResultCode("401");
                }
                else
                {
                    return GSON.fromJson(responsePayload, SipResponse.class);
                }
            }
            else
            {
                result = new SipResponse();
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
        result = new SipResponse();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
    }
    
    public SipResponse deleteSip(SipRequest acct)
    {
        SipResponse result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(acct);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("delete_sip.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new SipResponse();
                    result.setResultCode("401");
                }
                else
                {
                    return GSON.fromJson(responsePayload, SipResponse.class);
                }
            }
            else
            {
                result = new SipResponse();
                result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("deleteSip error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("deleteSip error" + e);
        }
        result = new SipResponse();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
    }
    
    public SipQueryResponse querySip(SipQueryRequest sip)
    {
        SipQueryResponse result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(sip);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("query_sip.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new SipQueryResponse();
                    result.setResultCode("401");
                }
                else
                {
                    return GSON.fromJson(responsePayload, SipQueryResponse.class);
                }
            }
            else
            {
                result = new SipQueryResponse();
                result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("deleteSip error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("deleteSip error" + e);
        }
        result = new SipQueryResponse();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
    }
}
