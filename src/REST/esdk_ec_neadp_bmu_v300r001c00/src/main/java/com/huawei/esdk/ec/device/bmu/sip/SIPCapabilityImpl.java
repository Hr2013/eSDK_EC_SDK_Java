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
package com.huawei.esdk.ec.device.bmu.sip;

import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.bean.BatchDeleteSIPResponse;
import com.huawei.esdk.ec.device.bmu.bean.QueryGatewayResponse;
import com.huawei.esdk.ec.device.bmu.bean.QuerySIPResponse;
import com.huawei.esdk.ec.device.bmu.sip.convert.SIPCapabilityConvert;
import com.huawei.esdk.ec.device.obg.ISIPCapability;
import com.huawei.esdk.ec.domain.model.SIP;
import com.huawei.esdk.ec.domain.model.bean.GatewayList;
import com.huawei.esdk.ec.domain.model.bean.SIPCondition;
import com.huawei.esdk.ec.domain.model.bean.SIPList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class SIPCapabilityImpl extends AbstractBMUCapability implements ISIPCapability
{
    private static final Logger LOGGER = Logger.getLogger(SIPCapabilityImpl.class);
    
    private SIPCapabilityConvert sipCapabilityConvert = new SIPCapabilityConvert();
    
    public SIPCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKErrorCode addSipNum(String userId, SIP sip)
    {
        LOGGER.debug("addSipNum() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = sipCapabilityConvert.getSIPRequest(userId, sip);
        
        try
        {
            XMLResMsg result = sendMessage(request, "addSipNum.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("addSipNum() error", e);
        }
        
        LOGGER.debug("addSipNum() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode addSipNums(String userId, String numStep, String uestep, String amount, SIP sip)
    {
        LOGGER.debug("addSipNums() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = sipCapabilityConvert.getSIPBatchRequest(userId, numStep, uestep, amount, sip);
        
        try
        {
            XMLResMsg result = sendMessage(request, "batchAddSipNum.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("addSipNums() error", e);
        }
        
        LOGGER.debug("addSipNums() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode modifySipNum(String userId, SIP sip)
    {
        LOGGER.debug("modifySipNum() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = sipCapabilityConvert.getSIPRequest(userId, sip);
        
        try
        {
            XMLResMsg result = sendMessage(request, "modifySipNum.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("modifySipNum() error", e);
        }
        
        LOGGER.debug("modifySipNum() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode modifySipPassword(String userId, SIP sip)
    {
        LOGGER.debug("modifySipPassword() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = sipCapabilityConvert.getSIPPasswordRequest(userId, sip);
        
        try
        {
            XMLResMsg result = sendMessage(request, "modifySipPassword.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("modifySipPassword() error", e);
        }
        
        LOGGER.debug("modifySipPassword() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode deleteSip(String userId, SIP sip)
    {
        LOGGER.debug("deleteSip() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = sipCapabilityConvert.getSIPDeleteRequest(userId, sip);
        
        try
        {
            XMLResMsg result = sendMessage(request, "deleteSipNum.action", null);
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("deleteSip() error", e);
        }
        
        LOGGER.debug("deleteSip() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<SIPList> batchDeleteSip(String userId, List<SIP> sips)
    {
        LOGGER.debug("batchDeleteSip() start");
        SDKResult<SIPList> sdkResult = new SDKResult<SIPList>();
        
        RestReqMessage request = sipCapabilityConvert.getSIPBatchDeleteRequest(userId, sips);
        
        try
        {
            XMLResMsg result = sendMessage(request, "batchDeleteSipNum.action", BatchDeleteSIPResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            if (null != result.getBody())
            {
                sdkResult.setResult(sipCapabilityConvert.getBatchDeleteSip((BatchDeleteSIPResponse)result.getBody()));
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("batchDeleteSip() error", e);
        }
        
        LOGGER.debug("batchDeleteSip() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<SIPList> querySip(String userId, SIPCondition sipCon)
    {
        LOGGER.debug("querySip() start");
        SDKResult<SIPList> sdkResult = new SDKResult<SIPList>();
        
        RestReqMessage request = sipCapabilityConvert.getSipRequest(userId, sipCon);
        
        try
        {
            XMLResMsg result = sendMessage(request, "querySipNum.action", QuerySIPResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (0 == sdkResult.getErrCode())
            {
                sdkResult.setResult(sipCapabilityConvert.getQuerySip((QuerySIPResponse)result.getBody()));
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("querySip() error", e);
        }
        
        LOGGER.debug("querySip() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<GatewayList> queryGateway(String userId)
    {
        LOGGER.debug("querySip() start");
        SDKResult<GatewayList> sdkResult = new SDKResult<GatewayList>();
        
        RestReqMessage request = sipCapabilityConvert.getGatewayRequest(userId);
        
        try
        {
            XMLResMsg result = sendMessage(request, "queryGateway.action", QueryGatewayResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (null != result.getBody())
            {
                sdkResult.setResult(sipCapabilityConvert.getGateway((QueryGatewayResponse)result.getBody()));
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("querySip() error", e);
        }
        
        LOGGER.debug("querySip() end");
        return sdkResult;
    }
}
