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

public class CallStatusMapping
{
    //提供两个属性，对应北向int的最大，最小值
    public static final int MAX = 14;

    public static final int MIN = 0;

    public static CallStatus int2enum(Integer num)
    {
        if (null == num)
        {
            return null;
        }
        switch (num)
        {
            case 0:

                return CallStatus.CTD_NOUSE;
            case 1:

                return CallStatus.CTD_CALLING_CALLER;
            case 2:
                return CallStatus.CTD_CALLING_CALLEE;

            case 3:
                return CallStatus.CTD_CALL_ESTABLISHED;
            case 4:
                return CallStatus.CTD_CALL_ENDED;
            case 5:

                return CallStatus.CTD_CALLER_CANNOT_REACHED;
            case 6:

                return CallStatus.CTD_CALLEE_CANNOT_REACHED;
            case 7:
                return CallStatus.CTD_CALLER_BUSY;

            case 8:
                return CallStatus.CTD_CALLEE_BUSY;
            case 9:

                return CallStatus.CTD_CALLER_NO_ANSWER;
            case 10:

                return CallStatus.CTD_CALLEE_NO_ANSWER;
            case 11:
                return CallStatus.CTD_VOIP_ASTRICT;

            case 12:
                return CallStatus.CTD_CTD_ASTRICT;
            case 13:
                return CallStatus.CTD_CALLER_OFF_LINE;
            case 14:
                return CallStatus.CTD_CALLEE_OFF_LINE;
            default:
                return null;
        }

    }
    

    public static Integer enum2int(CallStatus type)
    {
        if (null == type)
        {
            return null;
        }
        switch (type)
        {
            case CTD_NOUSE:

                return 0;
            case CTD_CALLING_CALLER:

                return 1;
            case CTD_CALLING_CALLEE:
                return 2;

            case CTD_CALL_ESTABLISHED:
                return 3;
            case CTD_CALL_ENDED:
                return 4;
            case CTD_CALLER_CANNOT_REACHED:

                return 5;
            case CTD_CALLEE_CANNOT_REACHED:

                return 6;
            case CTD_CALLER_BUSY:
                return 7;

            case CTD_CALLEE_BUSY:
                return 8;
            case CTD_CALLER_NO_ANSWER:
                return 9;
            case CTD_CALLEE_NO_ANSWER:

                return 10;
            case CTD_VOIP_ASTRICT:

                return 11;
            case CTD_CTD_ASTRICT:
                return 12;

            case CTD_CALLER_OFF_LINE:
                return 13;
            case CTD_CALLEE_OFF_LINE:
                return 14;
            default:
                return null;
        }

    }
}
