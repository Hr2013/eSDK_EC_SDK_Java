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
package com.huawei.esdk.ec.device.bmu.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "QueryLogAuditInfo")
public class QueryLogAuditInfo
{
    @XmlElement(name = "messagetype")
    private String messageType;
    
    @XmlElement(name = "sendaccount")
    private String sendAccount;
    
    @XmlElement(name = "receiveaccount")
    private String receiveAccount;
    
    @XmlElement(name = "sendip")
    private String sendIp;
    
    @XmlElement(name = "receivetime")
    private String receiveTime;
    
    @XmlElement(name = "contentkey")
    private String contentKey;

    public String getMessageType()
    {
        return messageType;
    }

    public void setMessageType(String messageType)
    {
        this.messageType = messageType;
    }

    public String getSendAccount()
    {
        return sendAccount;
    }

    public void setSendAccount(String sendAccount)
    {
        this.sendAccount = sendAccount;
    }

    public String getReceiveAccount()
    {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount)
    {
        this.receiveAccount = receiveAccount;
    }

    public String getSendIp()
    {
        return sendIp;
    }

    public void setSendIp(String sendIp)
    {
        this.sendIp = sendIp;
    }

    public String getReceiveTime()
    {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime)
    {
        this.receiveTime = receiveTime;
    }

    public String getContentKey()
    {
        return contentKey;
    }

    public void setContentKey(String contentKey)
    {
        this.contentKey = contentKey;
    }
}
