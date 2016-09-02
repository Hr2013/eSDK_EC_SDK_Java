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
package com.huawei.esdk.ec.domain.model;

import com.huawei.esdk.ec.device.obg.userprofile.UserProfileCapability;
import com.huawei.esdk.ec.domain.model.bean.EmployeeList;
import com.huawei.esdk.ec.domain.model.bean.EnterpriseList;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class PersonInfo
{
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    private String staffId;
    
    private String bindNum;
    
    private String staffAccount;
    
    private String name;
    
    private String headId;
    
    private String signature;
    
    private String sex;
    
    private String mobile;
    
    private String homePhone;
    
    private String fax;
    
    private String email;
    
    private String credit;
    
    private String underwrite;
    
    private String voip;
    
    private String otherPhone;
    
    private String addr;
    
    private String zip;
    
    private String seat;
    
    private String staffNO;
    
    private String shortPhone;
    
    private String officePhone;
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        PersonInfo.deviceManager = deviceManager;
    }
    
    public String getStaffId()
    {
        return staffId;
    }
    
    public void setStaffId(String staffId)
    {
        this.staffId = staffId;
    }
    
    public String getBindNum()
    {
        return bindNum;
    }
    
    public void setBindNum(String bindNum)
    {
        this.bindNum = bindNum;
    }
    
    public String getStaffAccount()
    {
        return staffAccount;
    }
    
    public void setStaffAccount(String staffAccount)
    {
        this.staffAccount = staffAccount;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getHeadId()
    {
        return headId;
    }
    
    public void setHeadId(String headId)
    {
        this.headId = headId;
    }
    
    public String getSignature()
    {
        return signature;
    }
    
    public void setSignature(String signature)
    {
        this.signature = signature;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public String getMobile()
    {
        return mobile;
    }
    
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    
    public String getHomePhone()
    {
        return homePhone;
    }
    
    public void setHomePhone(String homePhone)
    {
        this.homePhone = homePhone;
    }
    
    public String getFax()
    {
        return fax;
    }
    
    public void setFax(String fax)
    {
        this.fax = fax;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getCredit()
    {
        return credit;
    }
    
    public void setCredit(String credit)
    {
        this.credit = credit;
    }
    
    public String getUnderwrite()
    {
        return underwrite;
    }
    
    public void setUnderwrite(String underwrite)
    {
        this.underwrite = underwrite;
    }
    
    public String getVoip()
    {
        return voip;
    }
    
    public void setVoip(String voip)
    {
        this.voip = voip;
    }
    
    public String getOtherPhone()
    {
        return otherPhone;
    }
    
    public void setOtherPhone(String otherPhone)
    {
        this.otherPhone = otherPhone;
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
    
    public String getSeat()
    {
        return seat;
    }
    
    public void setSeat(String seat)
    {
        this.seat = seat;
    }
    
    public String getStaffNO()
    {
        return staffNO;
    }
    
    public void setStaffNO(String staffNO)
    {
        this.staffNO = staffNO;
    }
    
    public String getShortPhone()
    {
        return shortPhone;
    }
    
    public void setShortPhone(String shortPhone)
    {
        this.shortPhone = shortPhone;
    }
    
    public String getOfficePhone()
    {
        return officePhone;
    }
    
    public void setOfficePhone(String officePhone)
    {
        this.officePhone = officePhone;
    }
    
    public SDKResult<PersonInfo> queryPersonInfo(String account, String staffAccount)
        throws SDKException
    {
        UserProfileCapability userProfileCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileCapability.class);
        SDKResult<PersonInfo> result = userProfileCapability.queryPersonInfo(account, staffAccount);
        return result;
    }
    
    public SDKResult<PersonInfo> queryPersonInfoRest(String account, String staffAccount)
        throws SDKException
    {
        UserProfileCapability userProfileCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileCapability.class);
        SDKResult<PersonInfo> result = userProfileCapability.queryPersonInfo(account, staffAccount);
        return result;
    }
    
    public SDKResult<EmployeeList> queryEmployee(String account, String condition, int pagecount, int pagenum)
        throws SDKException
    {
        UserProfileCapability userProfileCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileCapability.class);
        SDKResult<EmployeeList> result = userProfileCapability.queryEmployee(account, condition, pagecount, pagenum);
        return result;
    }
    
    public SDKResult<EmployeeList> queryEmployeeRest(String account, String condition, int pagecount, int pagenum)
        throws SDKException
    {
        UserProfileCapability userProfileCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileCapability.class);
        SDKResult<EmployeeList> result = userProfileCapability.queryEmployee(account, condition, pagecount, pagenum);
        return result;
    }
    
    public SDKResult<EnterpriseList> queryEnterprise(String account, String deptId, int pagecount, int pagenum)
        throws SDKException
    {
        UserProfileCapability userProfileCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileCapability.class);
        SDKResult<EnterpriseList> result = userProfileCapability.queryEnterprise(account, deptId, pagecount, pagenum);
        return result;
    }
    
    public SDKResult<EnterpriseList> queryEnterpriseRest(String account, String deptId, int pagecount, int pagenum)
        throws SDKException
    {
        UserProfileCapability userProfileCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileCapability.class);
        SDKResult<EnterpriseList> result = userProfileCapability.queryEnterprise(account, deptId, pagecount, pagenum);
        return result;
    }
}
