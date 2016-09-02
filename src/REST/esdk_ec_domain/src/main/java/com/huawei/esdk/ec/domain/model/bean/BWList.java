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

public class BWList
{
    private String flowType; 

    private String activeBWListFlag;

    private String bwListFlag;

    private List<ScreenNum> screenNums;

    public String getFlowType()
    {
        return flowType;
    }

    public void setFlowType(String flowType)
    {
        this.flowType = flowType;
    }

    public String getActiveBWListFlag()
    {
        return activeBWListFlag;
    }

    public void setActiveBWListFlag(String activeBWListFlag)
    {
        this.activeBWListFlag = activeBWListFlag;
    }

    public String getBwListFlag()
    {
        return bwListFlag;
    }

    public void setBwListFlag(String bwListFlag)
    {
        this.bwListFlag = bwListFlag;
    }

    public List<ScreenNum> getScreenNums()
    {
        return screenNums;
    }

    public void setScreenNums(List<ScreenNum> screenNums)
    {
        this.screenNums = screenNums;
    }

    
}
