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
package com.huawei.esdk.ec.north.rest.eserver.resource.im;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.im.IMService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.GroupInstanceMessage;
import com.huawei.esdk.ec.north.rest.bean.RestErrCode;
import com.huawei.esdk.ec.north.rest.bean.eserver.AppSendMsgToGroup;
import com.huawei.esdk.ec.north.rest.eserver.resource.im.convert.IMResourceConvert;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/eserver/appSendMsgToGroup")
public class AppSendMsgToGroupResource
{
    private static final Logger LOGGER = Logger.getLogger(AppSendMsgToGroupResource.class);
    
    private IMService imService = new IMService();
    
    private IMResourceConvert convert = new IMResourceConvert();
    
    /**
     * 向部门发送系统通知消息
     * @param confInfo
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode appSendMsgToGroup(AppSendMsgToGroup msg)
    {
        RestErrCode result = new RestErrCode();
        
        /* 参数判空
         * DTS2016040803605
         * 向群组发送消息和向UC用户发送消息接口，当message为空，其他参数正确，接口仍然可以调用成功，返回0，但message参数为必填。 
         */
        if (null == msg || StringUtils.isEmpty(msg.getSendNumber()) || StringUtils.isEmpty(msg.getGroupId())
            || StringUtils.isEmpty(msg.getMessage()) || null == msg.getDateTime())
        {
            result.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            result.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return result;
        }
        
        try
        {
            GroupInstanceMessage im = convert.appSendMsgToGroupRest2Modal(msg);
            SDKErrorCode response = imService.appSendMsgToGroup(im);
            result.setResultCode(response.getErrCodeStr());
            result.setResultContext(response.getDescription());
            return result;
        }
        catch (SDKException e)
        {
            LOGGER.error("appSendMsgToGroup method SDK error", e);
            result.setResultCode(String.valueOf(e.getSdkErrCode()));
            return result;
        }
        catch (Exception e)
        {
            LOGGER.error("appSendMsgToGroup method error", e);
            result.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            return result;
        }
    }
}
