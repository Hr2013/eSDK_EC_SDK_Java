package com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert;

import com.huawei.esdk.ec.domain.model.multiapponline.AppInfo;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.AppInfoResponse;

public class AppInfoResourceConvert
{
    
    /** 
     * 查询应用信息 转换方法
     * @author wangxiaobo/wWX233376
     * @param result
     * @return GetAppInfoResponse
     * @see [类、类#方法、类#成员]
     */
    public AppInfoResponse getAppInfoModel2Rest(AppInfo appInfo)
    {
        AppInfoResponse response = null;
        
        if (null != appInfo)
        {
            response = new AppInfoResponse();
            
            response.setAppID(appInfo.getAppID());
            response.setAppName(appInfo.getAppName());
            response.setAppDesc(appInfo.getAppDesc());
            response.setAppLogoUrl(appInfo.getAppLogoUrl());
            response.setResult(appInfo.getResult());
        }
        
        return response;
    }
    
}
