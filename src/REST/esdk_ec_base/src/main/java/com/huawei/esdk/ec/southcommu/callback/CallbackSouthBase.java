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
package com.huawei.esdk.ec.southcommu.callback;  

import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.callback.CallbackItfInfo;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;

public abstract class CallbackSouthBase
{
    protected NotifyCollector notifyCollector;
    
    protected CallbackMessage buildCallbackMessage(Object payload,
            Object extendedInfo, String itfName, String module)
    {
        String appId = (String) ThreadLocalHolder.get(ESDKConstant.APP_ID);
        String deviceId = (String) ThreadLocalHolder
                .get(ESDKConstant.DEVICE_ID);

        CallbackMessage callbackMsg = new CallbackMessage();
        callbackMsg.setPayload(payload);
        callbackMsg.setExtendedInfo(extendedInfo);

        CallbackItfInfo callbackItfInfo = new CallbackItfInfo();
        callbackItfInfo.setDevId(deviceId);
        callbackItfInfo.setConnectionId(appId);
        callbackItfInfo.setItfName(itfName);
        callbackItfInfo.setModule(module);
        callbackMsg.setCallbackItfInfo(callbackItfInfo);

        return callbackMsg;
    }

    public NotifyCollector getNotifyCollector()
    {
        return notifyCollector;
    }

    public void setNotifyCollector(NotifyCollector notifyCollector)
    {
        this.notifyCollector = notifyCollector;
    }
}
