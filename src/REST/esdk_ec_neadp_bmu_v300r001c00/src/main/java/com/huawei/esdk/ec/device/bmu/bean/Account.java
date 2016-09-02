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
public class Account
{
    @XmlElement(name = "accountid")
    private String accountId;
    
    @XmlElement(name = "accounttype")
    private String accountType;
    
    @XmlElement(name = "loginname")
    private String loginName;
    
    @XmlElement(name = "password")
    private String password;
    
    @XmlElement(name = "name")
    private String name;
    
    @XmlElement(name = "sex")
    private String sex;
    
    @XmlElement(name = "homephone")
    private String homephone;
    
    @XmlElement(name = "cellphone")
    private String cellphone;
    
    @XmlElement(name = "officephone")
    private String officephone;
    
    @XmlElement(name = "shortphone")
    private String shortphone;
    
    @XmlElement(name = "otherphone")
    private String otherphone;
    
    @XmlElement(name = "fax")
    private String fax;
    
    @XmlElement(name = "email")
    private String email;
    
    @XmlElement(name = "addr")
    private String addr;
    
    @XmlElement(name = "title")
    private String title;
    
    @XmlElement(name = "departmentid")
    private String departmentId;
    
    @XmlElement(name = "userlevel")
    private String userLevel;
    
    @XmlElement(name = "roleid")
    private String roleId;
    
    @XmlElement(name = "failedreason")
    private String failedReason;
    
    @XmlElement(name = "oldpassword")
    private String oldPassword;
    
    @XmlElement(name = "newpassword")
    private String newPassword;
    
    @XmlElement(name = "bindno")
    private String bindNum;
    
    //EC3.0 new add
    @XmlElement(name = "staffno")
    private String staffNum;
    
    @XmlElement(name = "otherphone2")
    private String otherphone2;
    
    @XmlElement(name = "userstate")
    private String userState;
    
    @XmlElement(name = "notesmail")
    private String notesMail;
    
    @XmlElement(name = "zip")
    private String zip;
    
    @XmlElement(name = "birthday")
    private String birthday;
    
    @XmlElement(name = "des")
    private String des;
    
    @XmlElement(name = "website")
    private String website;
    
    @XmlElement(name = "qpinyin")
    private String qPinyin;
    
    @XmlElement(name = "jpinyin")
    private String jPinyin;
    
    @XmlElement(name = "accountstate")
    private String accountstate;
    
    @XmlElement(name = "modifytime")
    private String modifyTime;
    
    @XmlElement(name = "foreignname")
    private String foreignName;
    
    public String getAccountType()
    {
        return accountType;
    }
    
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }
    
    public String getLoginName()
    {
        return loginName;
    }
    
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public String getHomephone()
    {
        return homephone;
    }
    
    public void setHomephone(String homephone)
    {
        this.homephone = homephone;
    }
    
    public String getCellphone()
    {
        return cellphone;
    }
    
    public void setCellphone(String cellphone)
    {
        this.cellphone = cellphone;
    }
    
    public String getOfficephone()
    {
        return officephone;
    }
    
    public void setOfficephone(String officephone)
    {
        this.officephone = officephone;
    }
    
    public String getShortphone()
    {
        return shortphone;
    }
    
    public void setShortphone(String shortphone)
    {
        this.shortphone = shortphone;
    }
    
    public String getOtherphone()
    {
        return otherphone;
    }
    
    public void setOtherphone(String otherphone)
    {
        this.otherphone = otherphone;
    }
    
    public String getFax()
    {
        return fax;
    }
    
    public void setFax(String fax)
    {
        this.fax = fax;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getAddr()
    {
        return addr;
    }
    
    public void setAddr(String addr)
    {
        this.addr = addr;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getDepartmentId()
    {
        return departmentId;
    }
    
    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }
    
    public String getUserLevel()
    {
        return userLevel;
    }
    
    public void setUserLevel(String userLevel)
    {
        this.userLevel = userLevel;
    }
    
    public String getRoleId()
    {
        return roleId;
    }
    
    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }
    
    public String getFailedReason()
    {
        return failedReason;
    }
    
    public void setFailedReason(String failedReason)
    {
        this.failedReason = failedReason;
    }
    
    public String getAccountId()
    {
        return accountId;
    }
    
    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }
    
    public String getOldPassword()
    {
        return oldPassword;
    }
    
    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }
    
    public String getNewPassword()
    {
        return newPassword;
    }
    
    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }
    
    public String getBindNum()
    {
        return bindNum;
    }
    
    public void setBindNum(String bindNum)
    {
        this.bindNum = bindNum;
    }
    
    public String getStaffNum()
    {
        return staffNum;
    }
    
    public void setStaffNum(String staffNum)
    {
        this.staffNum = staffNum;
    }
    
    public String getOtherphone2()
    {
        return otherphone2;
    }
    
    public void setOtherphone2(String otherphone2)
    {
        this.otherphone2 = otherphone2;
    }
    
    public String getUserState()
    {
        return userState;
    }
    
    public void setUserState(String userState)
    {
        this.userState = userState;
    }
    
    public String getNotesMail()
    {
        return notesMail;
    }
    
    public void setNotesMail(String notesMail)
    {
        this.notesMail = notesMail;
    }
    
    public String getZip()
    {
        return zip;
    }
    
    public void setZip(String zip)
    {
        this.zip = zip;
    }
    
    public String getBirthday()
    {
        return birthday;
    }
    
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }
    
    public String getDes()
    {
        return des;
    }
    
    public void setDes(String des)
    {
        this.des = des;
    }
    
    public String getWebsite()
    {
        return website;
    }
    
    public void setWebsite(String website)
    {
        this.website = website;
    }
    
    public String getqPinyin()
    {
        return qPinyin;
    }
    
    public void setqPinyin(String qPinyin)
    {
        this.qPinyin = qPinyin;
    }
    
    public String getjPinyin()
    {
        return jPinyin;
    }
    
    public void setjPinyin(String jPinyin)
    {
        this.jPinyin = jPinyin;
    }
    
    public String getAccountstate()
    {
        return accountstate;
    }
    
    public void setAccountstate(String accountstate)
    {
        this.accountstate = accountstate;
    }
    
    public String getModifyTime()
    {
        return modifyTime;
    }
    
    public void setModifyTime(String modifyTime)
    {
        this.modifyTime = modifyTime;
    }
    
    public String getForeignName()
    {
        return foreignName;
    }
    
    public void setForeignName(String foreignName)
    {
        this.foreignName = foreignName;
    }
    
}
