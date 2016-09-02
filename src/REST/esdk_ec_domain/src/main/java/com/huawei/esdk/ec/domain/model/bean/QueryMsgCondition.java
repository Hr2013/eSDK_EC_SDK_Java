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
package com.huawei.esdk.ec.domain.model.bean; import java.util.Date;

/** * @author w00208247 * *  */
public class QueryMsgCondition
{
    private String userNum;
    private String msgType;
    private Date startTime;
    private Date endTime;
    
    public String getUserNum()
    {
        return userNum;
    }
    public void setUserNum(String userNum)
    {
        this.userNum = userNum;
    }
    public String getMsgType()
    {
        return msgType;
    }
    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }
    public Date getStartTime()
    {
        if(startTime == null)
            return null;
        return (Date)startTime.clone();
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = (Date)startTime.clone();
    }
    public Date getEndTime()
    {
        if(endTime == null)
            return null;
        return (Date)endTime.clone();
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = (Date)endTime.clone();
    }

}
