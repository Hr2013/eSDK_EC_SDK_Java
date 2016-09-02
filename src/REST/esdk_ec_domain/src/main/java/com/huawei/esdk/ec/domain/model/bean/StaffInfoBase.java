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

public class StaffInfoBase
{
    private String uri; // URI

    private String id;// ID

    private String staffId;// 成员Id

    private String staffNumber;// 成员号

    private String staffName;// 成员名

    private String ucNumber; // UC号

    private String sex;// 性别

    private String occupation;// 职业

    private UCPresType presence;// 软终端状态

    private String statusDesc;// 软终端二级状态

    private String headImageId;// 头像id

    private String signature;// 签名

    private String pinyinName;// 用户姓名拼音

    private String foreignName;// 用户外文姓名

    private String timeZone;// 用户所在时区

    private String timeZoneValue;// 用户所在时区的值

    private String displayName;// 用户显示名

    private ContactInfo contactInfo;// StaffInfoBase中有字段在ContactInfo中重复，为了适配C02版本，后续版本使用contactInfo中的字段

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

    public String getStaffId()
    {
        return staffId;
    }

    public void setStaffId(String staffId)
    {
        this.staffId = staffId;
    }

    public String getStaffNumber()
    {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber)
    {
        this.staffNumber = staffNumber;
    }

    public String getStaffName()
    {
        return staffName;
    }

    public void setStaffName(String staffName)
    {
        this.staffName = staffName;
    }

    public String getUcNumber()
    {
        return ucNumber;
    }

    public void setUcNumber(String ucNumber)
    {
        this.ucNumber = ucNumber;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getOccupation()
    {
        return occupation;
    }

    public void setOccupation(String occupation)
    {
        this.occupation = occupation;
    }

    public UCPresType getPresence()
    {
        return presence;
    }

    public void setPresence(UCPresType presence)
    {
        this.presence = presence;
    }

    public String getHeadImageId()
    {
        return headImageId;
    }

    public void setHeadImageId(String headImageId)
    {
        this.headImageId = headImageId;
    }

    public String getSignature()
    {
        return signature;
    }

    public void setSignature(String signature)
    {
        this.signature = signature;
    }

    /** * @param contactInfo the contactInfo to set */
    public void setContactInfo(ContactInfo contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    /** * @return the contactInfo */
    public ContactInfo getContactInfo()
    {
        return contactInfo;
    }

    public String getStatusDesc()
    {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
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

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }
}
