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
package com.huawei.esdk.ec.domain.model.callback;

import com.huawei.esdk.ec.domain.model.bean.GroupMember;

/**
 * 
 * notifyGroupInfo接口附加的信息
 * @author  gWX169839
 */
public class NotifyGroupInfoExtended
{
    private int msgType;
    private String ucAccount;
    private String groupId;
    private String creator;
    private GroupMember groupMember;
    
    public GroupMember getGroupMember()
    {
        return groupMember;
    }
    public void setGroupMember(GroupMember groupMember)
    {
        this.groupMember = groupMember;
    }
    public int getMsgType()
    {
        return msgType;
    }
    public void setMsgType(int msgType)
    {
        this.msgType = msgType;
    }
    public String getUcAccount()
    {
        return ucAccount;
    }
    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }
    public String getGroupId()
    {
        return groupId;
    }
    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }
    public String getCreator()
    {
        return creator;
    }
    public void setCreator(String creator)
    {
        this.creator = creator;
    }

}
