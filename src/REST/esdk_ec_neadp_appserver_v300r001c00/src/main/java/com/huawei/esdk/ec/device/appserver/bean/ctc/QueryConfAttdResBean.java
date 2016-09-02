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

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "body")
public class QueryConfAttdResBean
{
    @XmlElement(name = "params")
    QueryConfAttdResParamBean params;
    
    @XmlElementWrapper(name = "paramlist")
    @XmlElement(name = "bean")
    private List<Attendee> attendees;
    
    public QueryConfAttdResParamBean getParams()
    {
        return params;
    }
    
    public void setParams(QueryConfAttdResParamBean params)
    {
        this.params = params;
    }
    
    public List<Attendee> getAttendees()
    {
        return attendees;
    }
    
    public void setAttendees(List<Attendee> attendees)
    {
        this.attendees = attendees;
    }
    
}
