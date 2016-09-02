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
package com.huawei.esdk.ec.north.rest.bmu.resource.logAudit.convert;

import java.util.ArrayList;

import com.huawei.esdk.ec.domain.model.LogAuditList;
import com.huawei.esdk.ec.domain.model.bean.LogAudit;
import com.huawei.esdk.ec.domain.model.bean.QueryLogAuditInfo;
import com.huawei.esdk.ec.north.rest.bean.bmu.LogAuditInfo;
import com.huawei.esdk.ec.north.rest.bean.bmu.LogAuditInfoList;
import com.huawei.esdk.ec.north.rest.bean.bmu.QueryLogAuditRequest;

public class LogAuditResourceConvert
{
    
    public QueryLogAuditInfo queryLogAuditRest2Modal(QueryLogAuditRequest request)
    {
        QueryLogAuditInfo result = new QueryLogAuditInfo();
        result.setAccount(request.getAccount());
        result.setEndTime(request.getEndTime());
        
        if (null != request.getPageCount())
        {
            result.setPageCount(request.getPageCount());
        }
        
        if (null != request.getPageNum())
        {
            result.setPageNum(request.getPageNum());
        }
        
        result.setStartTime(request.getStartTime());
        result.setUserId(request.getUserId());
        return result;
    }
    
    public LogAuditInfoList queryLogAuditModal2Rest(LogAuditList logAuditList)
    {
        if (null == logAuditList)
        {
            return null;
        }
        
        LogAuditInfoList logAuditInfoList = new LogAuditInfoList();
        logAuditInfoList.setAmount(logAuditList.getAmount());
        logAuditInfoList.setLogAuditInfoList(new ArrayList<LogAuditInfo>());
        
        if (null != logAuditList.getLogAudits() && 0 < logAuditList.getLogAudits().size())
        {
            for (LogAudit item : logAuditList.getLogAudits())
            {
                LogAuditInfo restItem = new LogAuditInfo();
                logAuditInfoList.getLogAuditInfoList().add(restItem);
                
                restItem.setContent(item.getContent());
                restItem.setMessageType(item.getMessageType());
                restItem.setReceiveAccount(item.getReceiveAccount());
                restItem.setReceiveTime(item.getReceiveTime());
                restItem.setSendAccount(item.getSendAccount());
                restItem.setSendIp(item.getSendIp());
            }
        }
        
        return logAuditInfoList;
    }
    
}
