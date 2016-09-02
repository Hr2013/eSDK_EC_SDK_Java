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
package com.huawei.esdk.ec.domain.model.bean;

public class GroupInfoBase
{
    private String groupName; // 群组名

    private String groupNo; // 群组号

    protected String groupId; // 群组Id

    protected String groupCreater; // 群组创建者
    
    protected String groupOwner;//当前的群组管理员

    private String creatorURL;//群组创建者URL
    
    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getGroupNo()
    {
        return groupNo;
    }

    public void setGroupNo(String groupNo)
    {
        this.groupNo = groupNo;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public String getGroupCreater()
    {
        return groupCreater;
    }

    public void setGroupCreater(String creator)
    {
        this.groupCreater = creator;
    }

    public String getGroupOwner()
    {
        return groupOwner;
    }

    public void setGroupOwner(String groupOwner)
    {
        this.groupOwner = groupOwner;
    }

	public String getCreatorURL() {
		return creatorURL;
	}

	public void setCreatorURL(String creatorURL) {
		this.creatorURL = creatorURL;
	}
}
