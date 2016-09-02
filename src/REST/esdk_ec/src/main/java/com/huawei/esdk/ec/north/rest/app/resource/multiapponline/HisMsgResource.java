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
package com.huawei.esdk.ec.north.rest.app.resource.multiapponline;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.HisMsgService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.multiapponline.HisMsgInfoModel;
import com.huawei.esdk.ec.north.rest.bean.app.multiapponline.HisMsgRequest;
import com.huawei.esdk.ec.north.rest.bean.app.multiapponline.HisMsgResponse;
import com.huawei.esdk.ec.north.rest.app.resource.multiapponline.convert.HisMsgResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 历史消息资源对象
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Path("ec/appserver/hisMsg")
public class HisMsgResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(HisMsgResource.class);
    
    /**
     * 应用服务层对象
     */
    private static final HisMsgService HISMSG_SERVICE = new HisMsgService();
    
    /**
     * 应用资源转换对象
     */
    private static final HisMsgResourceConvert HISMSG_RESOURCE_CONVERT = new HisMsgResourceConvert();
    
    /** 
     * 历史信息查询
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
    public HisMsgResponse getHisMsg(HisMsgRequest request)
    {
        HisMsgResponse response = new HisMsgResponse();
        
        // 参数判空
        if (null == request)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultDesc(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            
            SDKResult<HisMsgInfoModel> result =
                HISMSG_SERVICE.getHisMsg(HISMSG_RESOURCE_CONVERT.getHisMsgRest2Model(request));
            response = HISMSG_RESOURCE_CONVERT.getHisMsgModel2Rest(result);
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("getHisMsg method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultDesc(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("getHisMsg method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultDesc(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
