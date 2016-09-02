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

import java.util.ArrayList;
import java.util.List;

public class FriendInfo
{
    private String sex; // 性别：male/female/unknown

    private String occupation; // 职务

    private String routeNumber; // 路由号码

    private String name; // 名字

    private ContactInfo contactInfo; // 联络信息

    private String signature; // 个性签名

    private String headImageId;// 头像ID

    private String deptDesc; // 部门说明

    private String friendAccount;// 好友账号

    private String id;// 联系人id

    private String des;// 个人描述

    private String ent;// 企业名

    private String deptName;// 部门名称

    private String ringTone;// 设置铃声

    private String displayName;// 展示名

    private String pinyinName;

    private String foreignName;

    private String timeZone;

    private String location;

    private String localTime;

    private String contact;

    private String timeZoneValue;

    private String userFullNumUri;

    private String clientNumber;

    private List<AssistantInfo> assistantInfos;

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

    public String getRouteNumber()
    {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber)
    {
        this.routeNumber = routeNumber;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ContactInfo getContactInfo()
    {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    public String getSignature()
    {
        return signature;
    }

    public void setSignature(String signature)
    {
        this.signature = signature;
    }

    public String getHeadImageId()
    {
        return headImageId;
    }

    public void setHeadImageId(String headImageId)
    {
        this.headImageId = headImageId;
    }

    public String getDeptDesc()
    {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc)
    {
        this.deptDesc = deptDesc;
    }

    /** * @param friendAccount the friendAccount to set */
    public void setFriendAccount(String friendAccount)
    {
        this.friendAccount = friendAccount;
    }

    /** * @return the friendAccount */
    public String getFriendAccount()
    {
        return friendAccount;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDes()
    {
        return des;
    }

    public void setDes(String des)
    {
        this.des = des;
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

    public String getRingTone()
    {
        return ringTone;
    }

    public void setRingTone(String ringTone)
    {
        this.ringTone = ringTone;
    }

    /** * @param displayName the displayName to set */
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    /** * @return the displayName */
    public String getDisplayName()
    {
        return displayName;
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

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocalTime()
    {
        return localTime;
    }

    public void setLocalTime(String localTime)
    {
        this.localTime = localTime;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getTimeZoneValue()
    {
        return timeZoneValue;
    }

    public void setTimeZoneValue(String timeZoneValue)
    {
        this.timeZoneValue = timeZoneValue;
    }

    public String getUserFullNumUri()
    {
        return userFullNumUri;
    }

    public void setUserFullNumUri(String userFullNumUri)
    {
        this.userFullNumUri = userFullNumUri;
    }

    public String getClientNumber()
    {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber)
    {
        this.clientNumber = clientNumber;
    }

    public List<AssistantInfo> getAssistantInfos()
    {
        if (assistantInfos == null)
        {
            assistantInfos = new ArrayList<AssistantInfo>();
        }
        return assistantInfos;
    }

}
