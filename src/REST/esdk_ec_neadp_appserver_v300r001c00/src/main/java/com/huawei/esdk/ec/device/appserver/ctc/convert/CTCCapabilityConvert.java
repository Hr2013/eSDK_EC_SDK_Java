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
package com.huawei.esdk.ec.device.appserver.ctc.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.appserver.bean.AttendeeRequest;
import com.huawei.esdk.ec.device.appserver.bean.ConfListResponse;
import com.huawei.esdk.ec.device.appserver.bean.ConferenceRequest;
import com.huawei.esdk.ec.device.appserver.bean.Invitee;
import com.huawei.esdk.ec.device.appserver.bean.InviteeList;
import com.huawei.esdk.ec.device.appserver.bean.ctc.ConfIdBean;
import com.huawei.esdk.ec.device.bean.XMLReqHeader;
import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.domain.model.Terminal;
import com.huawei.esdk.ec.domain.model.bean.ConfStatus;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class CTCCapabilityConvert
{
    
    public RestReqMessage getConferenceMode2Rest(String ucAccount, List<Terminal> sitelist, String confId)
    {
        Conference conf = new Conference();
        conf.setInitiatorId(ucAccount);
        conf.setConfId(confId);
        conf.setSites(sitelist);
        RestReqMessage request = getConferenceMode2Rest(conf);
        return request;
    }
    
    public RestReqMessage getConferenceMode2Rest(Conference conf)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        request.setPayload(buildCTCPayload(conf));
        
        return request;
    }
    
    private XMLReqMsg buildCTCPayload(Conference conf)
    {
        XMLReqMsg payload = new XMLReqMsg();
        
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(conf.getInitiatorId());
        payload.setHead(head);
        
        // 构建报文体
        ConferenceRequest request = new ConferenceRequest();
        com.huawei.esdk.ec.device.appserver.bean.Conference conference =
            new com.huawei.esdk.ec.device.appserver.bean.Conference();
        if (!StringUtils.isEmpty(conf.getConfId()))
        {
            conference.setConfId(conf.getConfId());
        }
        if (!StringUtils.isEmpty(conf.getSubject()))
        {
            conference.setTopic(conf.getSubject());
        }
        request.setConf(conference);
        
        List<Terminal> sites = conf.getSites();
        if (null != sites && !sites.isEmpty())
        {
            InviteeList inviteeList = new InviteeList();
            request.setInviteeList(inviteeList);
            List<Invitee> invitees = new ArrayList<Invitee>();
            inviteeList.setInvitees(invitees);
            for (Terminal site : sites)
            {
                Invitee invitee = new Invitee();
                invitee.setCee(site.getTerminalUri());
                invitees.add(invitee);
            }
        }
        payload.setBody(request);
        
        return payload;
    }
    
    public List<Conference> getConferenceListRest2Model(ConfListResponse resBean)
    {
        List<Conference> confModels = new ArrayList<Conference>();
        
        if (null != resBean)
        {
            List<com.huawei.esdk.ec.device.appserver.bean.Conference> confs = resBean.getConfs();
            if (null != confs && !confs.isEmpty())
            {
                for (com.huawei.esdk.ec.device.appserver.bean.Conference conf : confs)
                {
                    Conference confModel = new Conference();
                    confModel.setConfId(conf.getConfId());
                    confModel.setSubject(conf.getTopic());
                    if(null != conf.getStartTime())
                        confModel.setStartTime(conf.getStartTime());
                    
                    Terminal chairman = new Terminal();
                    chairman.setTerminalUri(conf.getEmcee());
                    confModel.setChairman(chairman);
                    
                    confModel.setConfStatus(ConfStatus.fromValue(conf.getStatus()));
                    
                    confModels.add(confModel);
                }
            }
        }
        return confModels;
    }
    
    public RestReqMessage getReleaseConfMode2Rest(String ucAccount, String confId)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(ucAccount);
        payload.setHead(head);
        
        // 构建报文体
        ConferenceRequest confRequest = new ConferenceRequest();
        com.huawei.esdk.ec.device.appserver.bean.Conference conference =
            new com.huawei.esdk.ec.device.appserver.bean.Conference();
        conference.setConfId(confId);
        confRequest.setConf(conference);
        
        payload.setBody(confRequest);
        
        request.setPayload(payload);
        
        return request;
    }

    public RestReqMessage getDelFromConfMode2Rest(String ucAccount, List<Terminal> sitelist, String confId)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(ucAccount);
        payload.setHead(head);
        // 构建报文体
        AttendeeRequest attRequest = new AttendeeRequest();
        
        attRequest.setConfId(confId);
        
        if (null != sitelist && !sitelist.isEmpty())
        {
            Terminal site = sitelist.get(0);
            if (null != site)
            {
                attRequest.setCee(site.getTerminalUri());
            }
        }
        
        payload.setBody(attRequest);
        
        request.setPayload(payload);
        
        return request;
    }

    public RestReqMessage getModifyTalkMode2Rest(String ucAccount, String confId, String ceeNum, int aut)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(ucAccount);
        payload.setHead(head);
        // 构建报文体
        AttendeeRequest attRequest = new AttendeeRequest();
        
        attRequest.setConfId(confId);
        attRequest.setCee(ceeNum);
        attRequest.setAuth(aut);
        
        payload.setBody(attRequest);
        
        request.setPayload(payload);
        
        return request;
    }
    
    public XMLReqMsg buildCtcConfIdReqMsg(String confId)
    {
        XMLReqMsg payload = new XMLReqMsg();
        
        ConfIdBean reqBody = new ConfIdBean();
        reqBody.setConfId(confId);
        
        payload.setBody(reqBody);
        
        return payload;
    }
    
    public XMLReqMsg buildCtcConfIdReqMsg(String confId, String ucAccount)
    {
        XMLReqMsg payload = new XMLReqMsg();
        
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(ucAccount);
        payload.setHead(head);
        
        ConfIdBean reqBody = new ConfIdBean();
        reqBody.setConfId(confId);
        
        payload.setBody(reqBody);
        
        return payload;
    }

}
