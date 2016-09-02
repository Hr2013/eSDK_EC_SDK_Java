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
package com.huawei.esdk.uc.professional.local.serviceImpl;

import org.apache.log4j.Logger;

import com.huawei.esdk.uc.professional.local.bean.NumberInfo;
import com.huawei.esdk.uc.professional.local.bean.RestResponse;
import com.huawei.esdk.uc.professional.local.bean.south.AddAccountRequest;
import com.huawei.esdk.uc.professional.local.bean.south.AddDepartmentResponse;
import com.huawei.esdk.uc.professional.local.bean.south.AddDepartmentResult;
import com.huawei.esdk.uc.professional.local.bean.south.DepartmentRequest;
import com.huawei.esdk.uc.professional.local.bean.south.PersonInfo;
import com.huawei.esdk.uc.professional.local.bean.south.QueryDepartmentInfoList;
import com.huawei.esdk.uc.professional.local.bean.south.QueryDepartmentResponse;
import com.huawei.esdk.uc.professional.local.bean.south.QueryPersonInfoResponse;
import com.huawei.esdk.uc.professional.local.bean.south.ResHeaderBean;
import com.huawei.esdk.uc.professional.local.bean.south.SipAccount;
import com.huawei.esdk.uc.professional.local.bean.south.SipList;
import com.huawei.esdk.uc.professional.local.bean.south.SipQueryRequest;
import com.huawei.esdk.uc.professional.local.bean.south.SipQueryResponse;
import com.huawei.esdk.uc.professional.local.bean.south.SipRequest;
import com.huawei.esdk.uc.professional.local.constant.ResultCode;
import com.huawei.esdk.uc.professional.local.resource.AccountResource;
import com.huawei.esdk.uc.professional.local.resource.BindNumResource;
import com.huawei.esdk.uc.professional.local.resource.DepartmentResource;
import com.huawei.esdk.uc.professional.local.resource.SIPAccountResource;
import com.huawei.esdk.uc.professional.local.resource.UserProfileCorpList;
import com.huawei.esdk.uc.professional.local.service.UserProfileServiceEx;
import com.huawei.esdk.uc.professional.local.utils.Encrypt;
import com.huawei.esdk.uc.professional.local.utils.KeyManagerUtils;
import com.huawei.esdk.uc.professional.local.utils.StringUtils;

public class UserProfileServiceExImpl implements UserProfileServiceEx
{
    private UserProfileCorpList userProfileCorpList = new UserProfileCorpList();
    
    private DepartmentResource departmentResource = new DepartmentResource();
    
    private AccountResource accountResource = new AccountResource();
    
    private BindNumResource bindNumResource = new BindNumResource();
    
    private SIPAccountResource sipAccountResource = new SIPAccountResource();
    
    private static final Logger LOGGER = Logger.getLogger(UserProfileServiceExImpl.class);
    
    private static UserProfileServiceExImpl instance = null;
    
    public static synchronized UserProfileServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new UserProfileServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public RestResponse<QueryDepartmentInfoList> queryDeptListInfo(String userId, String parentId, String pageCount,
        String pageNum)
    {
        RestResponse<QueryDepartmentInfoList> result = new RestResponse<QueryDepartmentInfoList>();
        
        QueryDepartmentResponse response = departmentResource.queryDepartment(userId, parentId, pageCount, pageNum);
        
        result.setResult(response.getQueryDepartmentInfoList());
        result.setResultCode(response.getResultCode());
        result.setResultContext(response.getResultContext());
        return result;
    }
    
    @Override
    public RestResponse<PersonInfo> queryStaffInfo(String ucAccount)
    {
        RestResponse<PersonInfo> result = new RestResponse<PersonInfo>();
        
        QueryPersonInfoResponse response = userProfileCorpList.queryPersonInfo(ucAccount);
        
        result.setResult(response.getPersonInfo());
        result.setResultCode(response.getResultCode());
        result.setResultContext(response.getResultContext());
        return result;
    }
    
    @Override
    public RestResponse<AddDepartmentResult> addDept(DepartmentRequest departmentInfo)
    {
        RestResponse<AddDepartmentResult> result = new RestResponse<AddDepartmentResult>();
        AddDepartmentResponse response = departmentResource.addDepartment(departmentInfo);
        result.setResultCode(response.getResultCode());
        result.setResultContext(response.getResultContext());
        if ("0".equals(response.getResultCode()))
        {
            result.setResult(new AddDepartmentResult());
            result.getResult().setDepartmentId(response.getDepartmentId());
            result.getResult().setDepartmentNo(response.getDepartmentNo());
        }
        return result;
    }
    
    @Override
    public Integer modifyDept(DepartmentRequest departmentInfo)
    {
        return Integer.parseInt(departmentResource.modifyDepartment(departmentInfo).getResultCode());
    }
    
    @Override
    public Integer delDept(String userId, String departmentId)
    {
        return Integer.parseInt(departmentResource.deleteDepartment(userId, departmentId).getResultCode());
    }
    
    @Override
    public RestResponse<String> addAccount(AddAccountRequest accountInfo)
    {
        int resp = KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
            RestResponse<String> res = new RestResponse<String>();
            res.setResult(String.valueOf(resp));
            return res;
        }
        
