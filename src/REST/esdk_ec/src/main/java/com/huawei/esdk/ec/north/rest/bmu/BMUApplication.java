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
package com.huawei.esdk.ec.north.rest.bmu;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.huawei.esdk.ec.north.rest.bmu.resource.account.AccountPasswordResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.account.AccountResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.account.BatchAddAccountResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.account.BatchDelAccountResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.account.BindNumResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.attendee.AttendeeResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.attendee.DelAttendeeResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.attendee.OperateAttendeeResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.attendee.TransferChairmanResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.ctc.BMUCTCBactchDeleteResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.ctc.BMUCTCBactchQueryJoinResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.ctc.BMUCTCBactchQueryResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.ctc.BMUCTCResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.dept.DepartmentResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.logAudit.LogAuditResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.phone.PhoneResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.prefix.ConfPrefixResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.prefix.GlobalSRTPResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.role.BMURoleResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.sip.GatewayResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.sip.SIPAccountBatchResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.sip.SIPAccountResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.sip.SIPConditionResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.sip.SIPPasswordResource;
import com.huawei.esdk.ec.north.rest.bmu.resource.userlevel.BMUUserLevelResource;


public class BMUApplication extends Application
{

    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(SIPAccountResource.class);
        set.add(SIPAccountBatchResource.class);
        set.add(SIPPasswordResource.class);
        set.add(SIPConditionResource.class);
        set.add(AccountResource.class);
        set.add(BatchAddAccountResource.class);
        set.add(DepartmentResource.class);
        set.add(AccountPasswordResource.class);
        set.add(BindNumResource.class);
        set.add(GlobalSRTPResource.class);
        set.add(ConfPrefixResource.class);
        set.add(BMURoleResource.class);
        set.add(BMUUserLevelResource.class);
        set.add(BMUCTCBactchDeleteResource.class);
        set.add(BMUCTCBactchQueryResource.class);
        set.add(BMUCTCResource.class);
        set.add(DelAttendeeResource.class);
        set.add(BatchDelAccountResource.class);
        set.add(GatewayResource.class);
        set.add(OperateAttendeeResource.class);
        set.add(TransferChairmanResource.class);
        set.add(AttendeeResource.class);
        set.add(PhoneResource.class);
        set.add(LogAuditResource.class);
        set.add(BMUCTCBactchQueryJoinResource.class);
        return set;
    }
    
}
