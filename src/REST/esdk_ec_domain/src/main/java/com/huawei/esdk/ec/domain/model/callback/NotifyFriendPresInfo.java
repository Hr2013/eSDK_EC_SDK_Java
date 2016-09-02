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

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.domain.model.bean.BuddyInfo;

public class NotifyFriendPresInfo
{
    private String ucAccount;

    private List<BuddyInfo> buddyInfos;

    private int expires;

    public String getUcAccount()
    {
        return ucAccount;
    }

    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }

    public List<BuddyInfo> getBuddyInfos()
    {
        if (null == buddyInfos)
        {
            buddyInfos = new ArrayList<BuddyInfo>();
        }
        return buddyInfos;
    }

    public void setBuddyInfos(List<BuddyInfo> buddyInfos)
    {
        this.buddyInfos = buddyInfos;
    }

    public int getExpires()
    {
        return expires;
    }

    public void setExpires(int expires)
    {
        this.expires = expires;
    }

}
