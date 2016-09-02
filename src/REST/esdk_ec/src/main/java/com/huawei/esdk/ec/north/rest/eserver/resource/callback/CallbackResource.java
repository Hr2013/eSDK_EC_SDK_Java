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
package com.huawei.esdk.ec.north.rest.eserver.resource.callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.base.BaseResource;
import com.huawei.esdk.ec.business.professional.rest.common.ECRestCallbackRegisterService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.north.rest.bean.MessageNotification;
import com.huawei.esdk.ec.north.rest.bean.MessageNotifications;
import com.huawei.esdk.ec.north.rest.bean.RestErrCode;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/eserver/callback")
public class CallbackResource extends BaseResource
{
    private static final Logger LOGGER = Logger.getLogger(CallbackResource.class);
    
    private ECRestCallbackRegisterService callbackService = ApplicationContextUtil.getBean("ecRestCallbackRegisterService");
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode registerNotification(MessageNotifications messageNotifications)
    {
        RestErrCode resBean = new RestErrCode();
        
        if (null == messageNotifications || null == messageNotifications.getCallbackUrls()
        		|| messageNotifications.getCallbackUrls().isEmpty())
        {
            resBean.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            resBean.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return resBean;
        }
        
        Map<String, String> map = new HashMap<String, String>();
        
        for (MessageNotification messageNotification : messageNotifications.getCallbackUrls())
        {
            if (StringUtils.isEmpty(messageNotification.getModule())
            		|| StringUtils.isEmpty(messageNotification.getWsUri()))
            {
                resBean.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
                resBean.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
                return resBean;
            }
            map.put(messageNotification.getModule(), messageNotification.getWsUri());
        }
        
        try
        {
            SDKErrorCode result = callbackService.register(map);
            
            resBean.setResultCode(result.getErrCode() + "");
            resBean.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return resBean;
        }
        catch (Exception e)
        {
            LOGGER.error("registerNotification method error", e);
            resBean.setResultCode(String.valueOf(ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR));
            resBean.setResultContext("eSDK system error");
            return resBean;
        }
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode unRegister(@QueryParam("modules") String modules)
    {
        RestErrCode resBean = new RestErrCode();
        if (StringUtils.isEmpty(modules))
        {
            resBean.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            resBean.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return resBean;
        }
        try
        {
            List<String> moduleList = new ArrayList<String>();
            for (String module : modules.split(","))
            {
                if (!StringUtils.isEmpty(module))
                {
                    moduleList.add(module);
                }
            }
            
            SDKErrorCode result = callbackService.unregister(moduleList);
            
            resBean.setResultCode(result.getErrCode() + "");
            resBean.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return resBean;
        }
        catch (Exception e)
        {
            LOGGER.error("unRegister method error", e);
            resBean.setResultCode(String.valueOf(ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR));
            resBean.setResultContext("eSDK system error");
            return resBean;
        }
    }
    
}
