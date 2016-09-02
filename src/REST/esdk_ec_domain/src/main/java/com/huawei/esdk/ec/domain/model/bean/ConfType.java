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

public enum ConfType {

    // 即时会议
    INSTANTCONF("InstantConference"),
    
    // 预约会议
    SCHEDULEDCONF("ScheduledConference"),
    
    // 需要预留多媒体资源的即时会议
    RESERVEDIC("ReservedIC"),
    
    // 需要预留多媒体资源的预约会议
    RESERVEDSC("ReservedSC");

    private final String value;

    ConfType(String v)
    {
        value = v;
    }

    public String value()
    {
        return value;
    }

    public static ConfType fromValue(String v)
    {
        for (ConfType c : ConfType.values())
        {
            if (c.value.equals(v))
            {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
