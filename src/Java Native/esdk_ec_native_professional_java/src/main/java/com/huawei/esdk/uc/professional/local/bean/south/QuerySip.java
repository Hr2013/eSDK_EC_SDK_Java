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

public class QuerySip
{
    /**
     * 操作用户标识ID
     */
    String userId;
    
    /**
     * 是否精确匹配
     * 0：否
     * 1：是
     */
    String exactSearch;
    
    /**
     * 查询条件类型：
     * 0：网关IP
     * 1：号码
     * 3：设备类型
     * 4：鉴权方式
     */
    String type;
    
    /**
     * 查询条件值
     * 根据查询条件类型的不同，对应的条件值的取值说明如下：
     * 4type为0（网关IP）时，value取值为具体的网关ip，例如：“10.170.103.86”
     * 4type为1（号码）时，value取值为sip号码，例如：18246
     * 4type为3（设备类型）时，value取值为：0-普通终端、2-UC
     * 4type为4（鉴权方式）时，value取值为：0-不鉴权、1-基于IP鉴权、2-基于密码鉴权、3-基于IP与密码鉴权
     */
    String value;
    
    /**
     * 分页查询页面数（0<pagecount<100）
     */
    String pageCount;
    
    /**
     * 当前分页
     */
    String pageNum;
    
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
