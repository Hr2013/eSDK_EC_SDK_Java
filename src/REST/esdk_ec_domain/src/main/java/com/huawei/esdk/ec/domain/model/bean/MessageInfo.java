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
package com.huawei.esdk.ec.domain.model.bean;

/** * @author w00208247 * * */
public class MessageInfo
{
    private String sender;
    private String receiver;
    private String msgId;
    private String groupId;
    private String msgtTime;
    private String msgType;
    private String encodeType;
    private String subject;
    private String content;
    
    public String getSender()
    {
        return sender;
    }
    public void setSender(String sender)
    {
        this.sender = sender;
    }
    public String getMsgtTime()
    {
        return msgtTime;
    }
    public void setMsgtTime(String msgtTime)
    {
        this.msgtTime = msgtTime;
    }
    public String getMsgType()
    {
        return msgType;
    }
    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }
    public String getEncodeType()
    {
        return encodeType;
    }
    public void setEncodeType(String encodeType)
    {
        this.encodeType = encodeType;
    }
    public String getSubject()
    {
        return subject;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content = content;
    }
    public String getReceiver()
    {
        return receiver;
    }
    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
    }
    public String getMsgId()
    {
        return msgId;
    }
    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
    }
    public String getGroupId()
    {
        return groupId;
    }
    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }
}
