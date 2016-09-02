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
package com.huawei.esdk.uc.professional.local.bean.south;

public class LogAuditInfo
{
    private String messageType;
    
    private String sendAccount;
    
    private String receiveAccount;
    
    private String sendIp;
    
    private String receiveTime;
    
    private String content;
    
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
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
}
