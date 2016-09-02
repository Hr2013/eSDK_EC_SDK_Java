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

public class GroupValTypeMapping
{
    public static final int MAX = 1;

    public static final int MIN = 0;

    public static GroupValType int2enum(Integer num)
    {
        if (null == num)
        {
            return null;
        }
        switch (num)
        {
            // 允许任何人加入
            case 0:
                return GroupValType.ALL_ALLOW;
                // 需要身份验证才可加入
            case 1:
                return GroupValType.NEED_PERMIT;

            default:
                return null;
        }
    }

    public static Integer enum2int(GroupValType type)
    {
        if (null == type)
        {
            return null;
        }
        switch (type)
        {
            // 允许任何人加入
            case ALL_ALLOW:
                return 0;

                // 需要身份验证才可加入
            case NEED_PERMIT:
                return 1;
            default:
                return null;
        }
    }
    
}
