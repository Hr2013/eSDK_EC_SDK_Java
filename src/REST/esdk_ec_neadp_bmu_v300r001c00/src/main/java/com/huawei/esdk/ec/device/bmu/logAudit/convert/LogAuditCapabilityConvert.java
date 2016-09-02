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
package com.huawei.esdk.ec.device.bmu.logAudit.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.QueryLogAuditParam;
import com.huawei.esdk.ec.device.bmu.bean.QueryLogAuditRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryLogAuditResponse;
import com.huawei.esdk.ec.domain.model.LogAuditList;
import com.huawei.esdk.ec.domain.model.bean.LogAudit;
import com.huawei.esdk.ec.domain.model.bean.QueryLogAuditInfo;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class LogAuditCapabilityConvert
{
    
    public RestReqMessage getQueryLogAuditRequest(QueryLogAuditInfo queryInfo)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        QueryLogAuditRequest logAuditRequest = new QueryLogAuditRequest();
        logAuditRequest.setUserId(queryInfo.getUserId());
        
        logAuditRequest.setQueryLogAuditParam(new QueryLogAuditParam());
        logAuditRequest.getQueryLogAuditParam().setEndtime(queryInfo.getEndTime());
        logAuditRequest.getQueryLogAuditParam().setPagecount(queryInfo.getPageCount());
        logAuditRequest.getQueryLogAuditParam().setPagenum(queryInfo.getPageNum());
        logAuditRequest.getQueryLogAuditParam().setStarttime(queryInfo.getStartTime());
        logAuditRequest.getQueryLogAuditParam().setAccount(queryInfo.getAccount());
        
        payload.setBody(logAuditRequest);
        request.setPayload(payload);
        
        return request;
    }
    
    public LogAuditList getQueryLogAuditResponse(QueryLogAuditResponse body)
    {
        if (null == body)
        {
            return null;
        }
        
        LogAuditList logAuditList = new LogAuditList();
        logAuditList.setAmount(String.valueOf(body.getAmount()));
        
        List<com.huawei.esdk.ec.device.bmu.bean.QueryLogAuditInfo> info = body.getQueryLogAuditInfos();
        if (null != info)
        {
            List<LogAudit> logAudits = new ArrayList<LogAudit>();
            logAuditList.setLogAudits(logAudits);
            
            for (com.huawei.esdk.ec.device.bmu.bean.QueryLogAuditInfo item : info)
            {
                LogAudit res = new LogAudit();
                res.setContent(item.getContentKey());
                res.setMessageType(item.getMessageType());
                res.setReceiveAccount(item.getReceiveAccount());
                res.setReceiveTime(item.getReceiveTime());
                res.setSendAccount(item.getSendAccount());
                res.setSendIp(item.getSendIp());
                logAudits.add(res);
            }
        }
        
        return logAuditList;
    }
    
}
