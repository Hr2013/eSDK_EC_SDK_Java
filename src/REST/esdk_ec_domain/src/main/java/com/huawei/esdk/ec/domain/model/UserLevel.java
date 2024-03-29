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

import com.huawei.esdk.ec.device.bmu.IUserLevelCapability;
import com.huawei.esdk.ec.domain.model.bean.UserLevelInfo;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class UserLevel
{
    private String count;
    
    private List<UserLevelInfo> userLevelInfos;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        UserLevel.deviceManager = deviceManager;
    }
    
    /**
     *  查询用户等级
     * @param userId
     * @param sip
     * @return
     * @throws SDKException
     */
    public SDKResult<UserLevel> queryUserLevel(String userId, 
        String pageCount, String pageNum)
        throws SDKException
    {
        IUserLevelCapability userLevelCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                IUserLevelCapability.class);
        SDKResult<UserLevel> result = userLevelCapability.queryUserLevel(userId, pageCount, pageNum);
        return result;
    }

    public String getCount()
    {
        return count;
    }

    public void setCount(String count)
    {
        this.count = count;
    }

    public List<UserLevelInfo> getUserLevelInfos()
    {
        return userLevelInfos;
    }

    public void setUserLevelInfos(List<UserLevelInfo> userLevelInfos)
    {
        this.userLevelInfos = userLevelInfos;
    }
    
    
}
