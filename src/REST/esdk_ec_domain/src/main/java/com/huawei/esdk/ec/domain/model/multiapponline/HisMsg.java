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
package com.huawei.esdk.ec.domain.model.multiapponline;

public class HisMsg
{
    private String accounts;
    
    private String groupId;
    
    private String contentType;
    
    private String pageCount;
    
    private String pageNum;
    
    private String beginTime;
    
    private String endTime;
    
    public String getAccounts()
    {
        return accounts;
    }
    
    public void setAccounts(String accounts)
    {
        this.accounts = accounts;
    }
    
    public String getGroupId()
    {
        return groupId;
    }
    
    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }
    
    public String getContentType()
    {
        return contentType;
    }
    
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
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
    
    public String getBeginTime()
    {
        return beginTime;
    }
    
    public void setBeginTime(String beginTime)
    {
        this.beginTime = beginTime;
    }
    
    public String getEndTime()
    {
        return endTime;
    }
    
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
    
}
