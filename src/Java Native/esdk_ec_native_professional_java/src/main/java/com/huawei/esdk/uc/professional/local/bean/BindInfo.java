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
package com.huawei.esdk.uc.professional.local.bean;

public class BindInfo
{
    /**
     * UC账号
     */
    String ucAccount;
    
    /**
     * 企业内短号
     */
    String corpInterNumber;
    
    /**
     * 绑定类型：
     * 0：绑定
     * 1：解绑定
     */
    Integer bindType;
    
    public String getUcAccount()
    {
        return ucAccount;
    }
    
    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }
    
    public String getCorpInterNumber()
    {
        return corpInterNumber;
    }
    
    public void setCorpInterNumber(String corpInterNumber)
    {
        this.corpInterNumber = corpInterNumber;
    }
    
    public Integer getBindType()
    {
        return bindType;
    }
    
    public void setBindType(Integer bindType)
    {
        this.bindType = bindType;
    }
    
}
