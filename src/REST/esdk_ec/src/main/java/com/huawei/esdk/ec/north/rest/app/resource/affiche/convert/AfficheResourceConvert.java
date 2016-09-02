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
package com.huawei.esdk.ec.north.rest.app.resource.affiche.convert;

import com.huawei.esdk.ec.domain.model.Affiche;
import com.huawei.esdk.ec.north.rest.bean.AfficheRequest;

public class AfficheResourceConvert
{

    public Affiche getAfficheRest2Model(AfficheRequest affiche)
    {
        Affiche model = new Affiche();
        model.setInitiatorId(affiche.getInitiatorId());
        model.setAfficheTitle(affiche.getAfficheTitle());
        model.setAfficheContent(affiche.getAfficheContent());
        model.setReceiverType(affiche.getReceiverType());
        
        if (null != affiche.getStaffAccounts() && !affiche.getStaffAccounts().isEmpty())
        {
            model.setStaffAccount(affiche.getStaffAccounts());
        }
        
        if (null != affiche.getDepartmentIds() && !affiche.getDepartmentIds().isEmpty())
        {
            model.setDepartmentId(affiche.getDepartmentIds());
        }
        
        return model;
    }
    
}
