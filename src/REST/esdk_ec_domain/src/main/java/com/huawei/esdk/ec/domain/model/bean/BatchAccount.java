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

import java.util.List;

import com.huawei.esdk.ec.domain.model.Account;

public class BatchAccount
{
    private int successAmount;
    
    private int failedAmount;
    
    private List<Account> accountIds;
    
    private List<Account> failedAccounts;
    
    public int getSuccessAmount()
    {
        return successAmount;
    }
    
    public void setSuccessAmount(int successAmount)
    {
        this.successAmount = successAmount;
    }
    
    public int getFailedAmount()
    {
        return failedAmount;
    }
    
    public void setFailedAmount(int failedAmount)
    {
        this.failedAmount = failedAmount;
    }
    
    public List<Account> getAccountIds()
    {
        return accountIds;
    }
    
    public void setAccountIds(List<Account> accountIds)
    {
        this.accountIds = accountIds;
    }
    
    public List<Account> getFailedAccounts()
    {
        return failedAccounts;
    }
    
    public void setFailedAccounts(List<Account> failedAccounts)
    {
        this.failedAccounts = failedAccounts;
    }
    
}
