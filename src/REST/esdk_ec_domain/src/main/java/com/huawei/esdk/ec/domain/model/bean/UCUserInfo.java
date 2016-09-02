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

public class UCUserInfo
{
    private String ucAccount; // UC帐号

    private String signature; // 签名

    private String mobileTel; // 电话号码

    private List<String> otherTel; // 住宅电话

    private String nickName; // 昵称
    
    private String email; // 邮箱

    private String headImageId; // 头像ID

    private String deptDesc; // 部门说明
    
    private String functionId;//用户终端功能位
    
    private String pinyinName;//姓名简拼
    
    private List<ContactNumBase> officePhone;//用户硬终端的公网长号
    
    private String userUri;
    
    private String userFullNumUri;
    
    private String statusFlag;

    public String getUcAccount()
    {
        return ucAccount;
    }

    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }

    public String getSignature()
    {
        return signature;
    }

    public void setSignature(String signature)
    {
        this.signature = signature;
    }

    public String getMobileTel()
    {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel)
    {
        this.mobileTel = mobileTel;
    }


    public List<String> getOtherTel()
    {
        return otherTel;
    }

    public void setOtherTel(List<String> otherTel)
    {
        this.otherTel = otherTel;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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

    public void setFunctionId(String functionId)
    {
        this.functionId = functionId;
    }

    public String getFunctionId()
    {
        return functionId;
    }

    public String getPinyinName()
    {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName)
    {
        this.pinyinName = pinyinName;
    }


    public List<ContactNumBase> getOfficePhone()
    {
        return officePhone;
    }

    public void setOfficePhone(List<ContactNumBase> officePhone)
    {
        this.officePhone = officePhone;
    }

    public String getUserUri()
    {
        return userUri;
    }

    public void setUserUri(String userURI)
    {
        this.userUri = userURI;
    }

    public String getUserFullNumUri()
    {
        return userFullNumUri;
    }

    public void setUserFullNumUri(String userFullNumUri)
    {
        this.userFullNumUri = userFullNumUri;
    }

    public String getStatusFlag()
    {
        return statusFlag;
    }

    public void setStatusFlag(String statusFlag)
    {
        this.statusFlag = statusFlag;
    }
}
