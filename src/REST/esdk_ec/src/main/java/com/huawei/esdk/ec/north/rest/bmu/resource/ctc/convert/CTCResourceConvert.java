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
package com.huawei.esdk.ec.north.rest.bmu.resource.ctc.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.common.CipherUtilsRest;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.north.rest.bean.BatchQueryMeetingParam;
import com.huawei.esdk.ec.north.rest.bean.DeleteMeetingBaseParam;
import com.huawei.esdk.ec.north.rest.bean.MeetingBaseInfo;
import com.huawei.esdk.ec.north.rest.bean.MeetingInfo;
import com.huawei.esdk.ec.north.rest.bean.QueryMeetingInfoList;
import com.huawei.esdk.ec.north.rest.bean.QueryMeetingResponse;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.DateUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class CTCResourceConvert
{
    public List<com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam> getDeleteMeetingRest2Modal(
        List<DeleteMeetingBaseParam> deleteItem)
    {
        List<com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam> modalDeleteItem =
            new ArrayList<com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam>();
        for(DeleteMeetingBaseParam restItem : deleteItem)
        {
            com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam modalItem = new
                com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam();
            modalItem.setConfId(restItem.getConfId());
            modalItem.setGwIp(restItem.getGwIp());
            modalDeleteItem.add(modalItem);
        }
        return modalDeleteItem;
    }
    
    public List<DeleteMeetingParam> getDeleteMeetingModal2Rest(List<com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam> list)
    {
        List<DeleteMeetingParam> restDeleteItem =
            new ArrayList<DeleteMeetingParam>();
        if(null != list)
        {
            for(com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam modalItem : list)
            {
                DeleteMeetingParam restItem = new DeleteMeetingParam();
                restItem.setConfId(modalItem.getConfId());
                restItem.setGwIp(modalItem.getGwIp());
                restItem.setSubPbx(modalItem.getSubPbx());
                restDeleteItem.add(restItem);
            }
        }
        return restDeleteItem;
    }
    
    public Conference getMeetingInfoRest2Model(MeetingBaseInfo meeting) throws SDKException
    {

        Conference confParam = new Conference();
        confParam.setUserId(meeting.getUserId());
        confParam.setGwIp(meeting.getGwIp());
        confParam.setSubPbx(meeting.getSubPbx());
        
        // modify by cWX191990, 修改DTS2014070300531，我们透传，让产品做校验 
        //if(null != meeting.getAmount())
        //{
        //    confParam.setMostNo(Integer.parseInt(meeting.getAmount()));
        //}
        confParam.setAmount(meeting.getAmount());
        
        if (!StringUtils.isEmpty(meeting.getChairmanPwd()))
        {
            String chairmanPwd = CipherUtilsRest.decodeFromBase64(meeting.getChairmanPwd());
            if (StringUtils.isEmpty(chairmanPwd))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
            confParam.setConfChairPwd(chairmanPwd);
        }
        else
        {
            confParam.setConfChairPwd(meeting.getChairmanPwd());
        }
        confParam.setConfMode(meeting.getConfMode());
        confParam.setSubject(meeting.getConfName());
        confParam.setConfId(meeting.getConfId());
        confParam.setEndTime(DateUtils.stringToDate(meeting.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        confParam.setEnterPrompt(meeting.getEnterPrompt());
        
        if (!StringUtils.isEmpty(meeting.getGuestPwd()))
        {
            String guestPwd = CipherUtilsRest.decodeFromBase64(meeting.getGuestPwd());
            if (StringUtils.isEmpty(guestPwd))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
            confParam.setConfMemberPwd(guestPwd);
        }
        else
        {
            confParam.setConfMemberPwd(meeting.getGuestPwd());
        }
        confParam.setLeavePrompt(meeting.getLeavePrompt());
        
        boolean isRecord = false;
        if(null != meeting.getRecordFlag() && "1".equals(meeting.getRecordFlag()))
        {
            isRecord = true;
        }
        confParam.setIfRecord(isRecord);
        
        confParam.setSrtpmode(meeting.getSrtpMode());
        confParam.setStartTime(DateUtils.stringToDate(meeting.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        
        return confParam;
    }
    
    public com.huawei.esdk.ec.domain.model.bean.QueryMeetingParam getQueryMeetingRest2Modal(BatchQueryMeetingParam param)
    {
        com.huawei.esdk.ec.domain.model.bean.QueryMeetingParam acctRequest = new 
            com.huawei.esdk.ec.domain.model.bean.QueryMeetingParam();
        acctRequest.setConfName(param.getConfName());
        acctRequest.setConfId(param.getConfId());
        acctRequest.setEndTime(DateUtils.stringToDate(param.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        acctRequest.setPageCount(param.getPageCount());
        acctRequest.setPageNum(param.getPageNum());
        acctRequest.setPhone(param.getPhone());
        acctRequest.setStartTime(DateUtils.stringToDate(param.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        acctRequest.setUserId(param.getUserId());
        return acctRequest;
    }
    
    private MeetingInfo getMeetingInfoModal2Rest(Conference confParam) throws SDKException
    {
        if(null == confParam)
        {
            return null;
        }
        MeetingInfo meetingInfo = new MeetingInfo();
        meetingInfo.setAmount(String.valueOf(confParam.getMostNo()));
        
        if (!StringUtils.isEmpty(confParam.getConfChairPwd()))
        {
            String chairPwd = null;
            try
            {
                chairPwd = CipherUtilsRest.encode(confParam.getConfChairPwd());
            }
            catch (SDKException e)
            {
                throw e;
            }
            if (StringUtils.isEmpty(chairPwd))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORCODE);
                throw sdkException;
            }
            meetingInfo.setChairmanPwd(chairPwd);
        }
        else
        {
            meetingInfo.setChairmanPwd(confParam.getConfChairPwd());
        }
        
        meetingInfo.setConfMode(confParam.getConfMode());
        meetingInfo.setConfName(confParam.getSubject());
        meetingInfo.setConfId(confParam.getConfId());
        meetingInfo.setConfPrefix(confParam.getConfprefix());
        meetingInfo.setEndTime(DateUtils.dateToString(confParam.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        meetingInfo.setEnterPrompt(confParam.getEnterPrompt());
        
        if (!StringUtils.isEmpty(confParam.getConfMemberPwd()))
        {
            String memberPwd = null;
            try
            {
                memberPwd = CipherUtilsRest.encode(confParam.getConfMemberPwd());
            }
            catch (SDKException e)
            {
                throw e;
            }
            if (StringUtils.isEmpty(memberPwd))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORCODE);
                throw sdkException;
            }
            meetingInfo.setGuestPwd(memberPwd);
        }
        else
        {
            meetingInfo.setGuestPwd(confParam.getConfMemberPwd());
        }
        meetingInfo.setLeavePrompt(confParam.getLeavePrompt());
        meetingInfo.setRecordFlag(true == confParam.isIfRecord() ? "1" : "0");
        meetingInfo.setSrtpMode(confParam.getSrtpmode());
        meetingInfo.setStartTime(DateUtils.dateToString(confParam.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        meetingInfo.setGwIp(confParam.getGwIp());
        
        //queryJoinMeeting add
        meetingInfo.setAttidentity(confParam.getAttidentity());
        meetingInfo.setKeeper(confParam.getKeeper());
        meetingInfo.setGuestUrl(confParam.getGuestUrl());
        meetingInfo.setChairmanUrl(confParam.getChairmanUrl());
        
        return meetingInfo;
    }

    public QueryMeetingResponse getQueryMeetingModal2Rest(SDKResult<PagedList<Conference>> result) throws SDKException
    {
        QueryMeetingResponse northMeetings = new QueryMeetingResponse();
        northMeetings.setResultCode(String.valueOf(result.getErrCode()));
        northMeetings.setResultContext(result.getDescription());
        
        if(null == result.getResult() || null == result.getResult().getRecords())
        {
            return northMeetings;
        }
        
        QueryMeetingInfoList queryMeetingInfoList = new QueryMeetingInfoList();
        List<MeetingInfo> confs = new ArrayList<MeetingInfo>();
        for(Conference modalMeeting : result.getResult().getRecords())
        {
            MeetingInfo restConf = getMeetingInfoModal2Rest(modalMeeting);
            if(null != restConf)
            {
                confs.add(restConf);
            }
        }
        
        queryMeetingInfoList.setAmount(String.valueOf(result.getResult().getTotalRecordCount()));
        queryMeetingInfoList.setMeetingInfoList(confs);
        
        northMeetings.setQueryMeetingInfoList(queryMeetingInfoList);
        
        return northMeetings;
    }
}
