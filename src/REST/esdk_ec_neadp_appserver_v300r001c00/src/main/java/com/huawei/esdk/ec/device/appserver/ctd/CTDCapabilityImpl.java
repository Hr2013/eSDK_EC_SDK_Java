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
package com.huawei.esdk.ec.device.appserver.ctd;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractAppServerCapability;
import com.huawei.esdk.ec.device.appserver.bean.CtdCallReqBean;
import com.huawei.esdk.ec.device.appserver.bean.CtdCallResBean;
import com.huawei.esdk.ec.device.bean.XMLReqHeader;
import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.obg.ICTDCapability;
import com.huawei.esdk.ec.domain.model.Call;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class CTDCapabilityImpl extends AbstractAppServerCapability implements ICTDCapability
{
    private static final Logger LOGGER = Logger.getLogger(CTDCapabilityImpl.class);
    
    public CTDCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKResult<String> dialCall(Call call)
    {
        SDKResult<String> sdkResult = new SDKResult<String>();
        
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        request.setPayload(buildCTDPayload(call));
        
        try
        {
            XMLResMsg result =
                sendMessage(request, "openInterface/ctdCall.action", CtdCallResBean.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            //TODO call id?
            if (0 == sdkResult.getErrCode())
            {
                CtdCallResBean resBean = (CtdCallResBean)result.getBody();
                if(null != resBean)
                {
                    sdkResult.setResult(resBean.getCallId());
                }
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("", e);
        }
        
        return sdkResult;
    }
    
    private XMLReqMsg buildCTDPayload(Call call)
    {        
        XMLReqMsg payload = new XMLReqMsg();
        //构建报文体
        CtdCallReqBean reqBean = new CtdCallReqBean();
        reqBean.setCaller(call.getCalling());
        reqBean.setCallee(call.getCallee());
        
        payload.setBody(reqBean);
        
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(call.getInitiator());
        payload.setHead(head);
        
        return payload;
    }

    @Override
    public SDKErrorCode releaseCall(String ctdId)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public SDKResult<Call> getStatus(String callId)
    {
        throw new UnsupportedOperationException();
    }
}
