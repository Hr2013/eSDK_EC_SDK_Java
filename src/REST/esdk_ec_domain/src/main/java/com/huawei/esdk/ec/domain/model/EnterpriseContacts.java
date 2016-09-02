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

import java.util.List;

import com.huawei.esdk.ec.device.obg.userprofile.UserProfileEnterpriseListCapability;
import com.huawei.esdk.ec.domain.model.bean.CorpInfo;
import com.huawei.esdk.ec.domain.model.bean.DeptInfo;
import com.huawei.esdk.ec.domain.model.bean.DeptInfoBase;
import com.huawei.esdk.ec.domain.model.bean.OffsetQryStaffCond;
import com.huawei.esdk.ec.domain.model.bean.PageQryStaffCond;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryDeptCond;
import com.huawei.esdk.ec.domain.model.bean.QueryModeInfo;
import com.huawei.esdk.ec.domain.model.bean.StaffInfo;
import com.huawei.esdk.ec.domain.model.bean.StaffInfoBase;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * * @author j00213891 * *企业通讯录
 */
public class EnterpriseContacts extends Contacts
{
    // 企业详情
    private CorpInfo corpInfo;

    // 部门信息列表
    private List<DeptInfoBase> deptInfoBaseList;

    // 雇员基本信息列表
    private List<StaffInfoBase> staffInfoBaseList;
    
    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
    .getBean("deviceManager");

    public static IDeviceManager getDeviceManager()
    {
    return deviceManager;
    }

    // 企业详细信息查询
    public SDKResult<CorpInfo> queryEnterpriseInfo() throws SDKException
    {
        UserProfileEnterpriseListCapability userProfile  = deviceManager.getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileEnterpriseListCapability.class);
        return userProfile.queryEnterpriseInfo();
    }

    // 企业部门搜索
    public SDKResult<PagedList<DeptInfoBase>> queryDeptListInfo(QueryModeInfo modeInfo,
            QueryDeptCond deptCond) throws SDKException
    {
        UserProfileEnterpriseListCapability userProfile  = deviceManager.getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileEnterpriseListCapability.class);
        return userProfile.queryDeptListInfo(modeInfo, deptCond);
    }

    // 企业部门详细信息查询
    public SDKResult<DeptInfo> queryDeptInfo(String deptId) throws SDKException
    {
        UserProfileEnterpriseListCapability userProfile  = deviceManager.getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileEnterpriseListCapability.class);
        return userProfile.queryDeptInfo(deptId);
    }

    // 企业通讯录搜索
    public SDKResult<PagedList<StaffInfoBase>> queryStaffList(String ucAccount,
            QueryModeInfo tListInfo, OffsetQryStaffCond tOffsetQryStaffCond,
            PageQryStaffCond tPageQryStaffCond) throws SDKException
    {
    	UserProfileEnterpriseListCapability userProfile  = deviceManager.getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileEnterpriseListCapability.class);
        return userProfile.queryStaffList(ucAccount, tListInfo, tOffsetQryStaffCond, tPageQryStaffCond);
    }

    // 企业成员详情查询
    public SDKResult<StaffInfo> queryStaffInfo(String ucNum) throws SDKException
    {
    	UserProfileEnterpriseListCapability userProfile  = deviceManager.getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileEnterpriseListCapability.class);
        return userProfile.queryStaffInfo(ucNum);
    }

    /** * @return the corpInfo */
    public CorpInfo getCorpInfo()
    {
        return corpInfo;
    }

    /** * @param corpInfo the corpInfo to set */
    public void setCorpInfo(CorpInfo corpInfo)
    {
        this.corpInfo = corpInfo;
    }

    /** * @return the deptInfoBaseList */
    public List<DeptInfoBase> getDeptInfoBaseList()
    {
        return deptInfoBaseList;
    }

    /** * @param deptInfoBaseList the deptInfoBaseList to set */
    public void setDeptInfoBaseList(List<DeptInfoBase> deptInfoBaseList)
    {
        this.deptInfoBaseList = deptInfoBaseList;
    }

    /** * @return the staffInfoBaseList */
    public List<StaffInfoBase> getStaffInfoBaseList()
    {
        return staffInfoBaseList;
    }

    /** * @param staffInfoBaseList the staffInfoBaseList to set */
    public void setStaffInfoBaseList(List<StaffInfoBase> staffInfoBaseList)
    {
        this.staffInfoBaseList = staffInfoBaseList;
    }
}
