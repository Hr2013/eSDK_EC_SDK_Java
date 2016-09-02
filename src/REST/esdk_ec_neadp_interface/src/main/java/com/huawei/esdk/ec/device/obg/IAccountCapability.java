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
package com.huawei.esdk.ec.device.obg;

import java.util.List;

import com.huawei.esdk.ec.domain.model.Account;
import com.huawei.esdk.ec.domain.model.bean.BatchAccount;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

public interface IAccountCapability
{
    /**
     * 添加账号
     * @param userId
     * @param account
     * @return
     */
    SDKResult<String> addAccount(String userId, Account account);
    
    /**
     * 批量添加账号
     * @param userId
     * @param accounts
     * @return
     */
    SDKResult<BatchAccount> batchAddAccount(String userId, List<Account> accounts);
    
    /**
     * 修改账号
     * @param userId
     * @param account
     * @return
     */
    SDKErrorCode modifyAccount(String userId, Account account);
    
    /**
     * 删除账号
     * @param userId
     * @param accountId
     * @return
     */
    SDKErrorCode deleteAccount(String userId, String accountId);
    
    /**
     * 批量删除账号
     * @param userId
     * @param accountIds
     * @return
     */
    SDKResult<BatchAccount> batchDelAccount(String userId, List<String> accountIds);
    
    /**
     * 查询账号
     * @param userId
     * @param exactSearch
     * @param condition
     * @param pageCount
     * @param pageNum
     * @return
     */
    SDKResult<BatchAccount> getAccount(String userId, String exactSearch, String condition, int pageCount, int pageNum);
    
    /**
     * 修改密码
     * @param userId
     * @param account
     * @return
     */
    SDKErrorCode modifyAcountPassword(String userId, Account account);
    
    /**
     * 绑定号码
     * @param userId
     * @param account
     * @return
     */
    SDKErrorCode bindNum(String userId, Account account);
    
    /**
     * 查询帐号详情(3.0新增)
     * 
     * @param userId
     * @param loginName
     * @return
     */
    SDKResult<Account> getAccountDetail(String userId, String loginName);
}
