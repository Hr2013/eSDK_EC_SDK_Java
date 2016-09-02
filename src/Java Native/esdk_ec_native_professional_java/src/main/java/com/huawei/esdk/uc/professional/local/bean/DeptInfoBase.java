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

public class DeptInfoBase
{
    private String id;
    
    private String memberUri;
    
    private String corpId;
    
    private String deptId;//ec3.0
    
    private String deptName;
    
    private String deptLevel;
    
    private String parentDeptId;//ec3.0
    
    private String deptPriority;
    
    private String deptDesc;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getMemberUri()
    {
        return memberUri;
    }
    
    public void setMemberUri(String memberUri)
    {
        this.memberUri = memberUri;
    }
    
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
    
    public String getDeptName()
    {
        return deptName;
    }
    
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }
    
    public String getDeptLevel()
    {
        return deptLevel;
    }
    
    public void setDeptLevel(String deptLevel)
    {
        this.deptLevel = deptLevel;
    }
    
    public String getParentDeptId()
    {
        return parentDeptId;
    }
    
    public void setParentDeptId(String parentDeptId)
    {
        this.parentDeptId = parentDeptId;
    }
    
    public String getDeptPriority()
    {
        return deptPriority;
    }
    
    public void setDeptPriority(String deptPriority)
    {
        this.deptPriority = deptPriority;
    }
    
    public String getDeptDesc()
    {
        return deptDesc;
    }
    
    public void setDeptDesc(String deptDesc)
    {
        this.deptDesc = deptDesc;
    }
}
