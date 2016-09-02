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
package com.huawei.esdk.uc.professional.local.bean.south;

public class SipAccount
{
    /**
     * 统一网关IP
     */
    private String gwIp;
    
    /**
     * subpbx id
     */
    private String subPbx;
    
    /**
     * 本地网关ip
     */
    private String localGwIp;
    
    /**
     * 是否联动：0是否，1为是
     */
    private String joint;
    
    /**
     * SIP设备标识
     */
    private String sipUe;
    
    /**
     * 设备类型
     */
    private String ueType;
    
    /**
     * SIP号码
     */
    private String number;
    
    /**
     * 长号
     */
    private String longNum;
    
    private SipAuth sipAuth;
    
    /**
     * 权限级别
     */
    private String rightLevel;
    
    /**
     * 是否自动添加字冠：0为否，1为是
     */
    private String addPrefix;
    
    /**
     * 是否删除sipUe标识  0：不删除，1：删除 ?
     */
    /**
     * 删除设备或删除SIP号码：?
     * 0：删除SIP号码
     * 1：删除设备
     */
    private String deleteSipUe;
    
    //EC3.0 NEW ADD
    /**
     * 基本呼出权限
     */
    private String bOutgoingRights;
    
    /**
     * 自定义呼出权限
     */
    private String cOutgoingRights;
    
    /**
     * USM放号参数
     */
    private USMSip usmSip;
    
    public USMSip getUsmSip()
    {
        return usmSip;
    }
    
    public void setUsmSip(USMSip usmSip)
    {
        this.usmSip = usmSip;
    }
    
    public String getGwIp()
    {
        return gwIp;
    }
    
    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }
    
    public String getSubPbx()
    {
        return subPbx;
    }
    
    public void setSubPbx(String subPbx)
    {
        this.subPbx = subPbx;
    }
    
    public String getLocalGwIp()
    {
        return localGwIp;
    }
    
    public void setLocalGwIp(String localGwIp)
    {
        this.localGwIp = localGwIp;
    }
    
    public String getJoint()
    {
        return joint;
    }
    
    public void setJoint(String joint)
    {
        this.joint = joint;
    }
    
    public String getSipUe()
    {
        return sipUe;
    }
    
    public void setSipUe(String sipUe)
    {
        this.sipUe = sipUe;
    }
    
    public String getUeType()
    {
        return ueType;
    }
    
    public void setUeType(String ueType)
    {
        this.ueType = ueType;
    }
    
    public String getNumber()
    {
        return number;
    }
    
    public void setNumber(String number)
    {
        this.number = number;
    }
    
    public String getLongNum()
    {
        return longNum;
    }
    
    public void setLongNum(String longNum)
    {
        this.longNum = longNum;
    }
    
    public SipAuth getSipAuth()
    {
        return sipAuth;
    }
    
    public void setSipAuth(SipAuth sipAuth)
    {
        this.sipAuth = sipAuth;
    }
    
    public String getRightLevel()
    {
        return rightLevel;
    }
    
    public void setRightLevel(String rightLevel)
    {
        this.rightLevel = rightLevel;
    }
    
    public String getAddPrefix()
    {
        return addPrefix;
    }
    
    public void setAddPrefix(String addPrefix)
    {
        this.addPrefix = addPrefix;
    }
    
    public String getDeleteSipUe()
    {
        return deleteSipUe;
    }
    
    public void setDeleteSipUe(String deleteSipUe)
    {
        this.deleteSipUe = deleteSipUe;
    }
    
    public String getbOutgoingRights()
    {
        return bOutgoingRights;
    }
    
    public void setbOutgoingRights(String bOutgoingRights)
    {
        this.bOutgoingRights = bOutgoingRights;
    }
    
    public String getcOutgoingRights()
    {
        return cOutgoingRights;
    }
    
    public void setcOutgoingRights(String cOutgoingRights)
    {
        this.cOutgoingRights = cOutgoingRights;
    }
    
}
