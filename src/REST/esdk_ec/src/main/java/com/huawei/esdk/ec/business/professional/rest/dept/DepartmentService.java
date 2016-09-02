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
package com.huawei.esdk.ec.business.professional.rest.dept;

import com.huawei.esdk.ec.domain.model.Department;
import com.huawei.esdk.ec.domain.model.bean.QueryDepartmentInfoList;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 部门服务层对象
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK UC V100R003C30]
 */
public class DepartmentService
{
    /** 
    * 新增部门
    * 
    * @param userId 操作用户
    * @param parentId 父部门ID
    * @param deptName 部门名称
    * @return SDK结果对象
    * @throws SDKException SDK系统异常
    * @see [类、类#方法、类#成员]
    */
    public SDKResult<Department> addDepartment(String userId, String parentId, String deptName)
        throws SDKException
    {
        return new Department().addDept(userId, null, parentId, deptName);
    }
    
    /** 
     * 修改部门
     * 
     * @param userId 操作用户
     * @param departmentId 部门ID
     * @param deptName 部门名称
     * @return SDK结果对象
     * @throws SDKException SDK系统异常
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> modifyDepartment(String userId, String departmentId, String deptName, String parentId)
        throws SDKException
    {
        return new Department().modifyDept(userId, departmentId, deptName, parentId);
    }
    
    /** 
     * 删除部门
     * 
     * @param userId 操作用户
     * @param departmentId 部门ID
     * @return SDK结果对象
     * @throws SDKException SDK系统异常
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> deleteDepartment(String userId, String departmentId)
        throws SDKException
    {
        return new Department().delDept(userId, departmentId);
    }
    
    /** 
    * 查询部门
    * 
    * @param userId 操作用户
    * @param parentId 父部门ID
    * @param pageCount 分页大小
    * @param pageNum 当前分页
    * @return SDK结果对象
    * @throws SDKException
    * @see [类、类#方法、类#成员]
    */
    public SDKResult<QueryDepartmentInfoList> queryDepartment(String userId, String parentId, int pageCount, int pageNum)
        throws SDKException
    {
        return new Department().queryDept(userId, parentId, pageCount, pageNum);
    }
}
