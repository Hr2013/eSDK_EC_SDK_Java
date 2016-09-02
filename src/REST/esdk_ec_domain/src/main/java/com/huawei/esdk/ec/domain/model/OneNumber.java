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

import com.huawei.esdk.ec.device.obg.voice.VoiceServiceOneNumberCapability;
import com.huawei.esdk.ec.domain.model.bean.BindingNumber;
import com.huawei.esdk.ec.domain.model.bean.OneNumberMode;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class OneNumber
{
    private String oneNumber;
    
    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
    	    .getBean("deviceManager");
    
    public OneNumber(String oneNumber)
    {
        this.setOneNumber(oneNumber);
    }

    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    //设置一号通模式
    public SDKErrorCode setOneNumberService(OneNumberMode oneNumberMode) throws SDKException
    {
    	VoiceServiceOneNumberCapability voiceAbility = deviceManager.getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                VoiceServiceOneNumberCapability.class);
        return voiceAbility.setOneNumberService(oneNumber, oneNumberMode);
    }
    
    //查询一号通绑定号码
    public SDKResult<List<BindingNumber>> queryBindingNumber() throws SDKException
    {
        SDKResult<List<BindingNumber>> result = null;
        VoiceServiceOneNumberCapability voiceServiceOneNumberCapability = getDeviceManager().getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                VoiceServiceOneNumberCapability.class);
        result = voiceServiceOneNumberCapability.queryBindingNumber(getOneNumber());
        return result;
    }

    public String getOneNumber()
    {
        return oneNumber;
    }

    public void setOneNumber(String oneNumber)
    {
        this.oneNumber = oneNumber;
    }

}
