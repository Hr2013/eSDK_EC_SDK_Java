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
@XmlRootElement(name = "SIP")
public class SIPDelCondition
{
    /**
     * 统一网关IP
     */
    @XmlElement(name = "gwip")
    private String gwIp;
    
    /**
     * subpbx id
     */
    @XmlElement(name = "subpbx")
    private String subPbx;
    
    /**
     * SIP号码
     */
    @XmlElement(name = "number")
    private String number;
    
    /**
     * SIP设备标识
     */
    @XmlElement(name = "deletesipue")
    private String deleteSipUe;
    
    public String getGwIp()
    {
        return gwIp;
    }
    
    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }
    
    public String getNumber()
    {
        return number;
    }
    
    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getSubPbx()
    {
        return subPbx;
    }

    public void setSubPbx(String subPbx)
    {
        this.subPbx = subPbx;
    }

    public String getDeleteSipUe()
    {
        return deleteSipUe;
    }

    public void setDeleteSipUe(String deleteSipUe)
    {
        this.deleteSipUe = deleteSipUe;
    }
    
}
