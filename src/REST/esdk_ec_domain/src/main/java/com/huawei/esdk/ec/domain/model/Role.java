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

import com.huawei.esdk.ec.device.bmu.IRoleCapability;
import com.huawei.esdk.ec.domain.model.bean.RoleInfo;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class Role
{
    private String amount;
    
    private List<RoleInfo> roleInfos;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        Role.deviceManager = deviceManager;
    }
    
    /**
     *  查询角色
     * @param userId
     * @param sip
     * @return
     * @throws SDKException
     */
    public SDKResult<Role> queryRole(String userId, 
        String pageCount, String pageNum, String lang)
        throws SDKException
    {
        IRoleCapability roleCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                IRoleCapability.class);
        SDKResult<Role> result = roleCapability.queryRole(userId, pageCount, pageNum, lang);
        return result;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public List<RoleInfo> getRoleInfos()
    {
        return roleInfos;
    }
    
    public void setRoleInfos(List<RoleInfo> roleInfos)
    {
        this.roleInfos = roleInfos;
    }
    
}
