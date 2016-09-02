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
package com.huawei.esdk.ec.north.rest.eserver.resource.presence.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.domain.model.UserState;
import com.huawei.esdk.ec.domain.model.UserStateListAck;

/**
 * 用户状态转换类
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  com.huawei.esdk.ec.north.rest.eserver.resource.presence.convert.PresenceResourceConvert
 * @since  eSDK EC V100R003C00
 */
public class PresenceResourceConvert
{
    /** 
     * 批量查询用户状态
     * 转换结果
     * @author wangxiaobo/wWX233376
     * @param result
     * @return
     * @see com.huawei.esdk.ec.north.rest.eserver.resource.presence.convert.PresenceResourceConvert
     */
    public List<com.huawei.esdk.ec.north.rest.bean.eserver.UserState> queryUCListPresenceDomain2North(
        UserStateListAck result)
    {
        List<com.huawei.esdk.ec.north.rest.bean.eserver.UserState> nUserStates =
            new ArrayList<com.huawei.esdk.ec.north.rest.bean.eserver.UserState>();
        
        List<UserState> userStates = result.getStateList();
        
        if (null != userStates && 0 < userStates.size())
        {
            for (UserState userState : userStates)
            {
                
                com.huawei.esdk.ec.north.rest.bean.eserver.UserState nUserState =
                    new com.huawei.esdk.ec.north.rest.bean.eserver.UserState();
                nUserStates.add(nUserState);
                
                nUserState.setClientDesc(userState.getClientDesc());
                nUserState.setClientType(userState.getClientType());
                nUserState.setCode(userState.getCode());
                // userState.setExtParams(userState.extParams);
                nUserState.setNewState(userState.getNewState());
                nUserState.setNewStateDesc(userState.getNewStateDesc());
                nUserState.setOldState(userState.getOldState());
                nUserState.setOldStateDesc(userState.getOldStateDesc());
                nUserState.setOrigin(userState.getOrigin());
                nUserState.setPriorityLevel(userState.getPriorityLevel());
                nUserState.setSno(userState.getSno());
                nUserState.setStamp(userState.getStamp());
                nUserState.setTarget(userState.getTarget());
            }
            
        }
        
        return nUserStates;
    }
    
}
