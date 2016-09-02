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
package com.huawei.esdk.ec.device.bmu.conf.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.ConfPrefix;
import com.huawei.esdk.ec.device.bmu.bean.ConfPrefixRequest;
import com.huawei.esdk.ec.device.bmu.bean.GlobalSRTP;
import com.huawei.esdk.ec.device.bmu.bean.GlobalSRTPRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryConfPrefixResponse;
import com.huawei.esdk.ec.device.bmu.bean.QueryGlobalSRTPResponse;
import com.huawei.esdk.ec.domain.model.bean.ConfPrefixList;
import com.huawei.esdk.ec.domain.model.bean.GlobalSRTPList;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class ConfCapabilityConvert
{

    public RestReqMessage getGlobalSRTPRequest(String userId, String gwip, String pageNum, String pageCount)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        GlobalSRTPRequest acctRequest = new GlobalSRTPRequest();
        
        acctRequest.setUserId(userId);
        
        acctRequest.setGwip(gwip);
        
        acctRequest.setPageCount(pageCount);
        
        acctRequest.setPageNum(pageNum);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }

    public GlobalSRTPList getGlobalSRTPRest2Model(QueryGlobalSRTPResponse body)
    {
        GlobalSRTPList rest = new GlobalSRTPList();
        rest.setAmount(String.valueOf(body.getAmount()));
        
        List<GlobalSRTP> globalSRTPs = body.getGlobalSRTPs();
        if (null != globalSRTPs && !globalSRTPs.isEmpty())
        {
            List<com.huawei.esdk.ec.domain.model.bean.GlobalSRTP> restSRTPs = new ArrayList<com.huawei.esdk.ec.domain.model.bean.GlobalSRTP>();
            rest.setGlobalSRTPs(restSRTPs);
            com.huawei.esdk.ec.domain.model.bean.GlobalSRTP restSRTP = null;
            for (GlobalSRTP srtp : globalSRTPs)
            {
                restSRTP = new com.huawei.esdk.ec.domain.model.bean.GlobalSRTP();
                restSRTPs.add(restSRTP);
                restSRTP.setGwIp(srtp.getGwip());
                restSRTP.setSrtpMode(srtp.getSrtpMode());
            }
        }
        
        return rest;
    }

    public RestReqMessage getConfPrefixRequest(String userId, String gwip)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        ConfPrefixRequest acctRequest = new ConfPrefixRequest();
        
        acctRequest.setUserId(userId);
        
        acctRequest.setGwip(gwip);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }

    public ConfPrefixList getConfPrefixRest2Model(QueryConfPrefixResponse body)
    {
        ConfPrefixList rest = new ConfPrefixList();
        rest.setAmount(String.valueOf(body.getAmount()));
        
        List<ConfPrefix> confPrefixs = body.getConfPrefixs();
        if (null != confPrefixs && !confPrefixs.isEmpty())
        {
            List<com.huawei.esdk.ec.domain.model.bean.ConfPrefix> restPrefixs = new ArrayList<com.huawei.esdk.ec.domain.model.bean.ConfPrefix>();
            rest.setConfPrefixs(restPrefixs);
            com.huawei.esdk.ec.domain.model.bean.ConfPrefix restPrefix = null;
            for (ConfPrefix prefix : confPrefixs)
            {
                restPrefix = new com.huawei.esdk.ec.domain.model.bean.ConfPrefix();
                restPrefixs.add(restPrefix);
                restPrefix.setSubPbx(prefix.getSubpbx());
                restPrefix.setConfPrfix(prefix.getConfPrfix());
                restPrefix.setIsPstn(prefix.getIspstn());
            }
        }
        
        return rest;
    }
    
}
