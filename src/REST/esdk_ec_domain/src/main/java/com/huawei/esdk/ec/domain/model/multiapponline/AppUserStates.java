package com.huawei.esdk.ec.domain.model.multiapponline;

import java.util.List;

import com.huawei.esdk.ec.devices.eserver.multiapponline.IAppUserStatesCapability;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class AppUserStates extends MultiAppOnlineModel
{
    private String user;
    
    private List<String> targets;
    
    private String appId;
    
    private String senderType;
    
    private String result;
    
    private List<EsdkUserState> targetStateList;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        AppUserStates.deviceManager = deviceManager;
    }
    
    public SDKResult<String> getAppUserStates(AppUserStates userStates)
        throws SDKException
    {
        IAppUserStatesCapability appUserStatesCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IAppUserStatesCapability.class);
        return appUserStatesCapability.getAppUserStates(userStates);
    }
    
    public String getUser()
    {
        return user;
    }
    
    public void setUser(String user)
    {
        this.user = user;
    }
    
    public List<String> getTargets()
    {
        return targets;
    }
    
    public void setTargets(List<String> targets)
    {
        this.targets = targets;
    }
    
    public String getAppId()
    {
        return appId;
    }
    
    public void setAppId(String appId)
    {
        this.appId = appId;
    }
    
    public String getSenderType()
    {
        return senderType;
    }
    
    public void setSenderType(String senderType)
    {
        this.senderType = senderType;
    }
    
    public String getResult()
    {
        return result;
    }
    
    public void setResult(String result)
    {
        this.result = result;
    }
    
    public List<EsdkUserState> getTargetStateList()
    {
        return targetStateList;
    }
    
    public void setTargetStateList(List<EsdkUserState> targetStateList)
    {
        this.targetStateList = targetStateList;
    }
}
