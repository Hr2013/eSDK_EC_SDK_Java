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
package com.huawei.esdk.ec.device.bmu.sip.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.AddSIPRequest;
import com.huawei.esdk.ec.device.bmu.bean.BatchAddSIPRequest;
import com.huawei.esdk.ec.device.bmu.bean.BatchDeleteSIPRequest;
import com.huawei.esdk.ec.device.bmu.bean.BatchDeleteSIPResponse;
import com.huawei.esdk.ec.device.bmu.bean.DeleteSIPRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryGatewayRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryGatewayResponse;
import com.huawei.esdk.ec.device.bmu.bean.QuerySIPRequest;
import com.huawei.esdk.ec.device.bmu.bean.QuerySIPResponse;
import com.huawei.esdk.ec.device.bmu.bean.SIPDelCondition;
import com.huawei.esdk.ec.device.bmu.bean.SIPQueryCondition;
import com.huawei.esdk.ec.domain.model.SIP;
import com.huawei.esdk.ec.domain.model.bean.Gateway;
import com.huawei.esdk.ec.domain.model.bean.GatewayList;
import com.huawei.esdk.ec.domain.model.bean.SIPAuth;
import com.huawei.esdk.ec.domain.model.bean.SIPCondition;
import com.huawei.esdk.ec.domain.model.bean.SIPList;
import com.huawei.esdk.ec.domain.model.bean.USMSip;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class SIPCapabilityConvert
{
    public RestReqMessage getSIPRequest(String userId, SIP sip)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        AddSIPRequest sipRequest = new AddSIPRequest();
        
        sipRequest.setUserId(userId);
        
        sipRequest.setSip(getSIPModel2Rest(sip));
        
        payload.setBody(sipRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    private com.huawei.esdk.ec.device.bmu.bean.SIP getSIPModel2Rest(SIP sip)
    {
        com.huawei.esdk.ec.device.bmu.bean.SIP sipRest = new com.huawei.esdk.ec.device.bmu.bean.SIP();
        
        sipRest.setAddPrefix(sip.getAddPrefix());
        sipRest.setGwIp(sip.getGwIp());
        sipRest.setJoint(sip.getJoint());
        sipRest.setLocalGwIp(sip.getLocalGwIp());
        sipRest.setLongNum(sip.getLongNum());
        sipRest.setNumber(sip.getNumber());
        sipRest.setRightLevel(sip.getRightLevel());
        sipRest.setSipUe(sip.getSipUe());
        sipRest.setSubPbx(sip.getSubPbx());
        sipRest.setUeType(sip.getUeType());
        
        SIPAuth auth = sip.getSipAuth();
        com.huawei.esdk.ec.device.bmu.bean.SIPAuth authRest = new com.huawei.esdk.ec.device.bmu.bean.SIPAuth();
        sipRest.setSipAuth(authRest);
        authRest.setType(auth.getType());
        
        // modify by cWX191990，不需要判断，如果为空字符会导致cxf发消息时少了该节点
        //if (!StringUtils.isEmpty(auth.getIp()))
        //{
        authRest.setIp(auth.getIp());
        //}
        //if (!StringUtils.isEmpty(auth.getPassword()))
        //{
        authRest.setPassword(auth.getPassword());
        //}
        
        //EC3.0 NEW ADD
        sipRest.setbOutgoingRights(sip.getbOutgoingRights());
        sipRest.setcOutgoingRights(sip.getcOutgoingRights());
        
        if (null != sip.getUsmSip())
        {
            sipRest.setStationGroupName(sip.getUsmSip().getStationGroupName());
            sipRest.setSipServerId(sip.getUsmSip().getSipServerId());
            sipRest.setLocalGwName(sip.getUsmSip().getLocalGwName());
            sipRest.setIsSyncLocalGw(sip.getUsmSip().getIsSyncLocalGw());
            sipRest.setSourceCode(sip.getUsmSip().getSourceCode());
            sipRest.setMrGroupName(sip.getUsmSip().getMrGroupName());
            sipRest.setCrgName(sip.getUsmSip().getCrgName());
            sipRest.setDomainName(sip.getUsmSip().getDomainName());
        }
        
        return sipRest;
    }
    
    public RestReqMessage getSIPPasswordRequest(String userId, SIP sip)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        AddSIPRequest sipRequest = new AddSIPRequest();
        
        sipRequest.setUserId(userId);
        
        sipRequest.setSip(getSIPPasswordModel2Rest(sip));
        
        payload.setBody(sipRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    private com.huawei.esdk.ec.device.bmu.bean.SIP getSIPPasswordModel2Rest(SIP sip)
    {
        com.huawei.esdk.ec.device.bmu.bean.SIP sipRest = new com.huawei.esdk.ec.device.bmu.bean.SIP();
        
        sipRest.setGwIp(sip.getGwIp());
        sipRest.setSubPbx(sip.getSubPbx());
        sipRest.setSipUe(sip.getSipUe());
        
        SIPAuth auth = sip.getSipAuth();
        com.huawei.esdk.ec.device.bmu.bean.SIPAuth authRest = new com.huawei.esdk.ec.device.bmu.bean.SIPAuth();
        sipRest.setSipAuth(authRest);
        authRest.setType(auth.getType());
        
        // modify by cWX191990，不需要判断，如果为空字符会导致cxf发消息时少了该节点
        //if (!StringUtils.isEmpty(auth.getOldIp()))
        //{
        authRest.setOldIp(auth.getOldIp());
        //}
        //if (!StringUtils.isEmpty(auth.getNewIp()))
        //{
        authRest.setNewIp(auth.getNewIp());
        //}
        
        //if (!StringUtils.isEmpty(auth.getOldPassword()))
        //{
        authRest.setOldPassword(auth.getOldPassword());
        //}
        //if (!StringUtils.isEmpty(auth.getNewPassword()))
        //{
        authRest.setNewPassword(auth.getNewPassword());
        //}
        return sipRest;
    }
    
    public RestReqMessage getSIPBatchRequest(String userId, String numStep, String uestep, String amount, SIP sip)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        BatchAddSIPRequest sipRequest = new BatchAddSIPRequest();
        
        sipRequest.setUserId(userId);
        com.huawei.esdk.ec.device.bmu.bean.SIP restSipBean = getSIPModel2Rest(sip);
        restSipBean.setUeStep(uestep);
        restSipBean.setNumStep(numStep);
        restSipBean.setAmount(amount);
        
        sipRequest.setSip(restSipBean);
        
        payload.setBody(sipRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getSIPDeleteRequest(String userId, SIP sip)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        DeleteSIPRequest sipRequest = new DeleteSIPRequest();
        
        sipRequest.setUserId(userId);
        
        SIPDelCondition sipDel = new SIPDelCondition();
        sipRequest.setSip(sipDel);
        sipDel.setGwIp(sip.getGwIp());
        
        // 20140709，产品需要使用sipUe，但没有修改number字段，因此需要将sipUe的值传给number
        sipDel.setNumber(sip.getNumber());
        //        sipDel.setNumber(sip.getSipUe());
        
        sipDel.setDeleteSipUe(sip.getDeleteSipUe());
        //        sipDel.setSubPbx(sip.getSubPbx());
        
        payload.setBody(sipRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getSIPBatchDeleteRequest(String userId, List<SIP> sips)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        BatchDeleteSIPRequest sipRequest = new BatchDeleteSIPRequest();
        
        sipRequest.setUserId(userId);
        
        List<SIPDelCondition> sipDels = new ArrayList<SIPDelCondition>();
        sipRequest.setSips(sipDels);
        
        for (SIP sip : sips)
        {
            SIPDelCondition sipDel = new SIPDelCondition();
            sipDels.add(sipDel);
            sipDel.setGwIp(sip.getGwIp());
            
            // 20140709，产品需要使用sipUe，但没有修改number字段，因此需要将sipUe的值传给number
            sipDel.setNumber(sip.getNumber());
            //            sipDel.setNumber(sip.getSipUe());
            
            sipDel.setDeleteSipUe(sip.getDeleteSipUe());
            //            sipDel.setSubPbx(sip.getSubPbx());
        }
        
        payload.setBody(sipRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getSipRequest(String userId, SIPCondition sipCon)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        QuerySIPRequest sipRequest = new QuerySIPRequest();
        
        sipRequest.setUserId(userId);
        sipRequest.setExactSearch(sipCon.getExactsearch());
        
        SIPQueryCondition condition = new SIPQueryCondition();
        sipRequest.setCondition(condition);
        condition.setType(sipCon.getType());
        condition.setValue(sipCon.getValue());
        
        sipRequest.setPageCount(sipCon.getPagecount());
        sipRequest.setPageNum(sipCon.getPagenum());
        
        payload.setBody(sipRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public SIPList getQuerySip(QuerySIPResponse body)
    {
        SIPList sipList = new SIPList();
        sipList.setAmount(body.getAmount());
        
        List<com.huawei.esdk.ec.device.bmu.bean.SIP> sips = body.getSips();
        if (null != sips && !sips.isEmpty())
        {
            List<SIP> models = new ArrayList<SIP>();
            sipList.setSips(models);
            SIP model = null;
            for (com.huawei.esdk.ec.device.bmu.bean.SIP sip : sips)
            {
                model = new SIP();
                models.add(model);
                model.setGwIp(sip.getGwIp());
                model.setSubPbx(sip.getSubPbx());
                model.setLocalGwIp(sip.getLocalGwIp());
                model.setJoint(sip.getJoint());
                model.setSipUe(sip.getSipUe());
                model.setUeType(sip.getUeType());
                model.setNumber(sip.getNumber());
                model.setLongNum(sip.getLongNum());
                model.setRightLevel(sip.getRightLevel());
                
                com.huawei.esdk.ec.device.bmu.bean.SIPAuth auth = sip.getSipAuth();
                if (null != auth)
                {
                    SIPAuth authModel = new SIPAuth();
                    model.setSipAuth(authModel);
                    
                    authModel.setType(auth.getType());
                    authModel.setPassword(auth.getPassword());
                    authModel.setIp(auth.getIp());
                }
                
                USMSip usmSip = new USMSip();
                model.setUsmSip(usmSip);
                usmSip.setStationGroupName(sip.getStationGroupName());
                usmSip.setSipServerId(sip.getSipServerId());
                usmSip.setLocalGwName(sip.getLocalGwName());
                usmSip.setIsSyncLocalGw(sip.getIsSyncLocalGw());
                usmSip.setSourceCode(sip.getSourceCode());
                usmSip.setMrGroupName(sip.getMrGroupName());
                usmSip.setCrgName(sip.getCrgName());
                usmSip.setDomainName(sip.getDomainName());
            }
        }
        
        return sipList;
    }
    
    public SIPList getBatchDeleteSip(BatchDeleteSIPResponse body)
    {
        SIPList modelList = new SIPList();
        modelList.setAmount(body.getAmount());
        
        List<com.huawei.esdk.ec.device.bmu.bean.SIP> sips = body.getSips();
        if (null != sips && !sips.isEmpty())
        {
            List<SIP> sipModels = new ArrayList<SIP>();
            modelList.setSips(sipModels);
            SIP sipModel = null;
            for (com.huawei.esdk.ec.device.bmu.bean.SIP sip : sips)
            {
                sipModel = new SIP();
                sipModel.setGwIp(sip.getGwIp());
                sipModel.setSubPbx(sip.getSubPbx());
                sipModel.setNumber(sip.getNumber());
                sipModels.add(sipModel);
            }
        }
        
        return modelList;
    }
    
    public RestReqMessage getGatewayRequest(String userId)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        QueryGatewayRequest sipRequest = new QueryGatewayRequest();
        
        sipRequest.setUserId(userId);
        
        payload.setBody(sipRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public GatewayList getGateway(QueryGatewayResponse body)
    {
        GatewayList modelList = new GatewayList();
        modelList.setAmount(body.getAmount());
        
        List<com.huawei.esdk.ec.device.bmu.bean.Gateway> rests = body.getGateways();
        if (null != rests && !rests.isEmpty())
        {
            List<Gateway> gateways = new ArrayList<Gateway>();
            modelList.setGateways(gateways);
            
            Gateway gateway = null;
            for (com.huawei.esdk.ec.device.bmu.bean.Gateway rest : rests)
            {
                gateway = new Gateway();
                gateways.add(gateway);
                
                gateway.setGwIp(rest.getGwIp());
                gateway.setState(rest.getState());
                gateway.setSubPbxs(rest.getSubPbxs());
            }
        }
        return modelList;
    }
    
}
