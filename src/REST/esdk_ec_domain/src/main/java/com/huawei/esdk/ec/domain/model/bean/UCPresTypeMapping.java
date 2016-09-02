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

public class UCPresTypeMapping
{
    public static final int MAX = 5;
    
    public static final int MIN = 0;
    
    public static UCPresType int2enum(Integer num)
    {
        if (null == num)
        {
            return null;
        }
        switch (num)
        {
            case 0:
                return UCPresType.ONLINE;
            case 1:
                return UCPresType.BUSY;
            case 2:
                return UCPresType.CALLING;
            case 3:
                return UCPresType.LEAVING;
            case 4:
                return UCPresType.OFFLINE;
            case 5:
                return UCPresType.DND;
            default:
                return null;
        }
        
    }
    
    public static Integer enum2int(UCPresType type)
    {
        if (null == type)
        {
            return null;
        }
        switch (type)
        {
            case ONLINE:
                return 0;
            case BUSY:
                return 1;
            case CALLING:
                return 2;
            case LEAVING:
                return 3;
            case OFFLINE:
                return 4;
            case DND:
                return 5;
            default:
                return null;
        }
        
    }
}
