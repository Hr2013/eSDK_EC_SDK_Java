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

import com.huawei.esdk.uc.professional.local.constant.ResultCode;
import com.huawei.esdk.uc.professional.local.service.ClientManagerServiceEx;

public class ClientManagerServiceExImpl implements ClientManagerServiceEx
{
    private static ClientManagerServiceExImpl instance = null;
    
    public static synchronized ClientManagerServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new ClientManagerServiceExImpl();
        }
        
        return instance;
    }
    
    @Override
    public Integer userLogin(String ucAccount, String pwd, String registerFunc)
    {
        if (null == ucAccount || null == pwd || null == registerFunc)
        {
            return ResultCode.North.SDK_PARAM_NOT_COMPLETE_ERRORCODE;
        }
        
        // eSDK支持兼容UC2.0userLogin的JavaNative接口，直接返回成功
        return 0;
    }
    
}
