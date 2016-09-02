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

public class UCPresQryResultMapping
{
    public static final int MAX = 5;
    
    public static final int MIN = 1;
    
    public static UCPresQryResult int2enum(Integer num)
    {
        if (null == num)
        {
            return null;
        }
        switch (num)
        {
            case 1:
                return UCPresQryResult.RES_OK;
            case 2:
                return UCPresQryResult.RES_ACCEPT;
            case 3:
                return UCPresQryResult.RES_FORBIDDEN;
            case 4:
                return UCPresQryResult.RES_NOT_FOUND;
            case 5:
                return UCPresQryResult.RES_SERVER_ERR;
            default:
                return null;
        }
        
    }
    
    public static Integer enum2int(UCPresQryResult type)
    {
        if (null == type)
        {
            return null;
        }
        switch (type)
        {
            case RES_OK:
                return 1;
            case RES_ACCEPT:
                return 2;
            case RES_FORBIDDEN:
                return 3;
            case RES_NOT_FOUND:
                return 4;
            case RES_SERVER_ERR:
                return 5;
            default:
                return null;
        }
        
    }
}
