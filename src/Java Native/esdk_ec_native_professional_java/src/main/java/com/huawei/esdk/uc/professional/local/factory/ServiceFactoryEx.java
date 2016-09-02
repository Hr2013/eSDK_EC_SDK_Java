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
package com.huawei.esdk.uc.professional.local.factory;

import com.huawei.esdk.uc.professional.local.service.ClientManagerServiceEx;
import com.huawei.esdk.uc.professional.local.service.ConfManagerServiceEx;
import com.huawei.esdk.uc.professional.local.service.IMServiceEx;
import com.huawei.esdk.uc.professional.local.service.LogAuditServiceEx;
import com.huawei.esdk.uc.professional.local.service.PresenceServiceEx;
import com.huawei.esdk.uc.professional.local.service.UserProfileServiceEx;
import com.huawei.esdk.uc.professional.local.serviceImpl.ClientManagerServiceExImpl;
import com.huawei.esdk.uc.professional.local.serviceImpl.ConfManagerServiceExImpl;
import com.huawei.esdk.uc.professional.local.serviceImpl.IMServiceExImpl;
import com.huawei.esdk.uc.professional.local.serviceImpl.LogAuditServiceExImpl;
import com.huawei.esdk.uc.professional.local.serviceImpl.PresenceServiceExImpl;
import com.huawei.esdk.uc.professional.local.serviceImpl.UserProfileServiceExImpl;

public class ServiceFactoryEx
{
    static
    {
        System.setProperty("org.apache.cxf.JDKBugHacks.defaultUsesCaches", "true");
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getService(Class<? extends T> interfaceClass)
    {
        if (interfaceClass.getName().equals(UserProfileServiceEx.class.getName()))
        {
            return (T)UserProfileServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(ClientManagerServiceEx.class.getName()))
        {
            return (T)ClientManagerServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(IMServiceEx.class.getName()))
        {
            return (T)IMServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(PresenceServiceEx.class.getName()))
        {
            return (T)PresenceServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(LogAuditServiceEx.class.getName()))
        {
            return (T)LogAuditServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(ConfManagerServiceEx.class.getName()))
        {
            return (T)ConfManagerServiceExImpl.getInstance();
        }
        else
        {
            return null;
        }
    }
}
