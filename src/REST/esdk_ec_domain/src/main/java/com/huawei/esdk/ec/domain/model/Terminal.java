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

import com.huawei.esdk.ec.domain.model.bean.TerminalStatus;

public class Terminal
{
    // 会场号码(支持短号、手机号码、区号+电话号码)
    private String terminalNo;
    
    // 会场URI
    private String terminalUri;
    
    // 会场名称
    private String name;
    
    // 会场账号
    private String account;
    
    // 会场发话权(0：无发话权；1：有发话权；2：正在申请)
    private int aut;

    // 会场状态
    private TerminalStatus terminalStatus;

    // 会场是否支持视频（真表示支持视频，假表示不支持）
    private boolean supportVideo;
    
    // 会场角色（1：主持人；2：普通成员）
    private int role;
    
    // 会场Email
    private String email;
    
    //与会者加入会议时间
    private String joinConfTime;
    
    public Terminal()
    {
    }

    public String getSiteNo()
    {
        return terminalNo;
    }

    public void setSiteNo(String terminalNo)
    {
        this.terminalNo = terminalNo;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public int getAut()
    {
        return aut;
    }

    public void setAut(int aut)
    {
        this.aut = aut;
    }

    public TerminalStatus getSiteStatus()
    {
        return terminalStatus;
    }

    public void setSiteStatus(TerminalStatus siteStatus)
    {
        this.terminalStatus = siteStatus;
    }

    public boolean isSupportVideo()
    {
        return supportVideo;
    }

    public void setSupportVideo(boolean supportVideo)
    {
        this.supportVideo = supportVideo;
    }

    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    /** * @param terminalUri the terminalUri to set */
    public void setTerminalUri(String terminalUri)
    {
        this.terminalUri = terminalUri;
    }

    /** * @return the terminalUri */
    public String getTerminalUri()
    {
        return terminalUri;
    }

    public String getJoinConfTime()
    {
        return joinConfTime;
    }

    public void setJoinConfTime(String joinConfTime)
    {
        this.joinConfTime = joinConfTime;
    }
}
