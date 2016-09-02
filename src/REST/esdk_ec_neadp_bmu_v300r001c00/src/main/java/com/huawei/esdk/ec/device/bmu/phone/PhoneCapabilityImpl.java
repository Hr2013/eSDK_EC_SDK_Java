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
package com.huawei.esdk.ec.device.bmu.phone;

import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.IPhoneCapability;
import com.huawei.esdk.ec.device.bmu.bean.QueryPhoneState;
import com.huawei.esdk.ec.device.bmu.bean.QueryPhoneStateResponse;
import com.huawei.esdk.ec.device.bmu.phone.convert.PhoneCapabilityConvert;
import com.huawei.esdk.ec.domain.model.bean.PhoneInfo;
import com.huawei.esdk.ec.domain.model.bean.PhoneStateList;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class PhoneCapabilityImpl extends AbstractBMUCapability implements IPhoneCapability
{
    private static final Logger LOGGER = Logger.getLogger(PhoneCapabilityImpl.class);
    
    private static final PhoneCapabilityConvert PHONE_CAPABILITY_CONVERT = new PhoneCapabilityConvert();
    
    public PhoneCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKResult<PhoneStateList> queryPhoneState(String userId, List<PhoneInfo> phoneInfoList)
    {
        LOGGER.debug("query phone state begin");
        
        SDKResult<PhoneStateList> result = new SDKResult<PhoneStateList>();
        
        // 拼装报文
        RestReqMessage reqMessage = PHONE_CAPABILITY_CONVERT.getQueryPhoneState(userId, phoneInfoList);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg =
                sendMessage(reqMessage, "queryPhoneState.action", QueryPhoneStateResponse.class.getName());
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
            
            // 结果转换
            if (null != xmlResMsg.getBody())
            {
                List<QueryPhoneState> phoneStateList = ((QueryPhoneStateResponse)xmlResMsg.getBody()).getPhoneStateList();
                result.setResult(PHONE_CAPABILITY_CONVERT.queryPhoneStateRest2Model(phoneStateList));
            }
            
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("query phone state error", e);
        }
        
        LOGGER.debug("query phone state end");
        
        return result;
    }
    
}
