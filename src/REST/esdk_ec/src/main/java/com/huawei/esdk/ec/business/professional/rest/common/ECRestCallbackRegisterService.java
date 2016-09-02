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
package com.huawei.esdk.ec.business.professional.rest.common;

import java.util.List;
import java.util.Map;

import com.huawei.esdk.ec.base.UCNotifyCallback;
import com.huawei.esdk.ec.business.professional.rest.multiapponline.callback.RestNotifyEServerCallback;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.platform.callback.itf.ICallback;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;

public class ECRestCallbackRegisterService
{
    private NotifyCollector notifyCollector;
    
    private UCNotifyCallback ecNotifyCallback = new UCNotifyCallback();
    
    public SDKErrorCode register(Map<String, String> map)
    {
        String devId = ConfigManager.getInstance().getValue("esdk.ec_eserver_device");
        notifyCollector.subscribeNotify(devId, "_", ecNotifyCallback);
        
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            ICallback callback = new RestNotifyEServerCallback(entry.getValue());
            ecNotifyCallback.registerCallback(entry.getKey(), callback);
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        
        return result;
    }
    
    public SDKErrorCode unregister(List<String> modules)
    {
        // Unsubscribe until all modules are unsubscribed
        for (String module : modules)
        {
            ecNotifyCallback.unregisterCallback(module);
        }
        
        if (!ecNotifyCallback.hasRegisteredModule())
        {
            String devId = ConfigManager.getInstance().getValue("esdk.ec_eserver_device");
            notifyCollector.unsubscribeNotify(devId, "_");
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        
        return result;
    }
    
    public NotifyCollector getNotifyCollector()
    {
        return notifyCollector;
    }
    
    public void setNotifyCollector(NotifyCollector notifyCollector)
    {
        this.notifyCollector = notifyCollector;
    }
    
}
