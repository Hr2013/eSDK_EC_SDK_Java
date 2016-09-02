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
@XmlRootElement(name = "QueryLogAuditParam")
public class QueryLogAuditParam
{
    @XmlElement(name = "account")
    private String account;
    
    @XmlElement(name = "starttime")
    private String starttime;
    
    @XmlElement(name = "endtime")
    private String endtime;
    
    @XmlElement(name = "pagecount")
    private int pagecount;
    
    @XmlElement(name = "pagenum")
    private int pagenum;
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
    public String getStarttime()
    {
        return starttime;
    }
    
    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }
    
    public String getEndtime()
    {
        return endtime;
    }
    
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }
    
    public int getPagecount()
    {
        return pagecount;
    }
    
    public void setPagecount(int pagecount)
    {
        this.pagecount = pagecount;
    }
    
    public int getPagenum()
    {
        return pagenum;
    }
    
    public void setPagenum(int pagenum)
    {
        this.pagenum = pagenum;
    }
}
