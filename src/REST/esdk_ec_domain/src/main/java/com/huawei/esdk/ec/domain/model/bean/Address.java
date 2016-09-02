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

/**
 * @author sWX198756
 *
 */
public class Address
{
    /**
     * 成员ID
     */
    private String memberId;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * espace号码
     */
    private String staffAccount;
    
    /**
     * 性别
     */
    private String sex;
    
    /**
     * 移动电话
     */
    private String mobile;
    
    /**
     * 固定电话
     */
    private String homephone;
    
    /**
     * 传真
     */
    private String fax;
    
    /**
     * 邮件
     */
    private String email;
    
    /**
     * 绑定号码
     */
    private String bindno;
    
    /**
     * 短号
     */
    private String shortphone;
    
    /**
     * 办公号码
     */
    private String officephone;
    
    public String getMemberId()
    {
        return memberId;
    }
    
    public void setMemberId(String memberId)
    {
        this.memberId = memberId;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getStaffAccount()
    {
        return staffAccount;
    }
    
    public void setStaffAccount(String staffAccount)
    {
        this.staffAccount = staffAccount;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public String getMobile()
    {
        return mobile;
    }
    
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    
    public String getHomephone()
    {
        return homephone;
    }
    
    public void setHomephone(String homephone)
    {
        this.homephone = homephone;
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
    
    public String getBindno()
    {
        return bindno;
    }
    
    public void setBindno(String bindno)
    {
        this.bindno = bindno;
    }
    
    public String getShortphone()
    {
        return shortphone;
    }
    
    public void setShortphone(String shortphone)
    {
        this.shortphone = shortphone;
    }
    
    public String getOfficephone()
    {
        return officephone;
    }
    
    public void setOfficephone(String officephone)
    {
        this.officephone = officephone;
    }
    
}
