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

import java.util.List;

public class ContactInfo
{
    private String routeNum; // UC软终端路由号码

    private List<ContactNumBase> fax;//传真号码

    private List<ContactNumBase> mobilePhone;// 手机
    
    private List<ContactNumBase> otherPhone;// 其他电话
    
    private List<ContactNumBase> officePhone;//  办公室电话
    
    private List<String> voip;
    
    private String staffNum;// 成员工号

    private String zipcode; // 邮编

    private String address; // 联系地址

    private String email; // Email地址

    private String webSite; //网站地址
    
    private String noteMail;//用户notes邮箱地址
    
    private String seatNum;//用户座位号
    
    private String corpId;// 企业Id
    
    private String deptId;// 部门Id

    private String deptName;// 部门名
    
    private String deptDesc; //部门描述
    
    private String deptDescEng;//部门英文描述
    
    private String contactDesc;
     
    private String otherInfo;//其他描述信息
    
    private List<AssistantInfo> assistant;//秘书信息
    
    private String homePhone;//家庭电话号码
    
    private String userFullNumUri;//UC软终端公网长号
    
    private String clientNumber;//用户软终端可拨打号码
    
    private String deviceType;//软终端类型
    
    private String exchange;//exchange日历状态

    private List<String> presencePhone;//IP Phone1状态
    
    private String softFuncId;//软终端Presence、IM标志位
    
    private List<String> phoneFuncID; //软终端phone Presence、IM标志位

    public String getRouteNum()
    {
        return routeNum;
    }

    public void setRouteNum(String routeNum)
    {
        this.routeNum = routeNum;
    }


    public List<ContactNumBase> getFax()
    {
        return fax;
    }

    public void setFax(List<ContactNumBase> fax)
    {
        this.fax = fax;
    }

    public List<ContactNumBase> getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone(List<ContactNumBase> mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }

    public List<ContactNumBase> getOtherPhone()
    {
        return otherPhone;
    }

    public void setOtherPhone(List<ContactNumBase> otherPhone)
    {
        this.otherPhone = otherPhone;
    }

    public List<ContactNumBase> getOfficePhone()
    {
        return officePhone;
    }

    public void setOfficePhone(List<ContactNumBase> officePhone)
    {
        this.officePhone = officePhone;
    }

    public List<String> getVoip()
    {
        return voip;
    }

    public void setVoip(List<String> voip)
    {
        this.voip = voip;
    }


    public String getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getWebSite()
    {
        return webSite;
    }

    public String getSoftFuncId()
    {
        return softFuncId;
    }

    public void setSoftFuncId(String softFuncId)
    {
        this.softFuncId = softFuncId;
    }

    public void setWebSite(String webSite)
    {
        this.webSite = webSite;
    }

    public String getNoteMail()
    {
        return noteMail;
    }

    public void setNoteMail(String noteMail)
    {
        this.noteMail = noteMail;
    }

    public String getSeatNum()
    {
        return seatNum;
    }

    public void setSeatNum(String seatNum)
    {
        this.seatNum = seatNum;
    }

    public String getDeptDesc()
    {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc)
    {
        this.deptDesc = deptDesc;
    }

    public String getDeptDescEng()
    {
        return deptDescEng;
    }

    public void setDeptDescEng(String deptDescEng)
    {
        this.deptDescEng = deptDescEng;
    }

    public String getContactDesc()
    {
        return contactDesc;
    }

    public void setContactDesc(String contactDesc)
    {
        this.contactDesc = contactDesc;
    }

    public String getOtherInfo()
    {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo)
    {
        this.otherInfo = otherInfo;
    }

    public List<AssistantInfo> getAssistant()
    {
        return assistant;
    }

    public void setAssistant(List<AssistantInfo> assistant)
    {
        this.assistant = assistant;
    }

    public String getHomePhone()
    {
        return homePhone;
    }

    public void setHomePhone(String homePhone)
    {
        this.homePhone = homePhone;
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

    public String getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getExchange()
    {
        return exchange;
    }

    public void setExchange(String exchange)
    {
        this.exchange = exchange;
    }

    public List<String> getPresencePhone()
    {
        return presencePhone;
    }

    public void setPresencePhone(List<String> presencePhone)
    {
        this.presencePhone = presencePhone;
    }

    public List<String> getPhoneFuncID()
    {
        return phoneFuncID;
    }

    public void setPhoneFuncID(List<String> phoneFuncID)
    {
        this.phoneFuncID = phoneFuncID;
    }

    /** * @param deptId the deptId to set */
    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }

    /** * @return the deptId */
    public String getDeptId()
    {
        return deptId;
    }

    /** * @param deptName the deptName to set */
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    /** * @return the deptName */
    public String getDeptName()
    {
        return deptName;
    }

    /** * @param corpId the corpId to set */
    public void setCorpId(String corpId)
    {
        this.corpId = corpId;
    }

    /** * @return the corpId */
    public String getCorpId()
    {
        return corpId;
    }

    /** * @param staffNum the staffNum to set */
    public void setStaffNum(String staffNum)
    {
        this.staffNum = staffNum;
    }

    /** * @return the staffNum */
    public String getStaffNum()
    {
        return staffNum;
    }

}
