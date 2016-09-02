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
package com.huawei.esdk.ec.device.eserver.multiapponline;

import org.apache.log4j.Logger;

import com.huawei.ecs.client.ClientHandler;
import com.huawei.esdk.ec.device.AbstractEServerCapability;
import com.huawei.esdk.ec.device.eserver.multiapponline.convert.GroupCapabilityConvert;
import com.huawei.esdk.ec.devices.eserver.multiapponline.IGroupCapability;
import com.huawei.esdk.ec.domain.model.multiapponline.Group;
import com.huawei.esdk.ec.domain.model.multiapponline.GroupMember;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 南向协议无关层
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class GroupCapabilityImpl extends AbstractEServerCapability implements IGroupCapability
{
    private static final Logger LOGGER = Logger.getLogger(GroupCapabilityImpl.class);
    
    GroupCapabilityConvert groupCapabilityConvert = new GroupCapabilityConvert();
    
    public GroupCapabilityImpl(ClientHandler clientHandler)
    {
        super(clientHandler);
    }
    
    @Override
    public SDKResult<String> getIMGroup(String queryKey, String isNeedAmount, String count, String senderAppID,
        String senderType, String pageIndex)
    {
        LOGGER.debug("getIMGroup start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        //        IMGroupQuery imGroupQuery =
        //            groupCapabilityConvert.getIMGroupModal2UDP(queryKey,
        //                isNeedAmount,
        //                count,
        //                senderAppID,
        //                senderType,
        //                pageIndex);
        
        //        EsdkMsg esdkMsg = buildEsdkMsg(null, imGroupQuery, PriorityLevel.NORMAL);
        //        
        //        asyncSendMessage(esdkMsg.sno, imGroupQuery.senderAppID, esdkMsg);
        //        
        //        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //        result.setResult(String.valueOf(esdkMsg.sno));
        
        LOGGER.debug("getIMGroup end");
        
        return result;
        
    }
    
    @Override
    public SDKResult<String> addGroup(Group imGroup)
    {
        LOGGER.debug("addGroup start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        //        message.Group group = groupCapabilityConvert.addGroupModal2UDP(imGroup);
        //        asyncSendMessage(group.sno, group.senderAppID, buildEsdkMsg(null, group, PriorityLevel.NORMAL));
        //        
        //        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //        result.setResult(String.valueOf(group.sno));
        
        LOGGER.debug("addGroup end");
        
        return result;
    }
    
    @Override
    public SDKResult<String> setGroup(Group imGroup)
    {
        LOGGER.debug("setGroup start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        //        message.Group group = groupCapabilityConvert.setGroupModal2UDP(imGroup);
        //        asyncSendMessage(group.sno, group.senderAppID, buildEsdkMsg(null, group, PriorityLevel.NORMAL));
        //        
        //        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //        result.setResult(String.valueOf(group.sno));
        
        LOGGER.debug("setGroup end");
        
        return result;
    }
    
    @Override
    public SDKResult<String> delGroup(Group imGroup)
    {
        LOGGER.debug("setGroup start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        //        message.Group group = groupCapabilityConvert.delGroupModal2UDP(imGroup);
        //        asyncSendMessage(group.sno, group.senderAppID, buildEsdkMsg(null, group, PriorityLevel.NORMAL));
        //        
        //        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //        result.setResult(String.valueOf(group.sno));
        
        LOGGER.debug("setGroup end");
        
        return result;
    }
    
    @Override
    public SDKResult<String> getGroupMembers(String appId, String imGroupID, String syncType, String stamp)
    {
        LOGGER.debug("getGroupMembers start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        //        IMGroupMemQuery imGroupMemQuery = groupCapabilityConvert.getGroupMembersModal2UDP(imGroupID, syncType, stamp);
        //        EsdkMsg esdkMsg = buildEsdkMsg(null, imGroupMemQuery, PriorityLevel.NORMAL);
        //        asyncSendMessage(esdkMsg.sno, appId, esdkMsg);
        //        
        //        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //        result.setResult(String.valueOf(esdkMsg.sno));
        
        LOGGER.debug("getGroupMembers end");
        
        return result;
        
    }
    
    @Override
    public SDKResult<String> addGroupMembers(GroupMember groupMember)
    {
        LOGGER.debug("addGroupMembers start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        //        JoinGroup joinGroup = groupCapabilityConvert.addGroupMembersModal2UDP(groupMember);
        //        asyncSendMessage(joinGroup.sno, joinGroup.senderAppID, buildEsdkMsg(null, joinGroup, PriorityLevel.NORMAL));
        //        
        //        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //        result.setResult(String.valueOf(joinGroup.sno));
        
        LOGGER.debug("addGroupMembers end");
        
        return result;
    }
    
    @Override
    public SDKResult<String> delGroupMembers(GroupMember groupMember)
    {
        LOGGER.debug("delGroupMembers start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        //        LeaveGroup leaveGroup = groupCapabilityConvert.delGroupMembersModal2UDP(groupMember);
        //        asyncSendMessage(leaveGroup.sno, leaveGroup.senderAppID, buildEsdkMsg(null, leaveGroup, PriorityLevel.NORMAL));
        //        
        //        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //        result.setResult(String.valueOf(leaveGroup.sno));
        
        LOGGER.debug("delGroupMembers end");
        
        return result;
    }
}
