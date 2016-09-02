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
package com.huawei.esdk.ec.north.rest.bmu.resource.account;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.account.AccountService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.bean.BatchAccount;
import com.huawei.esdk.ec.north.rest.app.resource.ctc.CTCResource;
import com.huawei.esdk.ec.north.rest.bean.AddAccountRequest;
import com.huawei.esdk.ec.north.rest.bean.GetAccountResponse;
import com.huawei.esdk.ec.north.rest.bean.RestErrCode;
import com.huawei.esdk.ec.north.rest.bean.RestResponse;
import com.huawei.esdk.ec.north.rest.bmu.resource.account.convert.AccountResourceConvert;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/bmu/account")
public class AccountResource
{
    
    private static final Logger LOGGER = Logger.getLogger(CTCResource.class);
    
    private static final AccountResourceConvert accountResourceConvert = new AccountResourceConvert();
    
    private static final AccountService accountService = new AccountService();
    
    /**
     * 添加账号
     * @param acct
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<String> addAccount(AddAccountRequest acct)
    {
        
        RestResponse<String> response = new RestResponse<String>();
        
        if (null == acct || StringUtils.isEmpty(acct.getUserId()) || null == acct.getAccount())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result =
                accountService.addAccount(acct.getUserId(),
                    accountResourceConvert.getAccountRest2Model(acct.getAccount()));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            response.setResult(StringUtils.avoidNull(result.getResult()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("addAccount method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("addAccount method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 修改账号
     * @param acct
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode modifyAccount(AddAccountRequest acct)
    {
        
        RestErrCode response = new RestErrCode();
        
        if (null == acct || StringUtils.isEmpty(acct.getUserId()) || null == acct.getAccount())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result =
                accountService.modifyAccount(acct.getUserId(),
                    accountResourceConvert.getAccountRest2Model(acct.getAccount()));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("modifyAccount method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("modifyAccount method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 删除账号
     * @param userId
     * @param accountId
     * @return
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode deleteAccount(@QueryParam("userId") String userId, @QueryParam("accountId") String accountId)
    {
        
        RestErrCode response = new RestErrCode();
        
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(accountId))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result = accountService.deleteAccount(userId, accountId);
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteAccount method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("deleteAccount method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 查询账号
     * @param userId
     * @param exactSearch
     * @param condition
     * @param pageCount
     * @param pageNum
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<GetAccountResponse> getAccount(@QueryParam("userId") String userId,
        @QueryParam("exactSearch") String exactSearch, @QueryParam("condition") String condition,
        @QueryParam("pageCount") String pageCount, @QueryParam("pageNum") String pageNum)
    {
        RestResponse<GetAccountResponse> response = new RestResponse<GetAccountResponse>();
        
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(exactSearch) || StringUtils.isEmpty(condition)
            || StringUtils.isEmpty(pageCount) || StringUtils.isEmpty(pageNum))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            int pageCountTemp = Integer.parseInt(pageCount);
            int pageNumTemp = Integer.parseInt(pageNum);
            
            SDKResult<BatchAccount> result =
                accountService.getAccount(userId, exactSearch, condition, pageCountTemp, pageNumTemp);
            
            response = accountResourceConvert.getAccountModel2Rest(result);
            
            return response;
        }
        catch (NumberFormatException e)
        {
            // 参数错误
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("getAccount method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("getAccount method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
