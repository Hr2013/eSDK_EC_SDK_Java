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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.userprofile.UserProfileService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.bean.EmployeeList;
import com.huawei.esdk.ec.north.rest.app.resource.userprofile.convert.UserProfileConvert;
import com.huawei.esdk.ec.north.rest.bean.QueryEmployeeResponse;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

@Path("ec/appserver/employee")
public class EmployeeResource
{
    
    private static final Logger LOGGER = Logger.getLogger(EmployeeResource.class);
    
    private UserProfileService userProfileService = new UserProfileService();
    
    private UserProfileConvert userProfileConvert = new UserProfileConvert();
    
    /**
     * 查询个人信息
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryEmployeeResponse queryEmployee(@QueryParam("account") String account, 
        @QueryParam("condition") String condition, 
        @QueryParam("pageCount") String pageCount, 
        @QueryParam("pageNum") String pageNum)
    {
        QueryEmployeeResponse response = new QueryEmployeeResponse();
        
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(condition) || StringUtils.isEmpty(pageCount) || StringUtils.isEmpty(pageNum))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        try
        {
            int pageCountTemp = Integer.parseInt(pageCount);
            int pageNumTemp = Integer.parseInt(pageNum);
            
            SDKResult<EmployeeList> result =
                userProfileService.queryEmployee(account, condition, pageCountTemp, pageNumTemp);
            response = userProfileConvert.getEmployeeModel2Rest(result);
            
            return response;
        }
        catch (NumberFormatException e)
        {
            // 参数错误
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryEmployee method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryEmployee method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
