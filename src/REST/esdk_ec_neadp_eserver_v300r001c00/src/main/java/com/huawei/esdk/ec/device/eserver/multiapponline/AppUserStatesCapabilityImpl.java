/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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
package com.huawei.esdk.ec.device.eserver.multiapponline;

import org.apache.log4j.Logger;

import com.huawei.ecs.client.ClientHandler;
import com.huawei.esdk.ec.device.AbstractEServerCapability;
import com.huawei.esdk.ec.device.eserver.multiapponline.convert.AppUserStatesCapabilityConvert;
import com.huawei.esdk.ec.devices.eserver.multiapponline.IAppUserStatesCapability;
import com.huawei.esdk.ec.domain.model.multiapponline.AppUserStates;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 南向协议无关层
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class AppUserStatesCapabilityImpl extends AbstractEServerCapability implements IAppUserStatesCapability
{
    private static final Logger LOGGER = Logger.getLogger(AppUserStatesCapabilityImpl.class);
    
    AppUserStatesCapabilityConvert appUserStatesCapabilityConvert = new AppUserStatesCapabilityConvert();
    
    public AppUserStatesCapabilityImpl(ClientHandler clientHandler)
    {
        super(clientHandler);
    }
    
    @Override
    public SDKResult<String> getAppUserStates(AppUserStates userStates)
    {
        LOGGER.debug("getAppUserStates start");
        SDKResult<String> result = new SDKResult<String>();
        
        //        //入参转换
        //        EsdkGetAppUserStateList appUserStateList = appUserStatesCapabilityConvert.getAppUserStatesModal2UDP(userStates);
        //        asyncSendMessage(appUserStateList.sno,
        //            appUserStateList.appId,
        //            buildEsdkMsg(null, appUserStateList, PriorityLevel.NORMAL));
        //        
        //        result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //        result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //        result.setResult(String.valueOf(appUserStateList.sno));
        
        LOGGER.debug("getAppUserStates end");
        
        return result;
    }
}
