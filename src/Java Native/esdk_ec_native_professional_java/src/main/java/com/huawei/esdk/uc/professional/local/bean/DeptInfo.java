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

import java.util.Date;

public class DeptInfo
{
    private String deptId;//ec3.0
    
    private String parentDeptId;//ec3.0
    
    private String deptNumber;
    
    private String corpId;
    
    private String parentCorpId;
    
    private String deptLevel;
    
    private String ownerId;
    
    private String name;//ec3.0
    
    private String fullName;
    
    private String deptDesc;
    
    private String fax;
    
    private String secretaryId;
    
    private Date modifyTime;
    
    private Date createTime;
    
    private String status;
    
    private String deptPriority;
    
    public String getDeptId()
    {
        return deptId;
    }
    
    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }
    
    public String getParentDeptId()
    {
        return parentDeptId;
    }
    
    public void setParentDeptId(String parentDeptId)
    {
        this.parentDeptId = parentDeptId;
    }
    
    public String getDeptNumber()
    {
        return deptNumber;
    }
    
    public void setDeptNumber(String deptNumber)
    {
        this.deptNumber = deptNumber;
    }
    
    public String getCorpId()
    {
        return corpId;
    }
    
    public void setCorpId(String corpId)
    {
        this.corpId = corpId;
    }
    
    public String getParentCorpId()
    {
        return parentCorpId;
    }
    
    public void setParentCorpId(String parentCorpId)
    {
        this.parentCorpId = parentCorpId;
    }
    
    public String getDeptLevel()
    {
        return deptLevel;
    }
    
    public void setDeptLevel(String deptLevel)
    {
        this.deptLevel = deptLevel;
    }
    
    public String getOwnerId()
    {
        return ownerId;
    }
    
    public void setOwnerId(String ownerId)
    {
        this.ownerId = ownerId;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getFullName()
    {
        return fullName;
    }
    
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
    
    public String getDeptDesc()
    {
        return deptDesc;
    }
    
    public void setDeptDesc(String deptDesc)
    {
        this.deptDesc = deptDesc;
    }
    
    public String getFax()
    {
        return fax;
    }
    
    public void setFax(String fax)
    {
        this.fax = fax;
    }
    
    public String getSecretaryId()
    {
        return secretaryId;
    }
    
    public void setSecretaryId(String secretaryId)
    {
        this.secretaryId = secretaryId;
    }
    
    public Date getModifyTime()
    {
        return modifyTime;
    }
    
    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getDeptPriority()
    {
        return deptPriority;
    }
    
    public void setDeptPriority(String deptPriority)
    {
        this.deptPriority = deptPriority;
    }
}
