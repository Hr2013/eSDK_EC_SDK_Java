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
import com.huawei.esdk.uc.professional.local.bean.RestErrCode;
import com.huawei.esdk.uc.professional.local.bean.RestRequestMessage;
import com.huawei.esdk.uc.professional.local.bean.south.AppSendMsgToDept;
import com.huawei.esdk.uc.professional.local.bean.south.AppSendMsgToGroup;
import com.huawei.esdk.uc.professional.local.bean.south.AppSendMsgToUC;
import com.huawei.esdk.uc.professional.local.constant.UCConstant;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;
import com.huawei.esdk.uc.professional.local.utils.RestUtils;
import com.huawei.esdk.uc.professional.local.utils.StringUtils;

public class IMResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(IMResource.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private Gson GSON = new Gson();
    
    public Integer appSendMsgToDept(AppSendMsgToDept msg)
    {
        LOGGER.info("appSendMsgToDept Begin");
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(msg);
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("appSendMsgToDept.path"));
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    return 401;
                }
                else
                {
                    return Integer.parseInt(GSON.fromJson(responsePayload,
                        RestErrCode.class).getResultCode());
                }
            }
            else
            {
                return 1;
            }
        }
        catch (IOException e)
        {
            LOGGER.error("appSendMsgToDept error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("appSendMsgToDept error" + e);
        }
        
        return 1;
    }
    
    public Integer appSendMsgToGroup(AppSendMsgToGroup msg)
    {
        LOGGER.info("appSendMsgToGroup Begin");
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(msg);
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("appSendMsgToGroup.path"));
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    return 401;
                }
                else
                {
                    return Integer.parseInt(GSON.fromJson(responsePayload,
                        RestErrCode.class).getResultCode());
                }
            }
            else
            {
                return 1;
            }
        }
        catch (IOException e)
        {
            LOGGER.error("appSendMsgToGroup error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("appSendMsgToGroup error" + e);
        }
        
        return 1;
    }
    
    public Integer appSendMsgToUC(AppSendMsgToUC msg)
    {
        LOGGER.info("appSendMsgToUC Begin");
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(msg);
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("appSendMsgToUC.path"));
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    return 401;
                }
                else
                {
                    return Integer.parseInt(GSON.fromJson(responsePayload,
                        RestErrCode.class).getResultCode());
                }
            }
            else
            {
                return 1;
            }
        }
        catch (IOException e)
        {
            LOGGER.error("appSendMsgToUC error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("appSendMsgToUC error" + e);
        }
        
        return 1;
    }
}
