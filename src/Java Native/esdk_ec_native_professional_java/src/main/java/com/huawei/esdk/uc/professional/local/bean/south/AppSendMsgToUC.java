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
package com.huawei.esdk.uc.professional.local.bean.south;

import java.util.Date;

public class AppSendMsgToUC
{
    private String sendNumber;
    
    private String ucAccount;
    
    private String message;
    
    private Date dateTime;
    
    private String priorityLevel;
    
    public String getPriorityLevel()
    {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel)
    {
        this.priorityLevel = priorityLevel;
    }

    public String getSendNumber()
    {
        return sendNumber;
    }
    
    public void setSendNumber(String sendNumber)
    {
        this.sendNumber = sendNumber;
    }
    
    public String getUcAccount()
    {
        return ucAccount;
    }
    
    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public void setMessage(String message)
    {
        this.message = message;
    }
    
    public Date getDateTime()
    {
        return dateTime;
    }
    
    public void setDateTime(Date dateTime)
    {
        this.dateTime = dateTime;
    }
    
}
