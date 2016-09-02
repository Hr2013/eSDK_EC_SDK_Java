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

import com.huawei.esdk.ec.device.obg.userprofile.UserProfilePublicGroupCapability;
import com.huawei.esdk.ec.domain.model.bean.GroupInfoBase;
import com.huawei.esdk.ec.domain.model.bean.LBSInfo;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryModeInfo;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class QueryService
{
    // 查询方式
    private QueryModeInfo queryModeInfo;
    
    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
    	    .getBean("deviceManager");
    
    public QueryService()
    {
        
    }
    
    //群组列表查询
    public SDKResult<PagedList<GroupInfoBase>> queryGroupList(String groupNo, 
    		String groupName, QueryModeInfo modeInfo) throws SDKException
    {
    	UserProfilePublicGroupCapability pgAbility = deviceManager.getDeviceServiceProxy(
    			ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfilePublicGroupCapability.class);
        return pgAbility.queryGroupList(groupNo, groupName, modeInfo);
    }
    
    // 群组信息查询,为何返回List?
    public SDKResult<List<Group>> queryGroupInfo(String groupId, String groupCreater) throws SDKException
    {
    	UserProfilePublicGroupCapability pgAbility = deviceManager.getDeviceServiceProxy(
    			ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfilePublicGroupCapability.class);
        return pgAbility.queryGroupInfo(groupId, groupCreater);
    }
    
    // 查询物理位置
    public SDKResult<LBSInfo> queryLBSLocation(String sRouteNumber)
    {
        return null;
    }

    public QueryModeInfo getListInfo()
    {
        return queryModeInfo;
    }

    public void setListInfo(QueryModeInfo listInfo)
    {
        this.queryModeInfo = listInfo;
    }
}
