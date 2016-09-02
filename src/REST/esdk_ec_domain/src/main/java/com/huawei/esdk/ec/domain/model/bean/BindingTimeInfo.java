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

import java.util.Date;

public class BindingTimeInfo
{
    private String beginWeekDay;

    private String endWeekDay;

    private Date beginTime;

    private Date endTime;

    public String getBeginWeekDay()
    {
        return beginWeekDay;
    }

    public void setBeginWeekDay(String beginWeekDay)
    {
        this.beginWeekDay = beginWeekDay;
    }

    public String getEndWeekDay()
    {
        return endWeekDay;
    }

    public void setEndWeekDay(String endWeekDay)
    {
        this.endWeekDay = endWeekDay;
    }

    public Date getBeginTime()
    {
        if(beginTime == null)
            return null;
        return (Date)beginTime.clone();
    }

    public void setBeginTime(Date beginTime)
    {
        this.beginTime = (Date)beginTime.clone();
    }

    public Date getEndTime()
    {
        if(endTime == null)
            return null;
        return (Date)endTime.clone();
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = (Date)endTime.clone();
    }

}
