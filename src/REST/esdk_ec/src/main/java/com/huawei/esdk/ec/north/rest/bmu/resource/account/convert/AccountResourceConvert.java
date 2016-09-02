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
package com.huawei.esdk.ec.north.rest.bmu.resource.account.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.common.CipherUtilsRest;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.Account;
import com.huawei.esdk.ec.domain.model.bean.BatchAccount;
import com.huawei.esdk.ec.north.rest.bean.AccountResponse;
import com.huawei.esdk.ec.north.rest.bean.BatchAddAccountResponse;
import com.huawei.esdk.ec.north.rest.bean.BatchDelAccountResponse;
import com.huawei.esdk.ec.north.rest.bean.FailedAccount;
import com.huawei.esdk.ec.north.rest.bean.FailedDelAccount;
import com.huawei.esdk.ec.north.rest.bean.GetAccountResponse;
import com.huawei.esdk.ec.north.rest.bean.RestResponse;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class AccountResourceConvert
{
    public Account getAccountRest2Model(com.huawei.esdk.ec.north.rest.bean.Account rest)
        throws SDKException
    {
        Account account = new Account();
        
        // UC2.3.1 begin
        account.setAccountType(rest.getAccountType());
        account.setLoginName(rest.getLoginName());
        
        if (!StringUtils.isEmpty(rest.getPassword()))
        {
            String password = CipherUtilsRest.decodeFromBase64(rest.getPassword());
            if (StringUtils.isEmpty(password))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
            account.setPassword(password);
        }
        else
        {
            account.setPassword(rest.getPassword());
        }
        
        account.setName(rest.getName());
        account.setSex(rest.getSex());
        account.setHomePhone(rest.getHomePhone());
        account.setCellPhone(rest.getCellPhone());
        account.setOfficePhone(rest.getOfficePhone());
        account.setShortPhone(rest.getShortPhone());
        account.setOtherPhone(rest.getOtherPhone());
        account.setFax(rest.getFax());
        account.setEmail(rest.getEmail());
        account.setAddr(rest.getAddr());
        account.setTitle(rest.getTitle());
        account.setDepartmentId(rest.getDepartmentId());
        account.setUserLevel(rest.getUserLevel());
        account.setRoleId(rest.getRoleId());
        // UC2.3.1 end
        
        //EC3.0 new add begin
        account.setOtherphone2(rest.getOtherphone2());
        account.setZip(rest.getZip());
        account.setStaffNum(rest.getStaffNum());
        account.setForeignName(rest.getForeignName());
        account.setUserState(rest.getUserState());
        account.setNotesMail(rest.getNotesMail());
        account.setBirthday(rest.getBirthday());
        account.setDes(rest.getDes());
        account.setWebsite(rest.getWebsite());
        
        // modify account use  
        account.setAccountId(rest.getAccountId());
        account.setjPinyin(rest.getjPinyin());
        account.setqPinyin(rest.getqPinyin());
        
        // modify account (password) use
        // account.setOldPassword(rest.getOldPassword());
        // account.setNewPassword(rest.getNewPassword());
        
        // bind num use
        // account.setBindNum(rest.getBindNum());
        
        return account;
    }
    
    public List<Account> getBatchAccountRest2Model(List<com.huawei.esdk.ec.north.rest.bean.Account> accounts)
        throws SDKException
    {
        List<Account> models = new ArrayList<Account>();
        Account model = null;
        for (com.huawei.esdk.ec.north.rest.bean.Account account : accounts)
        {
            model = getAccountRest2Model(account);
            models.add(model);
        }
        return models;
    }
    
    public RestResponse<BatchAddAccountResponse> getBatchAccountModel2Rest(SDKResult<BatchAccount> result)
    {
        RestResponse<BatchAddAccountResponse> response = new RestResponse<BatchAddAccountResponse>();
        
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        
        BatchAccount batchAccount = result.getResult();
        if (null != batchAccount)
        {
            BatchAddAccountResponse addAccountResponse = new BatchAddAccountResponse();
            response.setResult(addAccountResponse);
            addAccountResponse.setSuccessAmount(String.valueOf(batchAccount.getSuccessAmount()));
            addAccountResponse.setFailedAmount(String.valueOf(batchAccount.getFailedAmount()));
            
            List<Account> accountIds = batchAccount.getAccountIds();
            if (null != accountIds && !accountIds.isEmpty())
            {
                List<String> restIds = new ArrayList<String>();
                addAccountResponse.setAccountIds(restIds);
                for (Account accountId : accountIds)
                {
                    restIds.add(accountId.getAccountId());
                }
            }
            
            List<Account> failedAccounts = batchAccount.getFailedAccounts();
            if (null != failedAccounts && !failedAccounts.isEmpty())
            {
                List<FailedAccount> failedRests = new ArrayList<FailedAccount>();
                addAccountResponse.setFailedAccounts(failedRests);
                FailedAccount failed = null;
                for (Account account : failedAccounts)
                {
                    failed = new FailedAccount();
                    failedRests.add(failed);
                    failed.setLoginName(account.getLoginName());
                    failed.setFailedReason(account.getFailedReason());
                }
            }
        }
        
        return response;
    }
    
    public RestResponse<BatchDelAccountResponse> getBatchDelAccountModel2Rest(SDKResult<BatchAccount> result)
    {
        RestResponse<BatchDelAccountResponse> response = new RestResponse<BatchDelAccountResponse>();
        
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        
        BatchAccount model = result.getResult();
        if (null != model)
        {
            BatchDelAccountResponse rest = new BatchDelAccountResponse();
            response.setResult(rest);
            rest.setFailedAmount(String.valueOf(model.getFailedAmount()));
            
            // modify by cWX191990, 批量删除帐号不返回失败的信息，取值错误
            //List<Account> accts =model.getAccountIds();
            List<Account> accts = model.getFailedAccounts();
            
            if (null != accts && !accts.isEmpty())
            {
                List<FailedDelAccount> failedAccounts = new ArrayList<FailedDelAccount>();
                rest.setFailedAccounts(failedAccounts);
                FailedDelAccount failed = null;
                for (Account acct : accts)
                {
                    failed = new FailedDelAccount();
                    failed.setAccountId(acct.getAccountId());
                    failed.setFailedReason(acct.getFailedReason());
                    failedAccounts.add(failed);
                }
            }
        }
        
        return response;
    }
    
    public RestResponse<GetAccountResponse> getAccountModel2Rest(SDKResult<BatchAccount> result)
    {
        RestResponse<GetAccountResponse> response = new RestResponse<GetAccountResponse>();
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        BatchAccount modelAccount = result.getResult();
        if (null != modelAccount)
        {
            GetAccountResponse accoutRes = new GetAccountResponse();
            response.setResult(accoutRes);
            accoutRes.setAmount(modelAccount.getSuccessAmount());
            
            List<Account> accounts = modelAccount.getAccountIds();
            if (null != accounts && !accounts.isEmpty())
            {
                List<AccountResponse> rests = new ArrayList<AccountResponse>();
                accoutRes.setAccounts(rests);
                for (Account account : accounts)
                {
                    rests.add(getAccountModel2Rest(account));
                }
            }
        }
        
        return response;
    }
    
    public Account getAccountPasswordRest2Model(com.huawei.esdk.ec.north.rest.bean.Account rest)
        throws SDKException
    {
        Account account = new Account();
        account.setAccountId(rest.getAccountId());
        account.setLoginName(rest.getLoginName());
        
        if (!StringUtils.isEmpty(rest.getOldPassword()))
        {
            String oldPsw = CipherUtilsRest.decodeFromBase64(rest.getOldPassword());
            if (StringUtils.isEmpty(oldPsw))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
            account.setOldPassword(oldPsw);
        }
        else
        {
            account.setOldPassword(rest.getOldPassword());
        }
        
        if (!StringUtils.isEmpty(rest.getNewPassword()))
        {
            String newPsw = CipherUtilsRest.decodeFromBase64(rest.getNewPassword());
            if (StringUtils.isEmpty(newPsw))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
            account.setNewPassword(newPsw);
        }
        else
        {
            account.setNewPassword(rest.getNewPassword());
        }
        
        return account;
    }
    
    public Account getAccountBindNumRest2Model(com.huawei.esdk.ec.north.rest.bean.Account rest)
    {
        Account account = new Account();
        account.setAccountId(rest.getAccountId());
        account.setBindNum(rest.getBindNum());
        
        return account;
    }
    
    private AccountResponse getAccountModel2Rest(Account account)
    {
        AccountResponse rest = new AccountResponse();
        
        rest.setAccountType(account.getAccountType());
        rest.setLoginName(account.getLoginName());
        rest.setName(account.getName());
        rest.setSex(account.getSex());
        rest.setHomePhone(account.getHomePhone());
        rest.setCellPhone(account.getCellPhone());
        rest.setOfficePhone(account.getOfficePhone());
        rest.setShortPhone(account.getShortPhone());
        rest.setOtherPhone(account.getOtherPhone());
        rest.setFax(account.getFax());
        rest.setEmail(account.getEmail());
        rest.setAddress(account.getAddr());
        rest.setTitle(account.getTitle());
        rest.setDepartmentId(account.getDepartmentId());
        rest.setUserLevel(account.getUserLevel());
        rest.setRoleId(account.getRoleId());
        rest.setBindNum(account.getBindNum());
        
        // EC3.0 new add
        rest.setOtherphone2(account.getOtherphone2());
        rest.setZip(account.getZip());
        rest.setUserState(account.getUserState());
        rest.setNotesMail(account.getNotesMail());
        rest.setBirthday(account.getBirthday());
        rest.setDes(account.getDes());
        rest.setWebsite(account.getWebsite());
        rest.setjPinyin(account.getjPinyin());
        rest.setqPinyin(account.getqPinyin());
        rest.setAccountId(account.getAccountId());
        rest.setAccountState(account.getAccountState());
        rest.setModifyTime(account.getModifyTime());
        
        return rest;
    }
}
