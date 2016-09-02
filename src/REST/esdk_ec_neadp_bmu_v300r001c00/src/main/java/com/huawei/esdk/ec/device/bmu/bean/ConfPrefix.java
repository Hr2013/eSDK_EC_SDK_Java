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
@XmlRootElement(name = "ConfPrefix")
public class ConfPrefix
{
    @XmlElement(name = "subpbx")
    private String subpbx;
    
    @XmlElement(name = "confprfix")
    private String confPrfix;
    
    @XmlElement(name = "ispstn")
    private String ispstn;
    
    public String getSubpbx()
    {
        return subpbx;
    }
    
    public void setSubpbx(String subpbx)
    {
        this.subpbx = subpbx;
    }
    
    public String getConfPrfix()
    {
        return confPrfix;
    }
    
    public void setConfPrfix(String confPrfix)
    {
        this.confPrfix = confPrfix;
    }
    
    public String getIspstn()
    {
        return ispstn;
    }
    
    public void setIspstn(String ispstn)
    {
        this.ispstn = ispstn;
    }
    
}