        try
        {
            accountInfo.getAccount().setOldPassword(Encrypt.getEncryptPwd(accountInfo.getAccount().getOldPassword()));
            accountInfo.getAccount().setNewPassword(Encrypt.getEncryptPwd(accountInfo.getAccount().getNewPassword()));
            accountInfo.getAccount().setPassword(Encrypt.getEncryptPwd(accountInfo.getAccount().getPassword()));
        }
        catch (Exception e)
        {
            LOGGER.error("Encrypt Error:" + e);
            RestResponse<String> res = new RestResponse<String>();
            res.setResult(String.valueOf(ResultCode.SDK_TP_PASSWORD_ENCODE_ERRORCODE));
            return res;
        }
        
        RestResponse<String> response = accountResource.addAccount(accountInfo);
        return response;
    }
    
    @Override
    public Integer addNumber(SipRequest numberInfo)
    {
        int resp = KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
            return resp;
        }
        
        try
        {
            if (null != numberInfo.getSip() && null != numberInfo.getSip().getSipAuth())
            {
                numberInfo.getSip()
                    .getSipAuth()
                    .setPassword(Encrypt.getEncryptPwd(numberInfo.getSip().getSipAuth().getPassword()));
            }
        }
        catch (Exception e)
        {
            LOGGER.error("Encrypt Error:" + e);
            return ResultCode.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
        }
        
        return Integer.parseInt(sipAccountResource.addSIP(numberInfo).getResultCode());
    }
    
    @Override
    public Integer modifyNumber(SipRequest numberInfo)
    {
        int resp = KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
            return resp;
        }
        
        try
        {
            if (null != numberInfo.getSip() && null != numberInfo.getSip().getSipAuth())
            {
                numberInfo.getSip()
                    .getSipAuth()
                    .setPassword(Encrypt.getEncryptPwd(numberInfo.getSip().getSipAuth().getPassword()));
            }
        }
        catch (Exception e)
        {
            LOGGER.error("Encrypt Error:" + e);
            return ResultCode.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
        }
        return Integer.parseInt(sipAccountResource.modifySIP(numberInfo).getResultCode());
    }
    
    @Override
    public Integer delNumber(SipRequest numberInfo)
    {
        return Integer.parseInt(sipAccountResource.deleteSip(numberInfo).getResultCode());
    }
    
    @Override
    public RestResponse<SipList> queryNumber(SipQueryRequest req)
    { 
        RestResponse<SipList> result = new RestResponse<SipList>();
        int resp = KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
            result.setResultCode(String.valueOf(resp));
            return result;
        }
        
        SipQueryResponse response = sipAccountResource.querySip(req);
        result.setResultCode(response.getResultCode());
        if(null != response.getSipList() && 
            null != response.getSipList().getSips())
        {
            try
            {
                for(SipAccount sip : response.getSipList().getSips())
                {
                    if(null != sip.getSipAuth())
                    {
                        sip.getSipAuth().setPassword(Encrypt
                            .getDecryptPwd(sip.getSipAuth().getPassword()));
                    }
                }
            }
            catch (Exception e)
            {
                LOGGER.error("Encrypt Error:" + e);
                result.setResultCode(String.valueOf(ResultCode.
                    SDK_TP_PASSWORD_ENCODE_ERRORCODE));
                return result;
            }
        }
        result.setResult(response.getSipList());
        result.setResultContext(response.getResultContext());
        return result;
    }
    
    @Override
    public Integer numberBind(AddAccountRequest acct)
    {
        return Integer.parseInt(bindNumResource.bindNum(acct).getResultCode());
    }
    
    /**
     * 入参检查
     * @param numberInfo
     * @return 错误码，如果没错误则返回0表示成功
     */
    protected int checkNumberInfo(NumberInfo numberInfo)
    {
        if (null == numberInfo.getCorpInterNumber() || null == numberInfo.getTerminalType())
        {
            return ResultCode.North.SDK_PARAM_NOT_COMPLETE_ERRORCODE;
        }
        if (!StringUtils.isNumber(numberInfo.getCorpInterNumber()))
        {
            return ResultCode.North.SDK_DATA_INCORRECT_ERRORCODE;
        }
        
        if (null != numberInfo.getPublicNumber() && !StringUtils.isNumber(numberInfo.getPublicNumber()))
        {
            return ResultCode.North.SDK_DATA_INCORRECT_ERRORCODE;
        }
        if (numberInfo.getTerminalType() == 0 || numberInfo.getTerminalType() == 1)
        {
            return ResultCode.North.RESULT_SUCCESS;
        }
        else
        {
            return ResultCode.North.SDK_DATA_INCORRECT_ERRORCODE;
        }
    }
    
    /** {@inheritDoc} */
    
    @Override
    public Integer modifyAcountPassword(AddAccountRequest acct)
    {
        int resp = KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
            return resp;
        }
        
        try
        {
            acct.getAccount().setOldPassword(Encrypt.getEncryptPwd(acct.getAccount().getOldPassword()));
            acct.getAccount().setNewPassword(Encrypt.getEncryptPwd(acct.getAccount().getNewPassword()));
            acct.getAccount().setPassword(Encrypt.getEncryptPwd(acct.getAccount().getPassword()));
        }
        catch (Exception e)
        {
            LOGGER.error("Encrypt Error:" + e);
            return ResultCode.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
        }
        
        ResHeaderBean response = accountResource.modifyAcountPassword(acct);
        return Integer.parseInt(response.getResultCode());
    }
}
