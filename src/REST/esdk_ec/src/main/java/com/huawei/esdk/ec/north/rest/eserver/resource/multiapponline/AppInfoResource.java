/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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
package com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.AppInfoService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.multiapponline.AppInfo;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.AppInfoResponse;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.AppInfoResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 应用资源对象
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Path("ec/eserver/getAppInfo")
public class AppInfoResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(AppInfoResource.class);
    
    /**
     * 应用服务层对象
     */
    private static final AppInfoService APPINFO_SERVICE = new AppInfoService();
    
    /**
     * 应用资源转换对象
     */
    private static final AppInfoResourceConvert APPINFO_RESOURCE_CONVERT = new AppInfoResourceConvert();
    
    /** 
     * 查询应用信息
     * 
     * @author wangxiaobo/wWX233376
     * @param userId 操作者标识
     * @param appName 应用名称
     * @param applyTime 查询时间
     * @return
     * @see [类、类#方法、类#成员]
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AppInfoResponse getAppInfo(@QueryParam("appName") String appName, @QueryParam("applyTime") String applyTime)
    {
        AppInfoResponse response = new AppInfoResponse();
        
        // 参数判空
        if (StringUtils.isEmpty(appName))
        {
            response.setResult(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            return response;
        }
        
        try
        {
            
            SDKResult<AppInfo> result = APPINFO_SERVICE.getAppInfo(appName, applyTime);
            response = APPINFO_RESOURCE_CONVERT.getAppInfoModel2Rest(result.getResult());
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("getAppInfo method SDK error", e);
            response.setResult(String.valueOf(e.getSdkErrCode()));
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("getAppInfo method error", e);
            response.setResult(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            return response;
        }
    }
}
