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
package com.huawei.esdk.ec.device.bmu.conf;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.bean.QueryConfPrefixResponse;
import com.huawei.esdk.ec.device.bmu.bean.QueryGlobalSRTPResponse;
import com.huawei.esdk.ec.device.bmu.conf.convert.ConfCapabilityConvert;
import com.huawei.esdk.ec.device.obg.IConfCapability;
import com.huawei.esdk.ec.domain.model.bean.ConfPrefixList;
import com.huawei.esdk.ec.domain.model.bean.GlobalSRTPList;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class ConfCapabilityImpl extends AbstractBMUCapability implements IConfCapability
{
    private static final Logger LOGGER = Logger.getLogger(ConfCapabilityImpl.class);
    
    private ConfCapabilityConvert confCapabilityConvert = new ConfCapabilityConvert();
    
    public ConfCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKResult<GlobalSRTPList> queryGlobalSRTP(String userId, String gwip, String pageNum, String pageCount)
    {
        LOGGER.debug("queryGlobalSRTP() start");
        SDKResult<GlobalSRTPList> sdkResult = new SDKResult<GlobalSRTPList>();
        
        RestReqMessage request = confCapabilityConvert.getGlobalSRTPRequest(userId, gwip, pageNum, pageCount);
        
        try
        {
            XMLResMsg result = sendMessage(request, "queryGlobalSRTP.action", QueryGlobalSRTPResponse.class.getName());
            
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (null != result.getBody())
            {
                sdkResult.setResult(confCapabilityConvert.getGlobalSRTPRest2Model((QueryGlobalSRTPResponse)result.getBody()));
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("queryGlobalSRTP() error", e);
        }
        
        LOGGER.debug("queryGlobalSRTP() end");
        return sdkResult;
    }
    
    @Override
    public SDKResult<ConfPrefixList> queryConfPrefix(String userId, String gwip)
    {
        LOGGER.debug("queryConfPrefix() start");
        SDKResult<ConfPrefixList> sdkResult = new SDKResult<ConfPrefixList>();
        
        RestReqMessage request = confCapabilityConvert.getConfPrefixRequest(userId, gwip);
        
        try
        {
            XMLResMsg result = sendMessage(request, "queryConfPrefix.action", QueryConfPrefixResponse.class.getName());
            
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (null != result.getBody())
            {
                sdkResult.setResult(confCapabilityConvert.getConfPrefixRest2Model((QueryConfPrefixResponse)result.getBody()));
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("queryConfPrefix() error", e);
        }
        
        LOGGER.debug("queryConfPrefix() end");
        return sdkResult;
    }
    
}
