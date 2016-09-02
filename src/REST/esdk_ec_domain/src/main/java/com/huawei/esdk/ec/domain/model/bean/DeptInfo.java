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

import java.util.Date;

/**
 * * @author j00213891 * * 部门信息
 */
public class DeptInfo extends DeptInfoBase
{
    private String fullName;// 部门名全称

    private String deptNum; // 部门号码

    private String fax; // 传真

    private String ownerId; // 拥有者标识，如userUri或rootId

    private String parentId; // 父企业ID

    private String secretaryId; // 部长ID

    private String status; // 状态

    private Date createTime; // 创建时间

    private Date modifyTime; // 修改时间

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getDeptNum()
    {
        return deptNum;
    }

    public void setDeptNum(String deptNum)
    {
        this.deptNum = deptNum;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }

    public String getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(String ownerId)
    {
        this.ownerId = ownerId;
    }

    @Override
    public String getParentId()
    {
        return parentId;
    }

    @Override
    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public String getSecretaryId()
    {
        return secretaryId;
    }

    public void setSecretaryId(String secretaryId)
    {
        this.secretaryId = secretaryId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Date getCreateTime()
    {
        if(createTime == null)
            return null;
        return (Date)createTime.clone();
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = (Date)createTime.clone();
    }

    public Date getModifyTime()
    {
        if(modifyTime == null)
            return null;
        return (Date)modifyTime.clone();
    }

    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = (Date)modifyTime.clone();
    }

 
}
