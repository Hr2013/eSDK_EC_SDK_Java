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

import com.huawei.esdk.ec.device.obg.userprofile.UserProfileCapability;
import com.huawei.esdk.ec.domain.model.bean.Address;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class AddressListInfo
{
    /**
     * 搜索结果集中成员的总数
     */
    private int total;
    
    /**
     * 当前分页消息中成员的数量
     */
    private int sum;
    
    /**
     * 个人通讯录
     */
    private List<Address> addresses;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        AddressListInfo.deviceManager = deviceManager;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public int getSum()
    {
        return sum;
    }
    
    public void setSum(int sum)
    {
        this.sum = sum;
    }
    
    public List<Address> getAddresses()
    {
        return addresses;
    }
    
    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }
    
    public SDKResult<AddressListInfo> queryAddrList(String account, String condition, int pagecount, int pagenum)
        throws SDKException
    {
        UserProfileCapability userProfileCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileCapability.class);
        SDKResult<AddressListInfo> result = userProfileCapability.queryAddrList(account, condition, pagecount, pagenum);
        return result;
    }
    
    public SDKResult<AddressListInfo> queryAddrListRest(String account, String condition, int pagecount, int pagenum)
        throws SDKException
    {
        UserProfileCapability userProfileCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfileCapability.class);
        SDKResult<AddressListInfo> result = userProfileCapability.queryAddrList(account, condition, pagecount, pagenum);
        return result;
    }
}
