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


public class NotifyCCConfInfoExtended
{
    private String eventId;
    private String sbj;
    private String start;
    private String end;
    private boolean locked;
    private boolean muted;
    private String confState;
    private String maxVoice;
    private String maxVoiceAccount;
    
    public String getEventId()
    {
        return eventId;
    }
    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }
    public String getSbj()
    {
        return sbj;
    }
    public void setSbj(String sbj)
    {
        this.sbj = sbj;
    }
    public String getStart()
    {
        return start;
    }
    public void setStart(String start)
    {
        this.start = start;
    }
    public String getEnd()
    {
        return end;
    }
    public void setEnd(String end)
    {
        this.end = end;
    }
    public boolean isLocked()
    {
        return locked;
    }
    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }
    public boolean isMuted()
    {
        return muted;
    }
    public void setMuted(boolean muted)
    {
        this.muted = muted;
    }
    public String getConfState()
    {
        return confState;
    }
    public void setConfState(String confState)
    {
        this.confState = confState;
    }
    public String getMaxVoice()
    {
        return maxVoice;
    }
    public void setMaxVoice(String maxVoice)
    {
        this.maxVoice = maxVoice;
    }
    public String getMaxVoiceAccount()
    {
        return maxVoiceAccount;
    }
    public void setMaxVoiceAccount(String maxVoiceAccount)
    {
        this.maxVoiceAccount = maxVoiceAccount;
    }
    
}
