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
package com.huawei.esdk.ec.domain.model.bean;

public class LinkmanInfo
{
    private String uri; // 联系人url

    private String id; // 联系人id

    private String displayName; // 显示名

    private ContactInfo contactInfo; // 联络信息

    private String sex; // 性别：male/female/unknown

    private String des; // 个人描述

    private String occupation; // 职务

    private String ent; // 企业名

    private String deptName; // 部门名称

    private String pinyinName;
    
    private String foreignName;
    
    private String staffName;
    
//    private String staffNumber;
    
    private String timeZone;
    
    private String timeZoneValue;

    
    public String getUri()
    {
        return uri;
    }

    public void setUri(String uri)
    {
        this.uri = uri;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getDes()
    {
        return des;
    }

    public void setDes(String des)
    {
        this.des = des;
    }

    public String getOccupation()
    {
        return occupation;
    }

    public void setOccupation(String occupation)
    {
        this.occupation = occupation;
    }

    public String getEnt()
    {
        return ent;
    }

    public void setEnt(String ent)
    {
        this.ent = ent;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public ContactInfo getContactInfo()
    {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    public String getPinyinName()
    {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName)
    {
        this.pinyinName = pinyinName;
    }

    public String getForeignName()
    {
        return foreignName;
    }

    public void setForeignName(String foreignName)
    {
        this.foreignName = foreignName;
    }

    public String getStaffName()
    {
        return staffName;
    }

    public void setStaffName(String staffName)
    {
        this.staffName = staffName;
    }

    public String getTimeZone()
    {
        return timeZone;
    }

    public void setTimeZone(String timeZone)
    {
        this.timeZone = timeZone;
    }

    public String getTimeZoneValue()
    {
        return timeZoneValue;
    }

    public void setTimeZoneValue(String timeZoneValue)
    {
        this.timeZoneValue = timeZoneValue;
    }


}
