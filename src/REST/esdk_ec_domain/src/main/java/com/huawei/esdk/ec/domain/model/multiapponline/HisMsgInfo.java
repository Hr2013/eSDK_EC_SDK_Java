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
package com.huawei.esdk.ec.domain.model.multiapponline;

public class HisMsgInfo
{
    private String sender;
    
    private String msgId;
    
    private String msgType;
    
    private String msgContent;
    
    private String msgContentStr;
    
    private String recordTime;
    
    private String compressed;
    
    private String contentType;

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getMsgId()
    {
        return msgId;
    }

    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
    }

    public String getMsgType()
    {
        return msgType;
    }

    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }

    public String getMsgContent()
    {
        return msgContent;
    }

    public void setMsgContent(String msgContent)
    {
        this.msgContent = msgContent;
    }

    public String getMsgContentStr()
    {
        return msgContentStr;
    }

    public void setMsgContentStr(String msgContentStr)
    {
        this.msgContentStr = msgContentStr;
    }

    public String getRecordTime()
    {
        return recordTime;
    }

    public void setRecordTime(String recordTime)
    {
        this.recordTime = recordTime;
    }

    public String getCompressed()
    {
        return compressed;
    }

    public void setCompressed(String compressed)
    {
        this.compressed = compressed;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }
    
    
}
