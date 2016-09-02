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
package com.huawei.esdk.ec.device.bmu;

import com.huawei.esdk.ec.domain.model.Department;
import com.huawei.esdk.ec.domain.model.bean.QueryDepartmentInfoList;
import com.huawei.esdk.platform.common.SDKResult;

public interface IDepartmentCapability
{
    /** 
     * 新增部门
     * 
     * @param userId 操作用户
     * @param deptId 部门ID add by wangxiaobo
     * @param parentId 父部门ID
     * @param deptName 部门名称
     * @return SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<Department> addDept(String userId, String deptId, String parentId, String deptName);
    
    /** 
     * 修改部门
     * 
     * @param userId 操作用户
     * @param departmentId 部门ID
     * @param deptName 部门名称
     * @return SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> modifyDept(String userId, String departmentId, String deptName, String parentId);
    
    /** 
     * 删除部门
     * 
     * @param userId 操作用户
     * @param departmentId 部门ID
     * @return SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> delDept(String userId, String departmentId);
    
    /** 
     * 查询部门
     * 
     * @param userId 操作用户
     * @param parentId 父部门ID
     * @param pageCount 分页大小
     * @param pageNum 当前分页
     * @return SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<QueryDepartmentInfoList> queryDept(String userId, String parentId, int pageCount, int pageNum);
}
