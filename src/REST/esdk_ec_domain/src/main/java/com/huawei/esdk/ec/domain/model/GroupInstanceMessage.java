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

import java.util.Date;

import com.huawei.esdk.ec.device.obg.IMCapability;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 群组即时消息模型
 * 
 */
public class GroupInstanceMessage extends InstanceMessage
{
    // 群组ID
    private String groupId;
    
    // 群组创建者UC账号
    private String groupCreator;
    
    //EC3.0新增字段，消息优先级
    private Integer priorityLevel;
    
    public GroupInstanceMessage()
    {
        
    }

    public GroupInstanceMessage(String groupId, String groupCreator)
    {
        super();
        this.setGroupId(groupId);
        this.setGroupCreator(groupCreator);
    }

    // app用户发送消息
    public SDKErrorCode appSendMessage(String sendNo, String msg, Date msgSendTime)
    {
        return null;
    }
    
    public SDKErrorCode appSendMsgToGroup() throws SDKException
    {
        IMCapability imCapability =
            getDeviceManager().getDeviceServiceProxy
            (ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IMCapability.class);
        SDKErrorCode errorCode = imCapability.
            appSendMsgToGroup(this);
        return errorCode;
    }

    public String getGroupCreator()
    {
        return groupCreator;
    }

    public void setGroupCreator(String groupCreator)
    {
        this.groupCreator = groupCreator;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
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
