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

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.ec.device.appserver.bean.Adapter2;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
})
@XmlRootElement(name = "params")
public class ReportTypeResBean
{
    @XmlElement(name="confid")
    private String confId;
    
    @XmlElement(name="conftype")
    private String confType;
    
    @XmlElement(name="dataconfurl")
    private String dataConfURL;
    
    @XmlElement(name="siteid")
    private String siteId;
    
    @XmlElement(name="hostkey")
    private String hostKey;
    
    @XmlElement(name="attendeenum")
    private String attendeeNum;
    
    @XmlElement(name="attendeetype")
    private String attendeeType;
    
    @XmlElement(name="token")
    private String token;
    
    @XmlJavaTypeAdapter(Adapter2.class)
    @XmlElement(name="timestamp")
    private Date timestamp;
    
    @XmlElement(name="cmAddress")
    private String msAddr;

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
    }

    public String getConfType()
    {
        return confType;
    }

    public void setConfType(String confType)
    {
        this.confType = confType;
    }

    public String getDataConfURL()
    {
        return dataConfURL;
    }

    public void setDataConfURL(String dataConfURL)
    {
        this.dataConfURL = dataConfURL;
    }

    public String getSiteId()
    {
        return siteId;
    }

    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    public String getHostKey()
    {
        return hostKey;
    }

    public void setHostKey(String hostKey)
    {
        this.hostKey = hostKey;
    }

    public String getAttendeeNum()
    {
        return attendeeNum;
    }

    public void setAttendeeNum(String attendeeNum)
    {
        this.attendeeNum = attendeeNum;
    }

    public String getAttendeeType()
    {
        return attendeeType;
    }

    public void setAttendeeType(String attendeeType)
    {
        this.attendeeType = attendeeType;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public Date getTimestamp()
    {
        if(timestamp == null)
            return null;
        return (Date)timestamp.clone();
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = (Date)timestamp.clone();
    }

    public String getMsAddr()
    {
        return msAddr;
    }

    public void setMsAddr(String msAddr)
    {
        this.msAddr = msAddr;
    }
}
