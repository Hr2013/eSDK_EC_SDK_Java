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
package com.huawei.esdk.ec.device.bmu.userlevel;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.IUserLevelCapability;
import com.huawei.esdk.ec.device.bmu.bean.QueryUserLevelResponse;
import com.huawei.esdk.ec.device.bmu.userlevel.convert.UserLevelCapabilityConvert;
import com.huawei.esdk.ec.domain.model.UserLevel;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class UserLevelCapabilityImpl extends AbstractBMUCapability implements IUserLevelCapability
{
    private static final Logger LOGGER = Logger.getLogger(UserLevelCapabilityImpl.class);
    
    private UserLevelCapabilityConvert userLevelCapabilityConvert = new UserLevelCapabilityConvert();
    
    public UserLevelCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }

    @Override
    public SDKResult<UserLevel> queryUserLevel(String userId, String pageCount, String pageNum)
    {
        LOGGER.debug("queryUserLevel() start");
        SDKResult<UserLevel> sdkResult = new SDKResult<UserLevel>();
        
        RestReqMessage request = userLevelCapabilityConvert.getQueryUserLevelRequest(userId, pageCount, pageNum);
        
        try
        {
            XMLResMsg result = sendMessage(request, "queryUserLevel.action", QueryUserLevelResponse.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (0 == sdkResult.getErrCode())
            {
                sdkResult.setResult(userLevelCapabilityConvert.getQueryUserLevelResponse((QueryUserLevelResponse)result.getBody()));
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("queryUserLevel() error", e);
        }
        
        LOGGER.debug("queryUserLevel() end");
        
        return sdkResult;
    }
  
}
