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

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.AppUserStatesService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.north.rest.bean.RestResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.AppUserStatesRequest;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.AppUserStatesResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 应用用户状态资源对象
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Path("ec/eserver/appuserStates")
public class AppUserStatesResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(AppUserStatesResource.class);
    
    /**
     * 应用用户状态服务层对象
     */
    private static final AppUserStatesService APP_USER_STATES_SERVICE = new AppUserStatesService();
    
    /**
     * 应用用户状态资源转换对象
     */
    private static final AppUserStatesResourceConvert APP_USER_STATES_RESOURCE_CONVERT =
        new AppUserStatesResourceConvert();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<String> getAppUserStates(AppUserStatesRequest request)
    {
        RestResponse<String> response = new RestResponse<String>();
        
        // 参数判空
        if (null == request || StringUtils.isEmpty(request.getAppId()) || validateTargets(request.getTargets()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result =
                APP_USER_STATES_SERVICE.getAppUserStates(APP_USER_STATES_RESOURCE_CONVERT.getAppUserStatesRest2Model(request));
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            response.setResult(result.getResult());
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("getAppUserStates method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("getAppUserStates method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    private boolean validateTargets(List<String> strs)
    {
        if (null == strs || 0 == strs.size())
        {
            return true;
        }
        
        for (String str : strs)
        {
            if (StringUtils.isEmpty(str))
            {
                return true;
            }
        }
        
        return false;
    }
}
