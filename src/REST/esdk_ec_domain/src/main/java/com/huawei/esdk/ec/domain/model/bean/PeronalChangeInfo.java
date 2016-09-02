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

import java.util.Date;
import java.util.List;

public class PeronalChangeInfo
{
    // 分组变化信息列表
    private List<PersonalTeamChangeInfo> personalTeamChangeInfos;

    // 联系人变化信息列表
    private List<LinkmanChangeInfo> linkmanChanges;

    // 分组成员变化信息列表
    private List<TeamMemberChangeInfo> teamMemberChangeInfos;

    // 群组变化信息列表
    private List<GroupChangeInfo> groupChangeInfos;

    //时间戳
    private Date timeStamp;
    
    public Date getTimeStamp()
    {
        if(timeStamp == null)
            return null;
        return (Date)timeStamp.clone();
    }

    public void setTimeStamp(Date timeStamp)
    {
        this.timeStamp = (Date)timeStamp.clone();
    }

    public List<PersonalTeamChangeInfo> getPersonalTeamChangeInfos()
    {
        return personalTeamChangeInfos;
    }

    public void setPersonalTeamChangeInfos(
            List<PersonalTeamChangeInfo> personalTeamChangeInfos)
    {
        this.personalTeamChangeInfos = personalTeamChangeInfos;
    }

    public List<LinkmanChangeInfo> getLinkmanChanges()
    {
        return linkmanChanges;
    }

    public void setLinkmanChanges(List<LinkmanChangeInfo> linkmanChanges)
    {
        this.linkmanChanges = linkmanChanges;
    }

    public List<TeamMemberChangeInfo> getTeamMemberChangeInfos()
    {
        return teamMemberChangeInfos;
    }

    public void setTeamMemberChangeInfos(
            List<TeamMemberChangeInfo> teamMemberChangeInfos)
    {
        this.teamMemberChangeInfos = teamMemberChangeInfos;
    }

    public List<GroupChangeInfo> getGroupChangeInfos()
    {
        return groupChangeInfos;
    }

    public void setGroupChangeInfos(List<GroupChangeInfo> groupChangeInfos)
    {
        this.groupChangeInfos = groupChangeInfos;
    }
}
