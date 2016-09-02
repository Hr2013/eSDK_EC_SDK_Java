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
package com.huawei.esdk.ec.device.appserver.im.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.appserver.bean.AfficheRequest;
import com.huawei.esdk.ec.device.appserver.bean.AfficheStaff;
import com.huawei.esdk.ec.device.appserver.bean.DepartmentId;
import com.huawei.esdk.ec.device.appserver.bean.DepartmentIdList;
import com.huawei.esdk.ec.device.appserver.bean.StaffAccountList;
import com.huawei.esdk.ec.device.bean.XMLReqHeader;
import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class IMCapabilityConvert
{
    
    public RestReqMessage getAfficheMode2Rest(com.huawei.esdk.ec.domain.model.Affiche affiche)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        request.setPayload(payload);
        
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(affiche.getInitiatorId());
        payload.setHead(head);
        
        // 构建报文体
        AfficheRequest body = new AfficheRequest();
        payload.setBody(body);
        
        com.huawei.esdk.ec.device.appserver.bean.Affiche afficheRest =
            new com.huawei.esdk.ec.device.appserver.bean.Affiche();
        body.setAffiche(afficheRest);
        afficheRest.setAfficheTitle(affiche.getAfficheTitle());
        afficheRest.setAfficheContent(affiche.getAfficheContent());
        afficheRest.setReceiverType(affiche.getReceiverType());
        
        if (null != affiche.getStaffAccount() && !affiche.getStaffAccount().isEmpty())
        {
            StaffAccountList staffAccountList = new StaffAccountList();
            body.setStaffAccounts(staffAccountList);
            List<AfficheStaff> staffAccounts = new ArrayList<AfficheStaff>();
            staffAccountList.setStaffAccounts(staffAccounts);
            
            for (String staffAccount : affiche.getStaffAccount())
            {
                AfficheStaff afficheStaff = new AfficheStaff();
                afficheStaff.setStaffAccount(staffAccount);
                staffAccounts.add(afficheStaff);
            }
        }
        
        if (null != affiche.getDepartmentId() && !affiche.getDepartmentId().isEmpty())
        {
            DepartmentIdList departmentIdList = new DepartmentIdList();
            body.setDepartmentIds(departmentIdList);
            List<DepartmentId> departmentIds = new ArrayList<DepartmentId>();
            departmentIdList.setDepartmentIds(departmentIds);
            
            for (String departmentId : affiche.getDepartmentId())
            {
                DepartmentId deptId = new DepartmentId();
                deptId.setDepartmentId(departmentId);
                departmentIds.add(deptId);
            }
        }
        
        return request;
    }
}
