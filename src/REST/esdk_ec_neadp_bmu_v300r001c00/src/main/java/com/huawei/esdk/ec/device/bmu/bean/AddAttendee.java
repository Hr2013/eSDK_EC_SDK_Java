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
@XmlRootElement(name = "AddAttendee")
public class AddAttendee
{
    @XmlElement(name = "gwip")
    private String gwIp;
    
    @XmlElement(name = "subpbx")
    private String subPbx;
    
//    @XmlElement(name = "confno")
//    private String confNo;
    
    @XmlElement(name = "confid")
    private String confId;
    
    @XmlElement(name = "account")
    private String account;
    
    @XmlElement(name = "attnumber")
    private String attNumber;
    
    @XmlElement(name = "atttype")
    private String attType;
    
    //@XmlElement(name = "attstatus")
    //private String attStatus;
    
    //@XmlElement(name = "speakstatus")
    //private String speakStatus;
    
    @XmlElement(name = "email")
    private String email;

    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }

    public String getSubPbx()
    {
        return subPbx;
    }

    public void setSubPbx(String subpbx)
    {
        this.subPbx = subpbx;
    }

//    public String getConfNo()
//    {
//        return confNo;
//    }
//
//    public void setConfNo(String confNo)
//    {
//        this.confNo = confNo;
//    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getAttNumber()
    {
        return attNumber;
    }

    public void setAttNumber(String attNumber)
    {
        this.attNumber = attNumber;
    }

    public String getAttType()
    {
        return attType;
    }

    public void setAttType(String attType)
    {
        this.attType = attType;
    }

//    public String getAttStatus()
//    {
//        return attStatus;
//    }
//
//    public void setAttStatus(String attStatus)
//    {
//        this.attStatus = attStatus;
//    }

//    public String getSpeakStatus()
//    {
//        return speakStatus;
//    }
//
//    public void setSpeakStatus(String speakStatus)
//    {
//        this.speakStatus = speakStatus;
//    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
}
