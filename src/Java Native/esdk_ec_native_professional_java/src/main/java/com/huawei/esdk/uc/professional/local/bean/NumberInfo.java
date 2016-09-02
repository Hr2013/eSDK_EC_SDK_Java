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
package com.huawei.esdk.uc.professional.local.bean;

public class NumberInfo
{
    /**
     * 企业内短号，数字字符串。
     */
    private String corpInterNumber;
    
    /**
     * 功能位模板Id
     */
    private Integer memberFuncFlagId;
    
    /**
     * 终端类型 0/1
     */
    private Integer terminalType;
    
    /**
     * 公网长号，数字字符串。
     */
    private String publicNumber;
    
    /**
     * 呼叫源Id，数字字符串，0~65534。BMP默认赋值0。
     */
    private String sourceId;
    
    /**
     * 呼出权限
     */
    private String outgoingRights;
    
    /**
     * IVR（交互式语音应答）语言类型 English/Chinese
     */
    private String languageName;
    
    // EC3.0 NEW ADD
    /**
     * 统一网关IP，长度为32字节
     */
    private String gwIp;
    
    /**
     * 本地网关id，可为空
     */
    private String localGwIp;
    
    /**
     * 是否联动：0是否，1为是
     */
    private String joint;
    
    /**
     * 权限级别：0：默认用户1：正常用户2：高级用户3：超级用户
     */
    private String rightLevel;
    
    /**
     * 是否自动添加字冠：0：否 1：是
     */
    private String addPrefix;
    
    /**
     * 是否鉴权：0不鉴权，1 IP鉴权，2密码鉴权，3密码和IP共同鉴权
     */
    private String type;
    
    /**
     * 鉴权密码
     */
    private String password;
    
    /**
     * 鉴权IP
     */
    private String ip;
    
    public String getCorpInterNumber()
    {
        return corpInterNumber;
    }
    
    public void setCorpInterNumber(String corpInterNumber)
    {
        this.corpInterNumber = corpInterNumber;
    }
    
    public Integer getMemberFuncFlagId()
    {
        return memberFuncFlagId;
    }
    
    public void setMemberFuncFlagId(Integer memberFuncFlagId)
    {
        this.memberFuncFlagId = memberFuncFlagId;
    }
    
    public Integer getTerminalType()
    {
        return terminalType;
    }
    
    public void setTerminalType(Integer terminalType)
    {
        this.terminalType = terminalType;
    }
    
    public String getPublicNumber()
    {
        return publicNumber;
    }
    
    public void setPublicNumber(String publicNumber)
    {
        this.publicNumber = publicNumber;
    }
    
    public String getSourceId()
    {
        return sourceId;
    }
    
    public void setSourceId(String sourceId)
    {
        this.sourceId = sourceId;
    }
    
    public String getOutgoingRights()
    {
        return outgoingRights;
    }
    
    public void setOutgoingRights(String outgoingRights)
    {
        this.outgoingRights = outgoingRights;
    }
    
    public String getLanguageName()
    {
        return languageName;
    }
    
    public void setLanguageName(String languageName)
    {
        this.languageName = languageName;
    }
    
    public String getGwIp()
    {
        return gwIp;
    }
    
    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
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
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
}
