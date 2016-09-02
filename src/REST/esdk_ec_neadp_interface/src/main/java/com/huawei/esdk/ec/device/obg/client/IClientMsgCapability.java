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
package com.huawei.esdk.ec.device.obg.client; 

import com.huawei.esdk.ec.domain.model.InstanceMessage;
import com.huawei.esdk.ec.domain.model.bean.GroupInfoBase;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

/** * @author w00208247 * *  */
public interface IClientMsgCapability
{
    
    SDKErrorCode sendMessage(String ucAccount,InstanceMessage instanceMessage);
    
    SDKErrorCode withdrawMessage(InstanceMessage im);
    
    //C03接口新增方法
    SDKResult<PagedList<GroupInfoBase>> getMessage();
    
}
