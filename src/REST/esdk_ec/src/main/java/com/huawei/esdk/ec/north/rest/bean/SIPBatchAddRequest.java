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

public class SIPBatchAddRequest
{
    /**
     * 添加号码用户
     */
    private String userId;
    
    //号码步长
    private String numStep;
    
    //号码总数，不能超过1000
    private String amount;
    
    //设备步长
    private String ueStep;
    
    //初始号码
    private SIPAccount sip;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getNumStep()
    {
        return numStep;
    }

    public void setNumStep(String numStep)
    {
        this.numStep = numStep;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getUeStep()
    {
        return ueStep;
    }

    public void setUeStep(String ueStep)
    {
        this.ueStep = ueStep;
    }

    public SIPAccount getSip()
    {
        return sip;
    }

    public void setSip(SIPAccount sip)
    {
        this.sip = sip;
    }

}
