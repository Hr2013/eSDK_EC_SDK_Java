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

/**
 * @author sWX198756
 *
 */
public class TerminalInConfInfo
{
    // 会议ID
    private String confId;

    // 会议类型
    private ConfType confType;
    
    //外部的会议类型
    private String confTypeExt;

    // 与会者号码
    private String attendeeNum;

    // 与会者类型(1：主持人 2：与会者)
    private String attendeeType;

    // 数据会议服务端URL
    private String serverIP;
    
    //数据会议url 
    private String dataconfurl;

    // 加入手机会议的加密串
    private String token;

    // 时间戳
    private Date timeStamp;

    // 鉴权码
    private String siteId;

    // 主持人密码，最大8位的任意数字
    private String hostKey;

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
    }

    public ConfType getConfType()
    {
        return confType;
    }

    public void setConfType(ConfType confType)
    {
        this.confType = confType;
    }

    public String getAttendeeNum()
    {
        return attendeeNum;
    }

    public void setAttendeeNum(String attendeeNum)
    {
        this.attendeeNum = attendeeNum;
    }

    public String getAttendeeType()
    {
        return attendeeType;
    }

    public void setAttendeeType(String attendeeType)
    {
        this.attendeeType = attendeeType;
    }

    public String getServerIP()
    {
        return serverIP;
    }

    public void setServerIP(String serverIP)
    {
        this.serverIP = serverIP;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

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

    public String getSiteId()
    {
        return siteId;
    }

    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    public String getHostKey()
    {
        return hostKey;
    }

    public void setHostKey(String hostKey)
    {
        this.hostKey = hostKey;
    }

    /** * @param confTypeExt the confTypeExt to set */
    public void setConfTypeExt(String confTypeExt)
    {
        this.confTypeExt = confTypeExt;
    }

    /** * @return the confTypeExt */
    public String getConfTypeExt()
    {
        return confTypeExt;
    }

    public String getDataconfurl()
    {
        return dataconfurl;
    }

    public void setDataconfurl(String dataconfurl)
    {
        this.dataconfurl = dataconfurl;
    }

}
