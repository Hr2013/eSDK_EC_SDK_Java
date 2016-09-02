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

public class PageQryStaffCond
{
    private String corpId; // 企业ID，全局唯一

    private String deptId; // 部门ID

    private String staffName; // 成员姓名

    private String staffNo; // 成员工号

    private String spinyin; // 首拼音

    private String email; // 邮箱

    private String mobilePhone; // 手机号

    private String userUri; // 绑定短号

    private String ucNo; // UC账号

    public String getCorpId()
    {
        return corpId;
    }

    public void setCorpId(String corpId)
    {
        this.corpId = corpId;
    }

    public String getDeptId()
    {
        return deptId;
    }

    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }

    public String getStaffName()
    {
        return staffName;
    }

    public void setStaffName(String staffName)
    {
        this.staffName = staffName;
    }

    public String getStaffNo()
    {
        return staffNo;
    }

    public void setStaffNo(String staffNo)
    {
        this.staffNo = staffNo;
    }

    public String getSpinyin()
    {
        return spinyin;
    }

    public void setSpinyin(String spinyin)
    {
        this.spinyin = spinyin;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }

    public String getUserUri()
    {
        return userUri;
    }

    public void setUserUri(String userUri)
    {
        this.userUri = userUri;
    }

    public String getUcNo()
    {
        return ucNo;
    }

    public void setUcNo(String ucNo)
    {
        this.ucNo = ucNo;
    }

}
