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

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.ctc.CTCService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.north.rest.bean.MeetingBaseInfo;
import com.huawei.esdk.ec.north.rest.bean.RestErrCode;
import com.huawei.esdk.ec.north.rest.bean.RestResponse;
import com.huawei.esdk.ec.north.rest.bmu.resource.ctc.convert.CTCResourceConvert;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.DateUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/bmu/ctc")
public class BMUCTCResource
{
    private static final Logger LOGGER = Logger.getLogger(BMUCTCResource.class);
    
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
    public RestResponse<String> sheduleMeeting(MeetingBaseInfo confInfo)
    {
        RestResponse<String> response = new RestResponse<String>();
        
        if (null == confInfo)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        if (!validDate(confInfo.getStartTime()) || !validDate(confInfo.getEndTime()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result = ctcService.scheduleMeeting(ctcResourceConvert.getMeetingInfoRest2Model(confInfo));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            if(0 == result.getErrCode() && null != result.getResult())
            {
                response.setResult(result.getResult());
            }
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("sheduleMeeting method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("sheduleMeeting method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 修改CTC会议
     * @param confInfo
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode modifyMeeting(MeetingBaseInfo confInfo)
    {
        RestErrCode response = new RestErrCode();
        
        if (null == confInfo)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        if (!validDate(confInfo.getStartTime()) || !validDate(confInfo.getEndTime()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result = ctcService.modifyMeeting(ctcResourceConvert.getMeetingInfoRest2Model(confInfo));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("modifyMeeting method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("modifyMeeting method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }

    private boolean validDate(String dateTime)
    {
        if (StringUtils.isEmpty(dateTime))
        {
            return false;
        }
        
        if (null == DateUtils.stringToDate(dateTime, "yyyy-MM-dd HH:mm:ss"))
        {
            return false;
        }
        
        return true;
    }
}
