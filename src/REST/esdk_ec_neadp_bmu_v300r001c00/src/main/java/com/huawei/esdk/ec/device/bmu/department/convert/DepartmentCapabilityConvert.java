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
package com.huawei.esdk.ec.device.bmu.department.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.AddDepartment;
import com.huawei.esdk.ec.device.bmu.bean.AddDepartmentRequest;
import com.huawei.esdk.ec.device.bmu.bean.DeleteDepartmentRequest;
import com.huawei.esdk.ec.device.bmu.bean.ModifyDepartment;
import com.huawei.esdk.ec.device.bmu.bean.ModifyDepartmentRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryDepartmentRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryDepartmentResponse;
import com.huawei.esdk.ec.domain.model.bean.QueryDepartmentInfo;
import com.huawei.esdk.ec.domain.model.bean.QueryDepartmentInfoList;
import com.huawei.esdk.ec.domain.model.bean.QueryParentDepartmentInfo;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class DepartmentCapabilityConvert
{
    public RestReqMessage getAddDeptRequest(String userId, String deptId, String parentId, String deptName)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        AddDepartmentRequest addDepartmentRequest = new AddDepartmentRequest();
        addDepartmentRequest.setUserId(userId);
        
        AddDepartment addDepartment = new AddDepartment();
        addDepartment.setDepartmentId(deptId);
        addDepartment.setParentId(parentId);
        addDepartment.setDepartmentName(deptName);
        addDepartmentRequest.setDepartment(addDepartment);
        
        payload.setBody(addDepartmentRequest);
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getModifyDeptRequest(String userId, String departmentId, String deptName, String parentId)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        ModifyDepartmentRequest modifyDepartmentRequest = new ModifyDepartmentRequest();
        modifyDepartmentRequest.setUserId(userId);
        
        ModifyDepartment modifyDepartment = new ModifyDepartment();
        modifyDepartment.setDepartmentId(departmentId);
        modifyDepartment.setDepartmentName(deptName);
        modifyDepartment.setParentId(parentId);// 新增parentId字段
        modifyDepartmentRequest.setModifyDepartment(modifyDepartment);
        
        payload.setBody(modifyDepartmentRequest);
        request.setPayload(payload);
        return request;
    }
    
    public RestReqMessage getDelDeptRequest(String userId, String departmentId)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        DeleteDepartmentRequest deleteDepartmentRequest = new DeleteDepartmentRequest();
        deleteDepartmentRequest.setUserId(userId);
        deleteDepartmentRequest.setDepartmentId(departmentId);
        
        payload.setBody(deleteDepartmentRequest);
        request.setPayload(payload);
        return request;
    }
    
    public RestReqMessage getqueryDeptRequest(String userId, String parentId, int pageCount, int pageNum)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        QueryDepartmentRequest queryDepartmentRequest = new QueryDepartmentRequest();
        queryDepartmentRequest.setUserId(userId);
        queryDepartmentRequest.setParentId(parentId);
        queryDepartmentRequest.setPageCount(pageCount);
        queryDepartmentRequest.setPageNum(pageNum);
        
        payload.setBody(queryDepartmentRequest);
        request.setPayload(payload);
        return request;
    }
    
    public QueryDepartmentInfoList getQueryDeptRest2Model(QueryDepartmentResponse response)
    {
        QueryDepartmentInfoList departmentInfoList = new QueryDepartmentInfoList();
        departmentInfoList.setAmount(response.getAmount());
        
        if (null != response.getParentDepartmentInfo())
        {
            QueryParentDepartmentInfo parentDepartmentInfo = new QueryParentDepartmentInfo();
            departmentInfoList.setParentDepartmentInfo(parentDepartmentInfo);
            
            parentDepartmentInfo.setDepartmentId(response.getParentDepartmentInfo().getDepartmentId());
            parentDepartmentInfo.setDepartmentName(response.getParentDepartmentInfo().getDepartmentName());
            parentDepartmentInfo.setDepartmentNo(response.getParentDepartmentInfo().getDepartmentNo());
        }
        
        if (null != response.getDepartmentInfoList() && !response.getDepartmentInfoList().isEmpty())
        {
            List<QueryDepartmentInfo> departmentInfos = new ArrayList<QueryDepartmentInfo>();
            QueryDepartmentInfo departmentInfo = null;
            
            for (com.huawei.esdk.ec.device.bmu.bean.QueryDepartmentInfo qdInfo : response.getDepartmentInfoList())
            {
                departmentInfo = new QueryDepartmentInfo();
                departmentInfo.setDepartmentId(qdInfo.getDepartmentId());
                departmentInfo.setDepartmentName(qdInfo.getDepartmentName());
                departmentInfo.setDepartmentNo(qdInfo.getDepartmentNo());
                departmentInfos.add(departmentInfo);
            }
            
            departmentInfoList.setDepartmentInfoList(departmentInfos);
        }
        
        return departmentInfoList;
    }
}
