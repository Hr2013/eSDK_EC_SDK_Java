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
package com.huawei.esdk.ec.domain.model.bean;  public class WatcherInfo
{
    //被订阅者账号
    private String watcherAccount;
    
    //订阅关系状态
    private int state;
    
    //好友订阅触发事件
    private int event;

    public int getEvent()
    {
        return event;
    }

    public void setEvent(int event)
    {
        this.event = event;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public String getWatcherAccount()
    {
        return watcherAccount;
    }

    public void setWatcherAccount(String watcherAccount)
    {
        this.watcherAccount = watcherAccount;
    }
    
}
