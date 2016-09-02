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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.GroupService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.north.rest.bean.RestResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.DelGroupMembersRequest;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.GroupResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 删除群组成员资源对象
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Path("ec/eserver/delGroupMembers")
public class DelGroupMembersResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(DelGroupMembersResource.class);
    
    /**
     * 群组服务层对象
     */
    private static final GroupService GROUP_SERVICE = new GroupService();
    
    /**
     * 群组资源转换对象
     */
    private static final GroupResourceConvert GROUP_RESOURCE_CONVERT = new GroupResourceConvert();
    
    /** 
     * 删除群组成员
     * 
     * @author wangxiaobo/wWX233376
     * @param request
     * @return AddGroupMembersResponse
     * @see [类、类#方法、类#成员]
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<String> delGroupMembers(DelGroupMembersRequest request)
    {
        RestResponse<String> response = new RestResponse<String>();
        
        // 参数判空
        if (null == request || StringUtils.isEmpty(request.getSenderAppID())
            || StringUtils.isEmpty(request.getGroupID()) || StringUtils.isEmpty(request.getFlag())
            || GROUP_RESOURCE_CONVERT.validateTargets(request.getMembers()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result =
                GROUP_SERVICE.delGroupMembers(GROUP_RESOURCE_CONVERT.delGroupMembersRest2model(request));
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            response.setResult(result.getResult());
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("delGroupMembers method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("delGroupMembers method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
