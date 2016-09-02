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
package com.huawei.esdk.ec.device.obg.userprofile;

import java.util.Date;
import java.util.List;

import com.huawei.esdk.ec.domain.model.PersonalContacts;
import com.huawei.esdk.ec.domain.model.bean.LinkmanInfo;
import com.huawei.esdk.ec.domain.model.bean.PeronalChangeInfo;
import com.huawei.esdk.ec.domain.model.bean.PersonalTeam;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

/** * @author w00208247 
 * 个人通讯录接口
 * * * */
public interface UserProfilePersonListCapability
{
    SDKResult<List<PersonalTeam>> getPersonTeamInfo(String ucAccount);

    SDKResult<String> addClientTeam(String ucAccount, String name);

    SDKErrorCode delClientTeam(String ucAccount, String teamId);

    SDKErrorCode addLinkman(String ucAccount, LinkmanInfo linkmanInfo,
            String teamId);

    SDKErrorCode delLinkman(String ucAccount, String teamId, String linkmanId);


    SDKErrorCode addMemberToTeam(String ucAccount, String teamId,
            String linkmanId);
    
    SDKErrorCode modClientTeam(String ucAccount, String name, String teamId);

    SDKErrorCode delMemFromTeam(String ucAccount, String linkManId,
            String teamId);

    SDKResult<LinkmanInfo> getLinkmanInfo(String ucAccount, String linkManId,
            Integer queryType);

    SDKResult<PersonalContacts> getPersonAllAddressBook(String ucAccount);
    
    SDKResult<PeronalChangeInfo> getPersonIncAddressBook(String ucAccount,Date timeStamp);

}
