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
package com.huawei.esdk.ec.device.eserver.presence;

import java.util.List;

import message.UserStateList;

import org.apache.log4j.Logger;

import com.huawei.ecs.client.ClientHandler;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.device.AbstractEServerCapability;
import com.huawei.esdk.ec.device.eserver.bean.IMInfo;
import com.huawei.esdk.ec.device.eserver.presence.convert.PresenceCapabilityConvert;
import com.huawei.esdk.ec.devices.eserver.IPresenceCapability;
import com.huawei.esdk.ec.domain.model.UserStateListAck;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 用户状态
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  com.huawei.esdk.ec.devices.eserver.IPresenceCapability
 * @since  eSDK EC V100R003C00
 */
public class PresenceCapabilityImpl extends AbstractEServerCapability implements IPresenceCapability
{
    private static final Logger LOGGER = Logger.getLogger(PresenceCapabilityImpl.class);
    
    private PresenceCapabilityConvert presenceCapabilityConvert = new PresenceCapabilityConvert();
    
    public PresenceCapabilityImpl(ClientHandler clientHandler)
    {
        super(clientHandler);
    }
    
    @Override
    public SDKResult<UserStateListAck> queryUCPresence(List<String> ucAccount)
    {
        LOGGER.debug("query user presence start");
        SDKResult<UserStateListAck> result = new SDKResult<UserStateListAck>();
        
        //入参转换
        UserStateList userState = presenceCapabilityConvert.queryUCListPresenceRest2Udp(null, ucAccount);
        
        SDKResult<IMInfo> response =
            syncSendMessage(String.valueOf(userState.sno),
                buildEsdkMsg(userState.user, userState, userState.getPriorityLevel()));
        
        if (null == response.getResult() || null == response.getResult().getUserStateListAck())
        {
            result.setErrCode(ErrInfo.EServerErrInfo.QUERY_USER_STATUS_TIMEOUT_ERRORCODE);
            result.setDescription(ErrInfo.EServerErrInfo.QUERY_USER_STATUS_TIMEOUT_ERRORDESC);
        }
        else
        {
            result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
            result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
            result.setResult(presenceCapabilityConvert.queryUCListPresenceUdp2Rest(response.getResult()
                .getUserStateListAck()));
        }
        
        LOGGER.debug("query user presence result end");
        
        return result;
    }
}
