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
package com.huawei.esdk.ec.north.rest.eserver.resource.presence;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.presence.PresenceService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.UserStateListAck;
import com.huawei.esdk.ec.north.rest.bean.eserver.QueryUCListPresenceRequest;
import com.huawei.esdk.ec.north.rest.bean.eserver.QueryUCListPresenceResponse;
import com.huawei.esdk.ec.north.rest.eserver.resource.presence.convert.PresenceResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 用户状态资源对象
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  com.huawei.esdk.ec.north.rest.eserver.resource.presence.EServerPresenceResource
 * @since  eSDK EC V100R003C00
 */
@Path("ec/eserver/presence")
public class EServerPresenceResource
{
    /**
     * 一次最多查询用户状态的个数
     */
    private static final int UPPER_LIMIT_VALUE = 64;
    
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(EServerPresenceResource.class);
    
    /**
     * 用户状态服务层对象
     */
    private static final PresenceService PRESENCE_SERVICE = new PresenceService();
    
    /**
     * 用户状态资源转换对象
     */
    private static final PresenceResourceConvert PRESENCE_RESOURCE_CONVERT = new PresenceResourceConvert();
    
    /** 
     * 批量查询用户状态
     * @author wangxiaobo/wWX233376
     * @param queryUCListPresenceRequest
     * @return response
     * @see com.huawei.esdk.ec.north.rest.eserver.resource.presence.EServerPresenceResource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryUCListPresenceResponse queryUCListPresence(QueryUCListPresenceRequest queryUCListPresenceRequest)
    {
        QueryUCListPresenceResponse response = new QueryUCListPresenceResponse();
        
        /*
         * 参数判空
         * DTS2016040802915
         * 当queryUsers为空时，仍然可以成功获取msgId,但queryUsers要求为非空 
         */
        if (null == queryUCListPresenceRequest || null == queryUCListPresenceRequest.getQueryUsers()
            || 0 == queryUCListPresenceRequest.getQueryUsers().size()
            || validateEveryUser(queryUCListPresenceRequest.getQueryUsers()))
        {
            
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        if (queryUCListPresenceRequest.getQueryUsers().size() > UPPER_LIMIT_VALUE)
        {
            response.setResultCode(String.valueOf(ErrInfo.EServerErrInfo.NUMBER_OF_QUERY_OVER_UPPER_LIMIT_ERRORCODE));
            response.setResultContext(ErrInfo.EServerErrInfo.NUMBER_OF_QUERY_OVER_UPPER_LIMIT_ERRORDESC);
            return response;
        }
        
        try
        {
            SDKResult<UserStateListAck> result =
                PRESENCE_SERVICE.queryUCListPresence(queryUCListPresenceRequest.getQueryUsers());
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            if (0 == result.getErrCode() && null != result.getResult())
            {
                response.getUserStates()
                    .addAll(PRESENCE_RESOURCE_CONVERT.queryUCListPresenceDomain2North(result.getResult()));
            }
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryUCListPresence method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        
    }
    
    /*
     * 校验每一个待查询的用户账号
     */
    private boolean validateEveryUser(List<String> queryUsers)
    {
        for (String queryUser : queryUsers)
        {
            if (StringUtils.isEmpty(queryUser))
            {
                return true;
            }
        }
        
        return false;
    }
}
