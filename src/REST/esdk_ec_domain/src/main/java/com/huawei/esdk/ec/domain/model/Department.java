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
package com.huawei.esdk.ec.domain.model;

import com.huawei.esdk.ec.device.bmu.IDepartmentCapability;
import com.huawei.esdk.ec.devices.v200r001c03.bmp.UCV2R1C03BMPAccountCapability;
import com.huawei.esdk.ec.domain.model.bean.QueryDepartmentInfoList;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * 部门实体类
 */
public class Department
{
    // 部门ID
    private String deptId;
    
    // 部门所属企业ID
    private String corpId;
    
    // 父部门标识ID
    private String parentDeptId;
    
    // 部门名称
    private String deptName;
    
    // 部门编号
    private String deptNo;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        Department.deviceManager = deviceManager;
    }
    
    public Department(String deptId)
    {
        this.setDeptId(deptId);
    }
    
    public Department()
    {
    }
    
    /*
     * 增加部门
     */
    public SDKResult<String> addDept(Department dept)
        throws SDKException
    {
        UCV2R1C03BMPAccountCapability accountCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                UCV2R1C03BMPAccountCapability.class);
        SDKResult<String> errorCode = accountCapability.addDept(dept);
        return errorCode;
    }
    
    /**
     * 新增部门(Rest接口)
     * 
     * @param userId
     *            操作用户
     * @param parentId
     *            父部门ID
     * @param deptName
     *            部门名称
     * @return SDK结果对象
     * @throws SDKException
     *             SDK系统异常
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<Department> addDept(String userId, String deptId, String parentId, String deptName)
        throws SDKException
    {
        IDepartmentCapability departmentCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                IDepartmentCapability.class);
        return departmentCapability.addDept(userId, deptId, parentId, deptName);
    }
    
    /*
     * 增加部门
     */
    public SDKResult<String> updateDept(Department dept)
        throws SDKException
    {
        UCV2R1C03BMPAccountCapability accountCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                UCV2R1C03BMPAccountCapability.class);
        SDKResult<String> errorCode = accountCapability.updateDept(dept);
        return errorCode;
    }
    
    /*
     * 修改部门
     */
    public SDKResult<String> modifyDept(Department dept)
        throws SDKException
    {
        UCV2R1C03BMPAccountCapability accountCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                UCV2R1C03BMPAccountCapability.class);
        SDKResult<String> result = accountCapability.modDept(dept);
        return result;
    }
    
    /**
     * 修改部门(Rest接口)
     * 
     * @param userId
     *            操作用户
     * @param departmentId
     *            部门ID
     * @param deptName
     *            部门名称
     * @return SDK结果对象
     * @throws SDKException
     *             SDK系统异常
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> modifyDept(String userId, String departmentId, String deptName, String parentId)
        throws SDKException
    {
        IDepartmentCapability departmentCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                IDepartmentCapability.class);
        return departmentCapability.modifyDept(userId, departmentId, deptName, parentId);
    }
    
    /**
     * 删除部门<br>
     * 
     * @author liuquan 110528
     * @since eSdk V1R2
     * @param dept
     * @return
     * @throws SDKException
     */
    public SDKResult<String> delDept(Department dept)
        throws SDKException
    {
        UCV2R1C03BMPAccountCapability accountCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                UCV2R1C03BMPAccountCapability.class);
        SDKResult<String> result = accountCapability.delDept(dept);
        return result;
    }
    
    /**
     * 删除部门(Rest接口)
     * 
     * @param userId
     *            操作用户
     * @param departmentId
     *            部门ID
     * @return SDK结果对象
     * @throws SDKException
     *             SDK系统异常
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> delDept(String userId, String departmentId)
        throws SDKException
    {
        IDepartmentCapability departmentCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                IDepartmentCapability.class);
        return departmentCapability.delDept(userId, departmentId);
    }
    
    /**
     * 查询部门
     * 
     * @param userId
     *            操作用户
     * @param parentId
     *            父部门ID
     * @param pageCount
     *            分页大小
     * @param pageNum
     *            当前分页
     * @return SDK结果对象
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<QueryDepartmentInfoList> queryDept(String userId, String parentId, int pageCount, int pageNum)
        throws SDKException
    {
        IDepartmentCapability departmentCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                IDepartmentCapability.class);
        return departmentCapability.queryDept(userId, parentId, pageCount, pageNum);
    }
    
    public String getDeptId()
    {
        return deptId;
    }
    
    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }
    
    public String getCorpId()
    {
        return corpId;
    }
    
    public void setCorpId(String corpId)
    {
        this.corpId = corpId;
    }
    
    public String getParentDeptId()
    {
        return parentDeptId;
    }
    
    public void setParentDeptId(String parentDeptId)
    {
        this.parentDeptId = parentDeptId;
    }
    
    public String getDeptName()
    {
        return deptName;
    }
    
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }
    
    public String getDeptNo()
    {
        return deptNo;
    }
    
    public void setDeptNo(String deptNo)
    {
        this.deptNo = deptNo;
    }
    
}
