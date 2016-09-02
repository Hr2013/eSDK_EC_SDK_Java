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

public class OperationTypeMapping
{
    public static final int MAX = 3;
    
    public static final int MIN = 1;
    
    public static OperationType int2enum(Integer num)
    {
        if (null == num)
        {
            return null;
        }
        switch (num)
        {
            case 1:
                
                return OperationType.ACT_ADD;
            case 2:
                
                return OperationType.ACT_MOD;
            case 3:
                return OperationType.ACT_DEL;
                
            default:
                return null;
        }
        
    }
    
    public static Integer enum2int(OperationType type)
    {
        if (null == type)
        {
            return null;
        }
        switch (type)
        {
            case ACT_ADD:
                
                return 1;
            case ACT_MOD:
                return 2;
            case ACT_DEL:
                return 3;
                
            default:
                return null;
        }
        
    }
}
