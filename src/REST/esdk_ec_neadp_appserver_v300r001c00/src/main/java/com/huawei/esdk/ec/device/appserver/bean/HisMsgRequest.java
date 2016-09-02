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
package com.huawei.esdk.ec.device.appserver.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author zwx365065
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "params")
public class HisMsgRequest
{
    /**
     * 第三方应用服务器的IP信息
     */
    @XmlElement(name = "accounts")
    private String accounts;
    
    /**
     * 群组ID
     */
    @XmlElement(name = "groupid")
    private String groupid;
    
    /**
     * 消息内容类型
     */
    @XmlElement(name = "contenttype")
    private String contenttype;
    
    /**
     * 条数
     */
    @XmlElement(name = "pagecount")
    private String pagecount;
    
    /**
     * 页码
     */
    @XmlElement(name = "pagenum")
    private String pagenum;
    
    /**
     * 开始时间
     */
    @XmlElement(name = "begintime")
    private String begintime;
    
    /**
     * 结束时间
     */
    @XmlElement(name = "endtime")
    private String endtime;
    
    public String getAccounts()
    {
        return accounts;
    }
    
    public void setAccounts(String accounts)
    {
        this.accounts = accounts;
    }
    
    public String getGroupid()
    {
        return groupid;
    }
    
    public void setGroupid(String groupid)
    {
        this.groupid = groupid;
    }
    
    public String getContenttype()
    {
        return contenttype;
    }
    
    public void setContenttype(String contenttype)
    {
        this.contenttype = contenttype;
    }
    
    public String getPagecount()
    {
        return pagecount;
    }
    
    public void setPagecount(String pagecount)
    {
        this.pagecount = pagecount;
    }
    
    public String getPagenum()
    {
        return pagenum;
    }
    
    public void setPagenum(String pagenum)
    {
        this.pagenum = pagenum;
    }
    
    public String getBegintime()
    {
        return begintime;
    }
    
    public void setBegintime(String begintime)
    {
        this.begintime = begintime;
    }
    
    public String getEndtime()
    {
        return endtime;
    }
    
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }
    
}
