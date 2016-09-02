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
package com.huawei.esdk.ec.device.bmu.ctc;

import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.ICTCCapability;
import com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingResponse;
import com.huawei.esdk.ec.device.bmu.bean.QueryMeetingResponse;
import com.huawei.esdk.ec.device.bmu.bean.ScheduleMeetingResponse;
import com.huawei.esdk.ec.device.bmu.ctc.convert.CTCCapabilityConvert;
import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryMeetingParam;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class CTCCapabilityImpl extends AbstractBMUCapability implements ICTCCapability
{
    private static final Logger LOGGER = Logger.getLogger(CTCCapabilityImpl.class);
    
    private CTCCapabilityConvert ctcCapabilityConvert = new CTCCapabilityConvert();
    
    public CTCCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKResult<String> scheduleMeeting(Conference confParam)
    {
        LOGGER.debug("scheduleMeeting() start");
        SDKResult<String> sdkResult = new SDKResult<String>();
        
        RestReqMessage request = ctcCapabilityConvert.getScheduleMeetingRequest(confParam);
        
        try
        {
            XMLResMsg result = sendMessage(request, "scheduledMeeting.action", ScheduleMeetingResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            if (null != result.getBody())
            {
                sdkResult.setResult(((ScheduleMeetingResponse)result.getBody()).getConfId());
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("scheduleMeeting() error", e);
        }
        
        LOGGER.debug("scheduleMeeting() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode modifyMeeting(Conference confParam)
    {
        LOGGER.debug("modifyMeeting() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = ctcCapabilityConvert.getModifyMeetingRequest(confParam);
        
        try
        {
            XMLResMsg result = sendMessage(request, "modifyMeeting.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("modifyMeeting() error", e);
        }
        
        LOGGER.debug("modifyMeeting() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<List<DeleteMeetingParam>> deleteMeeting(String userId, List<DeleteMeetingParam> params)
    {
        LOGGER.debug("deleteMeeting() start");
        SDKResult<List<DeleteMeetingParam>> sdkResult = new SDKResult<List<DeleteMeetingParam>>();
        
        RestReqMessage request = ctcCapabilityConvert.getDeleteMeetingRequest(userId, params);
        
        try
        {
            XMLResMsg result = sendMessage(request, "deleteMeeting.action", DeleteMeetingResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            sdkResult.setResult(ctcCapabilityConvert.getDeleteMeetingResponse((DeleteMeetingResponse)result.getBody()));
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("deleteMeeting() error", e);
        }
        
        LOGGER.debug("deleteMeeting() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<PagedList<Conference>> queryMeeting(QueryMeetingParam param)
    {
        LOGGER.debug("queryMeeting() start");
        SDKResult<PagedList<Conference>> sdkResult = new SDKResult<PagedList<Conference>>();
        
        RestReqMessage request = ctcCapabilityConvert.getQueryMeetingRequest(param);
        
        try
        {
            XMLResMsg result = sendMessage(request, "queryMeeting.action", QueryMeetingResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            sdkResult.setResult(ctcCapabilityConvert.getQueryMeetingResponse((QueryMeetingResponse)result.getBody()));
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("queryMeeting() error", e);
        }
        
        LOGGER.debug("queryMeeting() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<PagedList<Conference>> queryJoinMeeting(QueryMeetingParam param)
    {
        LOGGER.debug("queryJoinMeeting() start");
        SDKResult<PagedList<Conference>> sdkResult = new SDKResult<PagedList<Conference>>();
        
        RestReqMessage request = ctcCapabilityConvert.getQueryMeetingRequest(param);
        
        try
        {
            XMLResMsg result = sendMessage(request, "queryJoinMeeting.action", QueryMeetingResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            sdkResult.setResult(ctcCapabilityConvert.getQueryMeetingResponse((QueryMeetingResponse)result.getBody()));
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("queryJoinMeeting() error", e);
        }
        
        LOGGER.debug("queryJoinMeeting() end");
        return sdkResult;
    }
    
}
