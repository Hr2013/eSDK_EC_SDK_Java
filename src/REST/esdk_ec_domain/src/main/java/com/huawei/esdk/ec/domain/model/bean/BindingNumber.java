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

import java.util.List;

public class BindingNumber
{
    private String bindingNumber;

    private String priority;

    private String bindType;

    private String useTimeRange;

    private List<BindingTimeInfo> bindingTimeInfos;

    public String getBindingNumber()
    {
        return bindingNumber;
    }

    public void setBindingNumber(String bindingNumber)
    {
        this.bindingNumber = bindingNumber;
    }

    public String getPriority()
    {
        return priority;
    }

    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    public String getBindType()
    {
        return bindType;
    }

    public void setBindType(String bindType)
    {
        this.bindType = bindType;
    }

    public String getUseTimeRange()
    {
        return useTimeRange;
    }

    public void setUseTimeRange(String useTimeRange)
    {
        this.useTimeRange = useTimeRange;
    }

    public List<BindingTimeInfo> getBindingTimeInfos()
    {
        return bindingTimeInfos;
    }

    public void setBindingTimeInfos(List<BindingTimeInfo> bindingTimeInfos)
    {
        this.bindingTimeInfos = bindingTimeInfos;
    }

}
