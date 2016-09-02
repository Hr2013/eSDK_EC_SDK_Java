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

/** * @author w00208247 * * */
public class ContactNumBase
{
    private int index;// 联系号码编号,从1开始计数

    private String number;// 联系号码

    private String interNumber;// 内部号码

    private String numberDesc;// 号码描述

    
    public ContactNumBase(int index, String number, String interNumber,
            String numberDesc)
    {
        super();
        this.index = index;
        this.number = number;
        this.interNumber = interNumber;
        this.numberDesc = numberDesc;
    }

    /** *  */
    public ContactNumBase()
    {
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getInterNumber()
    {
        return interNumber;
    }

    public void setInterNumber(String interNumber)
    {
        this.interNumber = interNumber;
    }

    public String getNumberDesc()
    {
        return numberDesc;
    }

    public void setNumberDesc(String numberDesc)
    {
        this.numberDesc = numberDesc;
    }

}
