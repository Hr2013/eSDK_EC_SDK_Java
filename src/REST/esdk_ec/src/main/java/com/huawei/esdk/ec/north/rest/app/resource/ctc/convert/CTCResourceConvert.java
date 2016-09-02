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
package com.huawei.esdk.ec.north.rest.app.resource.ctc.convert;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.common.CipherUtilsRest;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.domain.model.Terminal;
import com.huawei.esdk.ec.domain.model.bean.ConfStatus;
import com.huawei.esdk.ec.domain.model.bean.TerminalInConfInfo;
import com.huawei.esdk.ec.north.rest.bean.ConferenceInfo;
import com.huawei.esdk.ec.north.rest.bean.Invitee;
import com.huawei.esdk.ec.north.rest.bean.QueryConfResponse;
import com.huawei.esdk.ec.north.rest.bean.QueryConferenceInfo;
import com.huawei.esdk.ec.north.rest.bean.ctc.Attendee;
import com.huawei.esdk.ec.north.rest.bean.ctc.QueryAttendenceResBody;
import com.huawei.esdk.ec.north.rest.bean.ctc.ReportTerminalTypeResBody;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.DateUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class CTCResourceConvert
{
    private static final Logger LOGGER = Logger.getLogger(CTCResourceConvert.class);
    
    public Conference getConferenceRest2Model(ConferenceInfo confInfo)
    {
        Conference conf = new Conference();
        conf.setInitiatorId(confInfo.getAccount());
        conf.setSubject(confInfo.getTopic());
        List<Invitee> invitees = confInfo.getInvitees();
        if (null != invitees && !invitees.isEmpty())
        {
            List<Terminal> sites = new ArrayList<Terminal>();
            conf.setSites(sites);
            for (Invitee invitee : invitees)
            {
                Terminal terminal = new Terminal();
                terminal.setTerminalUri(invitee.getCee());
                sites.add(terminal);
            }
        }
        return conf;
    }
    
    public QueryConfResponse getQueryConfResponseModel2Rest(SDKResult<List<Conference>> result)
    {
        QueryConfResponse response = new QueryConfResponse();
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        
        
        List<Conference> confModels = result.getResult();
        if (null != confModels && !confModels.isEmpty())
        {
            List<QueryConferenceInfo> confs = new ArrayList<QueryConferenceInfo>();
            response.setConfs(confs);
            
            QueryConferenceInfo conf = null;
            for (Conference confModel : confModels)
            {
                conf = getConferenceInfoModel2Rest(confModel);
                if (null != conf)
                {
                    confs.add(conf);
                }
            }
        }
        
        return response;
    }

    private QueryConferenceInfo getConferenceInfoModel2Rest(Conference confModel)
    {
        if (null == confModel)
        {
            return null;
        }
        
        QueryConferenceInfo conf = new QueryConferenceInfo();
        conf.setConfId(confModel.getConfId());
        conf.setSubject(confModel.getSubject());
        
        // add by cWX191990，将date转成String
        conf.setStartTime(DateUtils.dateToString(confModel.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        Terminal chairman = confModel.getChairman();
        
        if (null != chairman)
        {
            conf.setEmcee(chairman.getTerminalUri());
        }
        
        ConfStatus status = confModel.getConfStatus();
        if (null != status)
        {
            conf.setStatus(status.value());
        }
        
        
        return conf;
    }

    public Conference getAttendeeRest2Model(ConferenceInfo confInfo)
    {
        Conference conf = new Conference();
        conf.setConfId(confInfo.getConfId());
        conf.setInitiatorId(confInfo.getAccount());
        
        List<Invitee> invitees = confInfo.getInvitees();
        if (null != invitees && !invitees.isEmpty())
        {
            List<Terminal> sites = new ArrayList<Terminal>();
            conf.setSites(sites);
            for (Invitee invitee : invitees)
            {
                Terminal terminal = new Terminal();
                terminal.setTerminalUri(invitee.getCee());
                sites.add(terminal);
            }
        }
        return conf;
    }
    
    public Conference getAttendeeRest2Model(String account, String confId, String cee)
    {
        Conference conf = new Conference();
        conf.setInitiatorId(account);
        conf.setConfId(confId);
        
        List<Terminal> sites = new ArrayList<Terminal>();
        conf.setSites(sites);
        Terminal terminal = new Terminal();
        terminal.setTerminalUri(cee);
        sites.add(terminal);
        return conf;
    }

    public QueryAttendenceResBody getAttendeeModel2Rest(SDKResult<List<Terminal>> result)
    {
        List<Terminal> terminals = result.getResult();
        if (null == terminals || terminals.isEmpty())
        {
            return null;
        }
        
        QueryAttendenceResBody body = new QueryAttendenceResBody();
        body.setNum(String.valueOf(terminals.size()));
        
        List<Attendee> attendees = new ArrayList<Attendee>();
        body.setAttendences(attendees);
        for (Terminal terminal : terminals)
        {
            if (null != terminal)
            {
                Attendee attendee = new Attendee();
                attendee.setCee(terminal.getTerminalUri());
                if (null != terminal.getSiteStatus())
                {
                    attendee.setStatus(terminal.getSiteStatus().value());
                }
                attendee.setAuth(String.valueOf(terminal.getAut()));
                attendee.setTime(terminal.getJoinConfTime());
                attendees.add(attendee);
            }
        }
        
        return body;
    }

    public ReportTerminalTypeResBody getCTCTerminalInConfInfoModel2Rest(TerminalInConfInfo model) throws SDKException
    {
        if (null == model)
        {
            return null;
        }
        
        ReportTerminalTypeResBody rest = new ReportTerminalTypeResBody();
        rest.setConfId(model.getConfId());
        rest.setConfType(model.getConfTypeExt());
        rest.setDataConfUrl(model.getDataconfurl());
        rest.setSiteId(model.getSiteId());
        
        String hostKey = model.getHostKey();
        if (!StringUtils.isEmpty(hostKey))
        {
            try
            {
                hostKey = CipherUtilsRest.encode(hostKey);
            }
            catch (SDKException e)
            {
                throw e;
            }
            if (StringUtils.isEmpty(hostKey))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORCODE);
                throw sdkException;
            }
            rest.setHostKey(hostKey);
        }
        else
        {
            rest.setHostKey("");
        }
        
        rest.setAttendeeNum(model.getAttendeeNum());
        rest.setAttendeeType(model.getAttendeeType());
        
        String token = model.getToken();
        if (!StringUtils.isEmpty(token))
        {
            try
            {
                rest.setToken(CipherUtilsRest.encode(token));
            }
            catch (SDKException e)
            {
                LOGGER.error("Token encode error", e);
                throw e;
            }
        }
        else
        {
            rest.setToken("");
        }
        if(null != model.getTimeStamp())
            rest.setTimeStamp(model.getTimeStamp());
        rest.setMsAddr(model.getServerIP());
        
        return rest;
    }
    
}
