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

public class QueryDepartmentInfoList
{
    private int amount;
    
    private List<QueryDepartmentInfo> departmentInfoList;
    
    private QueryParentDepartmentInfo parentDepartmentInfo;
    
    public int getAmount()
    {
        return amount;
    }
    
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    
    public List<QueryDepartmentInfo> getDepartmentInfoList()
    {
        return departmentInfoList;
    }
    
    public void setDepartmentInfoList(List<QueryDepartmentInfo> departmentInfoList)
    {
        this.departmentInfoList = departmentInfoList;
    }
    
    public QueryParentDepartmentInfo getParentDepartmentInfo()
    {
        return parentDepartmentInfo;
    }
    
    public void setParentDepartmentInfo(QueryParentDepartmentInfo parentDepartmentInfo)
    {
        this.parentDepartmentInfo = parentDepartmentInfo;
    }
}
