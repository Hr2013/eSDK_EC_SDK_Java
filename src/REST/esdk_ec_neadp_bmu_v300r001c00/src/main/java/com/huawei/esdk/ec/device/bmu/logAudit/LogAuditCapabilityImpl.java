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
package com.huawei.esdk.ec.device.bmu.logAudit;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.ILogAuditCapability;
import com.huawei.esdk.ec.device.bmu.bean.QueryLogAuditResponse;
import com.huawei.esdk.ec.device.bmu.logAudit.convert.LogAuditCapabilityConvert;
import com.huawei.esdk.ec.domain.model.LogAuditList;
import com.huawei.esdk.ec.domain.model.bean.QueryLogAuditInfo;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class LogAuditCapabilityImpl extends AbstractBMUCapability implements ILogAuditCapability
{

    private static final Logger LOGGER = Logger.getLogger(LogAuditCapabilityImpl.class);
    
    private LogAuditCapabilityConvert logAuditCapabilityConvert = new LogAuditCapabilityConvert();
    
    public LogAuditCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    
    /** 
     * 新增部门
     * 
     * @param userId 操作用户
     * @param parentId 父部门ID
     * @param deptName 部门名称
     * @return SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    @Override
    public SDKResult<LogAuditList> queryLogAudit(QueryLogAuditInfo queryInfo)
    {
        LOGGER.debug("queryLogAudit start");
        
        SDKResult<LogAuditList> result = new SDKResult<LogAuditList>();
        
        // 拼装报文
        RestReqMessage reqMessage = logAuditCapabilityConvert.getQueryLogAuditRequest(queryInfo);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg =
                sendMessage(reqMessage, "queryLogAudit.action", QueryLogAuditResponse.class.getName());
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
            
            // 结果转换
            if (null != xmlResMsg.getBody())
            {
                result.setResult(logAuditCapabilityConvert.getQueryLogAuditResponse(
                    (QueryLogAuditResponse)xmlResMsg.getBody()));
            }
            
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("queryLogAudit error", e);
        }
        
        LOGGER.debug("queryLogAudit end");
        
        return result;
    }

    
}
