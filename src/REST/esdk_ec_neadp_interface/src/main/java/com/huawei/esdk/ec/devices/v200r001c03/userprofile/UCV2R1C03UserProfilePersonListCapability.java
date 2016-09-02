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

import java.util.Date;

import com.huawei.esdk.ec.device.obg.userprofile.UserProfilePersonListCapability;
import com.huawei.esdk.ec.domain.model.PersonalContacts;
import com.huawei.esdk.ec.domain.model.bean.LinkmanInfo;
import com.huawei.esdk.ec.domain.model.bean.PeronalChangeInfo;
import com.huawei.esdk.ec.domain.model.bean.PersonalTeam;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

/** * @author k00207574 * *  */
public interface UCV2R1C03UserProfilePersonListCapability extends UserProfilePersonListCapability
{
    SDKErrorCode modifyTeamIndex(String ucAccount,PersonalTeam personalTeam);
    
    SDKErrorCode addLinkman(String ucAccount, LinkmanInfo linkmanInfo, String teamId);
    
    SDKResult<PersonalContacts> getPersonAllAddressBook(String ucAccount);
    
    SDKResult<PeronalChangeInfo> getPersonIncAddressBook(String ucAccount, Date timeStamp);
    
    SDKResult<LinkmanInfo> getLinkmanInfo(String ucAccount, String linkManId, Integer queryType);
    
    
}
