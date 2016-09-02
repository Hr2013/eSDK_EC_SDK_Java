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

public class UCPresInfo
{
    private UCUserInfo ucUserInfo; // UC用户基本信息
    
    private PresPublishInfo presPublish; // 用户发布的状态信息
    
    private PresPublishInfo presExchange; //用户发布的Exchange日历状态信息

    public PresPublishInfo getPresPublish()
    {
        return presPublish;
    }

    public void setPresPublish(PresPublishInfo presPublish)
    {
        this.presPublish = presPublish;
    }

    public UCUserInfo getUcUserInfo()
    {
        return ucUserInfo;
    }

    public void setUcUserInfo(UCUserInfo ucUserInfo)
    {
        this.ucUserInfo = ucUserInfo;
    }

    public void setPresExchange(PresPublishInfo presExchange)
    {
        this.presExchange = presExchange;
    }

    public PresPublishInfo getPresExchange()
    {
        return presExchange;
    }

}
