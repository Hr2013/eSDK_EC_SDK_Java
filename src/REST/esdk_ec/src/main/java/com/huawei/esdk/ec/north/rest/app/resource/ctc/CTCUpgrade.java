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
package com.huawei.esdk.ec.north.rest.app.resource.ctc;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.ctc.CTCService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.north.rest.bean.ResHeaderBean;
import com.huawei.esdk.ec.north.rest.bean.ctc.UpgradeReqBean;
import com.huawei.esdk.ec.north.rest.bean.ctc.UpgradeResBean;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/appserver/ctc_upgrade")
public class CTCUpgrade
{
    
    private static final Logger LOGGER = Logger.getLogger(CTCUpgrade.class);
    
    /**
     * 升级语音会议为数据会议
     * @param upgradeReqBean
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UpgradeResBean upgradeAudioToDataConf(UpgradeReqBean upgradeReqBean)
    {
        CTCService service = new CTCService();
        
        UpgradeResBean response = new UpgradeResBean();
        ResHeaderBean header = new ResHeaderBean();
        response.setHeader(header);
        
        if (null == upgradeReqBean || StringUtils.isEmpty(upgradeReqBean.getConfId()))
        {
            header.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            header.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result = service.upgradeAudioToDataConf(upgradeReqBean.getConfId(), upgradeReqBean.getAccount());
            header.setResultCode(String.valueOf(result.getErrCode()));
            header.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("upgradeAudioToDataConf method SDK error", e);
            header.setResultCode(String.valueOf(e.getSdkErrCode()));
            header.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("upgradeAudioToDataConf method error", e);
            header.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            header.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
