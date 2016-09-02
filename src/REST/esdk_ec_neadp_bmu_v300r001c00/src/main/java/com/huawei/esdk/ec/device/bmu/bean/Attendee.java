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
@XmlRootElement(name = "Account")
public class Attendee
{
    @XmlElement(name = "gwip")
    private String gwIp;
    
//    @XmlElement(name = "confno")
//    private String confNo;
    
    @XmlElement(name = "confid")
    private String confId;
    
    @XmlElement(name = "operate")
    private String operate;
    
    @XmlElement(name = "attnumber")
    private String attNumber;
    
    @XmlElement(name = "atttype")
    private String attType;
    
    @XmlElement(name = "opernumber")
    private String operNumber;
    
    @XmlElement(name = "oldchairman")
    private String oldChairman;
    
    @XmlElement(name = "newchairman")
    private String newChairman;
    
    public String getOperate()
    {
        return operate;
    }
    
    public void setOperate(String operate)
    {
        this.operate = operate;
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
    
    public String getOldChairman()
    {
        return oldChairman;
    }

    public void setOldChairman(String oldChairman)
    {
        this.oldChairman = oldChairman;
    }

    public String getNewChairman()
    {
        return newChairman;
    }

    public void setNewChairman(String newChairman)
    {
        this.newChairman = newChairman;
    }

    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
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

    public String getOperNumber()
    {
        return operNumber;
    }

    public void setOperNumber(String operNumber)
    {
        this.operNumber = operNumber;
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
