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

import com.huawei.esdk.ec.devices.eserver.IPresenceCapability;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * 用户状态Domain层
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  com.huawei.esdk.ec.domain.model.UserState
 * @since  eSDK EC V100R003C00
 */
public class UserState
{
    private int code;
    
    private long sno;
    
    private long stamp;
    
    private String extParams;
    
    private String priorityLevel;
    
    private String origin;
    
    private String target;
    
    private int oldState;
    
    private int newState;
    
    private String oldStateDesc;
    
    private String newStateDesc;
    
    private int clientType;
    
    private String clientDesc;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        UserState.deviceManager = deviceManager;
    }
    
    public SDKResult<UserStateListAck> queryUCPresence(List<String> ucAccount)
        throws SDKException
    {
        IPresenceCapability presenceCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IPresenceCapability.class);
        return presenceCapability.queryUCPresence(ucAccount);
    }
    
    public int getCode()
    {
        return code;
    }
    
    public void setCode(int code)
    {
        this.code = code;
    }
    
    public long getSno()
    {
        return sno;
    }
    
    public void setSno(long sno)
    {
        this.sno = sno;
    }
    
    public long getStamp()
    {
        return stamp;
    }
    
    public void setStamp(long stamp)
    {
        this.stamp = stamp;
    }
    
    public String getExtParams()
    {
        return extParams;
    }
    
    public void setExtParams(String extParams)
    {
        this.extParams = extParams;
    }
    
    public String getPriorityLevel()
    {
        return priorityLevel;
    }
    
    public void setPriorityLevel(String priorityLevel)
    {
        this.priorityLevel = priorityLevel;
    }
    
    public String getOrigin()
    {
        return origin;
    }
    
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }
    
    public String getTarget()
    {
        return target;
    }
    
    public void setTarget(String target)
    {
        this.target = target;
    }
    
    public int getOldState()
    {
        return oldState;
    }
    
    public void setOldState(int oldState)
    {
        this.oldState = oldState;
    }
    
    public int getNewState()
    {
        return newState;
    }
    
    public void setNewState(int newState)
    {
        this.newState = newState;
    }
    
    public String getOldStateDesc()
    {
        return oldStateDesc;
    }
    
    public void setOldStateDesc(String oldStateDesc)
    {
        this.oldStateDesc = oldStateDesc;
    }
    
    public String getNewStateDesc()
    {
        return newStateDesc;
    }
    
    public void setNewStateDesc(String newStateDesc)
    {
        this.newStateDesc = newStateDesc;
    }
    
    public int getClientType()
    {
        return clientType;
    }
    
    public void setClientType(int clientType)
    {
        this.clientType = clientType;
    }
    
    public String getClientDesc()
    {
        return clientDesc;
    }
    
    public void setClientDesc(String clientDesc)
    {
        this.clientDesc = clientDesc;
    }
    
}
