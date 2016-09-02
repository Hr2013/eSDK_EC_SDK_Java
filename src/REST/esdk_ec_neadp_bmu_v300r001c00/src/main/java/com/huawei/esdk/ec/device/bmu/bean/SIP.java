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
package com.huawei.esdk.ec.device.bmu.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "SIP")
public class SIP
{
    /**
     * 统一网关IP
     */
    @XmlElement(name = "gwip")
    private String gwIp;
    
    /**
     * subpbx id
     */
    @XmlElement(name = "subpbx")
    private String subPbx;
    
    /**
     * 本地网关ip
     */
    @XmlElement(name = "localgwip")
    private String localGwIp;
    
    /**
     * 是否联动：0是否，1为是
     */
    @XmlElement(name = "joint")
    private String joint;
    
    /**
     * SIP设备标识
     */
    @XmlElement(name = "sipue")
    private String sipUe;
    
    /**
     * 设备步长
     */
    @XmlElement(name = "uestep")
    private String ueStep;
    
    /**
     * 设备类型
     */
    @XmlElement(name = "uetype")
    private String ueType;
    
    /**
     * SIP号码
     */
    @XmlElement(name = "number")
    private String number;
    
    /**
     * 长号
     */
    @XmlElement(name = "longnum")
    private String longNum;
    
    /**
     * 号码步长
     */
    @XmlElement(name = "numstep")
    private String numStep;
    
    /**
     * 号码数量
     */
    @XmlElement(name = "amount")
    private String amount;
    
    @XmlElement(name = "authenticate")
    private SIPAuth sipAuth;
    
    /**
     * 权限级别
     */
    @XmlElement(name = "rightlevel")
    private String rightLevel;
    
    /**
     * 是否自动添加字冠：0为否，1为是
     */
    @XmlElement(name = "addprefix")
    private String addPrefix;
    
    //EC3.0 NEW ADD
    /**
     * 基本呼出权限
     */
    @XmlElement(name = "boutgoingrights")
    private String bOutgoingRights;
    
    /**
     * 自定义呼出权限
     */
    @XmlElement(name = "coutgoingrights")
    private String cOutgoingRights;
    
    /**
     * 所属站点组名称
     */
    @XmlElement(name = "stationgroupname")
    private String stationGroupName;
    
    /**
     * 注册服务器ID
     */
    @XmlElement(name = "sipserverid")
    private String sipServerId;
    
    /**
     * 本地网关名称
     */
    @XmlElement(name = "localgwname")
    private String localGwName;
    
    /**
     * 是否同步本地网关
     */
    @XmlElement(name = "issynclocalgw")
    private String isSyncLocalGw;
    
    /**
     * 呼叫源码
     */
    @XmlElement(name = "sourcecode")
    private String sourceCode;
    
    /**
     * 媒体资源组名称
     */
    @XmlElement(name = "mrgroupname")
    private String mrGroupName;
    
    /**
     * 权限组名称
     */
    @XmlElement(name = "crgname")
    private String crgName;
    
    /**
     * 所属VoIP域名称
     */
    @XmlElement(name = "domainname")
    private String domainName;
    
    public String getGwIp()
    {
        return gwIp;
    }
    
    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }
    
    public String getJoint()
    {
        return joint;
    }
    
    public void setJoint(String joint)
    {
        this.joint = joint;
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
    
    public SIPAuth getSipAuth()
    {
        return sipAuth;
    }
    
    public void setSipAuth(SIPAuth sipAuth)
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
    
    public String getUeStep()
    {
        return ueStep;
    }
    
    public void setUeStep(String ueStep)
    {
        this.ueStep = ueStep;
    }
    
    public String getNumStep()
    {
        return numStep;
    }
    
    public void setNumStep(String numStep)
    {
        this.numStep = numStep;
    }
    
    public String getAmount()
    {
        return amount;
    }
    
    public void setAmount(String amount)
    {
        this.amount = amount;
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
    
    public String getSipUe()
    {
        return sipUe;
    }
    
    public void setSipUe(String sipUe)
    {
        this.sipUe = sipUe;
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
    
    public String getStationGroupName()
    {
        return stationGroupName;
    }
    
    public void setStationGroupName(String stationGroupName)
    {
        this.stationGroupName = stationGroupName;
    }
    
    public String getSipServerId()
    {
        return sipServerId;
    }
    
    public void setSipServerId(String sipServerId)
    {
        this.sipServerId = sipServerId;
    }
    
    public String getLocalGwName()
    {
        return localGwName;
    }
    
    public void setLocalGwName(String localGwName)
    {
        this.localGwName = localGwName;
    }
    
    public String getIsSyncLocalGw()
    {
        return isSyncLocalGw;
    }
    
    public void setIsSyncLocalGw(String isSyncLocalGw)
    {
        this.isSyncLocalGw = isSyncLocalGw;
    }
    
    public String getSourceCode()
    {
        return sourceCode;
    }
    
    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
    }
    
    public String getMrGroupName()
    {
        return mrGroupName;
    }
    
    public void setMrGroupName(String mrGroupName)
    {
        this.mrGroupName = mrGroupName;
    }
    
    public String getCrgName()
    {
        return crgName;
    }
    
    public void setCrgName(String crgName)
    {
        this.crgName = crgName;
    }
    
    public String getDomainName()
    {
        return domainName;
    }
    
    public void setDomainName(String domainName)
    {
        this.domainName = domainName;
    }
}
