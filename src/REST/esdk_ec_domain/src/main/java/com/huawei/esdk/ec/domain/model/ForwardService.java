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

import com.huawei.esdk.ec.device.obg.voice.VoiceServiceFWDNumberCapability;
import com.huawei.esdk.ec.domain.model.bean.ForwardInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class ForwardService
{
	// 用户号码
    private String userNumber;

    // 前转信息
    private ForwardInfo forwardInfo;

    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
            .getBean("deviceManager");

    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }

    public ForwardService(String userNumber)
    {
        this.setUserNumber(userNumber);
    }

    // UC用户号码前转设置
    public SDKErrorCode setFWDService(String fwdType, String fwdNumber)
            throws SDKException
    {
        VoiceServiceFWDNumberCapability fwdNumberCapability = getDeviceManager()
                .getDeviceServiceProxy(
                		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        VoiceServiceFWDNumberCapability.class);
        return fwdNumberCapability
                .setFWDService(userNumber, fwdType, fwdNumber);
    }

    // UC用户号码前转查询
    public SDKResult<List<ForwardInfo>> queryFWDService() throws SDKException
    {
        VoiceServiceFWDNumberCapability voiceServiceFWDNumberCapability = getDeviceManager()
                .getDeviceServiceProxy(
                		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        VoiceServiceFWDNumberCapability.class);
        SDKResult<List<ForwardInfo>> result = voiceServiceFWDNumberCapability
                .queryFWDService(getUserNumber());
        return result;
    }

    // UC用户取消号码前转设置
    public SDKErrorCode unsetFWDService(String fwdType) throws SDKException
    {
        VoiceServiceFWDNumberCapability fwdNumberCapability = getDeviceManager()
                .getDeviceServiceProxy(
                		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        VoiceServiceFWDNumberCapability.class);
        return fwdNumberCapability.unsetFWDService(userNumber, fwdType);
    }

    public String getUserNumber()
    {
        return userNumber;
    }

    public void setUserNumber(String userNumber)
    {
        this.userNumber = userNumber;
    }

    public ForwardInfo getForwardInfo()
    {
        return forwardInfo;
    }

    public void setForwardInfo(ForwardInfo forwardInfo)
    {
        this.forwardInfo = forwardInfo;
    }

}
