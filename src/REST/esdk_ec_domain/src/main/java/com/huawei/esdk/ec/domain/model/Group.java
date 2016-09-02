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

import com.huawei.esdk.ec.device.obg.client.IClientPublicGroupCapability;
import com.huawei.esdk.ec.device.obg.userprofile.UserProfilePublicGroupCapability;
import com.huawei.esdk.ec.devices.v200r001c03.userprofile.UCV2R1C03UserProfilePublicGroupCapability;
import com.huawei.esdk.ec.domain.model.bean.GroupInfoBase;
import com.huawei.esdk.ec.domain.model.bean.GroupMember;
import com.huawei.esdk.ec.domain.model.bean.GroupModifyInfo;
import com.huawei.esdk.ec.domain.model.bean.GroupValType;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryModeInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * 群组实体类
 */
public class Group extends GroupInfoBase
{
    // 群组描述
    private String groupDec;

    // 群组公告
    private String groupPost;

    // 群组成员列表
    private List<GroupMember> members;

    // 最大成员数
    private long maxNumber;

    // 群组验证方式
    private GroupValType validateType;
    
    //群共享文件大小
    private int maxShareFileSize;
    
    //是否接收该群组消息，
    private int recvMsg;
    
    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
            .getBean("deviceManager");

    public Group(String id, String groupCreateID)
    {
        super();
        super.setGroupId(id);
        super.setGroupCreater(groupCreateID);
    }

