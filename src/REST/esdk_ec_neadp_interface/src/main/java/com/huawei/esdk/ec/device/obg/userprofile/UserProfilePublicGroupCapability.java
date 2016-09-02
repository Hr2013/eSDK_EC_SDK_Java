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

import java.util.List;

import com.huawei.esdk.ec.domain.model.Group;
import com.huawei.esdk.ec.domain.model.bean.GroupInfoBase;
import com.huawei.esdk.ec.domain.model.bean.GroupMember;
import com.huawei.esdk.ec.domain.model.bean.GroupModifyInfo;
import com.huawei.esdk.ec.domain.model.bean.JoinGroupInfo;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryModeInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

/** * @author w00208247 * * */
public interface UserProfilePublicGroupCapability
{
    SDKErrorCode addGroup(Group group);
    
    
    SDKErrorCode delGroup(Group group);
    
    SDKErrorCode delGroupMember(String ucAccount,Group group);

    SDKResult<List<Group>> queryGroupInfo(String groupId, String groupCreater);
    
    SDKResult<PagedList<GroupInfoBase>> queryGroupList(String groupNo, 
    		String groupName, QueryModeInfo modeInfo);
    
    SDKResult<PagedList<GroupMember>> queryGroupMember(String groupId, String creator,QueryModeInfo queryModeInfo);
    
    SDKResult<PagedList<JoinGroupInfo>> queryJoinGroupByUC(String ucAccount, QueryModeInfo queryModeInfo);

    SDKErrorCode addGroupMember(String ucAccount, Group group);


    SDKErrorCode modifyGroup(String groupId, String groupCreater,
            GroupModifyInfo groupModInfo);

}
