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
package com.huawei.esdk.ec.device.bmu.department;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.IDepartmentCapability;
import com.huawei.esdk.ec.device.bmu.bean.AddDepartmentResponse;
import com.huawei.esdk.ec.device.bmu.bean.QueryDepartmentResponse;
import com.huawei.esdk.ec.device.bmu.department.convert.DepartmentCapabilityConvert;
import com.huawei.esdk.ec.domain.model.Department;
import com.huawei.esdk.ec.domain.model.bean.QueryDepartmentInfoList;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class DepartmentCapabilityImpl extends AbstractBMUCapability implements IDepartmentCapability
{
    private static final Logger LOGGER = Logger.getLogger(DepartmentCapabilityImpl.class);
    
    private DepartmentCapabilityConvert departmentCapabilityConvert = new DepartmentCapabilityConvert();
    
    public DepartmentCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    /** 
     * 新增部门
     * 
     * @param userId 操作用户
     * @param parentId 父部门ID
     * @param deptName 部门名称
     * @return SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<Department> addDept(String userId, String deptId, String parentId, String deptName)
    {
        LOGGER.debug("add Dept start");
        
        SDKResult<Department> result = new SDKResult<Department>();
        
        // 拼装报文
        RestReqMessage reqMessage = departmentCapabilityConvert.getAddDeptRequest(userId, deptId, parentId, deptName);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg =
                sendMessage(reqMessage, "addDepartment.action", AddDepartmentResponse.class.getName());
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
            
            // 结果转换
            if (null != xmlResMsg.getBody())
            {
                Department department = new Department();
                department.setDeptId(((AddDepartmentResponse)xmlResMsg.getBody()).getDepartmentId());
                department.setDeptNo(((AddDepartmentResponse)xmlResMsg.getBody()).getDepartmentNo());
                result.setResult(department);
            }
            
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("add Dept error", e);
        }
        
        LOGGER.debug("add dept end");
        
        return result;
    }
    
    /** 
     * 修改部门
     * 
     * @param userId 操作用户
     * @param departmentId 部门ID
     * @param deptName 部门名称
     * @return SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> modifyDept(String userId, String departmentId, String deptName, String parentId)
    {
        LOGGER.debug("modify Dept start");
        
        SDKResult<String> result = new SDKResult<String>();
        
        // 拼装报文
        RestReqMessage reqMessage =
            departmentCapabilityConvert.getModifyDeptRequest(userId, departmentId, deptName, parentId);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg = sendMessage(reqMessage, "modifyDepartment.action", null);
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("modify Dept error", e);
        }
        
        LOGGER.debug("modify dept end");
        
        return result;
    }
    
    /** 
     * 删除部门
     * 
     * @param userId 操作用户
     * @param departmentId 部门ID
     * @return SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> delDept(String userId, String departmentId)
    {
        LOGGER.debug("delete Dept start");
        
        SDKResult<String> result = new SDKResult<String>();
        
        // 拼装报文
        RestReqMessage reqMessage = departmentCapabilityConvert.getDelDeptRequest(userId, departmentId);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg = sendMessage(reqMessage, "deleteDepartment.action", null);
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("delDept Dept error", e);
        }
        
        LOGGER.debug("delDept dept end");
        
        return result;
    }
    
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
    public SDKResult<QueryDepartmentInfoList> queryDept(String userId, String parentId, int pageCount, int pageNum)
    {
        LOGGER.debug("queryDept Dept start");
        
        SDKResult<QueryDepartmentInfoList> result = new SDKResult<QueryDepartmentInfoList>();
        
        // 拼装报文
        RestReqMessage reqMessage =
            departmentCapabilityConvert.getqueryDeptRequest(userId, parentId, pageCount, pageNum);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg =
                sendMessage(reqMessage, "queryDepartment.action", QueryDepartmentResponse.class.getName());
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
            
            // 转换成领域对象
            if (0 == result.getErrCode() && null != xmlResMsg.getBody())
            {
                result.setResult(departmentCapabilityConvert.getQueryDeptRest2Model((QueryDepartmentResponse)xmlResMsg.getBody()));
            }
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("queryDept Dept error", e);
        }
        
        LOGGER.debug("queryDept dept end");
        return result;
    }
}
