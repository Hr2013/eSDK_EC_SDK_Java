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
package com.huawei.esdk.ec.device.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * U19设备连接池
 * <p>
 * @author  c00316442
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class U19DeviceConnectionBase
{
    private static Map<String, Object> deviceConnectionMap;
    
    private static List<Object> connMgrList = new ArrayList<Object>();
    
    public static List<Object> getConnMgrList()
    {
        return connMgrList;
    }

    public static void setConnMgrList(List<Object> connMgrList)
    {
        U19DeviceConnectionBase.connMgrList = connMgrList;
    }

    public static Map<String, Object> getDeviceConnectionMap()
    {
        return deviceConnectionMap;
    }
    
    public static void setDeviceConnectionMap(Map<String, Object> deviceConnectionMap)
    {
        U19DeviceConnectionBase.deviceConnectionMap = deviceConnectionMap;
    }
}
