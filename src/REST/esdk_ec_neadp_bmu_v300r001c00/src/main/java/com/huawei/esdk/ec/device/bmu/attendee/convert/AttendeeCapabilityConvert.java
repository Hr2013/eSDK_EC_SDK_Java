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
package com.huawei.esdk.ec.device.bmu.attendee.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.AddAttendee;
import com.huawei.esdk.ec.device.bmu.bean.AddAttendeeRequest;
import com.huawei.esdk.ec.device.bmu.bean.DelAttendeeInfo;
import com.huawei.esdk.ec.device.bmu.bean.DelAttendeeList;
import com.huawei.esdk.ec.device.bmu.bean.DelAttendeeListInfo;
import com.huawei.esdk.ec.device.bmu.bean.DelAttendeeRequest;
import com.huawei.esdk.ec.device.bmu.bean.DelAttendeeResponse;
import com.huawei.esdk.ec.device.bmu.bean.OperateAttendeeRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryAttendeeRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryAttendeeResponse;
import com.huawei.esdk.ec.domain.model.Attendee;
import com.huawei.esdk.ec.domain.model.bean.DelAttendeeFailedInfo;
import com.huawei.esdk.ec.domain.model.bean.DelAttendeeFailedList;
import com.huawei.esdk.ec.domain.model.bean.DelAttendeeInfoList;
import com.huawei.esdk.ec.domain.model.bean.QueryAttendeeInfo;
import com.huawei.esdk.ec.domain.model.bean.QueryAttendeeInfoList;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class AttendeeCapabilityConvert
{
    public RestReqMessage getAddAttendeeModel2Rest(Attendee attendee)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        AddAttendeeRequest addAttendeeRequest = new AddAttendeeRequest();
        addAttendeeRequest.setUserId(attendee.getUserId());
        
        AddAttendee addAttendee = new AddAttendee();
        addAttendee.setAccount(attendee.getAccount());
        addAttendee.setAttNumber(attendee.getAttNumber());
        //addAttendee.setAttStatus(attendee.getAttStatus());
        addAttendee.setAttType(attendee.getAttType());
        addAttendee.setConfId(attendee.getConfId());
        addAttendee.setEmail(attendee.getEmail());
        addAttendee.setGwIp(attendee.getGwIp());
        //addAttendee.setSpeakStatus(attendee.getSpeakStatus());
        addAttendee.setSubPbx(attendee.getSubPbx());
        
        addAttendeeRequest.setAddAttendee(addAttendee);
        
        payload.setBody(addAttendeeRequest);
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getQueryAttendeeRequest(String userId, String gwIp, String confId, int pageCount, int pageNum)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        QueryAttendeeRequest attendeeRequest = new QueryAttendeeRequest();
        attendeeRequest.setConfId(confId);
        attendeeRequest.setGwIp(gwIp);
        attendeeRequest.setPageCount(pageCount);
        attendeeRequest.setPageNum(pageNum);
        attendeeRequest.setUserId(userId);
        
        payload.setBody(attendeeRequest);
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getDeleteAttendeeRequest(DelAttendeeInfoList daInfoList)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        DelAttendeeRequest attendeeRequest = new DelAttendeeRequest();
        attendeeRequest.setUserId(daInfoList.getUserId());
        
        DelAttendeeListInfo attendeeListInfo = new DelAttendeeListInfo();
        attendeeListInfo.setConfId(daInfoList.getConfId());
        attendeeListInfo.setGwIp(daInfoList.getGwIp());
        
        List<DelAttendeeInfo> attendeeInfos = new ArrayList<DelAttendeeInfo>();
        DelAttendeeInfo delAttendeeInfo = null;
        
        for (com.huawei.esdk.ec.domain.model.bean.DelAttendeeInfo info : daInfoList.getAttendeeInfos())
        {
            delAttendeeInfo = new DelAttendeeInfo();
            delAttendeeInfo.setAccount(info.getAccount());
            delAttendeeInfo.setAttNumber(info.getAttNumber());
            attendeeInfos.add(delAttendeeInfo);
        }
        
        DelAttendeeList delAttendeeList = new DelAttendeeList();
        delAttendeeList.setAttendeeInfos(attendeeInfos);
        attendeeListInfo.setAttendeeList(delAttendeeList);
        attendeeRequest.setAttendeeList(attendeeListInfo);
        
        payload.setBody(attendeeRequest);
        request.setPayload(payload);
        
        return request;
    }
    
    public QueryAttendeeInfoList getQueryAttendeeRest2Model(QueryAttendeeResponse response)
    {
        QueryAttendeeInfoList queryAttendeeInfoList = new QueryAttendeeInfoList();
        queryAttendeeInfoList.setAmount(response.getAmount());
        
        if (null != response.getAttendeeInfoList() && !response.getAttendeeInfoList().isEmpty())
        {
            List<QueryAttendeeInfo> attendeeInfos = new ArrayList<QueryAttendeeInfo>();
            QueryAttendeeInfo attendeeInfo = null;
            
            for (com.huawei.esdk.ec.device.bmu.bean.QueryAttendeeInfo info : response.getAttendeeInfoList())
            {
                attendeeInfo = new QueryAttendeeInfo();
                attendeeInfo.setAccount(info.getAccount());
                attendeeInfo.setAttNumber(info.getAttNumber());
                attendeeInfo.setAttStatus(info.getAttStatus());
                attendeeInfo.setAttType(info.getAttType());
                attendeeInfo.setConfId(info.getConfId());
                attendeeInfo.setEmail(info.getEmail());
                attendeeInfo.setGwIp(info.getGwIp());
                attendeeInfo.setDataUrl(info.getDataUrl());
                
                attendeeInfos.add(attendeeInfo);
            }
            
            queryAttendeeInfoList.setAttendeeInfoList(attendeeInfos);
        }
        
        return queryAttendeeInfoList;
    }
    
    public DelAttendeeFailedList getDeleteAttendeeRest2Model(DelAttendeeResponse response)
    {
        DelAttendeeFailedList attendeeFailedList = new DelAttendeeFailedList();
        
        if (null != response.getAttendeeFailedList().getAttendeeFailedInfos()
            && !response.getAttendeeFailedList().getAttendeeFailedInfos().isEmpty())
        {
            List<DelAttendeeFailedInfo> attendeeFailedInfos = new ArrayList<DelAttendeeFailedInfo>();
            DelAttendeeFailedInfo attendeeFailedInfo = null;
            
            for (com.huawei.esdk.ec.device.bmu.bean.DelAttendeeFailedInfo info : response.getAttendeeFailedList()
                .getAttendeeFailedInfos())
            {
                attendeeFailedInfo = new DelAttendeeFailedInfo();
                attendeeFailedInfo.setAccount(info.getAccount());
                attendeeFailedInfo.setAttNumber(info.getAttNumber());
                attendeeFailedInfo.setFailedReason(info.getFailedReason());
                
                attendeeFailedInfos.add(attendeeFailedInfo);
            }
            
            attendeeFailedList.setAttendeeFailedInfos(attendeeFailedInfos);
            
            return attendeeFailedList;
        }
        
        return attendeeFailedList;
    }
    
    public RestReqMessage getOperateAttendeeRequest(Attendee attendee)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        OperateAttendeeRequest acctRequest = new OperateAttendeeRequest();
        
        acctRequest.setUserId(attendee.getUserId());
        
        com.huawei.esdk.ec.device.bmu.bean.Attendee rest = new com.huawei.esdk.ec.device.bmu.bean.Attendee();
        rest.setAttNumber(attendee.getAttNumber());
        rest.setAttType(attendee.getAttType());
        rest.setConfId(attendee.getConfId());
        rest.setGwIp(attendee.getGwIp());
        rest.setOperate(attendee.getOperate());
        rest.setOperNumber(attendee.getOperNumber());
        
        acctRequest.setAttendee(rest);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getChairmanRequest(Attendee attendee)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        OperateAttendeeRequest acctRequest = new OperateAttendeeRequest();
        
        acctRequest.setUserId(attendee.getUserId());
        
        com.huawei.esdk.ec.device.bmu.bean.Attendee rest = new com.huawei.esdk.ec.device.bmu.bean.Attendee();
        rest.setConfId(attendee.getConfId());
        rest.setGwIp(attendee.getGwIp());
        rest.setOldChairman(attendee.getOldChairman());
        rest.setNewChairman(attendee.getNewChairman());
        
        acctRequest.setAttendee(rest);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
}
