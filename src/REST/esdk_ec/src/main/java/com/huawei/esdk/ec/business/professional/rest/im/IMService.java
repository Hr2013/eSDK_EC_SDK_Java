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
package com.huawei.esdk.ec.business.professional.rest.im;

import com.huawei.esdk.ec.domain.model.DeptInstanceMessage;
import com.huawei.esdk.ec.domain.model.GroupInstanceMessage;
import com.huawei.esdk.ec.domain.model.UCUserInstanceMessage;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;

public class IMService
{

    public SDKErrorCode appSendMsgToUC(UCUserInstanceMessage im) throws SDKException
    {
        return im.appSendMsgToUC();
    }

    public SDKErrorCode appSendMsgToDept(DeptInstanceMessage im) throws SDKException
    {
        return im.appSendMsgToDept();
    }

    public SDKErrorCode appSendMsgToGroup(GroupInstanceMessage im) throws SDKException
    {
        return im.appSendMsgToGroup();
    }
    
}