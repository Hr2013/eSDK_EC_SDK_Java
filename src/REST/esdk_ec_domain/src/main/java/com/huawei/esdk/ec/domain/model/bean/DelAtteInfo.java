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

public class DelAtteInfo
{
    /**
     * 与会者号码，最大32位长度号码
     */
    private String attendeeNumber;
    
    /**
     * 与会者是否注册用户
     */
    private String isRegister;

    public String getAttendeeNumber()
    {
        return attendeeNumber;
    }

    public void setAttendeeNumber(String attendeeNumber)
    {
        this.attendeeNumber = attendeeNumber;
    }

    public String getIsRegister()
    {
        return isRegister;
    }

    public void setIsRegister(String isRegister)
    {
        this.isRegister = isRegister;
    }
}
