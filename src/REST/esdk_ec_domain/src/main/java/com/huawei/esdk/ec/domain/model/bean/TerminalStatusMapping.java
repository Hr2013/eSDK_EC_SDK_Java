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

public class TerminalStatusMapping
{
    
    public final static int MAX = 4;
    
    public final static int MIN = 1;
    
    public static TerminalStatus int2enum(Integer num)
    {
        if (null == num)
        {
            return null;
        }
        switch (num)
        {
            case 1:
                
                return TerminalStatus.INVITING;
            case 2:
                return TerminalStatus.INVITED;
                
            case 3:
                return TerminalStatus.NOTINVITED;
            case 4:
                return TerminalStatus.HANGUP;
            default:
                return null;
        }
        
    }
    
    public static Integer enum2int(TerminalStatus type)
    {
        if (null == type)
        {
            return -1;
        }
        switch (type)
        {
            case INVITING:
                return 1;
            case INVITED:
                return 2;
            case NOTINVITED:
                return 3;
            case HANGUP:
                return 4;
            default:
                return -1;
        }
        
    }
}
