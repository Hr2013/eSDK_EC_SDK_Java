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
package com.huawei.esdk.ec.device.eserver.multiapponline;

import org.apache.log4j.Logger;

import com.huawei.ecs.client.ClientHandler;
import com.huawei.esdk.ec.device.AbstractEServerCapability;
import com.huawei.esdk.ec.device.eserver.multiapponline.convert.AppInfoCapabilityConvert;
import com.huawei.esdk.ec.devices.eserver.multiapponline.IAppInfoCapability;
import com.huawei.esdk.ec.domain.model.multiapponline.AppInfo;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 南向协议无关层
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class AppInfoCapabilityImpl extends AbstractEServerCapability implements IAppInfoCapability
{
    private static final Logger LOGGER = Logger.getLogger(AppInfoCapabilityImpl.class);
    
    AppInfoCapabilityConvert appInfoCapabilityConvert = new AppInfoCapabilityConvert();
    
    public AppInfoCapabilityImpl(ClientHandler clientHandler)
    {
        super(clientHandler);
    }
    
    @Override
    public SDKResult<AppInfo> getAppInfo(String appName, String applyTime)
    {
        LOGGER.debug("getAppInfo start");
        SDKResult<AppInfo> result = new SDKResult<AppInfo>();
        
        //        //入参转换
        //        GetAppInfo appInfo = appInfoCapabilityConvert.getAppInfoModal2UDP(appName, applyTime);
        //        SDKResult<IMInfo> response =
        //            syncSendMessage(String.valueOf(appInfo.sno), buildEsdkMsg(null, appInfo, PriorityLevel.NORMAL));
        //        
        //        if (null == response.getResult() || null == response.getResult().getAppInfoAck())
        //        {
        //            result.setErrCode(ErrInfo.EServerErrInfo.IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORCODE);
        //            result.setDescription(ErrInfo.EServerErrInfo.IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORDESC);
        //        }
        //        else
        //        {
        //            result.setErrCode(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORCODE);
        //            result.setDescription(ErrInfo.EServerErrInfo.OPERATE_SUCCESS_ERRORDESC);
        //            result.setResult(appInfoCapabilityConvert.getAppInfoUDP2Rest(response.getResult().getAppInfoAck()));
        //        }
        
        LOGGER.debug("getAppInfo end");
        return result;
    }
    
}
