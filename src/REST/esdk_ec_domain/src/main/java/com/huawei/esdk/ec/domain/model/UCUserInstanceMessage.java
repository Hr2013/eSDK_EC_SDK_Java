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
package com.huawei.esdk.ec.domain.model;

import com.huawei.esdk.ec.device.obg.IMCapability;
import com.huawei.esdk.ec.devices.v300r001c00.im.ECV3R1C00IMCapability;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 部门即时消息模型
 * 
 */
public class UCUserInstanceMessage extends InstanceMessage
{
    //UC账号ID
    private String ucAccount;
    
    //EC3.0新增字段，消息优先级
    private Integer priorityLevel;
    
    public SDKErrorCode appSendMsgToUC()
        throws SDKException
    {
        IMCapability imCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IMCapability.class);
        SDKErrorCode errorCode = imCapability.appSendMsgToUC(this);
        return errorCode;
        
    }
    
    public SDKErrorCode appSendMsgToUCAsyn()
        throws SDKException
    {
        ECV3R1C00IMCapability imCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                ECV3R1C00IMCapability.class);
        SDKErrorCode errorCode = imCapability.appSendMsgToUC(this);
        return errorCode;
        
    }
    
    public String getUcAccount()
    {
        return ucAccount;
    }
    
    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }
    
    public Integer getPriorityLevel()
    {
        return priorityLevel;
    }
    
    public void setPriorityLevel(Integer priorityLevel)
    {
        this.priorityLevel = priorityLevel;
    }
    
}
