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
package com.huawei.esdk.ec.device.bmu.account;

import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.account.convert.AccountCapabilityConvert;
import com.huawei.esdk.ec.device.bmu.bean.AddAccountResponse;
import com.huawei.esdk.ec.device.bmu.bean.BatchAddAccountResponse;
import com.huawei.esdk.ec.device.bmu.bean.BatchDelAccountResponse;
import com.huawei.esdk.ec.device.bmu.bean.QueryAccountDetailResponse;
import com.huawei.esdk.ec.device.bmu.bean.QueryAccountResponse;
import com.huawei.esdk.ec.device.obg.IAccountCapability;
import com.huawei.esdk.ec.domain.model.Account;
import com.huawei.esdk.ec.domain.model.bean.BatchAccount;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class AccountCapabilityImpl extends AbstractBMUCapability implements IAccountCapability
{
    private static final Logger LOGGER = Logger.getLogger(IAccountCapability.class);
    
    private AccountCapabilityConvert accountCapabilityConvert = new AccountCapabilityConvert();
    
    public AccountCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKResult<String> addAccount(String userId, Account account)
    {
        LOGGER.debug("addAccount() start");
        SDKResult<String> sdkResult = new SDKResult<String>();
        
        RestReqMessage request = accountCapabilityConvert.getAccountRequest(userId, account);
        
        try
        {
            XMLResMsg result = sendMessage(request, "addAccount.action", AddAccountResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (null != result.getBody())
            {
                sdkResult.setResult(((AddAccountResponse)result.getBody()).getAccountId());
            }
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("addAccount() error", e);
        }
        
        LOGGER.debug("addAccount() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<BatchAccount> batchAddAccount(String userId, List<Account> accounts)
    {
        LOGGER.debug("batchAddAccount() start");
        SDKResult<BatchAccount> sdkResult = new SDKResult<BatchAccount>();
        
        RestReqMessage request = accountCapabilityConvert.getBatchAccountRequest(userId, accounts);
        
        try
        {
            XMLResMsg result = sendMessage(request, "batchAddAccount.action", BatchAddAccountResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (null != result.getBody())
            {
                sdkResult.setResult(accountCapabilityConvert.getBatchAccountRest2Model((BatchAddAccountResponse)result.getBody()));
            }
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("batchAddAccount() error", e);
        }
        
        LOGGER.debug("batchAddAccount() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode modifyAccount(String userId, Account account)
    {
        LOGGER.debug("modifyAccount() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = accountCapabilityConvert.getAccountRequest(userId, account);
        
        try
        {
            XMLResMsg result = sendMessage(request, "modifyAccount.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("modifyAccount() error", e);
        }
        
        LOGGER.debug("modifyAccount() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode deleteAccount(String userId, String accountId)
    {
        LOGGER.debug("deleteAccount() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = accountCapabilityConvert.getDelAccountRequest(userId, accountId);
        
        try
        {
            XMLResMsg result = sendMessage(request, "deleteAccount.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("deleteAccount() error", e);
        }
        
        LOGGER.debug("deleteAccount() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<BatchAccount> batchDelAccount(String userId, List<String> accountIds)
    {
        LOGGER.debug("batchDelAccount() start");
        SDKResult<BatchAccount> sdkResult = new SDKResult<BatchAccount>();
        
        RestReqMessage request = accountCapabilityConvert.getBatchDelAccountRequest(userId, accountIds);
        
        try
        {
            XMLResMsg result =
                sendMessage(request, "batchDeleteAccount.action", BatchDelAccountResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (null != result.getBody())
            {
                sdkResult.setResult(accountCapabilityConvert.getBatchDelAccountRest2Model((BatchDelAccountResponse)result.getBody()));
            }
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("batchDelAccount() error", e);
        }
        
        LOGGER.debug("batchDelAccount() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<BatchAccount> getAccount(String userId, String exactSearch, String condition, int pageCount,
        int pageNum)
    {
        LOGGER.debug("getAccount() start");
        SDKResult<BatchAccount> sdkResult = new SDKResult<BatchAccount>();
        
        RestReqMessage request =
            accountCapabilityConvert.getQueryAccountRequest(userId, exactSearch, condition, pageCount, pageNum);
        
        try
        {
            XMLResMsg result = sendMessage(request, "queryAccount.action", QueryAccountResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (null != result.getBody())
            {
                sdkResult.setResult(accountCapabilityConvert.getQueryAccountRest2Model((QueryAccountResponse)result.getBody()));
            }
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("getAccount() error", e);
        }
        
        LOGGER.debug("getAccount() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode modifyAcountPassword(String userId, Account account)
    {
        LOGGER.debug("modifyAcountPassword() start");
        SDKResult<BatchAccount> sdkResult = new SDKResult<BatchAccount>();
        
        RestReqMessage request = accountCapabilityConvert.getAcountPasswordRequest(userId, account);
        
        try
        {
            XMLResMsg result = sendMessage(request, "modifyAcountPassword.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("modifyAcountPassword() error", e);
        }
        
        LOGGER.debug("modifyAcountPassword() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode bindNum(String userId, Account account)
    {
        LOGGER.debug("bindNum() start");
        SDKResult<BatchAccount> sdkResult = new SDKResult<BatchAccount>();
        
        RestReqMessage request = accountCapabilityConvert.getBindNumRequest(userId, account);
        
        try
        {
            XMLResMsg result = sendMessage(request, "bindNum.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("bindNum() error", e);
        }
        
        LOGGER.debug("bindNum() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<Account> getAccountDetail(String userId, String loginName)
    {
        LOGGER.debug("getAccountDetail() start");
        SDKResult<Account> sdkResult = new SDKResult<Account>();
        
        RestReqMessage request = accountCapabilityConvert.getQueryAccountDetailRequest(userId, loginName);
        
        try
        {
            XMLResMsg result =
                sendMessage(request, "queryAccountDetail.action", QueryAccountDetailResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (null != result.getBody())
            {
                sdkResult.setResult(accountCapabilityConvert.getQueryAccountDetailRest2Model((QueryAccountDetailResponse)result.getBody()));
            }
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("getAccountDetail() error", e);
        }
        
        LOGGER.debug("getAccountDetail() end");
        return sdkResult;
    }
    
}
