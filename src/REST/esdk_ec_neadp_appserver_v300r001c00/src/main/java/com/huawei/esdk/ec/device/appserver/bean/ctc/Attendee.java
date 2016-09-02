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
package com.huawei.esdk.ec.device.appserver.bean.ctc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attendee", propOrder = {})
public class Attendee
{
    @XmlElement(name = "cee")
    private String cee;
    
    @XmlElement(name = "status")
    private String status;
    
    @XmlElement(name = "auth")
    private int auth;
    
    @XmlElement(name = "time")
    private String time;
    
    @XmlElement(name = "displayName")
    private String displayName;
    
    @XmlElement(name = "espaceAccount")
    private String espaceAccount;
    
    @XmlElement(name = "mediaType")
    private String mediaType;
    
    @XmlElement(name = "ucType")
    private String ucType;
    
    public String getCee()
    {
        return cee;
    }
    
    public void setCee(String cee)
    {
        this.cee = cee;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public int getAuth()
    {
        return auth;
    }
    
    public void setAuth(int auth)
    {
        this.auth = auth;
    }
    
    public String getTime()
    {
        return time;
    }
    
    public void setTime(String time)
    {
        this.time = time;
    }
    
    public String getDisplayName()
    {
        return displayName;
    }
    
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }
    
    public String getEspaceAccount()
    {
        return espaceAccount;
    }
    
    public void setEspaceAccount(String espaceAccount)
    {
        this.espaceAccount = espaceAccount;
    }
    
    public String getMediaType()
    {
        return mediaType;
    }
    
    public void setMediaType(String mediaType)
    {
        this.mediaType = mediaType;
    }
    
    public String getUcType()
    {
        return ucType;
    }
    
    public void setUcType(String ucType)
    {
        this.ucType = ucType;
    }
    
}
