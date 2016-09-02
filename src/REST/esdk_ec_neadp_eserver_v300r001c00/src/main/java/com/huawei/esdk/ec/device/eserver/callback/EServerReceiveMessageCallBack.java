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
package com.huawei.esdk.ec.device.eserver.callback;

import com.huawei.ecs.client.ReceiveMessageCallBack;
import com.huawei.esdk.ec.device.AbstractEServerCapability;
import com.huawei.esdk.ec.device.eserver.bean.IMInfo;
import com.huawei.esdk.platform.callback.ISouthCallbackService;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;

import comm.codec.BaseMessage;
import message.ChatAck;
import message.SystemNoticeForEsdkAck;
import message.UserStateListAck;

/**
 * 回调消息类
 * @author wangxiaobo/wWX233376
 * @see  com.huawei.ecs.client.ReceiveMessageCallBack
 * @since  eSDK EC V100R003C00
 */
public class EServerReceiveMessageCallBack implements ReceiveMessageCallBack
{
    private final static EServerReceiveMessageCallBack instance = new EServerReceiveMessageCallBack();
    
    private EServerReceiveMessageCallBack()
    {
        super();
    }
    
    public static EServerReceiveMessageCallBack getInstance()
    {
        return instance;
    }
    
    // 接收消息
    @Override
    public void receiveMessage(Object message)
    {
        long sno = 0;
        
        ISouthCallbackService service = ApplicationContextUtil.getBean("eserverCallbackService");
        
        if (null == message)
        {
            service.processCallbackMessage(null);
            return;
        }
        
        IMInfo imInfo = null;
        
        if (message instanceof BaseMessage)
        {
            sno = ((BaseMessage)message).sno;
        }
        
        imInfo = AbstractEServerCapability.getImInfoMap().get(String.valueOf(sno));
        
        //同步
        if (null != imInfo)
        {
            if (message instanceof UserStateListAck)
            {
                imInfo.setUserStateListAck((UserStateListAck)message);
            }
            else if (message instanceof ChatAck)
            {
                imInfo.setChatAck((ChatAck)message);
            }
            else if (message instanceof SystemNoticeForEsdkAck)
            {
                imInfo.setDeptChatAck((SystemNoticeForEsdkAck)message);
            }
            //            else if (message instanceof GetAppInfoAck)
            //            {
            //                imInfo.setAppInfoAck((GetAppInfoAck)message);
            //            }
            
            imInfo.getLatch().countDown();
        }
        // 回调
        //        else
        //        {
        //            Gson gson = new Gson();
        //            
        //            //以下是多应用在线接口，采用回调实现
        //            Class<?>[] clzs = {GroupAck.class, IMGroupQueryAck.class, IMGroupMemQueryAck.class, JoinGroupAck.class,
        //                LeaveGroupAck.class, ChatAck.class, EsdkGetAppUserStateListAck.class};
        //                
        //            for (int i = 0; i < clzs.length; i++)
        //            {
        //                if (message.getClass().equals(clzs[i]))
        //                {
        //                    service.processCallbackMessage(i + "-" + String.valueOf(sno) + "-" + gson.toJson(message));
        //                }
        //            }
        //        }
    }
}