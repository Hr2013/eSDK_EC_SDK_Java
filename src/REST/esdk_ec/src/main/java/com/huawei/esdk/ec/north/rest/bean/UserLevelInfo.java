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
package com.huawei.esdk.ec.north.rest.bean;

public class UserLevelInfo
{
    private String levelId;
    
    private String levelName;
    
    private String levelValue;
    
    private String description;
    
    public String getLevelId()
    {
        return levelId;
    }
    
    public void setLevelId(String levelId)
    {
        this.levelId = levelId;
    }
    
    public String getLevelName()
    {
        return levelName;
    }
    
    public void setLevelName(String levelName)
    {
        this.levelName = levelName;
    }
    
    public String getLevelValue()
    {
        return levelValue;
    }
    
    public void setLevelValue(String levelValue)
    {
        this.levelValue = levelValue;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
}
