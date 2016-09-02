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
package com.huawei.esdk.uc.professional.local.bean;

/**
 * 账号信息
 *
 */
public class AccountInfo
{
    /**
     * UC账号
     */
    private String ucAccount;
    
    /**
     * 所属部门ID
     */
    private String deptId;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 外文姓名
     */
    private String foreignName;
    
    /**
     * 姓名全拼
     */
    private String pinyin;
    
    /**
     * 姓名简拼
     */
    private String simplePinyin;
    
    /**
     * 性别
     */
    private String gender;
    
    /**
     * 工号
     */
    private String staffNo;
    
    /**
     * 用户级别
     */
    private String level;
    
    /**
     * 职务
     */
    private String title;
    
    /**
     * 移动电话
     */
    private String mobilePhone;
    
    /**
     * 家庭电话
     */
    private String homePhone;
    
    /**
     * 其它号码
     */
    private String otherPhone;
    
    /**
     * 其它号码2
     */
    private String otherPhone2;
    
    /**
     * 传真号码
     */
    private String fax;
    
    /**
     * 邮箱地址
     */
    private String email;
    
    /**
     * 邮编
     */
    private String zipcode;
    
    /**
     * 地址
     */
    private String address;
    
    /**
     * 时区
     */
    private String timeZone;
    
    /**
     * 开通客户端类型
     */
    private String terminalFlag;
    
    //EC3.0 new add
    
    private String accountType;
    
    private String password;
    
    private String officePhone;
    
    private String shortPhone;
    
    private String roleId;
    
    private String userstate;
    
    private String notesmail;
    
    private String birthday;
    
    private String des;
    
    private String website;
    
    private String accountstate;
    
    private String bindNum;
    
    private String accountId;
    
    private String modifyTime;
    
    public String getUcAccount()
    {
        return ucAccount;
    }
    
    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }
    
    public String getDeptId()
    {
        return deptId;
    }
    
    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getForeignName()
    {
        return foreignName;
    }
    
    public void setForeignName(String foreignName)
    {
        this.foreignName = foreignName;
    }
    
    public String getPinyin()
    {
        return pinyin;
    }
    
    public void setPinyin(String pinyin)
    {
        this.pinyin = pinyin;
    }
    
    public String getSimplePinyin()
    {
        return simplePinyin;
    }
    
    public void setSimplePinyin(String simplePinyin)
    {
        this.simplePinyin = simplePinyin;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public String getStaffNo()
    {
        return staffNo;
    }
    
    public void setStaffNo(String staffNo)
    {
        this.staffNo = staffNo;
    }
    
    public String getLevel()
    {
        return level;
    }
    
    public void setLevel(String level)
    {
        this.level = level;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getMobilePhone()
    {
        return mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }
    
    public String getHomePhone()
    {
        return homePhone;
    }
    
    public void setHomePhone(String homePhone)
    {
        this.homePhone = homePhone;
    }
    
    public String getOtherPhone()
    {
        return otherPhone;
    }
    
    public void setOtherPhone(String otherPhone)
    {
        this.otherPhone = otherPhone;
    }
    
    public String getOtherPhone2()
    {
        return otherPhone2;
    }
    
    public void setOtherPhone2(String otherPhone2)
    {
        this.otherPhone2 = otherPhone2;
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
    
    public String getTimeZone()
    {
        return timeZone;
    }
    
    public void setTimeZone(String timeZone)
    {
        this.timeZone = timeZone;
    }
    
    public String getTerminalFlag()
    {
        return terminalFlag;
    }
    
    public void setTerminalFlag(String terminalFlag)
    {
        this.terminalFlag = terminalFlag;
    }
    
    public String getAccountType()
    {
        return accountType;
    }
    
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getOfficePhone()
    {
        return officePhone;
    }
    
    public void setOfficePhone(String officePhone)
    {
        this.officePhone = officePhone;
    }
    
    public String getShortPhone()
    {
        return shortPhone;
    }
    
    public void setShortPhone(String shortPhone)
    {
        this.shortPhone = shortPhone;
    }
    
    public String getRoleId()
    {
        return roleId;
    }
    
    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }
    
    public String getUserstate()
    {
        return userstate;
    }
    
    public void setUserstate(String userstate)
    {
        this.userstate = userstate;
    }
    
    public String getNotesmail()
    {
        return notesmail;
    }
    
    public void setNotesmail(String notesmail)
    {
        this.notesmail = notesmail;
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
    
    public String getAccountstate()
    {
        return accountstate;
    }
    
    public void setAccountstate(String accountstate)
    {
        this.accountstate = accountstate;
    }
    
    public String getBindNum()
    {
        return bindNum;
    }
    
    public void setBindNum(String bindNum)
    {
        this.bindNum = bindNum;
    }
    
    public String getAccountId()
    {
        return accountId;
    }
    
    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }
    
    public String getModifyTime()
    {
        return modifyTime;
    }
    
    public void setModifyTime(String modifyTime)
    {
        this.modifyTime = modifyTime;
    }
    
}
