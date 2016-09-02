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

import java.util.List;

/**
 * <一句话功能简述>
 * <p>
 * <功能详细描述>
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class UserStateListAck
{
    private int code;
    
    private long sno;
    
    private long stamp;
    
    private String extParams;
    
    private String priorityLevel;
    
    private String user;
    
    private List<UserState> stateList;
    
    public int getCode()
    {
        return code;
    }
    
    public void setCode(int code)
    {
        this.code = code;
    }
    
    public long getSno()
    {
        return sno;
    }
    
    public void setSno(long sno)
    {
        this.sno = sno;
    }
    
    public long getStamp()
    {
        return stamp;
    }
    
    public void setStamp(long stamp)
    {
        this.stamp = stamp;
    }
    
    public String getExtParams()
    {
        return extParams;
    }
    
    public void setExtParams(String extParams)
    {
        this.extParams = extParams;
    }
    
    public String getPriorityLevel()
    {
        return priorityLevel;
    }
    
    public void setPriorityLevel(String priorityLevel)
    {
        this.priorityLevel = priorityLevel;
    }
    
    public String getUser()
    {
        return user;
    }
    
    public void setUser(String user)
    {
        this.user = user;
    }
    
    public List<UserState> getStateList()
    {
        return stateList;
    }
    
    public void setStateList(List<UserState> stateList)
    {
        this.stateList = stateList;
    }
}
