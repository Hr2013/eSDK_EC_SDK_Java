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

import com.huawei.esdk.ec.domain.model.Department;
import com.huawei.esdk.ec.domain.model.bean.UCAccountInfo;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * <一句话功能简述>
 * <p>
 * <功能详细描述>
 * <p>
 * @author gWX169839
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface UCV2R1C03BMPAccountCapability
{
    SDKResult<String> addDept(Department dept);

    SDKResult<String> modDept(Department dept);

    SDKResult<String> delDept(Department dept);

    SDKResult<String> updateDept(Department dept);

    SDKResult<String> updateAccount(UCAccountInfo ucAccountInfo);

    SDKResult<String> delAccount(UCAccountInfo ucAccountInfo);

    SDKResult<String> addAccount(UCAccountInfo ucAccountInfo);

    SDKResult<String> modAccount(UCAccountInfo ucAccountInfo);
}
