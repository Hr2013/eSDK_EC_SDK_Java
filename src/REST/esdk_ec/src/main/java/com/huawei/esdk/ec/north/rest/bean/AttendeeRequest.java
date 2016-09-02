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

public class AttendeeRequest
{
    /**
     * 操作用户
     */
    private String userId;
    
    /**
     * 网关IP
     */
    private String gwIp;
    
    /**
     * 虚拟PBX ID
     */
    private String subPbx;
    
    /**
     * 会议厅号
     */
//    private String confNo;
    
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
    //private String attStatus;
    
    /**
     * 麦克风，话筒状态（可选）
     */
    //private String speakStatus;
    
    /**
     * 邮箱（可选）
     */
    private String email;
    
    /**
     * 旧主席
     */
    private String oldChairman;
    
    /**
     * 新主席
     */
    private String newChairman;
    
    /**
     * 操作与会者类型: 0:踢出，1:邀请 
     */
    private String operate;
    
    /**
     * 操作人号码
     */
    private String operNumber;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

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

//    public String getAttStatus()
//    {
//        return attStatus;
//    }
//
//    public void setAttStatus(String attStatus)
//    {
//        this.attStatus = attStatus;
//    }

//    public String getSpeakStatus()
//    {
//        return speakStatus;
//    }
//
//    public void setSpeakStatus(String speakStatus)
//    {
//        this.speakStatus = speakStatus;
//    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSubPbx()
    {
        return subPbx;
    }

    public void setSubPbx(String subPbx)
    {
        this.subPbx = subPbx;
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

    public String getOperate()
    {
        return operate;
    }

    public void setOperate(String operate)
    {
        this.operate = operate;
    }

    public String getOperNumber()
    {
        return operNumber;
    }

    public void setOperNumber(String operNumber)
    {
        this.operNumber = operNumber;
    }

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
}
