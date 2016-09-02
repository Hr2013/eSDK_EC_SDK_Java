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

import com.huawei.esdk.ec.device.obg.userprofile.UserProfilePublicGroupCapability;
import com.huawei.esdk.ec.domain.model.bean.JoinGroupInfo;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryModeInfo;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class MyGroupsService
{
    private String ucAccount;
    
    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
    	    .getBean("deviceManager");
    
    public MyGroupsService(String ucAccount)
    {
        this.setUcAccount(ucAccount);
    }

    //查找某个用户的群组列表
    public SDKResult<PagedList<JoinGroupInfo>> queryJoinGroupByUC(QueryModeInfo queryModeInfo) throws SDKException
    {
        UserProfilePublicGroupCapability pgAbility = deviceManager.getDeviceServiceProxy(
        		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
            UserProfilePublicGroupCapability.class);
        return pgAbility.queryJoinGroupByUC(this.getUcAccount(),queryModeInfo);
    }
    
    public String getUcAccount()
    {
        return ucAccount;
    }


    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }

}
