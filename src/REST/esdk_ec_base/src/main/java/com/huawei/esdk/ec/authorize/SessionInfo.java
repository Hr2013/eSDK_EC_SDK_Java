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
package com.huawei.esdk.ec.authorize;

public class SessionInfo
{
    private String userId;
    
    private String pwd;
    
    private String appId;

    private String tag;
    
    private boolean isLogged;
    
    private byte[] secretKey;
    
    private byte[] iv;
    
    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public boolean isLogged()
    {
        return isLogged;
    }

    public void setLogged(boolean isLogged)
    {
        this.isLogged = isLogged;
    }

    public byte[] getSecretKey()
    {
        if(secretKey == null)
        {
            return new byte[0];
        }
        return secretKey.clone();
    }

    public void setSecretKey(byte[] secretKey)
    {
        if(secretKey != null)
        {
            this.secretKey = secretKey.clone();
        }
    }

    public byte[] getIv()
    {
        if(iv == null)
        {
            return new byte[0];
        }
        return iv.clone();
    }

    public void setIv(byte[] iv)
    {
        if(iv != null)
        {
            this.iv = iv.clone();
        }
    }
    
}
