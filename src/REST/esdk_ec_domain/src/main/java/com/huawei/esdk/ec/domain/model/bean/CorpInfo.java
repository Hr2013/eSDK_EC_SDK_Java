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

import java.util.Date;

/**
 * * @author j00213891 * * 企业信息
 */
public class CorpInfo
{
	// 企业ID,全局唯一
    private String corpId; 

    // 公司值班号码（不是集团总机号码）
    private String corpOnlinePhone; 

    // 联系人
    private String linkman;

    // 证件类别-1：身份证；2：军官证；3：学生证
    private String linkmanCardType; 

    // 联系人身份证号
    private String linkmanCardNo; 

    // 联系人座机
    private String linkPhone;

    // 联系人手机
    private String linkMobile;

    // 联系人邮箱
    private String linkMail;

    // 传真
    private String fax;

    // 地址
    private String addr;

    // 邮编
    private String zip;

    // 企业所属省份ID
    private String provinceId; 

    // 企业所属地区ID
    private String areaId; 

    // 企业所属城市ID
    private String cityId;

    // Web地址
    private String webUrl;

    // Wap地址
    private String wapUrl;

    // 父企业ID
    private String parentCorpId;

    // 企业帐号
    private String corpAccount;

    // 企业域名，全局唯一
    private String corpDomain;

    // 企业名称
    private String corpName;

    // 企业简称
    private String shortName;

    // 企业英文名称
    private String corpForeignName;

    // 企业描述
    private String corpDesc;

    // 企业性质： 0：国营 1：集体 2：私营 3：股份制 4：中外合资 5：外商独资
    private String corpType;

    // 企业等级： 0 : A类企业 1 : B类企业 2: C类企业
    private String corpRank; 

    // 销户日期
    private String cancelDate; 

    // 销户原因;
    private String cancelReason;

    // 企业开户时间
    private Date createTime; 

    // 最近修改时间
    private Date modifyTime;

    // 状态有3种： 0：正常 1：删除 2：暂停
    private String status; 

    public String getCorpId()
    {
        return corpId;
    }

    public void setCorpId(String corpId)
    {
        this.corpId = corpId;
    }

    public String getCorpOnlinePhone()
    {
        return corpOnlinePhone;
    }

    public void setCorpOnlinePhone(String corpOnlinePhone)
    {
        this.corpOnlinePhone = corpOnlinePhone;
    }

    public String getLinkman()
    {
        return linkman;
    }

    public void setLinkman(String linkman)
    {
        this.linkman = linkman;
    }

    public String getLinkmanCardType()
    {
        return linkmanCardType;
    }

    public void setLinkmanCardType(String linkmanCardType)
    {
        this.linkmanCardType = linkmanCardType;
    }

    public String getLinkmanCardNo()
    {
        return linkmanCardNo;
    }

    public void setLinkmanCardNo(String linkmanCardNo)
    {
        this.linkmanCardNo = linkmanCardNo;
    }

    public String getLinkPhone()
    {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone)
    {
        this.linkPhone = linkPhone;
    }

    public String getLinkMobile()
    {
        return linkMobile;
    }

    public void setLinkMobile(String linkMobile)
    {
        this.linkMobile = linkMobile;
    }

    public String getLinkMail()
    {
        return linkMail;
    }

    public void setLinkMail(String linkMail)
    {
        this.linkMail = linkMail;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }

    public String getAddr()
    {
        return addr;
    }

    public void setAddr(String addr)
    {
        this.addr = addr;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getProvinceId()
    {
        return provinceId;
    }

    public void setProvinceId(String provinceId)
    {
        this.provinceId = provinceId;
    }

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getCityId()
    {
        return cityId;
    }

    public void setCityId(String cityId)
    {
        this.cityId = cityId;
    }

    public String getWebUrl()
    {
        return webUrl;
    }

    public void setWebUrl(String webUrl)
    {
        this.webUrl = webUrl;
    }

    public String getWapUrl()
    {
        return wapUrl;
    }

    public void setWapUrl(String wapUrl)
    {
        this.wapUrl = wapUrl;
    }

    public String getParentCorpId()
    {
        return parentCorpId;
    }

    public void setParentCorpId(String parentCorpId)
    {
        this.parentCorpId = parentCorpId;
    }

    public String getCorpAccount()
    {
        return corpAccount;
    }

    public void setCorpAccount(String corpAccount)
    {
        this.corpAccount = corpAccount;
    }

    public String getCorpDomain()
    {
        return corpDomain;
    }

    public void setCorpDomain(String corpDomain)
    {
        this.corpDomain = corpDomain;
    }

    public String getCorpName()
    {
        return corpName;
    }

    public void setCorpName(String corpName)
    {
        this.corpName = corpName;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public String getCorpForeignName()
    {
        return corpForeignName;
    }

    public void setCorpForeignName(String corpForeignName)
    {
        this.corpForeignName = corpForeignName;
    }

    public String getCorpDesc()
    {
        return corpDesc;
    }

    public void setCorpDesc(String corpDesc)
    {
        this.corpDesc = corpDesc;
    }

    public String getCorpType()
    {
        return corpType;
    }

    public void setCorpType(String corpType)
    {
        this.corpType = corpType;
    }

    public String getCorpRank()
    {
        return corpRank;
    }

    public void setCorpRank(String corpRank)
    {
        this.corpRank = corpRank;
    }

    public String getCancelDate()
    {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate)
    {
        this.cancelDate = cancelDate;
    }

    public String getCancelReason()
    {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason)
    {
        this.cancelReason = cancelReason;
    }

    public Date getCreateTime()
    {
        if(createTime == null)
            return null;
        return (Date)createTime.clone();
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = (Date)createTime.clone();
    }

    public Date getModifyTime()
    {
        if(modifyTime == null)
            return null;
        return (Date)modifyTime.clone();
    }

    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = (Date)modifyTime.clone();
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

}
