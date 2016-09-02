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

public class DepartmentInfo
{
    /**
     * 部门ID
     */
    private String deptId;
    
    /**
     * 部门名称
     */
    private String deptName;
    
    /**
     * 子部门的个数
     */
    private String subDeptCount;
    
    /**
     * 子部门中员工的数量
     */
    private String subEmployeeCount;
    
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
    
    public String getSubDeptCount()
    {
        return subDeptCount;
    }
    
    public void setSubDeptCount(String subDeptCount)
    {
        this.subDeptCount = subDeptCount;
    }
    
    public String getSubEmployeeCount()
    {
        return subEmployeeCount;
    }
    
    public void setSubEmployeeCount(String subEmployeeCount)
    {
        this.subEmployeeCount = subEmployeeCount;
    }
    
}
