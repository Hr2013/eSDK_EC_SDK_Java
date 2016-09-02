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

public class SIPAuth
{
    /**
     * 是否鉴权：0不鉴权，1密码鉴权，2IP鉴权，3密码和IP共同鉴权
     */
    private String type;
    
    /**
     * 鉴权密码
     */
    private String password;
    
    /**
     * 鉴权IP
     */
    private String ip;
    
    private String oldPassword;
    
    private String newPassword;
    
    private String oldIp;
    
    private String newIp;
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public String getOldPassword()
    {
        return oldPassword;
    }
    
    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }
    
    public String getNewPassword()
    {
        return newPassword;
    }
    
    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }
    
    public String getOldIp()
    {
        return oldIp;
    }
    
    public void setOldIp(String oldIp)
    {
        this.oldIp = oldIp;
    }
    
    public String getNewIp()
    {
        return newIp;
    }
    
    public void setNewIp(String newIp)
    {
        this.newIp = newIp;
    }
    
}
