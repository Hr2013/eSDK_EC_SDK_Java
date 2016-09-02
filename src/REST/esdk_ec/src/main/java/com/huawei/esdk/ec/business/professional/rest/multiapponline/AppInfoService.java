package com.huawei.esdk.ec.business.professional.rest.multiapponline;

import com.huawei.esdk.ec.domain.model.multiapponline.AppInfo;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class AppInfoService
{
    public SDKResult<AppInfo> getAppInfo(String appName, String applyTime)
        throws SDKException
    {
        return new AppInfo().getAppInfo(appName, applyTime);
    }
    
}
