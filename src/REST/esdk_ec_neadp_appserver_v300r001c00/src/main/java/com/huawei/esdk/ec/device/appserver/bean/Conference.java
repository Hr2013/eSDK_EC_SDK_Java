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

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "Conference")
public class Conference
{
    @XmlElement(name = "confid")
    private String confId;
    
    @XmlElement(name = "topic")
    private String topic;
    
    @XmlJavaTypeAdapter(Adapter1.class)
    @XmlElement(name = "time")
    private Date startTime;
    
    @XmlElement(name = "emcee")
    private String emcee;
    
    @XmlElement(name = "status")
    private String status;
    
    public String getConfId()
    {
        return confId;
    }
    
    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
    public String getTopic()
    {
        return topic;
    }
    
    public void setTopic(String topic)
    {
        this.topic = topic;
    }
    
    public Date getStartTime()
    {
        if(startTime == null)
            return null;
        return (Date)startTime.clone();
    }
    
    public void setStartTime(Date startTime)
    {
        this.startTime = (Date)startTime.clone();
    }
    
    public String getEmcee()
    {
        return emcee;
    }
    
    public void setEmcee(String emcee)
    {
        this.emcee = emcee;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
}
