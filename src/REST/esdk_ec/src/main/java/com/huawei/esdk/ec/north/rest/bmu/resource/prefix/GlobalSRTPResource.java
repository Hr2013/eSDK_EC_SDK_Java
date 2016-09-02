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
package com.huawei.esdk.ec.north.rest.bmu.resource.prefix;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.conf.ConfService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.bean.GlobalSRTPList;
import com.huawei.esdk.ec.north.rest.bean.RestResponse;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/bmu/global_srtp")
public class GlobalSRTPResource
{
    private static final Logger LOGGER = Logger.getLogger(GlobalSRTPResource.class);
    
    //    private static final ConfResourceConvert confResourceConvert = new ConfResourceConvert();
    
    private static final ConfService confService = new ConfService();
    
    /**
     * 查询会议全局加密配置
     * @param confInfo
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<GlobalSRTPList> queryGlobalSRTP(@QueryParam("userId") String userId,
        @QueryParam("gwIp") String gwIp, @QueryParam("pageNum") String pageNum,
        @QueryParam("pageCount") String pageCount)
    {
        RestResponse<GlobalSRTPList> response = new RestResponse<GlobalSRTPList>();
        
        if (StringUtils.isEmpty(userId))// || StringUtils.isEmpty(gwIp) || StringUtils.isEmpty(pageNum)
            //|| StringUtils.isEmpty(pageCount))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            
            return response;
        }
        
        try
        {
            SDKResult<GlobalSRTPList> result = confService.queryGlobalSRTP(userId, gwIp, pageNum, pageCount);
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            response.setResult(result.getResult());
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryGlobalSRTP method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryGlobalSRTP method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
