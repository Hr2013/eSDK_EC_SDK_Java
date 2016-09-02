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

public class Attendee
{
    private String gwIp;
    
    private String confNo;
    
    private String operate;
    
    private String attNumber;
    
    private String attType;
    
    private String operNumber;
    
    private String oldChairman;
    
    private String newChairman;

    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }

    public String getConfNo()
    {
        return confNo;
    }

    public void setConfNo(String confNo)
    {
        this.confNo = confNo;
    }

    public String getOperate()
    {
        return operate;
    }

    public void setOperate(String operate)
    {
        this.operate = operate;
    }

    public String getAttNumber()
    {
        return attNumber;
    }

    public void setAttNumber(String attNumber)
    {
        this.attNumber = attNumber;
    }

    public String getAttType()
    {
        return attType;
    }

    public void setAttType(String attType)
    {
        this.attType = attType;
    }

    public String getOperNumber()
    {
        return operNumber;
    }

    public void setOperNumber(String operNumber)
    {
        this.operNumber = operNumber;
    }

    public String getOldChairman()
    {
        return oldChairman;
    }

    public void setOldChairman(String oldChairman)
    {
        this.oldChairman = oldChairman;
    }

    public String getNewChairman()
    {
        return newChairman;
    }

    public void setNewChairman(String newChairman)
    {
        this.newChairman = newChairman;
    }
    
}
