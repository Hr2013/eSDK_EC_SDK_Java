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
@XmlType(name = "", propOrder = {
})
@XmlRootElement(name = "DelAttendeeListInfo")
public class DelAttendeeListInfo
{
    @XmlElement(name = "gwip")
    private String gwIp;
    
//    @XmlElement(name = "confno")
//    private String confNo;
    
    @XmlElement(name = "confid")
    private String confId;
    
    @XmlElement(name = "attlist")
    private DelAttendeeList attendeeList;

    public DelAttendeeList getAttendeeList()
    {
        return attendeeList;
    }

    public void setAttendeeList(DelAttendeeList attendeeList)
    {
        this.attendeeList = attendeeList;
    }

    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
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
    
}
