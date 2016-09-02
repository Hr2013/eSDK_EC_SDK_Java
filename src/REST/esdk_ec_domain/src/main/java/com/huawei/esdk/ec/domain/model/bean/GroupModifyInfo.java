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

import java.util.List;

public class GroupModifyInfo
{
    private String groupName; // 群组名称

    private String groupDec; // 群组描述

    private String groupPost; // 群组公告

    private List<GroupValType> groupValTypeList; // 群组验证方式
    
    private int maxShareFileSize; //群共享文件大小

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getGroupDec()
    {
        return groupDec;
    }

    public void setGroupDec(String groupDec)
    {
        this.groupDec = groupDec;
    }

    public String getGroupPost()
    {
        return groupPost;
    }

    public void setGroupPost(String groupPost)
    {
        this.groupPost = groupPost;
    }

    public List<GroupValType> getGroupValTypeList()
    {
        return groupValTypeList;
    }

    public void setGroupValTypeList(List<GroupValType> groupValTypeList)
    {
        this.groupValTypeList = groupValTypeList;
    }

    public int getMaxShareFileSize()
    {
        return maxShareFileSize;
    }

    public void setMaxShareFileSize(int maxShareFileSize)
    {
        this.maxShareFileSize = maxShareFileSize;
    }

}
