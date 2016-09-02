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
package com.huawei.esdk.ec.north.rest.bmu.resource.ctc;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.ctc.CTCService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam;
import com.huawei.esdk.ec.north.rest.bean.BatchDeleteMeetingParam;
import com.huawei.esdk.ec.north.rest.bean.RestResponse;
import com.huawei.esdk.ec.north.rest.bmu.resource.ctc.convert.CTCResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/bmu/batch_delete_ctc")
public class BMUCTCBactchDeleteResource
{
    private static final Logger LOGGER = Logger.getLogger(BMUCTCBactchDeleteResource.class);
    
    private static final CTCResourceConvert ctcResourceConvert = new CTCResourceConvert();
    
    private static final CTCService ctcService = new CTCService();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<List<DeleteMeetingParam>> deleteMeeting(BatchDeleteMeetingParam params)
    {
        RestResponse<List<DeleteMeetingParam>> response =
            new RestResponse<List<DeleteMeetingParam>>();
        
        if (StringUtils.isEmpty(params.getUserId()) 
            || null == params.getDeleteItem())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<List<com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam>> result = 
                ctcService.deleteMeeting(params.getUserId(),
                ctcResourceConvert.getDeleteMeetingRest2Modal(params.getDeleteItem()));
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(result.getDescription());
            
            response.setResult(ctcResourceConvert.getDeleteMeetingModal2Rest(result.getResult()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteMeeting method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("deleteMeeting method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
        
    }
}
