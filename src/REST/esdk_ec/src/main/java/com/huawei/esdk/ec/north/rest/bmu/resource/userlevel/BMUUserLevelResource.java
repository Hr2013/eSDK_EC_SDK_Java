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
package com.huawei.esdk.ec.north.rest.bmu.resource.userlevel;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.userlevel.UserLevelService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.UserLevel;
import com.huawei.esdk.ec.north.rest.bean.QueryUserLevelResponse;
import com.huawei.esdk.ec.north.rest.bean.RestResponse;
import com.huawei.esdk.ec.north.rest.bmu.resource.userlevel.convert.UserLevelResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/bmu/userlevel")
public class BMUUserLevelResource
{
    
    private static final Logger LOGGER = Logger.getLogger(BMUUserLevelResource.class);
    
    private static final UserLevelResourceConvert userLevelResourceConvert = new UserLevelResourceConvert();
    
    private static final UserLevelService userLevelService = new UserLevelService();
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<QueryUserLevelResponse> queryUserLevel(
        @QueryParam("userId") String userId,
        @QueryParam("pageCount") String pageCount,
        @QueryParam("pageNum") String pageNum)
    {
        RestResponse<QueryUserLevelResponse> response = new RestResponse<QueryUserLevelResponse>();
        
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(pageCount) ||
                StringUtils.isEmpty(pageNum))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<UserLevel> result =
                userLevelService.queryUserLevel(userId,pageCount, pageNum);
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            response.setResult(userLevelResourceConvert.queryUserLevelModal2Rest(result.getResult()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryUserLevel method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryUserLevel method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
