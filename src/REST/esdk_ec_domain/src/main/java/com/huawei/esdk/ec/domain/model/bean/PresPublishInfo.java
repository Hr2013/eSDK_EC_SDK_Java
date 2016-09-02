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

public class PresPublishInfo
{
    private UCPresType presType; // 用户类型状态

    private String location; // 地点

    private String deviceType; // 设备类型

    private String tZone; // 时区

    private String availableTool; // 可用工具

    private String presStatus; //用户状态
    
    public UCPresType getPresType()
    {
        return presType;
    }

    public void setPresType(UCPresType presType)
    {
        this.presType = presType;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getTZone()
    {
        return tZone;
    }

    public void setTZone(String tZone)
    {
        this.tZone = tZone;
    }

    public String getAvailableTool()
    {
        return availableTool;
    }

    public void setAvailableTool(String availableTool)
    {
        this.availableTool = availableTool;
    }

    public String getPresStatus()
    {
        return presStatus;
    }

    public void setPresStatus(String presStatus)
    {
        this.presStatus = presStatus;
    }

}
