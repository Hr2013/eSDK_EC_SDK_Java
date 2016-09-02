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
package com.huawei.esdk.ec.device.bmu.role;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.IRoleCapability;
import com.huawei.esdk.ec.device.bmu.bean.QueryRoleResponse;
import com.huawei.esdk.ec.device.bmu.role.convert.RoleCapabilityConvert;
import com.huawei.esdk.ec.domain.model.Role;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class RoleCapabilityImpl extends AbstractBMUCapability implements IRoleCapability
{
    private static final Logger LOGGER = Logger.getLogger(RoleCapabilityImpl.class);
    
    private RoleCapabilityConvert roleCapabilityConvert = new RoleCapabilityConvert();
    
    public RoleCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKResult<Role> queryRole(String userId, String pageCount, String pageNum, String lang)
    {
        LOGGER.debug("queryRole() start");
        SDKResult<Role> sdkResult = new SDKResult<Role>();
        
        RestReqMessage request = roleCapabilityConvert.getQueryRoleRequest(userId, pageCount, pageNum, lang);
        
        try
        {
            XMLResMsg result = sendMessage(request, "queryRole.action", QueryRoleResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (0 == sdkResult.getErrCode())
            {
                sdkResult.setResult(roleCapabilityConvert.getQueryRoleResponse((QueryRoleResponse)result.getBody()));
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("queryRole() error", e);
        }
        
        LOGGER.debug("queryRole() end");
        
        return sdkResult;
    }
}
