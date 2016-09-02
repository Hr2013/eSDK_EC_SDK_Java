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
package com.huawei.esdk.ec.device.appserver.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "HisMsgInfo")
public class HisMsgInfo
{
    @XmlElement(name = "sender")
    private String sender;
    
    @XmlElement(name = "msgid")
    private int msgid;
    
    @XmlElement(name = "msgtype")
    private int msgtype;
    
    @XmlElement(name = "msgcontent")
    private String msgcontent;
    
    @XmlElement(name = "msgcontentstr")
    private String msgcontentstr;
    
    @XmlElement(name = "recordtime")
    private String recordtime;
    
    @XmlElement(name = "compressed")
    private int compressed;
    
    @XmlElement(name = "contenttype")
    private int contenttype;
    
    public String getSender()
    {
        return sender;
    }
    
    public void setSender(String sender)
    {
        this.sender = sender;
    }
    
    public int getMsgid()
    {
        return msgid;
    }
    
    public void setMsgid(int msgid)
    {
        this.msgid = msgid;
    }
    
    public int getMsgtype()
    {
        return msgtype;
    }
    
    public void setMsgtype(int msgtype)
    {
        this.msgtype = msgtype;
    }
    
    public String getMsgcontent()
    {
        return msgcontent;
    }
    
    public void setMsgcontent(String msgcontent)
    {
        this.msgcontent = msgcontent;
    }
    
    public String getMsgcontentstr()
    {
        return msgcontentstr;
    }
    
    public void setMsgcontentstr(String msgcontentstr)
    {
        this.msgcontentstr = msgcontentstr;
    }
    
    public String getRecordtime()
    {
        return recordtime;
    }
    
    public void setRecordtime(String recordtime)
    {
        this.recordtime = recordtime;
    }
    
    public int getCompressed()
    {
        return compressed;
    }
    
    public void setCompressed(int compressed)
    {
        this.compressed = compressed;
    }
    
    public int getContenttype()
    {
        return contenttype;
    }
    
    public void setContenttype(int contenttype)
    {
        this.contenttype = contenttype;
    }
    
}
