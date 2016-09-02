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

public class QueryAttendeeInfo
{
    /**
     * 网关IP
     */
    private String gwIp;
    
    /**
     * 会议厅号
     */
    //private String confNo;
    
    /**
     * 会议ID
     */
    private String confId;
    
    /**
     * 用户姓名或账号
     */
    private String account;
    
    /**
     * 与会人号码
     */
    private String attNumber;
    
    /**
     * 与会者类型: 0可听，可说   1只听，不说   2只说，不听 3主席
     */
    private String attType;
    
    /**
     * 与会者状态： 0离会    1等待    2连接中    3已进入
     */
    private String attStatus;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 数据会议链接
     */
    private String dataUrl;

    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }

//    public String getConfNo()
//    {
//        return confNo;
//    }
//
//    public void setConfNo(String confNo)
//    {
//        this.confNo = confNo;
//    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
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

    public String getAttStatus()
    {
        return attStatus;
    }

    public void setAttStatus(String attStatus)
    {
        this.attStatus = attStatus;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
    }

    public String getDataUrl()
    {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl)
    {
        this.dataUrl = dataUrl;
    }
    
}
