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
package com.huawei.esdk.uc.professional.local.bean.south;

public class SipQueryRequest
{
    /**
     * 添加号码用户
     */
    private String userId;
    
    private String exactSearch;
    
    private String type;
    
    private String value;
    
    private String pageCount;
    
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
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getValue()
    {
        return value;
    }
    
    public void setValue(String value)
    {
        this.value = value;
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
