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
package com.huawei.esdk.ec.north.rest.bmu.resource.dept.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.north.rest.bean.QueryDepartmentInfo;
import com.huawei.esdk.ec.north.rest.bean.QueryDepartmentInfoList;
import com.huawei.esdk.ec.north.rest.bean.QueryParentDepartmentInfo;

public class DepartmentResourceConvert
{
    public QueryDepartmentInfoList getQueryDepartmentModel2Rest(
        com.huawei.esdk.ec.domain.model.bean.QueryDepartmentInfoList response)
    {
        QueryDepartmentInfoList departmentInfoList = new QueryDepartmentInfoList();
        departmentInfoList.setAmount(String.valueOf(response.getAmount()));
        
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
            
            for (com.huawei.esdk.ec.domain.model.bean.QueryDepartmentInfo qdInfo : response.getDepartmentInfoList())
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
