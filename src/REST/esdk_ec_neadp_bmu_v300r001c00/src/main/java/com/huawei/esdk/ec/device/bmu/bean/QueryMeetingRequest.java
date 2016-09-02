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
@XmlRootElement(name = "params")
public class QueryMeetingRequest
{
    @XmlElement(name="userid")
    private String userId;
    @XmlElement(name="confid")
    private String confId;
    @XmlElement(name="phone")
    private String phone;
    @XmlElement(name="confname")
    private String confName;
    @XmlElement(name="starttime")
    private String startTime;
    @XmlElement(name="endtime")
    private String endTime;
    @XmlElement(name="pagecount")
    private String pageCount;
    @XmlElement(name="pagenum")
    private String pageNum;
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    public String getConfId()
    {
        return confId;
    }
    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public String getConfName()
    {
        return confName;
    }
    public void setConfName(String confName)
    {
        this.confName = confName;
    }
    public String getStartTime()
    {
        return startTime;
    }
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }
    public String getEndTime()
    {
        return endTime;
    }
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
    public String getPageCount()
    {
        return pageCount;
    }
    public void setPageCount(String pageCount)
    {
        this.pageCount = pageCount;
    }
    public String getPageNum()
    {
        return pageNum;
    }
    public void setPageNum(String pageNum)
    {
        this.pageNum = pageNum;
    }

    
}
