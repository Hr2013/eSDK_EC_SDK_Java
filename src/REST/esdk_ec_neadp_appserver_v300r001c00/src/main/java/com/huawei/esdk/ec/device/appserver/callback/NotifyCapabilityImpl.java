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
package com.huawei.esdk.ec.device.appserver.callback;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractAppServerCapability;
import com.huawei.esdk.ec.device.appserver.callback.convert.NotifyCapabilityConvert;
import com.huawei.esdk.ec.device.appserver.im.IMCapabilityImpl;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.obg.INotifyCapability;
import com.huawei.esdk.ec.domain.model.AddressListInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class NotifyCapabilityImpl extends AbstractAppServerCapability implements INotifyCapability
{
    private static final Logger LOGGER = Logger.getLogger(IMCapabilityImpl.class);
    
    private NotifyCapabilityConvert notifyCapabilityConvert = new NotifyCapabilityConvert();
    
    public NotifyCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKErrorCode registerNotification(boolean register)
    {
        LOGGER.debug("registerNotification() start");
        SDKResult<AddressListInfo> result = new SDKResult<AddressListInfo>();
        RestReqMessage request = notifyCapabilityConvert.getNotificationMode2Rest(register);
        
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/callbackURL.action", null);
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("registerNotification() error", e);
        }
        
        LOGGER.debug("registerNotification() end");
        return result;
    }
    
}
