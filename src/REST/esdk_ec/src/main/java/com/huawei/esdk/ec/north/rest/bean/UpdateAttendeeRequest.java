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
package com.huawei.esdk.ec.north.rest.bean;

/**
 * @author sWX198756
 *
 */
public class UpdateAttendeeRequest
{
    /**
     * 账号
     */
    private String account;
    
    /**
     * 会议id
     */
    private String confId;
    
    /**
     * 会者号码
     */
    private String cee;
    
    /**
     * 话语权
     */
    private String auth;
    
    public String getConfId()
    {
        return confId;
    }
    
    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
    public String getCee()
    {
        return cee;
    }
    
    public void setCee(String cee)
    {
        this.cee = cee;
    }
    
    public String getAuth()
    {
        return auth;
    }
    
    public void setAuth(String auth)
    {
        this.auth = auth;
    }
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
}
