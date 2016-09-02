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
package com.huawei.esdk.ec.device.appserver.callback.convert;

import com.huawei.esdk.ec.device.appserver.bean.NotifyRequest;
import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.config.ConfigManager;

public class NotifyCapabilityConvert
{
    
    public RestReqMessage getNotificationMode2Rest(boolean register)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        NotifyRequest acctRequest = new NotifyRequest();
        
        acctRequest.setOpt(register ? "1" : "0");
        
        String serverUrl = ConfigManager.getInstance().getValue("esdk.callback.service.url");
        if (!serverUrl.endsWith("/"))
        {
        	serverUrl += "/";
        }
        acctRequest.setConferStateURL(serverUrl + ConfigManager.getInstance().getValue("esdk.C03.ctcConferStateURL"));
        acctRequest.setConfInfoURL(serverUrl + ConfigManager.getInstance().getValue("esdk.C03.ctcConfInfoURL"));
        acctRequest.setUserStateURL(serverUrl + ConfigManager.getInstance().getValue("esdk.C03.ctcUserStateURL"));
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
}
