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

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.appserver.callback.NotifyCapabilityImpl;
import com.huawei.esdk.ec.device.appserver.ctc.CTCCapabilityImpl;
import com.huawei.esdk.ec.device.appserver.ctd.CTDCapabilityImpl;
import com.huawei.esdk.ec.device.appserver.im.IMCapabilityImpl;
import com.huawei.esdk.ec.device.appserver.multiapponline.HisMsgCapabilityImpl;
import com.huawei.esdk.ec.device.appserver.userprofile.UserProfileCapabilityImpl;
import com.huawei.esdk.ec.device.obg.ICTCCapability;
import com.huawei.esdk.ec.device.obg.ICTDCapability;
import com.huawei.esdk.ec.device.obg.IMCapability;
import com.huawei.esdk.ec.device.obg.INotifyCapability;
import com.huawei.esdk.ec.device.obg.userprofile.UserProfileCapability;
import com.huawei.esdk.ec.devices.app.multiapponline.IHisMsgCapability;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.commu.itf.IProtocolAdapterManager;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.nemgr.base.MultiConnDeviceBase;
import com.huawei.esdk.platform.nemgr.itf.IDeviceConnection;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class AppServerV3R1C00Device extends MultiConnDeviceBase
{
    private static final Logger LOGGER = Logger.getLogger(MultiConnDeviceBase.class);
    
    private IDeviceManager deviceManager = ApplicationContextUtil.getBean("deviceManager");
    
    protected IProtocolAdapterManager protocolAdapterManager = ApplicationContextUtil.getBean("protocolAdapterManager");
    
    /*
     * Service Access Point (URL)
     */
    private String sap;
    
    protected ISDKProtocolAdapter protocolAdapter;
    
    protected String getSap()
    {
        return sap;
    }
    
    protected void setSap(String sap)
    {
        this.sap = sap;
    }
    
    public AppServerV3R1C00Device(String sap)
    {
        this.sap = sap;
        this.protocolAdapter =
            (ISDKProtocolAdapter)protocolAdapterManager.getProtocolInstanceByType(ESDKConstant.PROTOCOL_ADAPTER_TYPE_REST_HTLS,
                sap);
        protocolAdapter.setSdkProtocolAdatperCustProvider(new UCAppServerRestCustProvider());
        
        prepareDeviceCapability(sap);
    }
    
    protected void prepareDeviceCapability(String sap)
    {
        LOGGER.debug("The SAP = " + sap);
        addServiceObjectMap(ICTDCapability.class, new CTDCapabilityImpl(this.protocolAdapter));
        addServiceObjectMap(ICTCCapability.class, new CTCCapabilityImpl(this.protocolAdapter));
        addServiceObjectMap(IMCapability.class, new IMCapabilityImpl(this.protocolAdapter));
        addServiceObjectMap(UserProfileCapability.class, new UserProfileCapabilityImpl(this.protocolAdapter));
        addServiceObjectMap(INotifyCapability.class, new NotifyCapabilityImpl(this.protocolAdapter));
        addServiceObjectMap(IHisMsgCapability.class, new HisMsgCapabilityImpl(this.protocolAdapter));
    }
    
    @Override
    public IDeviceConnection createConnection(String appId, String sap, String user, String pwd)
    {
        return (IDeviceConnection)new AppServerConnection(protocolAdapter, this, user, pwd);
    }
    
    @Override
    public void prepareAuthInfo(String user, String pwd)
    {
        prepareDevAuthInfo(user, pwd);
    }
    
    protected void prepareDevAuthInfo(String user, String pwd)
    {
        AccountInfo acctInfo = authorizePolicy.getDeviceAccountInfo(user, pwd);
        MessageContext mc = ThreadLocalHolder.get();
        mc.getEntities().put(ESDKConstant.DEVICE_USER_ID, acctInfo.getUserId());
        mc.getEntities().put(ESDKConstant.DEVICE_PLAIN_PWD, acctInfo.getPassword());
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
