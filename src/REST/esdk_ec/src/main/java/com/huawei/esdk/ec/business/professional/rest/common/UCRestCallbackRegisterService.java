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
package com.huawei.esdk.ec.business.professional.rest.common;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.base.UCNotifyCallback;
import com.huawei.esdk.ec.business.professional.rest.ctc.callback.RestNotifyCTCCallback;
import com.huawei.esdk.ec.domain.model.Notify;
import com.huawei.esdk.platform.callback.itf.ICallback;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;

public class UCRestCallbackRegisterService
{
    private static final Logger LOGGER = Logger.getLogger(UCRestCallbackRegisterService.class);
    
    private NotifyCollector notifyCollector;
    
    //    private IDeviceManager deviceManager;
    
    private UCNotifyCallback ucNotifyCallback = new UCNotifyCallback();
    
    public SDKErrorCode register(Map<String, String> map)
    {
        String devId = ConfigManager.getInstance().getValue("esdk.ec_appserver_device");
        
        notifyCollector.subscribeNotify(devId, "_", ucNotifyCallback);
        
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            if ("CTC".equalsIgnoreCase(entry.getKey()))
            {
                ICallback callback = new RestNotifyCTCCallback(entry.getValue());
                ucNotifyCallback.registerCallback("ctc", callback);
            }
            else
            {
                LOGGER.warn("UCRestCallbackRegisterService register ability error - " + entry.getKey()
                    + " is not supported");
            }
        }
        SDKErrorCode result = new SDKErrorCode();
        try
        {
            result = new Notify().registerNotification(true);
        }
        catch (SDKException e)
        {
            LOGGER.debug("register eror!");
        }
        return result;
    }
    
    public SDKErrorCode unregister(List<String> modules)
    {
        // Unsubscribe until all modules are unsubscribed
        for (String module : modules)
        {
            ucNotifyCallback.unregisterCallback(module);
        }
        
        //TODO call south interface
        if (!ucNotifyCallback.hasRegisteredModule())
        {
            String devId = ConfigManager.getInstance().getValue("esdk.ec_appserver_device");
            notifyCollector.unsubscribeNotify(devId, "_");
        }
        
        SDKErrorCode result = new SDKErrorCode();
        try
        {
            result = new Notify().registerNotification(false);
        }
        catch (SDKException e)
        {
            LOGGER.debug("unregister eror!");
        }
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
    
    //    public IDeviceManager getDeviceManager()
    //    {
    //        return deviceManager;
    //    }
    //
    //    public void setDeviceManager(IDeviceManager deviceManager)
    //    {
    //        this.deviceManager = deviceManager;
    //    }
}
