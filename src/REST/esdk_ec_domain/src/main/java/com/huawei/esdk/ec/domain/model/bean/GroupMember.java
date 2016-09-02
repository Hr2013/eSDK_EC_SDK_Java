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

public class GroupMember
{
    private Integer status; // 状态类型

    private String displayName; // 显示名字

    private String ucAccount; // UC账号

    private String userUri; // 成员URI
    
    private boolean ownerFlag;//群组管理员标志位：true:群组管理员，false:群组成员
    
    private Integer  operationResult;//对应C03版本中 批量添加或删除 中res字段 

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getUcAccount()
    {
        return ucAccount;
    }

    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }

    public String getUserUri()
    {
        return userUri;
    }

    public void setUserUri(String userUri)
    {
        this.userUri = userUri;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    /** * @param ownerFlag the ownerFlag to set */
    public void setOwnerFlag(boolean ownerFlag)
    {
        this.ownerFlag = ownerFlag;
    }

    /** * @return the ownerFlag */
    public boolean isOwnerFlag()
    {
        return ownerFlag;
    }

    public Integer getOperationResult()
    {
        return operationResult;
    }

    public void setOperationResult(Integer operationResult)
    {
        this.operationResult = operationResult;
    }

}
