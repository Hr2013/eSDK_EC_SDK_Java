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

public enum ConfStatus 
{

    // 0表示会议预约成功
    SCHEDULED("0"),
    
    // 1表示会议正在创建
    CREATING("1"),
    
    //2表示会议已经召开
    HOLDING("2"),
    
    //3表示会议已经结束
    END("3"),
    
    //4表示属于周期会议，已经预约成功
    RECSCHEDULED("4"),
    
    //5表示周期会议正在创建
    RECCREATING("5"),
    
    //6表示属于周期会议，已经召开
    RECHOLDING("6"),
    
    //7表示属于周期会议，已经结束
    RECEND("7"),
    
    //8表示创建预约会议失败
    FAILURE("8"),
    
    //9表示创建周期预约会议失败
    RECFAILURE("9"),

    //10表示正在修改会议
    MODIFYING("10"),
    
    //11表示会场被锁定
    LOCKING("11"),
    
    //12表示周期会场被锁定
    RECLOCKING("12"),
    
    //13表示会议被用户取消
    CANCEL("13");
    
    private final String value;

    ConfStatus(String v)
    {
        value = v;
    }

    public String value()
    {
        return value;
    }

    public static ConfStatus fromValue(String v)
    {
        for (ConfStatus c : ConfStatus.values())
        {
            if (c.value.equals(v))
            {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
