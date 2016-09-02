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
package com.huawei.esdk.ec.device.bmu.role.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.QueryRoleRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryRoleResponse;
import com.huawei.esdk.ec.device.bmu.bean.RoleInfo;
import com.huawei.esdk.ec.device.bmu.bean.RoleInfoArray;
import com.huawei.esdk.ec.domain.model.Role;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class RoleCapabilityConvert
{
    
    public RestReqMessage getQueryRoleRequest(String userId, String pageCount, String pageNum, String lang)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        QueryRoleRequest acctRequest = new QueryRoleRequest();
        
        acctRequest.setUserId(userId);
        
        acctRequest.setLang(lang);
        acctRequest.setPageCount(pageCount);
        acctRequest.setPageNum(pageNum);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }

    public Role getQueryRoleResponse(QueryRoleResponse body)
    {
        if(null == body)
        {
            return null;
        }
        Role role = new Role();
        role.setAmount(body.getAmount());
        RoleInfoArray roleInfoArray = body.getRoleInfoArray();
        if(null != roleInfoArray && null != roleInfoArray.getRoleInfos())
        {
            List<com.huawei.esdk.ec.domain.model.bean.RoleInfo> roleInfos = new
                ArrayList<com.huawei.esdk.ec.domain.model.bean.RoleInfo>();
            for(RoleInfo rl : roleInfoArray.getRoleInfos())
            {
                com.huawei.esdk.ec.domain.model.bean.RoleInfo roleModal = new 
                    com.huawei.esdk.ec.domain.model.bean.RoleInfo();
                roleModal.setDescription(rl.getDescription());
                roleModal.setRoleId(rl.getRoleId());
                roleModal.setRoleName(rl.getRoleName());
                roleModal.setRoleType(rl.getRoleType());
                
                roleInfos.add(roleModal);
            }
            
            role.setRoleInfos(roleInfos);
        }
        return role;
    }
    
}
