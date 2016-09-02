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

import com.huawei.esdk.ec.device.obg.client.IClientCommonCapability;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * * @author j00213891 * * 业务鉴权方式待定
 */
public class BussinessAAService
{
    private int otherLoginType;

    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
            .getBean("deviceManager");

    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }

    // UC客户端登陆
    public SDKResult<Integer> userLogin(String ucAccount, String pw,
            String registerFunc, String deviceIP, String handleID)
            throws SDKException
    {
        IClientCommonCapability client = getDeviceManager()
                .getDeviceServiceProxy(
                		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientCommonCapability.class);
        SDKResult<Integer> sdkResult = client.userLogin(ucAccount, pw,
                registerFunc, deviceIP, handleID);
        return sdkResult;
    }

    // UC客户端注销
    public SDKErrorCode userLogOut(String ucAccount) throws SDKException
    {
        IClientCommonCapability client = getDeviceManager()
                .getDeviceServiceProxy(
                		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientCommonCapability.class);
        SDKErrorCode sdkErrorCode = client.userLogOut(ucAccount);
        return sdkErrorCode;
    }

    /** * @param otherLoginType the otherLoginType to set */
    public void setOtherLoginType(int otherLoginType)
    {
        this.otherLoginType = otherLoginType;
    }

    /** * @return the otherLoginType */
    public int getOtherLoginType()
    {
        return otherLoginType;
    }

}
