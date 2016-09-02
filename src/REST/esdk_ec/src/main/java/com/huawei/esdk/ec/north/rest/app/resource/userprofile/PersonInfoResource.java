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
package com.huawei.esdk.ec.north.rest.app.resource.userprofile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.userprofile.UserProfileService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.PersonInfo;
import com.huawei.esdk.ec.north.rest.app.resource.userprofile.convert.UserProfileConvert;
import com.huawei.esdk.ec.north.rest.bean.QueryPersonInfoResponse;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/appserver/person_info")
public class PersonInfoResource
{
    
    private static final Logger LOGGER = Logger.getLogger(PersonInfoResource.class);
    
    private UserProfileService userProfileService = new UserProfileService();
    
    private UserProfileConvert userProfileConvert = new UserProfileConvert();
    
    /**
     * 查询个人详情
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public QueryPersonInfoResponse queryPersonInfo( 
        @QueryParam("staffAccount") String staffAccount)
    {
        QueryPersonInfoResponse response = new QueryPersonInfoResponse();
        
        if (StringUtils.isEmpty(staffAccount))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        try
        {
            SDKResult<PersonInfo> result =
                userProfileService.queryPersonInfo(" ", staffAccount);
            response = userProfileConvert.getQueryPersonInfoModel2Rest(result);
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryPersonInfo method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryPersonInfo method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
