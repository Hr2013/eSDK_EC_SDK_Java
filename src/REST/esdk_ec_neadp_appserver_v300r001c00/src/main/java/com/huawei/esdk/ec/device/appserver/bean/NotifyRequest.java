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
@XmlRootElement(name = "params")
public class NotifyRequest
{
    @XmlElement(name = "opt")
    private String opt;
    
    @XmlElement(name = "ctcuserstateurl")
    private String userStateURL;
    
    @XmlElement(name = "ctcconferstateurl")
    private String conferStateURL;
    
    @XmlElement(name = "ctcconfinfourl")
    private String confInfoURL;
    
    public String getOpt()
    {
        return opt;
    }
    
    public void setOpt(String opt)
    {
        this.opt = opt;
    }
    
    public String getUserStateURL()
    {
        return userStateURL;
    }
    
    public void setUserStateURL(String userStateURL)
    {
        this.userStateURL = userStateURL;
    }
    
    public String getConferStateURL()
    {
        return conferStateURL;
    }
    
    public void setConferStateURL(String conferStateURL)
    {
        this.conferStateURL = conferStateURL;
    }
    
    public String getConfInfoURL()
    {
        return confInfoURL;
    }
    
    public void setConfInfoURL(String confInfoURL)
    {
        this.confInfoURL = confInfoURL;
    }
    
}
