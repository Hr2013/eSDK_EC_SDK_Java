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
package com.huawei.esdk.uc.professional.local.serviceImpl;

import com.huawei.esdk.uc.professional.local.bean.south.AppSendMsgToDept;
import com.huawei.esdk.uc.professional.local.bean.south.AppSendMsgToGroup;
import com.huawei.esdk.uc.professional.local.bean.south.AppSendMsgToUC;
import com.huawei.esdk.uc.professional.local.resource.IMResource;
import com.huawei.esdk.uc.professional.local.service.IMServiceEx;

public class IMServiceExImpl implements IMServiceEx
{
    
    private IMResource imResource = new IMResource();
    
    private static IMServiceExImpl instance = null;
    
    public static synchronized IMServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new IMServiceExImpl();
        }
        return instance;
    }

    @Override
    public Integer appSendMsgToUC(AppSendMsgToUC msg)
    {
        return imResource.appSendMsgToUC(msg);
    }

    @Override
    public Integer appSendMsgToDept(AppSendMsgToDept msg)
    {
        return imResource.appSendMsgToDept(msg);
    }

    @Override
    public Integer appSendMsgToGroup(AppSendMsgToGroup msg)
    {
        return imResource.appSendMsgToGroup(msg);
    }
    
}
