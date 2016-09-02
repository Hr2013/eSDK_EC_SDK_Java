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
package com.huawei.esdk.ec.devices.v200r001c03.ctc;

import java.util.Date;
import java.util.List;

import com.huawei.esdk.ec.device.obg.ICTCCapability;
import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

public interface UCV2R1C03CTCCapability extends ICTCCapability
{
    SDKResult<String> createConf(Conference confParam);
    
    SDKErrorCode joinConf(String confId,String ucAccount, String siteNo,String siteName,String role);
    
    SDKErrorCode viewTerminalSite(String confId, String ucAccount, 
        String videoSourceUri, String isLock);
    
    SDKErrorCode subConfStatus(String appID, String confID);
    
    SDKResult<List<Conference>> getConfList(String initiator, String qryType, Date beginTime, Date endTime,
        PagedList<Object> pageList, String confType2);
}
