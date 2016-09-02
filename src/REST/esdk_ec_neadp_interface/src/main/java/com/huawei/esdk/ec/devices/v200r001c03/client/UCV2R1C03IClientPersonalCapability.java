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

import java.util.List;

import com.huawei.esdk.ec.device.obg.client.IClientPersonalCapability;
import com.huawei.esdk.ec.domain.model.bean.PresPublishInfo;
import com.huawei.esdk.ec.domain.model.bean.PublishPresStatus;
import com.huawei.esdk.ec.domain.model.bean.UserMobile;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public interface UCV2R1C03IClientPersonalCapability extends IClientPersonalCapability
{
    SDKResult<PublishPresStatus> pubPresInfo(String ucAccount,PresPublishInfo presPublish, long expires);
    SDKResult<PublishPresStatus> refreshPresInfo(String ucAccount, PresPublishInfo presPublish,
        PublishPresStatus pubPresStatus);
    
    SDKResult<Long> subPGM(String ucAccount, String subFlag, String groupUrl, String creator, long expires);
    
    SDKErrorCode uploadheadid (String ucAccount, String headId);
    
    SDKResult<List<UserMobile>> uploadMobileAddress(String ucAccount,List<String> mobileList) throws SDKException;
      
    SDKErrorCode setSignature(String ucAccount, String usrInfo);
    
    SDKResult<Long> refreshSubPGM(String ucAccount, String subFlag, String groupUrl, String creator, long expires);
}
