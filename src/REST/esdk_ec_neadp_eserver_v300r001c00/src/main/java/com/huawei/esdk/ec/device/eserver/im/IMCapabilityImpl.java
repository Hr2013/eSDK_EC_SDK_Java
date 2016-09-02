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
package com.huawei.esdk.ec.device.eserver.im;

import message.Chat;
import message.SystemNoticeForEsdk;

import org.apache.log4j.Logger;

import com.huawei.ecs.client.ClientHandler;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.device.AbstractEServerCapability;
import com.huawei.esdk.ec.device.eserver.bean.IMInfo;
import com.huawei.esdk.ec.device.eserver.im.convert.IMCapabilityConvert;
import com.huawei.esdk.ec.devices.v300r001c00.im.ECV3R1C00IMCapability;
import com.huawei.esdk.ec.domain.model.Affiche;
import com.huawei.esdk.ec.domain.model.DeptInstanceMessage;
import com.huawei.esdk.ec.domain.model.GroupInstanceMessage;
import com.huawei.esdk.ec.domain.model.UCUserInstanceMessage;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 南向协议无关层 
 * @author  gWX169839
 */
public class IMCapabilityImpl extends AbstractEServerCapability implements ECV3R1C00IMCapability
{
    private static final Logger LOGGER = Logger.getLogger(IMCapabilityImpl.class);
    
    IMCapabilityConvert imCapabilityConvert = new IMCapabilityConvert();
    
    public IMCapabilityImpl(ClientHandler clientHandler)
    {
        super(clientHandler);
    }
    
    @Override
    public SDKErrorCode appSendMsgToUC(UCUserInstanceMessage userInstanceMessage)
    {
        LOGGER.debug("appSendMsgToUC start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        Chat chat = imCapabilityConvert.appSendMsgToUCModal2Rest(userInstanceMessage);
        SDKResult<IMInfo> response =
            syncSendMessage(String.valueOf(chat.sno),
                buildEsdkMsg(userInstanceMessage.getSender(),
                    chat,
                    getPriorityLevelInt2Enum(userInstanceMessage.getPriorityLevel())));
        
        if (null == response.getResult() || null == response.getResult().getChatAck())
        {
            result.setErrCode(ErrInfo.EServerErrInfo.IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORCODE);
            result.setDescription(ErrInfo.EServerErrInfo.IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORDESC);
        }
        else
        {
            result.setErrCode(response.getResult().getChatAck().result);
            
            if (ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE == result.getErrCode())
            {
                result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
            }
        }
        
        LOGGER.debug("appSendMsgToUC end");
        
        return result;
    }
    
    @Override
    public SDKErrorCode appSendMsgToDept(DeptInstanceMessage deptInstanceMessage)
    {
        LOGGER.debug("appSendMsgToDept start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        SystemNoticeForEsdk chat = imCapabilityConvert.appSendMsgToDeptModal2Rest(deptInstanceMessage);
        
        //发送消息
        SDKResult<IMInfo> response =
            syncSendMessage(String.valueOf(chat.sno),
                buildEsdkMsg(deptInstanceMessage.getSender(),
                    chat,
                    getPriorityLevelInt2Enum(deptInstanceMessage.getPriorityLevel())));
        
        if (null == response.getResult() || null == response.getResult().getDeptChatAck())
        {
            result.setErrCode(ErrInfo.EServerErrInfo.IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORCODE);
            result.setDescription(ErrInfo.EServerErrInfo.IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORDESC);
        }
        else
        {
            result.setErrCode(response.getResult().getDeptChatAck().resultCode);
            
            if (ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE == result.getErrCode())
            {
                result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
            }
        }
        
        LOGGER.debug("appSendMsgToDept end");
        
        return result;
    }
    
    @Override
    public SDKErrorCode appSendMsgToGroup(GroupInstanceMessage groupInstanceMessage)
    {
        LOGGER.debug("appSendMsgToGroup start");
        SDKResult<String> result = new SDKResult<String>();
        
        //入参转换
        Chat chat = imCapabilityConvert.appSendMsgToGroupModal2Rest(groupInstanceMessage);
        
        //发送消息
        SDKResult<IMInfo> response =
            syncSendMessage(String.valueOf(chat.sno),
                buildEsdkMsg(groupInstanceMessage.getSender(),
                    chat,
                    getPriorityLevelInt2Enum(groupInstanceMessage.getPriorityLevel())));
        
        if (null == response.getResult() || null == response.getResult().getChatAck())
        {
            result.setErrCode(ErrInfo.EServerErrInfo.IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORCODE);
            result.setDescription(ErrInfo.EServerErrInfo.IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORDESC);
        }
        else
        {
            result.setErrCode(response.getResult().getChatAck().result);
            
            if (ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE == result.getErrCode())
            {
                result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
            }
        }
        LOGGER.debug("appSendMsgToGroup end");
        
        return result;
    }
    
    @Override
    public SDKErrorCode sendAffiche(Affiche affiche)
    {
        throw new UnsupportedOperationException();
    }
}
