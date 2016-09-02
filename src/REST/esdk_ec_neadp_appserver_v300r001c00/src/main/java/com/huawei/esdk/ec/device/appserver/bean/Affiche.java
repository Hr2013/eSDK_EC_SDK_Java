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
@XmlRootElement(name = "Affiche")
public class Affiche
{
    /**
     * 公告主题
     */
    @XmlElement(name = "afficheTitle")
    private String afficheTitle;
    
    /**
     * 公告内容
     */
    @XmlElement(name = "afficheContent")
    private String afficheContent;
    
    /**
     * 0代表部门发送，1代表按用户发送
     */
    @XmlElement(name = "receiverType")
    private String receiverType;
    
    public String getAfficheTitle()
    {
        return afficheTitle;
    }
    
    public void setAfficheTitle(String afficheTitle)
    {
        this.afficheTitle = afficheTitle;
    }
    
    public String getAfficheContent()
    {
        return afficheContent;
    }
    
    public void setAfficheContent(String afficheContent)
    {
        this.afficheContent = afficheContent;
    }
    
    public String getReceiverType()
    {
        return receiverType;
    }
    
    public void setReceiverType(String receiverType)
    {
        this.receiverType = receiverType;
    }
    
}
