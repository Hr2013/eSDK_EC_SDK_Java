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
package com.huawei.esdk.ec.device.eserver.presence.convert;

import java.util.ArrayList;
import java.util.List;

import message.UserStateList;
import com.huawei.esdk.ec.domain.model.UserState;
import com.huawei.esdk.ec.domain.model.UserStateListAck;
import comm.udp.PriorityLevel;

/**
 * 用户状态转换类
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  com.huawei.esdk.ec.device.eserver.presence.convert.PresenceCapabilityConvert
 * @since  eSDK EC V100R003C00
 */
public class PresenceCapabilityConvert
{
    /** 
     * 批量查询用户状态
     * 转换入参
     * @author wangxiaobo/wWX233376
     * @param user
     * @param queryUsers
     * @return
     * @see com.huawei.esdk.ec.device.eserver.presence.convert.PresenceCapabilityConvert
     */
    public UserStateList queryUCListPresenceRest2Udp(String user, List<String> queryUsers)
    {
        UserStateList userState = new UserStateList();
        userState.user = user;
        userState.targets = queryUsers;
        
        return userState;
    }
    
    /** 
     * 批量查询用户状态
     * 转换结果
     * @author wangxiaobo/wWX233376
     * @param mUserStateListAck
     * @return
     * @see com.huawei.esdk.ec.device.eserver.presence.convert.PresenceCapabilityConvert
     */
    public UserStateListAck queryUCListPresenceUdp2Rest(message.UserStateListAck mUserStateListAck)
    {
        UserStateListAck userStateListAck = new UserStateListAck();
        
        if (null != mUserStateListAck)
        {
            userStateListAck.setCode(mUserStateListAck.code);
            userStateListAck.setSno(mUserStateListAck.sno);
            userStateListAck.setStamp(mUserStateListAck.stamp);
            
            // userStateListAck.setExtParams(mUserStateListAck.extParams);
            userStateListAck.setPriorityLevel(getPriorityLevelEnum2Int(mUserStateListAck.getPriorityLevel()));
            userStateListAck.setUser(mUserStateListAck.user);
            
            List<UserState> userStates = new ArrayList<UserState>();
            userStateListAck.setStateList(userStates);
            
            if (null != mUserStateListAck.stateList && 0 != mUserStateListAck.stateList.size())
            {
                for (message.UserState mUserState : mUserStateListAck.stateList)
                {
                    UserState userState = new UserState();
                    userStates.add(userState);
                    
                    userState.setClientDesc(mUserState.clientDesc);
                    userState.setClientType(mUserState.clientType);
                    userState.setCode(mUserState.code);
                    // userState.setExtParams(mUserState.extParams);
                    userState.setNewState(mUserState.newState);
                    userState.setNewStateDesc(mUserState.newStateDesc);
                    userState.setOldState(mUserState.oldState);
                    userState.setOldStateDesc(mUserState.oldStateDesc);
                    userState.setOrigin(mUserState.origin);
                    userState.setPriorityLevel(getPriorityLevelEnum2Int(mUserStateListAck.getPriorityLevel()));
                    userState.setSno(mUserState.sno);
                    userState.setStamp(mUserState.stamp);
                    userState.setTarget(mUserState.target);
                }
            }
        }
        
        return userStateListAck;
    }
    
    private String getPriorityLevelEnum2Int(PriorityLevel input)
    {
        if (null == input)
        {
            return null;
        }
        
        switch (input)
        {
            case LOW:
                return "2";
                
            case NORMAL:
                return "1";
                
            case HIGH:
                return "0";
                
            default:
                return "1";
        }
    }
}
