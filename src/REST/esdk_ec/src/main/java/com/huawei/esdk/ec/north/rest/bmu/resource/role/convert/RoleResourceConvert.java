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
package com.huawei.esdk.ec.north.rest.bmu.resource.role.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.domain.model.Role;
import com.huawei.esdk.ec.domain.model.bean.RoleInfo;
import com.huawei.esdk.ec.north.rest.bean.QueryRoleInfoResponse;

public class RoleResourceConvert
{

    public QueryRoleInfoResponse queryRoleModal2Rest(Role result)
    {
        if(null == result)
        {
            return null;
        }
        QueryRoleInfoResponse queryRoleInfoResponse = new QueryRoleInfoResponse();
        queryRoleInfoResponse.setAmount(result.getAmount());
        List<RoleInfo> rolesModal = result.getRoleInfos();
        if(null != rolesModal)
        {
            List<com.huawei.esdk.ec.north.rest.bean.RoleInfo> roleInfos = new 
                ArrayList<com.huawei.esdk.ec.north.rest.bean.RoleInfo>();
            for(RoleInfo roleModal : rolesModal)
            {
                com.huawei.esdk.ec.north.rest.bean.RoleInfo role = 
                    new com.huawei.esdk.ec.north.rest.bean.RoleInfo();
                role.setDescription(roleModal.getDescription());
                role.setRoleId(roleModal.getRoleId());
                role.setRoleName(roleModal.getRoleName());
                role.setRoleType(roleModal.getRoleType());
                roleInfos.add(role);
            }
            queryRoleInfoResponse.setRoleInfos(roleInfos);
        }
        return queryRoleInfoResponse;
    }
    
}
