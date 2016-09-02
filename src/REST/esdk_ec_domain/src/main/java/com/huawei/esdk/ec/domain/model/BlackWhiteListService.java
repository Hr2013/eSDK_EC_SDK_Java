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
package com.huawei.esdk.ec.domain.model;

import java.util.List;

import com.huawei.esdk.ec.device.obg.voice.VoiceServiceBWNumberCapability;
import com.huawei.esdk.ec.domain.model.bean.BWList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class BlackWhiteListService
{
    private String userNumber;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");

    public BlackWhiteListService(String userNumber)
    {
        this.setUserNumber(userNumber);
    }
    
    //UC用户号码黑白名单状态设置
    public SDKResult<String> setBWListState(String bwListFlag) throws SDKException
    {
        VoiceServiceBWNumberCapability voiceServiceBWNumberCapability =
            getDeviceManager().getDeviceServiceProxy
            (ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                    VoiceServiceBWNumberCapability.class);
        return voiceServiceBWNumberCapability.setBWListState(userNumber, bwListFlag);
    }
    
    //UC用户号码黑白名单业务设置
    public SDKErrorCode setBWService(String optCode, BWList bwList) throws SDKException
    {
        VoiceServiceBWNumberCapability voiceServiceBWNumberCapability =
            getDeviceManager().getDeviceServiceProxy
            (ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                    VoiceServiceBWNumberCapability.class);
        return voiceServiceBWNumberCapability.setBWService(userNumber,optCode, bwList);
    }
    
    // UC用户号码黑白名单查询
    public SDKResult<List<BWList>> queryBWService() throws SDKException
    {
        VoiceServiceBWNumberCapability voiceServiceBWNumberCapability =
            getDeviceManager().getDeviceServiceProxy
            (ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                VoiceServiceBWNumberCapability.class);
        SDKResult<List<BWList>> result = voiceServiceBWNumberCapability.
        queryBWService(getUserNumber());
        return result;
    }

    public String getUserNumber()
    {
        return userNumber;
    }

    public void setUserNumber(String userNumber)
    {
        this.userNumber = userNumber;
    }

    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }

    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        BlackWhiteListService.deviceManager = deviceManager;
    }
    
}
