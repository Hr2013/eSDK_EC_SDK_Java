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

public class OneNumberMode
{
    private String ringMode;

    private String priorityMode;

    private String busySelectMode;

    public String getRingMode()
    {
        return ringMode;
    }

    public void setRingMode(String ringMode)
    {
        this.ringMode = ringMode;
    }

    public String getPriorityMode()
    {
        return priorityMode;
    }

    public void setPriorityMode(String priorityMode)
    {
        this.priorityMode = priorityMode;
    }

    public String getBusySelectMode()
    {
        return busySelectMode;
    }

    public void setBusySelectMode(String busySelectMode)
    {
        this.busySelectMode = busySelectMode;
    }

}
