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

public class DelAttendeeRequest
{
    private String userId;
    
    private String gwIp;
    
    //private String confNo;
    
    private String confId;
    
    private List<DelAttendeeInfo> attendeeInfos;
    
    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }

//    public String getConfNo()
//    {
//        return confNo;
//    }
//
//    public void setConfNo(String confNo)
//    {
//        this.confNo = confNo;
//    }

    public List<DelAttendeeInfo> getAttendeeInfos()
    {
        return attendeeInfos;
    }

    public void setAttendeeInfos(List<DelAttendeeInfo> attendeeInfos)
    {
        this.attendeeInfos = attendeeInfos;
    }

    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
}
