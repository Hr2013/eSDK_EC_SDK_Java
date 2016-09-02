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
package com.huawei.esdk.ec.north.rest.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.huawei.esdk.ec.north.rest.app.resource.affiche.AfficheResource;
import com.huawei.esdk.ec.north.rest.app.resource.callback.CallbackResource;
import com.huawei.esdk.ec.north.rest.app.resource.ctc.CTCAttendeeResource;
import com.huawei.esdk.ec.north.rest.app.resource.ctc.CTCResource;
import com.huawei.esdk.ec.north.rest.app.resource.ctc.CTCTerminalType;
import com.huawei.esdk.ec.north.rest.app.resource.ctc.CTCUpgrade;
import com.huawei.esdk.ec.north.rest.app.resource.ctd.CTDResource;
import com.huawei.esdk.ec.north.rest.app.resource.multiapponline.HisMsgResource;
import com.huawei.esdk.ec.north.rest.app.resource.userprofile.AddressResource;
import com.huawei.esdk.ec.north.rest.app.resource.userprofile.EmployeeResource;
import com.huawei.esdk.ec.north.rest.app.resource.userprofile.EnterpriseResource;
import com.huawei.esdk.ec.north.rest.app.resource.userprofile.PersonInfoResource;
import com.huawei.esdk.platform.common.config.ConfigManager;

public class AppServerApplication extends Application
{
    private String multiAppOnline = ConfigManager.getInstance().getValue("ec.multi.app.online.service");
    
    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(CTDResource.class);
        set.add(CTCResource.class);
        set.add(CTCAttendeeResource.class);
        set.add(CTCTerminalType.class);
        set.add(CTCUpgrade.class);
        set.add(AfficheResource.class);
        set.add(AddressResource.class);
        set.add(PersonInfoResource.class);
        set.add(EmployeeResource.class);
        set.add(EnterpriseResource.class);
        set.add(CallbackResource.class);
        
        if (Boolean.parseBoolean(multiAppOnline))
        {
            set.add(HisMsgResource.class);
        }
        
        return set;
    }
    
}
