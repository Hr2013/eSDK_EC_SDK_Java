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

import com.huawei.esdk.ec.business.professional.rest.multiapponline.GroupIMService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.north.rest.bean.RestResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GroupIMRequest;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.GroupIMResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 群组消息资源对象
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Path("ec/eserver/sendGroupIm")
public class GroupIMResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(GroupIMResource.class);
    
    /**
     * 应用服务层对象
     */
    private static final GroupIMService GROUPIM_SERVICE = new GroupIMService();
    
    /**
     * 应用资源转换对象
     */
    private static final GroupIMResourceConvert GROUPIM_RESOURCE_CONVERT = new GroupIMResourceConvert();
    
    /** 
     * 发送群组消息
     * 
     * @author wangxiaobo/wWX233376
     * @param userId 操作者标识
     * @param appName 应用名称
     * @param applyTime 查询时间
     * @return
     * @see [类、类#方法、类#成员]
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<String> sendGroupIm(GroupIMRequest request)
    {
        RestResponse<String> response = new RestResponse<String>();
        
        // 参数判空
        if (null == request || StringUtils.isEmpty(request.getOriginAppID())
            || StringUtils.isEmpty(request.getGroupID()) || StringUtils.isEmpty(request.getContent())
            || StringUtils.isEmpty(request.getFlag()) || StringUtils.isEmpty(request.getOrigin()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            
            SDKResult<String> result =
                GROUPIM_SERVICE.sendGroupIm(GROUPIM_RESOURCE_CONVERT.sendGroupImRest2Model(request));
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            response.setResult(result.getResult());
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("sendGroupIm method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("sendGroupIm method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
