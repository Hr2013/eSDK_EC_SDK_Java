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
import com.huawei.esdk.ec.device.eserver.multiapponline.convert.GroupIMCapabilityConvert;
import com.huawei.esdk.ec.devices.eserver.multiapponline.IGroupIMCapability;
import com.huawei.esdk.ec.domain.model.multiapponline.GroupIMModel;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 南向协议无关层
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class GroupIMCapabilityImpl extends AbstractEServerCapability implements IGroupIMCapability
{
    private static final Logger LOGGER = Logger.getLogger(GroupIMCapabilityImpl.class);
    
    GroupIMCapabilityConvert groupIMCapabilityConvert = new GroupIMCapabilityConvert();
    
    public GroupIMCapabilityImpl(ClientHandler clientHandler)
    {
        super(clientHandler);
    }
    
    @Override
    public SDKResult<String> sendGroupIm(GroupIMModel groupIm)
    {
        LOGGER.debug("sendGroupIm start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        //        Chat chat = groupIMCapabilityConvert.sendGroupImModal2Rest(groupIm);
        //        asyncSendMessage(chat.sno, chat.originAppID, buildEsdkMsg(null, chat, PriorityLevel.NORMAL));
        //        
        //        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //        result.setResult(String.valueOf(chat.sno));
        
        LOGGER.debug("sendGroupIm end");
        
        return result;
    }
}
