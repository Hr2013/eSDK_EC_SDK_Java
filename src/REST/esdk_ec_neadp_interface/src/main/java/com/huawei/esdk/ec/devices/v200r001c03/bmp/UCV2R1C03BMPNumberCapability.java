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
package com.huawei.esdk.ec.devices.v200r001c03.bmp;

import com.huawei.esdk.ec.domain.model.UCNumber;
import com.huawei.esdk.ec.domain.model.bean.BindInfo;
import com.huawei.esdk.platform.common.SDKResult;

public interface UCV2R1C03BMPNumberCapability
{
    SDKResult<String> addNumber(UCNumber ucNumber);
    
    SDKResult<String> delNumber(UCNumber ucNumber);
    
    SDKResult<String> numberBind(BindInfo bindInfo);
    
    SDKResult<String> modifyNumber(UCNumber ucNumber);

    SDKResult<UCNumber> queryNumber(UCNumber ucNumber);
}
