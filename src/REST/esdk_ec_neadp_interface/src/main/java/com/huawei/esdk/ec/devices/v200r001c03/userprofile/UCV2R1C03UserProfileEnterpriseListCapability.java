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
package com.huawei.esdk.ec.devices.v200r001c03.userprofile;

import com.huawei.esdk.ec.device.obg.userprofile.UserProfileEnterpriseListCapability;
import com.huawei.esdk.ec.domain.model.bean.OffsetQryStaffCond;
import com.huawei.esdk.ec.domain.model.bean.PageQryStaffCond;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryModeInfo;
import com.huawei.esdk.ec.domain.model.bean.StaffInfo;
import com.huawei.esdk.ec.domain.model.bean.StaffInfoBase;
import com.huawei.esdk.platform.common.SDKResult;

/** * @author w00208247 * *  */
public interface UCV2R1C03UserProfileEnterpriseListCapability extends UserProfileEnterpriseListCapability
{
    SDKResult<PagedList<StaffInfoBase>> queryStaffList(String ucAccount,
            QueryModeInfo tListInfo, OffsetQryStaffCond tOffsetQryStaffCond,
            PageQryStaffCond tPageQryStaffCond);
    
    SDKResult<StaffInfo> queryStaffInfo(String ucNum);
    
}
