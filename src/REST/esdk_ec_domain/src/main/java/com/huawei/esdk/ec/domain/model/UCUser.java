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

import com.huawei.esdk.ec.device.obg.client.IClientPersonalCapability;
import com.huawei.esdk.ec.device.obg.userprofile.UserProfilePersonListCapability;
import com.huawei.esdk.ec.devices.v200r001c03.bmp.UCV2R1C03BMPAccountCapability;
import com.huawei.esdk.ec.devices.v200r001c03.bmp.UCV2R1C03BMPNumberCapability;
import com.huawei.esdk.ec.domain.model.bean.BindInfo;
import com.huawei.esdk.ec.domain.model.bean.PresPublishInfo;
import com.huawei.esdk.ec.domain.model.bean.PublishPresStatus;
import com.huawei.esdk.ec.domain.model.bean.UCAccountInfo;
import com.huawei.esdk.ec.domain.model.bean.UserMobile;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class UCUser
{
    // UC账号
    private String ucAccount;

    // UC账号信息
    private UCAccountInfo ucAccountInfo;

    private String registerState;

    // 回调中句柄ID
    private String handleId;

    // 设备IP地址
    private String deviceIP;

    // 是否拥有VoIP功能权限
    private long voipAbility;

    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
            .getBean("deviceManager");

    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }

    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        UCUser.deviceManager = deviceManager;
    }

    public UCUser(String ucAccount)
    {
        this.setUcAccount(ucAccount);
    }

    public UCUser()
    {
    }

    /**
     * 更新账号updAccount
     * @throws SDKException
     */
    public SDKResult<String> updAccount(UCAccountInfo ucAccountInfo)
            throws SDKException
    {
        UCV2R1C03BMPAccountCapability accountCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                        UCV2R1C03BMPAccountCapability.class);
        SDKResult<String> result = accountCapability
                .updateAccount(ucAccountInfo);
        return result;
    }

    /**
     * 增加账号addAccount
     * @throws SDKException
     * @author z00231026
     */
    public SDKResult<String> addAccount(UCAccountInfo ucAccountInfo)
            throws SDKException
    {
        UCV2R1C03BMPAccountCapability accountCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                        UCV2R1C03BMPAccountCapability.class);
        SDKResult<String> result = accountCapability.addAccount(ucAccountInfo);
        return result;
    }

    /**
     * 修改账号modifyAccount
     * @throws SDKException
     * @author z00231026
     */
    public SDKResult<String> modifyAccount(UCAccountInfo ucAccountInfo)
            throws SDKException
    {
        UCV2R1C03BMPAccountCapability accountCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                        UCV2R1C03BMPAccountCapability.class);
        SDKResult<String> result = accountCapability.modAccount(ucAccountInfo);
        return result;
    }

    /**
     * 删除账号<br>
     * @author liuquan 110528
     * @since eSdk V1R2
     * @param ucAccountInfo
     * @return
     * @throws SDKException
     */
    public SDKResult<String> delAccount(UCAccountInfo ucAccountInfo)
            throws SDKException
    {
        UCV2R1C03BMPAccountCapability accountCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                        UCV2R1C03BMPAccountCapability.class);
        SDKResult<String> result = accountCapability.delAccount(ucAccountInfo);
        return result;
    }

    /**
     * 号码绑定 numberBind
     * @throws SDKException 
     */
    public SDKResult<String> numberBind(BindInfo bindInfo) throws SDKException
    {
        UCV2R1C03BMPNumberCapability numberCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                UCV2R1C03BMPNumberCapability.class);
        SDKResult<String> result = numberCapability.numberBind(bindInfo);
        return result;
    }

    // 获取好友列表
    public SDKResult<MyFriendsService> getFriendList()
    {
        return null;
    }

    // 获取UC用户全量通讯录
    public SDKResult<PersonalContacts> getPersonAllAddressBook()
            throws SDKException
    {

        UserProfilePersonListCapability personListCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePersonListCapability.class);
        SDKResult<PersonalContacts> result = personListCapability
                .getPersonAllAddressBook(getUcAccount());
        return result;
    }

    // 个人签名设置 ----需要用户登陆
    public SDKErrorCode setSignature(String usrInfo) throws SDKException
    {
        SDKErrorCode result = null;
        IClientPersonalCapability clientPersonalCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPersonalCapability.class);
        result = clientPersonalCapability.setSignature(getUcAccount(), usrInfo);
        return result;
    }

    // 状态发布 ----需要用户登陆
    public SDKResult<PublishPresStatus> pubPresInfo(
            PresPublishInfo presPublish, long expires) throws SDKException
    {
        IClientPersonalCapability clientPersonalCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPersonalCapability.class);
        SDKResult<PublishPresStatus> result = clientPersonalCapability
                .pubPresInfo(getUcAccount(), presPublish, expires);
        return result;
    }

    // 状态刷新 ----需要用户登陆
    public SDKResult<PublishPresStatus> refreshPresInfo(
            PresPublishInfo presPublish, PublishPresStatus pubPresStatus)
            throws SDKException
    {
        SDKResult<PublishPresStatus> result = null;
        IClientPersonalCapability clientPersonalCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPersonalCapability.class);
        result = clientPersonalCapability.refreshPresInfo(getUcAccount(),
                presPublish, pubPresStatus);
        return result;
    }

    // 订阅PGM ----需要用户登陆
    public SDKResult<Long> subPGM(String subFlag, String groupUrl,
            String creator, long expires) throws SDKException
    {
        IClientPersonalCapability personalAbility = deviceManager
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPersonalCapability.class);
        return personalAbility.subPGM(ucAccount, subFlag, groupUrl, creator,
                expires);
    }

    // PGM订阅刷新 ----需要用户登陆
    public SDKResult<Long> refreshSubPGM(String subFlag, String groupUrl,
            String creator, long expires) throws SDKException
    {
        SDKResult<Long> result = null;
        IClientPersonalCapability clientPersonalCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPersonalCapability.class);
        result = clientPersonalCapability.refreshSubPGM(getUcAccount(),
                subFlag, groupUrl, creator, expires);
        return result;
    }

    /**
     * 手机通讯录上传 ----需要用户登陆
     * @author k00207574
     */
    public SDKResult<List<UserMobile>> uploadMobileAddress(
            List<String> mobileList) throws SDKException
    {
        IClientPersonalCapability client = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPersonalCapability.class);
        return client.uploadMobileAddress(ucAccount, mobileList);
    }

    // 上传头像id ----需要用户登陆
    public SDKErrorCode uploadheadid(String headId) throws SDKException
    {
        IClientPersonalCapability personalAbility = deviceManager
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPersonalCapability.class);
        return personalAbility.uploadheadid(ucAccount, headId);
    }

    /** * @return the ucAccount */
    public String getUcAccount()
    {
        return ucAccount;
    }

    /** * @param ucAccount the ucAccount to set */
    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }

    public String getRegisterState()
    {
        return registerState;
    }

    public void setRegisterState(String registerState)
    {
        this.registerState = registerState;
    }

    /** * @param deviceIP the deviceIP to set */
    public void setDeviceIP(String deviceIP)
    {
        this.deviceIP = deviceIP;
    }

    /** * @return the deviceIP */
    public String getDeviceIP()
    {
        return deviceIP;
    }

    /** * @param voipAbility the voipAbility to set */
    public void setVoipAbility(long voipAbility)
    {
        this.voipAbility = voipAbility;
    }

    /** * @return the voipAbility */
    public long getVoipAbility()
    {
        return voipAbility;
    }

    public String getHandleId()
    {
        return handleId;
    }

    public void setHandleId(String handleId)
    {
        this.handleId = handleId;
    }

    public UCAccountInfo getUcAccountInfo()
    {
        return ucAccountInfo;
    }

    public void setUcAccountInfo(UCAccountInfo ucAccountInfo)
    {
        this.ucAccountInfo = ucAccountInfo;
    }

}
