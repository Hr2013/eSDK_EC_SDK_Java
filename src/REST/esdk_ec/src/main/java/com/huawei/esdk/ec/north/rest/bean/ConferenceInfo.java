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
package com.huawei.esdk.ec.north.rest.bean;

import java.util.List;

/**
 * @author sWX198756
 *
 */
public class ConferenceInfo
{
    /**
     * 用户账号
     */
    private String account;
    
    /**
     * 会议id
     */
    private String confId;
    
    /**
     * 会议主题
     */
    private String topic;
    
    /**
     * 会议开始时间
     */
    private String startTime;
    
    /**
     * 会议主持人
     */
    private String emcee;
    
    /**
     * 会议状态
     */
    private String status;
    
    /**
     * 与会人号码
     */
    private List<Invitee> invitees;
    
    public String getTopic()
    {
        return topic;
    }
    
    public void setTopic(String topic)
    {
        this.topic = topic;
    }
    
    public List<Invitee> getInvitees()
    {
        return invitees;
    }
    
    public void setInvitees(List<Invitee> invitees)
    {
        this.invitees = invitees;
    }
    
    public String getConfId()
    {
        return confId;
    }
    
    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
    public String getStartTime()
    {
        return startTime;
    }
    
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }
    
    public String getEmcee()
    {
        return emcee;
    }
    
    public void setEmcee(String emcee)
    {
        this.emcee = emcee;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
}
