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
package com.huawei.esdk.ec.north.rest.eserver;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.huawei.esdk.ec.north.rest.eserver.resource.callback.CallbackResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.im.AppSendMsgToDeptResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.im.AppSendMsgToGroupResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.im.AppSendMsgToUCResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.AddGroupMembersResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.AddGroupResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.AppInfoResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.AppUserStatesResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.DelGroupMembersResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.DelGroupResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.GetGroupMembersResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.GetIMGroupResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.GroupIMResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.SetGroupResource;
import com.huawei.esdk.ec.north.rest.eserver.resource.presence.EServerPresenceResource;
import com.huawei.esdk.platform.common.config.ConfigManager;

public class EServerApplication extends Application
{
    private String multiAppOnline = ConfigManager.getInstance().getValue("ec.multi.app.online.service");
    
    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(EServerPresenceResource.class);
        set.add(AppSendMsgToDeptResource.class);
        set.add(AppSendMsgToUCResource.class);
        set.add(AppSendMsgToGroupResource.class);
        
        if (Boolean.parseBoolean(multiAppOnline))
        {
            set.add(AddGroupMembersResource.class);
            set.add(AddGroupResource.class);
            set.add(AppInfoResource.class);
            set.add(DelGroupMembersResource.class);
            set.add(DelGroupResource.class);
            set.add(GetGroupMembersResource.class);
            set.add(GetIMGroupResource.class);
            set.add(GroupIMResource.class);
            set.add(SetGroupResource.class);
            set.add(AppUserStatesResource.class);
        }
        
        set.add(CallbackResource.class);
        
        return set;
    }
}
