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

import com.huawei.esdk.ec.domain.model.PersonInfo;

public class EnterpriseList
{
    
    /**
     * 某层级部门中部门和员工的总数
     */
    private int total;
    
    /**
     * 当前分页中部门的数量
     */
    private int deptSum;
    
    /**
     * 当前分页中员工的数量
     */
    private int employeeSum;
    
    /**
     * 上一级部门ID
     */
    private String parentdept;
    
    /**
     * 个人信息
     */
    private List<DepartmentInfo> departments;
    
    /**
     * 个人信息
     */
    private List<PersonInfo> employees;
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public int getDeptSum()
    {
        return deptSum;
    }
    
    public void setDeptSum(int deptSum)
    {
        this.deptSum = deptSum;
    }
    
    public int getEmployeeSum()
    {
        return employeeSum;
    }
    
    public void setEmployeeSum(int employeeSum)
    {
        this.employeeSum = employeeSum;
    }
    
    public String getParentdept()
    {
        return parentdept;
    }
    
    public void setParentdept(String parentdept)
    {
        this.parentdept = parentdept;
    }
    
    public List<PersonInfo> getEmployees()
    {
        return employees;
    }
    
    public void setEmployees(List<PersonInfo> employees)
    {
        this.employees = employees;
    }
    
    public List<DepartmentInfo> getDepartments()
    {
        return departments;
    }
    
    public void setDepartments(List<DepartmentInfo> departments)
    {
        this.departments = departments;
    }
    
}
