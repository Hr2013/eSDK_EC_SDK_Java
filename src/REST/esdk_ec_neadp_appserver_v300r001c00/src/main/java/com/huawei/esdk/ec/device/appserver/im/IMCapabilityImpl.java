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
package com.huawei.esdk.ec.device.appserver.im;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractAppServerCapability;
import com.huawei.esdk.ec.device.appserver.im.convert.IMCapabilityConvert;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.obg.IMCapability;
import com.huawei.esdk.ec.domain.model.Affiche;
import com.huawei.esdk.ec.domain.model.DeptInstanceMessage;
import com.huawei.esdk.ec.domain.model.GroupInstanceMessage;
import com.huawei.esdk.ec.domain.model.UCUserInstanceMessage;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

/**
 * 南向协议无关层 
 * @author  gWX169839
 */
public class IMCapabilityImpl extends AbstractAppServerCapability implements IMCapability
{
    private static final Logger LOGGER = Logger.getLogger(IMCapabilityImpl.class);
    
    IMCapabilityConvert imCapabilityConvert = new IMCapabilityConvert();
    
    public IMCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKErrorCode appSendMsgToUC(UCUserInstanceMessage userInstanceMessage)
    {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public SDKErrorCode appSendMsgToDept(DeptInstanceMessage deptInstanceMessage)
    {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public SDKErrorCode appSendMsgToGroup(GroupInstanceMessage groupInstanceMessage)
    {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public SDKErrorCode sendAffiche(Affiche affiche)
    {
        LOGGER.debug("sendAffiche() start");
        SDKErrorCode result = new SDKErrorCode();
        RestReqMessage request = imCapabilityConvert.getAfficheMode2Rest(affiche);
        
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/sendAffiche.action", null);
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("sendAffiche() error", e);
        }
        
        LOGGER.debug("sendAffiche() end");
        return result;
    }
    
}
