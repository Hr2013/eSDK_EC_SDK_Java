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
package com.huawei.esdk.ec.north.rest.bmu.resource.logAudit;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.business.professional.rest.logAudit.LogAuditService;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.LogAuditList;
import com.huawei.esdk.ec.domain.model.bean.QueryLogAuditInfo;
import com.huawei.esdk.ec.north.rest.bean.bmu.QueryLogAuditRequest;
import com.huawei.esdk.ec.north.rest.bean.bmu.QueryLogAuditResponse;
import com.huawei.esdk.ec.north.rest.bmu.resource.logAudit.convert.LogAuditResourceConvert;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 部门资源对象
 * <p>
 * @author  gaolinfei/gWX169839
 * @see  [相关类/方法]
 * @since  [eSDK UC V100R005C30]
 */
@Path("ec/bmu/logAudit")
public class LogAuditResource
{
    
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(LogAuditResource.class);
    
    /**
     * 历史记录服务层对象
     */
    private static final LogAuditService LOGAUDIT_SERVICE = new LogAuditService();
    
    /**
     * 部门资源转换对象
     */
    private static final LogAuditResourceConvert LOGAUDIT_RESOURCE_CONVERT = new LogAuditResourceConvert();
    
    /** 
    * 新增部门
    * 
    * @param departmentRequest 部门入参，包括操作用户、父部门ID，部门名称
    * @return AddDepartmentResponse 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryLogAuditResponse queryLogAudit(QueryLogAuditRequest request)
    {
        QueryLogAuditResponse response = new QueryLogAuditResponse();
        
        // 参数判空 pageCount、pageNum参非必选，应该改为0..1
        if (null == request || StringUtils.isEmpty(request.getUserId()) || StringUtils.isEmpty(request.getAccount())
            || null == request.getStartTime() || null == request.getEndTime())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            QueryLogAuditInfo queryInfo = LOGAUDIT_RESOURCE_CONVERT.queryLogAuditRest2Modal(request);
            SDKResult<LogAuditList> result = LOGAUDIT_SERVICE.queryLogAudit(queryInfo);
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            if (0 == result.getErrCode() && null != result.getResult())
            {
                response.setLogAuditInfoList(LOGAUDIT_RESOURCE_CONVERT.queryLogAuditModal2Rest(result.getResult()));
            }
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryLogAudit method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryLogAudit method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
