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

import java.util.Date;
import java.util.List;

import com.huawei.esdk.ec.device.obg.userprofile.UserProfileFriendCapability;
import com.huawei.esdk.ec.devices.v200r001c03.userprofile.UCV2R1C03UserProfileFriendCapability;
import com.huawei.esdk.ec.domain.model.bean.FriendChangeInfo;
import com.huawei.esdk.ec.domain.model.bean.FriendInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class MyFriendsService
{
    // key：UC账号
    private String ucAccount;

    // 好友基本信息列表
    private List<FriendInfo> friendInfoBases;

    public MyFriendsService(String ucAccount)
    {
        this.setUcAccount(ucAccount);
    }

    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
            .getBean("deviceManager");

    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }

    // 好友信息增量同步
    public SDKResult<List<FriendChangeInfo>> getPersonIncFriendList(Date date)
            throws SDKException
    {
        SDKResult<List<FriendChangeInfo>> result = null;
        UserProfileFriendCapability userProfileFriendCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfileFriendCapability.class);
        result = userProfileFriendCapability.getPersonIncFriendList(
                getUcAccount(), String.valueOf((date.getTime() / 1000)));
        return result;
    }

    // 好友信息查询
    public SDKResult<FriendInfo> getFriendInfo(int type, String friendAccount)
            throws SDKException
    {
        SDKResult<FriendInfo> result = null;
        UserProfileFriendCapability userProfileFriendCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfileFriendCapability.class);
        result = userProfileFriendCapability.getFriendInfo(getUcAccount(),
                type, friendAccount);
        return result;
    }

    // 添加好友
    public SDKErrorCode addFriend(String friendAccount) throws SDKException
    {
        SDKErrorCode result = null;
        UserProfileFriendCapability userProfileFriendCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfileFriendCapability.class);
        result = userProfileFriendCapability.addFriend(getUcAccount(),
                friendAccount);
        return result;
    }

    // 删除好友
    public SDKErrorCode delFriend(String friendAccount) throws SDKException
    {
        SDKErrorCode result = null;
        UserProfileFriendCapability userProfileFriendCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfileFriendCapability.class);
        result = userProfileFriendCapability.delFriend(getUcAccount(),
                friendAccount);
        return result;
    }

    // 好友列表
    public SDKResult<List<FriendInfo>> getFriendList() throws SDKException
    {
        SDKResult<List<FriendInfo>> result = null;
        UserProfileFriendCapability userProfileFriendCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfileFriendCapability.class);
        result = userProfileFriendCapability.getFriendList(getUcAccount());
        return result;
    }
    
    /**
     * addNewFriend
     */
    public SDKErrorCode addNewFriend(String groupId) throws SDKException {
        SDKErrorCode result = null;
        UCV2R1C03UserProfileFriendCapability userProfileFriendCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UCV2R1C03UserProfileFriendCapability.class);
        
        FriendInfo friendInfo = friendInfoBases.get(0);

        result = userProfileFriendCapability.addNewFriend(ucAccount,friendInfo,friendInfo.getFriendAccount(),groupId);
        return result;
    }

    public String getUcAccount()
    {
        return ucAccount;
    }

    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }

    public List<FriendInfo> getFriendInfoBases()
    {
        return friendInfoBases;
    }

    public void setFriendInfoBases(List<FriendInfo> friendInfoBases)
    {
        this.friendInfoBases = friendInfoBases;
    }

}
