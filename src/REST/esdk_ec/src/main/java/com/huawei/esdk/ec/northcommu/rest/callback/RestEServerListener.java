/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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
package com.huawei.esdk.ec.northcommu.rest.callback;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.commu.itf.IProtocolAdapterManager;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class RestEServerListener
{
    private static final Logger LOGGER = Logger.getLogger(RestEServerListener.class);
    
    private ISDKProtocolAdapter restProtocolAdapter;
    
    private IProtocolAdapterManager protocolAdapterManager = ApplicationContextUtil.getBean("protocolAdapterManager");
    
    public RestEServerListener(String sap)
    {
        restProtocolAdapter =
            protocolAdapterManager.getProtocolInstanceByType(ESDKConstant.PROTOCOL_ADAPTER_TYPE_REST, sap);
    }
    
    public void sendCallbackMsg(Object payload, String messageType)
    {
        LOGGER.debug("Received a callback message.");
        LOGGER.debug("Callback message: " + payload);
        
        try
        {
            RestReqMessage req = new RestReqMessage();
            req.getHttpHeaders().put("Content-Type", "application/json;charset=UTF-8");
            req.setMediaType("json");
            req.setHttpMethod("POST");
            req.setPayload(payload);
            restProtocolAdapter.syncSendMessage(req, null, null);
            LOGGER.debug("Sent a callback message.");
        }
        catch (ProtocolAdapterException e)
        {
            LOGGER.error(messageType + " callback error", e);
            LOGGER.warn("Callback message is not processed successfully by client");
        }
        catch (Exception e)
        {
            LOGGER.error(messageType, e);
            LOGGER.warn("Callback message is not processed successfully by client");
        }
    }
    
}
