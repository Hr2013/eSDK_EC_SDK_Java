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
package com.huawei.esdk.ec.device.bmu.ctc.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingRequest;
import com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingResponse;
import com.huawei.esdk.ec.device.bmu.bean.EditMeetingRequest;
import com.huawei.esdk.ec.device.bmu.bean.MeetingInfo;
import com.huawei.esdk.ec.device.bmu.bean.QueryMeetingRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryMeetingResponse;
import com.huawei.esdk.ec.device.bmu.bean.ScheduleMeetingRequest;
import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryMeetingParam;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.utils.DateUtils;

public class CTCCapabilityConvert
{
    
    public RestReqMessage getScheduleMeetingRequest(Conference confParam)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        ScheduleMeetingRequest acctRequest = new ScheduleMeetingRequest();
        acctRequest.setUserId(confParam.getUserId());
        MeetingInfo meetingInfo = getMeetingInfoModal2Rest(confParam);
        meetingInfo.setConfId(null);
        acctRequest.setMeetingInfo(meetingInfo);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getModifyMeetingRequest(Conference confParam)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        EditMeetingRequest acctRequest = new EditMeetingRequest();
        acctRequest.setUserId(confParam.getUserId());
        MeetingInfo meetingInfo = getMeetingInfoModal2Rest(confParam);
        acctRequest.setMeetingInfo(meetingInfo);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public RestReqMessage getQueryMeetingRequest(Conference confParam)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        EditMeetingRequest acctRequest = new EditMeetingRequest();
        acctRequest.setUserId(confParam.getUserId());
        MeetingInfo meetingInfo = getMeetingInfoModal2Rest(confParam);
        acctRequest.setMeetingInfo(meetingInfo);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    private MeetingInfo getMeetingInfoModal2Rest(Conference confParam)
    {
        if (null == confParam)
        {
            return null;
        }
        MeetingInfo meetingInfo = new MeetingInfo();
        
        // modify by cWX191990, 修改DTS2014070300531，我们透传，让产品做校验 
        //meetingInfo.setAmount(String.valueOf(confParam.getMostNo()));
        meetingInfo.setAmount(confParam.getAmount());
        
        meetingInfo.setChairmanPwd(confParam.getConfChairPwd());
        meetingInfo.setConfMode(confParam.getConfMode());
        meetingInfo.setConfName(confParam.getSubject());
        meetingInfo.setConfId(confParam.getConfId());
        meetingInfo.setConfpreFix(confParam.getConfprefix());
        meetingInfo.setEndTime(DateUtils.dateToString(confParam.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        meetingInfo.setEnterPrompt(confParam.getEnterPrompt());
        meetingInfo.setGuestPwd(confParam.getConfMemberPwd());
        meetingInfo.setLeavePrompt(confParam.getLeavePrompt());
        meetingInfo.setRecordFlag(true == confParam.isIfRecord() ? "1" : "0");
        meetingInfo.setSrtpMode(confParam.getSrtpmode());
        meetingInfo.setStartTime(DateUtils.dateToString(confParam.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        meetingInfo.setGwIp(confParam.getGwIp());
        meetingInfo.setSubPbx(confParam.getSubPbx());
        return meetingInfo;
    }
    
    public RestReqMessage getDeleteMeetingRequest(String userId, List<DeleteMeetingParam> params)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        DeleteMeetingRequest acctRequest = new DeleteMeetingRequest();
        acctRequest.setUserId(userId);
        
        List<com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingParam> deleteMeetingParamsSouth =
            new ArrayList<com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingParam>();
        
        for (DeleteMeetingParam param : params)
        {
            com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingParam southPaarm = getDelMeetingParamModal2Rest(param);
            if (null != southPaarm)
            {
                deleteMeetingParamsSouth.add(southPaarm);
            }
        }
        
        acctRequest.setDeleteMeetingParams(deleteMeetingParamsSouth);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    private com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingParam getDelMeetingParamModal2Rest(DeleteMeetingParam param)
    {
        if (null == param)
        {
            return null;
        }
        com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingParam southParam =
            new com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingParam();
        southParam.setConfId(param.getConfId());
        southParam.setGwIp(param.getGwIp());
        southParam.setSubPbx(param.getSubPbx());
        return southParam;
    }
    
    public List<DeleteMeetingParam> getDeleteMeetingResponse(DeleteMeetingResponse body)
    {
        if (null == body || null == body.getDeleteMeetingFailedList()
            || null == body.getDeleteMeetingFailedList().getDeleteMeetingParams())
        {
            return null;
        }
        List<DeleteMeetingParam> FailedListModal = new ArrayList<DeleteMeetingParam>();
        List<com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingParam> FailedList =
            body.getDeleteMeetingFailedList().getDeleteMeetingParams();
        for (com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingParam southParam : FailedList)
        {
            DeleteMeetingParam modalParam = getDelMeetingParamRest2Modal(southParam);
            if (null != modalParam)
            {
                FailedListModal.add(modalParam);
            }
        }
        return FailedListModal;
    }
    
    private DeleteMeetingParam getDelMeetingParamRest2Modal(com.huawei.esdk.ec.device.bmu.bean.DeleteMeetingParam param)
    {
        if (null == param)
        {
            return null;
        }
        DeleteMeetingParam modalParam = new DeleteMeetingParam();
        modalParam.setConfId(param.getConfId());
        modalParam.setGwIp(param.getGwIp());
        modalParam.setSubPbx(param.getSubPbx());
        return modalParam;
    }
    
    public RestReqMessage getQueryMeetingRequest(QueryMeetingParam param)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        QueryMeetingRequest acctRequest = new QueryMeetingRequest();
        
        acctRequest.setConfName(param.getConfName());
        acctRequest.setConfId(param.getConfId());
        acctRequest.setEndTime(DateUtils.dateToString(param.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        acctRequest.setPageCount(param.getPageCount());
        acctRequest.setPageNum(param.getPageNum());
        acctRequest.setPhone(param.getPhone());
        acctRequest.setStartTime(DateUtils.dateToString(param.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        acctRequest.setUserId(param.getUserId());
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public PagedList<Conference> getQueryMeetingResponse(QueryMeetingResponse body)
    {
        if (null == body || null == body.getMeetingInfoArray() || null == body.getMeetingInfoArray().getMeetingInfos())
        {
            return null;
        }
        PagedList<Conference> result = new PagedList<Conference>();
        
        List<Conference> confModals = new ArrayList<Conference>();
        List<MeetingInfo> southConfs = body.getMeetingInfoArray().getMeetingInfos();
        
        for (MeetingInfo meeting : southConfs)
        {
            Conference modalConf = getMeetingInfoRest2Modal(meeting);
            if (null != modalConf)
            {
                confModals.add(modalConf);
            }
        }
        
        result.setTotalRecordCount(Integer.parseInt(body.getAmount()));
        result.setRecords(confModals);
        return result;
    }
    
    private Conference getMeetingInfoRest2Modal(MeetingInfo meeting)
    {
        if (null == meeting)
        {
            return null;
        }
        Conference confParam = new Conference();
        if (null != meeting.getAmount())
        {
            try
            {
                confParam.setMostNo(Integer.parseInt(meeting.getAmount()));
            }
            catch (NumberFormatException e)
            {
                confParam.setMostNo(0);
            }
            
        }
        confParam.setConfChairPwd(meeting.getChairmanPwd());
        confParam.setConfMode(meeting.getConfMode());
        confParam.setSubject(meeting.getConfName());
        confParam.setConfId(meeting.getConfId());
        confParam.setConfprefix(meeting.getConfpreFix());
        confParam.setEndTime(DateUtils.stringToDate(meeting.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        confParam.setEnterPrompt(meeting.getEnterPrompt());
        confParam.setConfMemberPwd(meeting.getGuestPwd());
        confParam.setLeavePrompt(meeting.getLeavePrompt());
        
        boolean isRecord = false;
        if (null != meeting.getRecordFlag() && "1".equals(meeting.getRecordFlag()))
        {
            isRecord = true;
        }
        confParam.setIfRecord(isRecord);
        
        confParam.setSrtpmode(meeting.getSrtpMode());
        confParam.setStartTime(DateUtils.stringToDate(meeting.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        confParam.setGwIp(meeting.getGwIp());
        
        //queryJoinMeeting add
        confParam.setAttidentity(meeting.getAttidentity());
        confParam.setKeeper(meeting.getKeeper());
        confParam.setGuestUrl(meeting.getGuestUrl());
        confParam.setChairmanUrl(meeting.getChairmanUrl());
        
        return confParam;
    }
    
}