    public Group()
    {

    }

    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }

    // 群组成员查询
    public SDKResult<PagedList<GroupMember>> queryGroupMember(QueryModeInfo queryModeInfo) throws SDKException
    {
        UserProfilePublicGroupCapability pgAbility = deviceManager
                .getDeviceServiceProxy(
                		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePublicGroupCapability.class);
        return pgAbility.queryGroupMember(this.getGroupId(),
                this.getGroupCreater(), queryModeInfo);
    }

    // 创建群组
    public SDKErrorCode addGroup(Group group) throws SDKException
    {
        SDKErrorCode result = null;
        UserProfilePublicGroupCapability publicGroup = deviceManager
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePublicGroupCapability.class);
        result = publicGroup.addGroup(group);
        return result;
    }

    // 解散群组
    public SDKErrorCode delGroup(Group group) throws SDKException
    {
        SDKErrorCode result = null;
        UserProfilePublicGroupCapability publicGroup = deviceManager
        .getDeviceServiceProxy(
            ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
            UserProfilePublicGroupCapability.class);
        result = publicGroup.delGroup(group);
        return result;
    }

    // 修改群组
    public SDKErrorCode modGroup(GroupModifyInfo groupModInfo)
            throws SDKException
    {
        UserProfilePublicGroupCapability pgAbility = deviceManager
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePublicGroupCapability.class);
        return pgAbility.modifyGroup(this.getGroupId(), this.getGroupCreater(),
                groupModInfo);
    }

    // 邀请成员加入
    public SDKErrorCode addGroupMumbers(String ucAccount, Group group)
            throws SDKException
    {
        SDKErrorCode result = null;
        UserProfilePublicGroupCapability publicGroup = deviceManager
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePublicGroupCapability.class);
        result = publicGroup.addGroupMember(ucAccount, group);
        return result;
    }

    // 删除群组成员
    public SDKErrorCode delGroupMumber(String ucAccount, Group group)
            throws SDKException
    {
        SDKErrorCode result = null;
        UserProfilePublicGroupCapability publicGroup = deviceManager
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePublicGroupCapability.class);
        result = publicGroup.delGroupMember(ucAccount, group);
        return result;
    }

    // 用户申请加入群组 --- UC用户需登录
    public SDKErrorCode applyJoinGroup(String groupName, String ucAccount, String owner)
            throws SDKException
    {
        IClientPublicGroupCapability publicGroupCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPublicGroupCapability.class);
        return publicGroupCapability.applyJoinGroup(groupId, groupName,
                ucAccount, groupCreater, owner);
    }

    // 用户申请退出群组 --- UC用户需登录
    public SDKErrorCode applyQuitGroup(String groupName, String ucAccount, String owner)
            throws SDKException
    {
        IClientPublicGroupCapability publicGroupCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPublicGroupCapability.class);
        return publicGroupCapability.applyQuitGroup(groupId, groupName,
                ucAccount, groupCreater, owner);
    }

    // 群组管理员对加入群组申请的响应 --- UC用户需登录
    public SDKErrorCode replyGroupApply(GroupInfoBase groupInfo,
            String ucAccount, Integer result) throws SDKException
    {
        SDKErrorCode errorCode = null;
        IClientPublicGroupCapability clientPublicGroup = deviceManager
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPublicGroupCapability.class);
        errorCode = clientPublicGroup.replyGroupApply(groupInfo, ucAccount,
                result);
        return errorCode;
    }

    // 群组邀请响应--- UC用户需登录
    public SDKErrorCode replyGroupInvite(GroupInfoBase groupInfo,
            String ucAccount, Integer result) throws SDKException
    {
        SDKErrorCode errorCode = null;
        IClientPublicGroupCapability clientPublicGroup = deviceManager
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        IClientPublicGroupCapability.class);
        errorCode = clientPublicGroup.replyGroupInvite(groupInfo, ucAccount,
                result);
        return errorCode;
    }

    // 群组变更通知回调
    public SDKErrorCode notifyGroupInfo(int msgType, String notifyAccount,
            GroupMember groupMemberChange, Group group)
    {
        return null;
    }

    // 群组管理信息通知回调
    public SDKErrorCode notifyGroupManage(int msgType, String notifyAccount,
            String memberAccount, Group group, List<String> result)
    {
        return null;
    }
    
    /**
     * 固定群消息屏蔽
     * * @return
     */
    public SDKErrorCode screenGroupMsg(GroupInfoBase groupInfo,int isMasked){
        return null;   
    }
    
    /**
     * 修改群组管理员
     * * @return
     * @throws SDKException 
     */
    public SDKErrorCode modGroupOwner(Group groupInfo,GroupMember member) throws SDKException
    {
        UCV2R1C03UserProfilePublicGroupCapability pgAbility = deviceManager
        .getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UCV2R1C03UserProfilePublicGroupCapability.class);
        return pgAbility.modGroupOwner(groupInfo,member);
    }
    
    /**
     * addGroupMemberBatch 
     * 批量邀请成员加入
     * @throws SDKException 
     */
    public SDKResult<List<GroupMember>> addGroupMemberBatch(Group groupInfo) throws SDKException
    {
        UCV2R1C03UserProfilePublicGroupCapability pgAbility = deviceManager
        .getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UCV2R1C03UserProfilePublicGroupCapability.class);
        return pgAbility.addGroupMemberBatch(groupInfo);
    }
    
    /**
     * delGroupMemberBatch 
     * 批量删除群组成员
     * @throws SDKException 
     */
    public SDKResult<List<GroupMember>> delGroupMemberBatch(Group groupInfo) throws SDKException
    {
        UCV2R1C03UserProfilePublicGroupCapability pgAbility = deviceManager
        .getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UCV2R1C03UserProfilePublicGroupCapability.class);
        return pgAbility.delGroupMemberBatch(groupInfo);
    }
    
    /**
     * screenGroupMsg
     *  固定群消息屏蔽
     * * @return
     */
    public SDKErrorCode screenGroupMessage(){
        return null;
    }
    
    public String getGroupDec()
    {
        return groupDec;
    }

    public String getGroupPost()
    {
        return groupPost;
    }

    public void setGroupPost(String groupPost)
    {
        this.groupPost = groupPost;
    }

    public long getMaxNumber()
    {
        return maxNumber;
    }

    public void setMaxNumber(long maxNumber)
    {
        this.maxNumber = maxNumber;
    }

    public GroupValType getValidateType()
    {
        return validateType;
    }

    public void setValidateType(GroupValType validateType)
    {
        this.validateType = validateType;
    }

    public void setGroupDec(String groupDec)
    {
        this.groupDec = groupDec;
    }

    public List<GroupMember> getMembers()
    {
        return members;
    }

    public void setMembers(List<GroupMember> members)
    {
        this.members = members;
    }

    /** * @param maxShareFileSize the maxShareFileSize to set */
    public void setMaxShareFileSize(int maxShareFileSize)
    {
        this.maxShareFileSize = maxShareFileSize;
    }

    /** * @return the maxShareFileSize */
    public int getMaxShareFileSize()
    {
        return maxShareFileSize;
    }

    public int getRecvMsg()
    {
        return recvMsg;
    }

    public void setRecvMsg(int recvMsg)
    {
        this.recvMsg = recvMsg;
    }

}
