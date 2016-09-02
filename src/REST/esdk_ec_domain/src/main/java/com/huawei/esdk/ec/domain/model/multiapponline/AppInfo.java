package com.huawei.esdk.ec.domain.model.multiapponline;

import com.huawei.esdk.ec.devices.eserver.multiapponline.IAppInfoCapability;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class AppInfo
{
    private String appID;
    
    private String appName;
    
    private String appDesc;
    
    private String appLogoUrl;
    
    private String result;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        AppInfo.deviceManager = deviceManager;
    }
    
    public SDKResult<AppInfo> getAppInfo(String appName, String applyTime)
        throws SDKException
    {
        IAppInfoCapability appInfoCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IAppInfoCapability.class);
        return appInfoCapability.getAppInfo(appName, applyTime);
    }
    
    public String getAppID()
    {
        return appID;
    }
    
    public void setAppID(String appID)
    {
        this.appID = appID;
    }
    
    public String getAppName()
    {
        return appName;
    }
    
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    
    public String getAppDesc()
    {
        return appDesc;
    }
    
    public void setAppDesc(String appDesc)
    {
        this.appDesc = appDesc;
    }
    
    public String getAppLogoUrl()
    {
        return appLogoUrl;
    }
    
    public void setAppLogoUrl(String appLogoUrl)
    {
        this.appLogoUrl = appLogoUrl;
    }
    
    public String getResult()
    {
        return result;
    }
    
    public void setResult(String result)
    {
        this.result = result;
    }
}
