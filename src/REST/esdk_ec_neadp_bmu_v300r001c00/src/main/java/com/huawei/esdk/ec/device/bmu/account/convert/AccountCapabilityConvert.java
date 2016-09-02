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
package com.huawei.esdk.ec.device.bmu.account.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.AddAccountRequest;
import com.huawei.esdk.ec.device.bmu.bean.BatchAddAccountRequest;
import com.huawei.esdk.ec.device.bmu.bean.BatchAddAccountResponse;
import com.huawei.esdk.ec.device.bmu.bean.BatchDelAccountRequest;
import com.huawei.esdk.ec.device.bmu.bean.BatchDelAccountResponse;
import com.huawei.esdk.ec.device.bmu.bean.DeleteAccountRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryAccountDetailRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryAccountDetailResponse;
import com.huawei.esdk.ec.device.bmu.bean.QueryAccountRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryAccountResponse;
import com.huawei.esdk.ec.domain.model.Account;
import com.huawei.esdk.ec.domain.model.bean.BatchAccount;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class AccountCapabilityConvert
{
    
    public RestReqMessage getAccountRequest(String userId, Account account)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        AddAccountRequest acctRequest = new AddAccountRequest();
        
        acctRequest.setUserId(userId);
        
        acctRequest.setAccount(getAccountModel2Rest(account));
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    private com.huawei.esdk.ec.device.bmu.bean.Account getAccountModel2Rest(Account model)
    {
        com.huawei.esdk.ec.device.bmu.bean.Account account = new com.huawei.esdk.ec.device.bmu.bean.Account();
        
        account.setAccountType(model.getAccountType());
        account.setLoginName(model.getLoginName());
        account.setPassword(model.getPassword());
        account.setName(model.getName());
        account.setSex(model.getSex());
        account.setHomephone(model.getHomePhone());
        account.setCellphone(model.getCellPhone());
        account.setOfficephone(model.getOfficePhone());
        account.setShortphone(model.getShortPhone());
        account.setOtherphone(model.getOtherPhone());
        account.setFax(model.getFax());
        account.setEmail(model.getEmail());
        account.setAddr(model.getAddr());
        account.setTitle(model.getTitle());
        account.setDepartmentId(model.getDepartmentId());
        account.setUserLevel(model.getUserLevel());
        account.setRoleId(model.getRoleId());
        // UC2.3.1 end
        
        //EC3.0 new add begin
        account.setOtherphone2(model.getOtherphone2());
        account.setZip(model.getZip());
        account.setStaffNum(model.getStaffNum());
        account.setForeignName(model.getForeignName());
        account.setUserState(model.getUserState());
        account.setNotesMail(model.getNotesMail());
        account.setBirthday(model.getBirthday());
        account.setDes(model.getDes());
        account.setWebsite(model.getWebsite());
        
        // modify account use  
        if (!StringUtils.isEmpty(model.getAccountId()))
        {
            account.setAccountId(model.getAccountId());
        }
        account.setjPinyin(model.getjPinyin());
        account.setqPinyin(model.getqPinyin());
        
        return account;
    }
    
    public RestReqMessage getBatchAccountRequest(String userId, List<Account> accounts)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        BatchAddAccountRequest acctRequest = new BatchAddAccountRequest();
        
        acctRequest.setUserId(userId);
        
        List<com.huawei.esdk.ec.device.bmu.bean.Account> accountRests =
            new ArrayList<com.huawei.esdk.ec.device.bmu.bean.Account>();
        acctRequest.setAccounts(accountRests);
        for (Account account : accounts)
        {
            accountRests.add(getAccountModel2Rest(account));
        }
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public BatchAccount getBatchAccountRest2Model(BatchAddAccountResponse body)
    {
        BatchAccount model = new BatchAccount();
        model.setSuccessAmount(body.getSuccessAmount());
        model.setFailedAmount(body.getFailedAmount());
        
        if (null != body.getAccountIds() && !body.getAccountIds().isEmpty())
        {
            List<Account> modelIds = new ArrayList<Account>();
            model.setAccountIds(modelIds);
            
            Account modelId = null;
            for (String id : body.getAccountIds())
            {
                modelId = new Account();
                modelIds.add(modelId);
                modelId.setAccountId(id);
            }
        }
        
        if (null != body.getFailedAccounts() && !body.getFailedAccounts().isEmpty())
        {
            List<Account> failedAccounts = new ArrayList<Account>();
            model.setFailedAccounts(failedAccounts);
            Account failed = null;
            for (com.huawei.esdk.ec.device.bmu.bean.Account restAccount : body.getFailedAccounts())
            {
                failed = new Account();
                failedAccounts.add(failed);
                failed.setLoginName(restAccount.getLoginName());
                failed.setFailedReason(restAccount.getFailedReason());
            }
        }
        
        return model;
    }
    
    public RestReqMessage getDelAccountRequest(String userId, String accountId)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        DeleteAccountRequest acctRequest = new DeleteAccountRequest();
        
        acctRequest.setUserId(userId);
        
        acctRequest.setAccountId(accountId);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getBatchDelAccountRequest(String userId, List<String> accountIds)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        BatchDelAccountRequest acctRequest = new BatchDelAccountRequest();
        
        acctRequest.setUserId(userId);
        acctRequest.setAccountIds(accountIds);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public BatchAccount getBatchDelAccountRest2Model(BatchDelAccountResponse body)
    {
        BatchAccount model = new BatchAccount();
        model.setFailedAmount(body.getFailedAmount());
        
        if (null != body.getFailedAccounts() && !body.getFailedAccounts().isEmpty())
        {
            List<Account> failedAccounts = new ArrayList<Account>();
            model.setFailedAccounts(failedAccounts);
            Account failed = null;
            for (com.huawei.esdk.ec.device.bmu.bean.Account restAccount : body.getFailedAccounts())
            {
                failed = new Account();
                failedAccounts.add(failed);
                failed.setAccountId(restAccount.getAccountId());
                failed.setFailedReason(restAccount.getFailedReason());
            }
        }
        
        return model;
    }
    
    public RestReqMessage getQueryAccountRequest(String userId, String exactSearch, String condition, int pageCount,
        int pageNum)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        QueryAccountRequest acctRequest = new QueryAccountRequest();
        
        acctRequest.setUserId(userId);
        acctRequest.setCondition(condition);
        acctRequest.setExactSearch(exactSearch);
        acctRequest.setPageCount(pageCount);
        acctRequest.setPageNum(pageNum);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public BatchAccount getQueryAccountRest2Model(QueryAccountResponse body)
    {
        BatchAccount accountModel = new BatchAccount();
        accountModel.setSuccessAmount(body.getAmount());
        List<com.huawei.esdk.ec.device.bmu.bean.Account> accounts = body.getAccounts();
        
        if (null != accounts && !accounts.isEmpty())
        {
            List<Account> models = new ArrayList<Account>();
            accountModel.setAccountIds(models);
            for (com.huawei.esdk.ec.device.bmu.bean.Account account : accounts)
            {
                models.add(getAccountRest2Model(account));
            }
        }
        
        return accountModel;
    }
    
    public RestReqMessage getAcountPasswordRequest(String userId, Account model)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        AddAccountRequest acctRequest = new AddAccountRequest();
        
        acctRequest.setUserId(userId);
        
        com.huawei.esdk.ec.device.bmu.bean.Account rest = new com.huawei.esdk.ec.device.bmu.bean.Account();
        rest.setAccountId(model.getAccountId());
        rest.setLoginName(model.getLoginName());
        rest.setOldPassword(model.getOldPassword());
        rest.setNewPassword(model.getNewPassword());
        
        acctRequest.setAccount(rest);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getBindNumRequest(String userId, Account model)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        AddAccountRequest acctRequest = new AddAccountRequest();
        
        acctRequest.setUserId(userId);
        
        com.huawei.esdk.ec.device.bmu.bean.Account rest = new com.huawei.esdk.ec.device.bmu.bean.Account();
        rest.setAccountId(model.getAccountId());
        rest.setBindNum(model.getBindNum());
        
        acctRequest.setAccount(rest);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getQueryAccountDetailRequest(String userId, String loginName)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        QueryAccountDetailRequest acctRequest = new QueryAccountDetailRequest();
        
        acctRequest.setUserId(userId);
        
        acctRequest.setLoginName(loginName);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public Account getQueryAccountDetailRest2Model(QueryAccountDetailResponse body)
    {
        com.huawei.esdk.ec.device.bmu.bean.Account account = body.getAccount();
        return getAccountRest2Model(account);
    }
    
    private Account getAccountRest2Model(com.huawei.esdk.ec.device.bmu.bean.Account account)
    {
        Account model = new Account();
        model.setAccountType(account.getAccountType());
        model.setAccountId(account.getAccountId());
        model.setLoginName(account.getLoginName());
        model.setName(account.getName());
        model.setSex(account.getSex());
        model.setHomePhone(account.getHomephone());
        model.setCellPhone(account.getCellphone());
        model.setOfficePhone(account.getOfficephone());
        model.setShortPhone(account.getShortphone());
        model.setOtherPhone(account.getOtherphone());
        model.setFax(account.getFax());
        model.setEmail(account.getEmail());
        model.setAddr(account.getAddr());
        model.setTitle(account.getTitle());
        model.setDepartmentId(account.getDepartmentId());
        model.setUserLevel(account.getUserLevel());
        model.setRoleId(account.getRoleId());
        model.setBindNum(account.getBindNum());
        
        //EC3.0 new add
        model.setOtherphone2(account.getOtherphone2());
        model.setZip(account.getZip());
        model.setUserState(account.getUserState());
        model.setNotesMail(account.getNotesMail());
        model.setBirthday(account.getBirthday());
        model.setDes(account.getDes());
        model.setWebsite(account.getWebsite());
        model.setjPinyin(account.getjPinyin());
        model.setqPinyin(account.getqPinyin());
        model.setAccountState(account.getAccountstate());
        model.setModifyTime(account.getModifyTime());
        
        return model;
    }
}
