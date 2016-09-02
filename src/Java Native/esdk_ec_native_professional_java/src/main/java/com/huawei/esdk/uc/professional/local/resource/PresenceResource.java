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
import com.huawei.esdk.uc.professional.local.bean.south.QueryUCListPresenceRequest;
import com.huawei.esdk.uc.professional.local.bean.south.QueryUCListPresenceResponse;
import com.huawei.esdk.uc.professional.local.constant.UCConstant;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;
import com.huawei.esdk.uc.professional.local.utils.RestUtils;
import com.huawei.esdk.uc.professional.local.utils.StringUtils;

public class PresenceResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(PresenceResource.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
    
    public QueryUCListPresenceResponse queryUCListPresence(QueryUCListPresenceRequest queryUCListPresenceRequest)
    {
        LOGGER.info("queryUCListPresence Begin");
        QueryUCListPresenceResponse result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(queryUCListPresenceRequest);
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("queryUCListPresence.path"));
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new QueryUCListPresenceResponse();
                    result.setResultCode("401");
                    return result;
                }
                else
                {
                    return GSON.fromJson(responsePayload, QueryUCListPresenceResponse.class);
                }
            }
            else
            {
                result = new QueryUCListPresenceResponse();
                result.setResultCode("1");
                return result;
            }
        }
        catch (IOException e)
        {
            LOGGER.error("queryUCListPresence error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("queryUCListPresence error" + e);
        }
        
        result = new QueryUCListPresenceResponse();
        result.setResultCode("1");
        return result;
    }
}
