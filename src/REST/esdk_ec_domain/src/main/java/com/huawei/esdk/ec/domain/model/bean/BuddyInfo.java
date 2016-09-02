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
package com.huawei.esdk.ec.domain.model.bean;  public class BuddyInfo
{
    // 好友账号
    private String presentity;
    
    //订阅关系状态
    private Integer state;
    
    // 好友呈现信息
    private UCPresInfo ucPresInfo;

    public String getPresentity()
    {
        return presentity;
    }

    public void setPresentity(String presentity)
    {
        this.presentity = presentity;
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }

    public UCPresInfo getUcPresInfo()
    {
        return ucPresInfo;
    }

    public void setUcPresInfo(UCPresInfo ucPresInfo)
    {
        this.ucPresInfo = ucPresInfo;
    }
}
