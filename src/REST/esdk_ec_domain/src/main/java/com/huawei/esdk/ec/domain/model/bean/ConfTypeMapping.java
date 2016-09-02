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

public class ConfTypeMapping
{
    public static final int MAX = 4;

    public static final int MIN = 1;

    public static ConfType int2enum(Integer num)
    {
        if (null == num)
        {
            return null;
        }
        switch (num)
        {
            case 1:

                return ConfType.INSTANTCONF;
            case 2:
                return ConfType.SCHEDULEDCONF;

            case 3:
                return ConfType.RESERVEDIC;
            case 4:
                return ConfType.RESERVEDSC;
            default:
                return null;
        }

    }

    public static Integer enum2int(ConfType type)
    {
        if (null == type)
        {
            return null;
        }
        switch (type)
        {
            case INSTANTCONF:

                return 1;
            case SCHEDULEDCONF:
                return 2;

            case RESERVEDIC:
                return 3;
            case RESERVEDSC:
                return 4;
            default:
                return null;
        }

    }
}
