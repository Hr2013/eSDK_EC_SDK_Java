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
package com.huawei.esdk.ec.business.professional.rest.account;

import java.util.List;

import com.huawei.esdk.ec.domain.model.Account;
import com.huawei.esdk.ec.domain.model.bean.BatchAccount;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class AccountService
{
    
    public SDKResult<String> addAccount(String userId, Account account)
        throws SDKException
    {
        return account.addAccount(userId, account);
    }
    
    public SDKResult<BatchAccount> batchAddAccount(String userId, List<Account> accounts)
        throws SDKException
    {
        return new Account().batchAddAccount(userId, accounts);
    }
    
    public SDKErrorCode modifyAccount(String userId, Account account)
        throws SDKException
    {
        return account.modifyAccount(userId, account);
    }
    
    public SDKErrorCode deleteAccount(String userId, String accountId)
        throws SDKException
    {
        return new Account().deleteAccount(userId, accountId);
    }
    
    public SDKResult<BatchAccount> batchDelAccount(String userId, List<String> accountIds)
        throws SDKException
    {
        return new Account().batchDelAccount(userId, accountIds);
    }

    public SDKResult<BatchAccount> getAccount(String userId, String exactSearch, String condition, int pageCount, int pageNum)
        throws SDKException
    {
        return new Account().getAccount(userId, exactSearch, condition, pageCount, pageNum);
    }

    public SDKErrorCode modifyAcountPassword(String userId, Account account)
        throws SDKException
    {
        return new Account().modifyAcountPassword(userId, account);
    }

    public SDKErrorCode bindNum(String userId, Account account)
        throws SDKException
    {
        return new Account().bindNum(userId, account);
    }
    
}
