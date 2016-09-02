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
package com.huawei.esdk.ec.device;

import com.huawei.ecs.client.ClientHandler;
import com.huawei.esdk.ec.device.eserver.im.IMCapabilityImpl;
import com.huawei.esdk.ec.device.eserver.multiapponline.AppInfoCapabilityImpl;
import com.huawei.esdk.ec.device.eserver.multiapponline.AppUserStatesCapabilityImpl;
import com.huawei.esdk.ec.device.eserver.multiapponline.GroupCapabilityImpl;
import com.huawei.esdk.ec.device.eserver.multiapponline.GroupIMCapabilityImpl;
import com.huawei.esdk.ec.device.eserver.presence.PresenceCapabilityImpl;
import com.huawei.esdk.ec.device.obg.IMCapability;
import com.huawei.esdk.ec.devices.eserver.IPresenceCapability;
import com.huawei.esdk.ec.devices.eserver.multiapponline.IAppInfoCapability;
import com.huawei.esdk.ec.devices.eserver.multiapponline.IAppUserStatesCapability;
import com.huawei.esdk.ec.devices.eserver.multiapponline.IGroupCapability;
import com.huawei.esdk.ec.devices.eserver.multiapponline.IGroupIMCapability;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.base.MultiConnDeviceBase;
import com.huawei.esdk.platform.nemgr.itf.IDeviceConnection;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class EServerV3R1C00Device extends MultiConnDeviceBase
{
    private IDeviceManager deviceManager = ApplicationContextUtil.getBean("deviceManager");
    
    private String sap;
    
    protected ClientHandler clientHandler;
    
    protected String getSap()
    {
        return sap;
    }
    
    protected void setSap(String sap)
    {
        this.sap = sap;
    }
    
    public EServerV3R1C00Device(String sap)
    {
        this.sap = sap;
        this.clientHandler = ClientHandler.getInstance();
        
        prepareDeviceCapability();
    }
    
    protected void prepareDeviceCapability()
    {
        addServiceObjectMap(IPresenceCapability.class, new PresenceCapabilityImpl(this.clientHandler));
        addServiceObjectMap(IMCapability.class, new IMCapabilityImpl(this.clientHandler));
        addServiceObjectMap(IAppInfoCapability.class, new AppInfoCapabilityImpl(this.clientHandler));
        addServiceObjectMap(IGroupCapability.class, new GroupCapabilityImpl(this.clientHandler));
        addServiceObjectMap(IGroupIMCapability.class, new GroupIMCapabilityImpl(this.clientHandler));
        addServiceObjectMap(IAppUserStatesCapability.class, new AppUserStatesCapabilityImpl(this.clientHandler));
    }
    
    @Override
    public IDeviceConnection createConnection(String appId, String sap, String user, String pwd)
    {
        return new EServerConnection(clientHandler, this, user, pwd);
    }
    
    @Override
    public void prepareAuthInfo(String user, String pwd)
    {
        
    }
    
    @Override
    public String getConnIdFromContext()
    {
        String id = "";
        MessageContext mc = ThreadLocalHolder.get();
        if (null != mc)
        {
            AccountInfo acctInfo = (AccountInfo)mc.getEntities().get(ESDKConstant.ACCT_INFO_ESDK);
            if (null != acctInfo)
            {
                AccountInfo devAcctInfo =
                    authorizePolicy.getDeviceAccountInfo(acctInfo.getUserId(), acctInfo.getPassword());
                id = devAcctInfo.getUserId();// + acctInfo.getPassword();
            }
        }
        return id;
    }
    
    @Override
    public Boolean releaseConns()
    {
        for (String key : id2Connection.keySet())
        {
            IDeviceConnection conn = id2Connection.get(key);
            deviceManager.releaseConn(conn);
        }
        return true;
    }
    
}
