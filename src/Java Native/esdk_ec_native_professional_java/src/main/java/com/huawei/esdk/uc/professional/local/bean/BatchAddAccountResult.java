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

import java.util.List;

import com.huawei.esdk.uc.professional.local.bean.FailedAccount;

/**
 * 批量添加账号操作返回结果
 */
public class BatchAddAccountResult
{
	/**
	 * 成功数量
	 */
    private String successAmount;
	/**
	 * 失败数量
	 */
    private String failedAmount;
    /**
     * 添加成功的账号ID
     */
    private List<String> successAccountIds;
    /**
     * 添加失败的账号失败信息
     */
    private List<FailedAccount> failedAccounts;
    
    public String getSuccessAmount()
    {
        return successAmount;
    }
    
    public void setSuccessAmount(String successAmount)
    {
        this.successAmount = successAmount;
    }
    
    public String getFailedAmount()
    {
        return failedAmount;
    }
    
    public void setFailedAmount(String failedAmount)
    {
        this.failedAmount = failedAmount;
    }
    
    public List<String> getSuccessAccountIds()
    {
        return successAccountIds;
    }
    
    public void setSuccessAccountIds(List<String> successAccountIds)
    {
        this.successAccountIds = successAccountIds;
    }
    
    public List<FailedAccount> getFailedAccounts()
    {
        return failedAccounts;
    }
    
    public void setFailedAccounts(List<FailedAccount> failedAccounts)
    {
        this.failedAccounts = failedAccounts;
    }
    
}
