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
package com.huawei.esdk.ec.north.rest.app.resource.ctc;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.ctc.CTCService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.north.rest.app.resource.ctc.convert.CTCResourceConvert;
import com.huawei.esdk.ec.north.rest.bean.ConferenceInfo;
import com.huawei.esdk.ec.north.rest.bean.CreateConfResponse;
import com.huawei.esdk.ec.north.rest.bean.EndConfResponse;
import com.huawei.esdk.ec.north.rest.bean.QueryConfResponse;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/appserver/ctc")
public class CTCResource
{
    private static final Logger LOGGER = Logger.getLogger(CTCResource.class);
    
    private static final CTCResourceConvert ctcResourceConvert = new CTCResourceConvert();
    
    private static final CTCService ctcService = new CTCService();
    
    /**
     * 发起CTC会议
     * @param confInfo
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CreateConfResponse createConf(ConferenceInfo confInfo)
    {
        CreateConfResponse response = new CreateConfResponse();
        
        if (null == confInfo || StringUtils.isEmpty(confInfo.getAccount()) || null == confInfo.getInvitees()
            || confInfo.getInvitees().isEmpty() || StringUtils.isEmpty(confInfo.getTopic()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result = ctcService.createConf(ctcResourceConvert.getConferenceRest2Model(confInfo));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            response.setConfId(StringUtils.avoidNull(result.getResult()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("createConf method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("createConf method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 查询CTC会议列表
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryConfResponse queryConf(@QueryParam("account") String account)
    {
        QueryConfResponse response = new QueryConfResponse();
        
        if (StringUtils.isEmpty(account))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        try
        {
            SDKResult<List<Conference>> result = ctcService.queryConf(account);
            response = ctcResourceConvert.getQueryConfResponseModel2Rest(result);
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryConf method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryConf method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 终止CTC会议
     * @param confId
     * @return
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public EndConfResponse endConf(@QueryParam("confId") String confId)
    {
        EndConfResponse response = new EndConfResponse();
        
        if (StringUtils.isEmpty(confId))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result = ctcService.endConf("", confId);
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(result.getDescription());
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("endConf method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("endConf method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
