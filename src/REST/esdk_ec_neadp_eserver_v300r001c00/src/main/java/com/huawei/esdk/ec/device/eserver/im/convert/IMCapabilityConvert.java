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
package com.huawei.esdk.ec.device.eserver.im.convert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

import message.Chat;
import message.SystemNoticeForEsdk;

import com.huawei.esdk.ec.common.UCConstant;
import com.huawei.esdk.ec.domain.model.DeptInstanceMessage;
import com.huawei.esdk.ec.domain.model.GroupInstanceMessage;
import com.huawei.esdk.ec.domain.model.UCUserInstanceMessage;
import com.huawei.esdk.platform.common.utils.Base64Utils;

public class IMCapabilityConvert
{
    public Chat appSendMsgToUCModal2Rest(UCUserInstanceMessage userInstanceMessage)
    {
        Chat chat = new Chat();
        chat.origin = userInstanceMessage.getSender();
        chat.target = userInstanceMessage.getUcAccount();
        chat.flag = UCConstant.MSG_FLAG_NORMAL;
        chat.contentType = UCConstant.MSG_CONTENT_TYPE_HTML;
        chat.content =
            addMsgContentFormat(userInstanceMessage.getSender(),
                UCConstant.MSG_FLAG_COMPRESSED,
                userInstanceMessage.getContent());
        userInstanceMessage.getContent();
        
        if (null != userInstanceMessage.getDateTime())
            chat.deliverTime = userInstanceMessage.getDateTime().getTime();
        return chat;
    }
    
    private String addMsgContentFormat(String ucAccount, int flag, String msg)
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<r>");
        sb.append("<n>");
        try
        {
            sb.append(Base64Utils.encode(null == ucAccount ? "".getBytes() : ucAccount.getBytes("UTF-8")));
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        sb.append("</n>");
        sb.append("<g>");
        sb.append(flag);
        sb.append("</g>");
        sb.append("<c>");
        
        if (UCConstant.MSG_FLAG_COMPRESSED == flag)
        {
            sb.append(Base64Utils.encode(compress(msg)));
        }
        else
        {
            sb.append(msg);
        }
        
        sb.append("</c>");
        sb.append("</r>");
        
        return sb.toString();
    }
    
    private byte[] compress(String msg)
    {
        if ((msg == null) || (msg.length() == 0))
        {
            return new byte[0];
        }
        
        byte[] compressed = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream(msg.length());
        GZIPOutputStream gos;
        try
        {
            gos = new GZIPOutputStream(bos);
            gos.write(msg.getBytes("UTF-8"));
            gos.close();
            
            compressed = bos.toByteArray();
            bos.close();
        }
        catch (IOException e)
        {
            return new byte[0];
        }
        
        return compressed;
    }
    
    public Chat appSendMsgToGroupModal2Rest(GroupInstanceMessage groupInstanceMessage)
    {
        Chat chat = new Chat();
        chat.origin = groupInstanceMessage.getSender();
        chat.groupID = groupInstanceMessage.getGroupId();
        chat.flag = UCConstant.MSG_FLAG_GROUP;
        chat.contentType = UCConstant.MSG_CONTENT_TYPE_HTML;
        chat.content =
            addMsgContentFormat(groupInstanceMessage.getSender(),
                UCConstant.MSG_FLAG_COMPRESSED,
                groupInstanceMessage.getContent());
        if (null != groupInstanceMessage.getDateTime())
            chat.deliverTime = groupInstanceMessage.getDateTime().getTime();
        return chat;
    }
    
    public SystemNoticeForEsdk appSendMsgToDeptModal2Rest(DeptInstanceMessage deptInstanceMessage)
    {
        SystemNoticeForEsdk result = new SystemNoticeForEsdk();
        result.sender = deptInstanceMessage.getSender();
        result.subject = deptInstanceMessage.getSubject();
        result.content = deptInstanceMessage.getContent();
        result.departmentId = deptInstanceMessage.getDeptNo();
        result.receiverType = 0;
        return result;
    }
    
}
