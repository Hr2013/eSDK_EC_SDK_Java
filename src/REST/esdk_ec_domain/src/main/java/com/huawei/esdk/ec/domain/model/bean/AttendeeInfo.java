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

import java.util.List;

public class AttendeeInfo
{
    private String recordNum;
    
    private String msgContentLen;
    
    private List<String> attendeeNumbers;
    
    public String getRecordNum()
    {
        return recordNum;
    }
    
    public void setRecordNum(String recordNum)
    {
        this.recordNum = recordNum;
    }
    
    public String getMsgContentLen()
    {
        return msgContentLen;
    }
    
    public void setMsgContentLen(String msgContentLen)
    {
        this.msgContentLen = msgContentLen;
    }
    
    public List<String> getAttendeeNumbers()
    {
        return attendeeNumbers;
    }
    
    public void setAttendeeNumbers(List<String> attendeeNumbers)
    {
        this.attendeeNumbers = attendeeNumbers;
    }
}
