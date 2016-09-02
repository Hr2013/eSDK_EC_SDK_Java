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

public class StaffInfo extends StaffInfoBase
{
    private String ucURL; // 成员URL，软终端路由号码

    private String foreignName; // 成员英文名

    private String spinyin; // 首拼音

    private String vip;

    private String level; // 级别


    public String getUcURL()
    {
        return ucURL;
    }

    public void setUcURL(String ucURL)
    {
        this.ucURL = ucURL;
    }

    public String getForeignName()
    {
        return foreignName;
    }

    public void setForeignName(String foreignName)
    {
        this.foreignName = foreignName;
    }

    public String getSpinyin()
    {
        return spinyin;
    }

    public void setSpinyin(String spinyin)
    {
        this.spinyin = spinyin;
    }

    public String getVip()
    {
        return vip;
    }

    public void setVip(String vip)
    {
        this.vip = vip;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

}
