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

import com.huawei.esdk.ec.device.obg.userprofile.UserProfilePSSvrCapability;
import com.huawei.esdk.ec.domain.model.bean.UCPresInfo;
import com.huawei.esdk.ec.domain.model.bean.UCPresQryResult;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class QueryUCPresenceInfo extends QueryService
{
    private UCPresQryResult queryResult;

    private List<UCPresInfo> ucPresInfos;
    
    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
        .getBean("deviceManager");

    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    // 查询UC用户状态
    public SDKResult<List<QueryUCPresenceInfo>> queryUCPresence(
            List<String> presentitys) throws SDKException
    {
        SDKResult<List<QueryUCPresenceInfo>> result = null;
        UserProfilePSSvrCapability userProfileFriendCapability = getDeviceManager().getDeviceServiceProxy(
        		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfilePSSvrCapability.class);
        result = userProfileFriendCapability.queryUCPresence(presentitys);
        return result;
    }

    public UCPresQryResult getQueryResult()
    {
        return queryResult;
    }

    public void setQueryResult(UCPresQryResult queryResult)
    {
        this.queryResult = queryResult;
    }

    public List<UCPresInfo> getUcPresInfos()
    {
        return ucPresInfos;
    }

    public void setUcPresInfos(List<UCPresInfo> ucPresInfos)
    {
        this.ucPresInfos = ucPresInfos;
    }
}
