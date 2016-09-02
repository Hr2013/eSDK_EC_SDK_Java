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
package com.huawei.esdk.ec.device.bmu.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "params")
public class QuerySIPRequest
{
    @XmlElement(name = "userid")
    private String userId;
    
    @XmlElement(name = "exactsearch")
    private String exactSearch;
    
    @XmlElement(name = "condition")
    private SIPQueryCondition condition;
    
    @XmlElement(name = "pagecount")
    private String pageCount;
    
    @XmlElement(name = "pagenum")
    private String pageNum;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getExactSearch()
    {
        return exactSearch;
    }
    
    public void setExactSearch(String exactSearch)
    {
        this.exactSearch = exactSearch;
    }
    
    public SIPQueryCondition getCondition()
    {
        return condition;
    }
    
    public void setCondition(SIPQueryCondition condition)
    {
        this.condition = condition;
    }
    
    public String getPageCount()
    {
        return pageCount;
    }
    
    public void setPageCount(String pageCount)
    {
        this.pageCount = pageCount;
    }
    
    public String getPageNum()
    {
        return pageNum;
    }
    
    public void setPageNum(String pageNum)
    {
        this.pageNum = pageNum;
    }
    
}
