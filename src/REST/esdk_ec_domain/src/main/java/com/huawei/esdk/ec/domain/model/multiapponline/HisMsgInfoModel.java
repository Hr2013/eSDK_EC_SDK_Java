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
package com.huawei.esdk.ec.domain.model.multiapponline;

import java.util.List;

import com.huawei.esdk.ec.devices.app.multiapponline.IHisMsgCapability;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class HisMsgInfoModel
{
    private String total;
    
    private String sum;
    
    private List<HisMsgInfo> hisMsgInfoList;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        HisMsgInfoModel.deviceManager = deviceManager;
    }
    
    public SDKResult<HisMsgInfoModel> getHisMsg(HisMsg hisMsg)
        throws SDKException
    {
        IHisMsgCapability appInfoCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                IHisMsgCapability.class);
        return appInfoCapability.getHisMsg(hisMsg);
    }
    
    public String getTotal()
    {
        return total;
    }
    
    public void setTotal(String total)
    {
        this.total = total;
    }
    
    public String getSum()
    {
        return sum;
    }
    
    public void setSum(String sum)
    {
        this.sum = sum;
    }
    
    public List<HisMsgInfo> getHisMsgInfoList()
    {
        return hisMsgInfoList;
    }
    
    public void setHisMsgInfoList(List<HisMsgInfo> hisMsgInfoList)
    {
        this.hisMsgInfoList = hisMsgInfoList;
    }
    
}
