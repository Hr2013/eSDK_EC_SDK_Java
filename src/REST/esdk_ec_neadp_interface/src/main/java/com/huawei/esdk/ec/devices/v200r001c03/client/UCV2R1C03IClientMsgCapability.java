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
package com.huawei.esdk.ec.devices.v200r001c03.client;

import com.huawei.esdk.ec.device.obg.client.IClientMsgCapability;
import com.huawei.esdk.ec.domain.model.InstanceMessage;
import com.huawei.esdk.ec.domain.model.bean.MessageInfo;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryMsgCondition;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

public interface UCV2R1C03IClientMsgCapability extends IClientMsgCapability
{
    SDKErrorCode markMsgReadFlag(String ucAccount, QueryMsgCondition msgCondition, String msgID);
    
    SDKResult<PagedList<MessageInfo>> getMessage(String sender, String messageType, String timeStamp,
        PagedList<Integer> pageList);
    
    SDKResult<PagedList<MessageInfo>> getMsgLog(String sender, QueryMsgCondition msgCondition,
        PagedList<Integer> pageList);
    
    SDKErrorCode withdrawMessage(InstanceMessage im);
    
    SDKErrorCode sendMessage(String ucAccount, InstanceMessage instanceMessage);
}
