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
package com.huawei.esdk.ec.device.appserver.ctc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractAppServerCapability;
import com.huawei.esdk.ec.device.appserver.bean.ConfListResponse;
import com.huawei.esdk.ec.device.appserver.bean.ConferenceResponse;
import com.huawei.esdk.ec.device.appserver.bean.ctc.Attendee;
import com.huawei.esdk.ec.device.appserver.bean.ctc.QueryConfAttdResBean;
import com.huawei.esdk.ec.device.appserver.bean.ctc.ReportTypeResBean;
import com.huawei.esdk.ec.device.appserver.bean.ctc.UpgradeAudio2DataConfReqBean;
import com.huawei.esdk.ec.device.appserver.ctc.convert.CTCCapabilityConvert;
import com.huawei.esdk.ec.device.bean.XMLReqHeader;
import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.obg.ICTCCapability;
import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.domain.model.HoldingConference;
import com.huawei.esdk.ec.domain.model.Terminal;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.TerminalInConfInfo;
import com.huawei.esdk.ec.domain.model.bean.TerminalStatus;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class CTCCapabilityImpl extends AbstractAppServerCapability implements ICTCCapability
{
    private static final Logger LOGGER = Logger.getLogger(CTCCapabilityImpl.class);
    
    CTCCapabilityConvert ctcCapabilityConvert = new CTCCapabilityConvert();
    
    public CTCCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKResult<HoldingConference> getConfInfo(String ucAccount, String confId)
        throws SDKException
    {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public SDKErrorCode audioToVideoConf(String ucAccount, String confId)
    {
        LOGGER.debug("audioToVideoConf() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        request.setPayload(ctcCapabilityConvert.buildCtcConfIdReqMsg(confId));
        
        try
        {
            XMLResMsg result =
                sendMessage(request, "openInterface/upgrade.action", UpgradeAudio2DataConfReqBean.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("audioToVideoConf() error", e);
        }
        
        LOGGER.debug("audioToVideoConf() end");
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode joinConf(String confId, String ucAccount, String siteNo, String siteName, String role)
    {
        throw new UnsupportedOperationException();
    }
    
    /* 
     * 添加与会者
     */
    @Override
    public SDKErrorCode addIntoConf(String ucAccount, List<Terminal> sitelist, String confId)
    {
        LOGGER.debug("addIntoConf() start");
        SDKErrorCode result = new SDKErrorCode();
        RestReqMessage request = ctcCapabilityConvert.getConferenceMode2Rest(ucAccount, sitelist, confId);
        
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/addAtt.action", null);
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("addIntoConf() error", e);
        }
        
        LOGGER.debug("addIntoConf() end");
        return result;
    }
    
    /*  
     * 删除与会者
     */
    @Override
    public SDKErrorCode delFromConf(String ucAccount, List<Terminal> sitelist, String confId)
    {
        LOGGER.debug("delFromConf() start");
        SDKErrorCode result = new SDKErrorCode();
        RestReqMessage request = ctcCapabilityConvert.getDelFromConfMode2Rest(ucAccount, sitelist, confId);
        
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/delAtt.action", null);
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("delFromConf() error", e);
        }
        
        LOGGER.debug("delFromConf() end");
        return result;
    }
    
    /* 
     * 上报终端
     */
    @Override
    public SDKResult<TerminalInConfInfo> informTerminalType(String confId, String ucAccount, String terminalType,
        String terminalIP, String location)
    {
        LOGGER.debug("informTerminalType() start");
        SDKResult<TerminalInConfInfo> sdkResult = new SDKResult<TerminalInConfInfo>();
        
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        request.setPayload(ctcCapabilityConvert.buildCtcConfIdReqMsg(confId, ucAccount));
        
        try
        {
            XMLResMsg result =
                sendMessage(request, "openInterface/reportType.action", ReportTypeResBean.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
            if (0 == sdkResult.getErrCode())
            {
                ReportTypeResBean body = (ReportTypeResBean)result.getBody();
                
                if (null != body)
                {
                    TerminalInConfInfo terminalInConfInfo = new TerminalInConfInfo();
                    sdkResult.setResult(terminalInConfInfo);
                    
                    terminalInConfInfo.setConfId(body.getConfId());
                    terminalInConfInfo.setConfTypeExt(body.getConfType());
                    terminalInConfInfo.setDataconfurl(body.getDataConfURL());
                    terminalInConfInfo.setSiteId(body.getSiteId());
                    terminalInConfInfo.setHostKey(body.getHostKey());
                    terminalInConfInfo.setAttendeeNum(body.getAttendeeNum());
                    terminalInConfInfo.setAttendeeType(body.getAttendeeType());
                    terminalInConfInfo.setToken(body.getToken());
                    if(null != body.getTimestamp())
                        terminalInConfInfo.setTimeStamp(body.getTimestamp());
                    terminalInConfInfo.setServerIP(body.getMsAddr());
                }
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("informTerminalType() error", e);
        }
        LOGGER.debug("informTerminalType() end");
        return sdkResult;
    }
    
    /* 
     * 修改与会者会议话语权
     */
    @Override
    public SDKErrorCode modifyTalkMode(String ucAccount, String confId, String ceeNum, int aut)
    {
        LOGGER.debug("modifyTalkMode() start");
        SDKErrorCode result = new SDKErrorCode();
        RestReqMessage request = ctcCapabilityConvert.getModifyTalkMode2Rest(ucAccount, confId, ceeNum, aut);
        
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/modAttSpeakRight.action", null);
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("modifyTalkMode() error", e);
        }
        
        LOGGER.debug("modifyTalkMode() end");
        return result;
    }
    
    @Override
    public SDKErrorCode subConfStatus(String appID, String confID)
    {
        throw new UnsupportedOperationException();
    }
    
    /* 
     *  发起CTC会议
     */
    @Override
    public SDKResult<String> createConf(Conference confParam)
    {
        LOGGER.debug("createConf() start");
        SDKResult<String> result = new SDKResult<String>();
        RestReqMessage request = ctcCapabilityConvert.getConferenceMode2Rest(confParam);
        
        try
        {
            XMLResMsg response =
                sendMessage(request, "openInterface/addConf.action", ConferenceResponse.class.getName());
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
            if (0 == result.getErrCode())
            {
                ConferenceResponse resBean = (ConferenceResponse)response.getBody();
                result.setResult(resBean.getConfId());
            }
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("createConf() error", e);
        }
        
        LOGGER.debug("createConf() end");
        return result;
    }
    
    /* 
     * 终止会议
     */
    @Override
    public SDKErrorCode releaseConf(String ucAccount, String confId)
    {
        LOGGER.debug("releaseConf() start");
        SDKErrorCode result = new SDKErrorCode();
        
        RestReqMessage request = ctcCapabilityConvert.getReleaseConfMode2Rest(ucAccount, confId);
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/delConf.action", null);
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("getConfList() error", e);
        }
        
        LOGGER.debug("getConfList() end");
        
        return result;
    }
    
    /* 
     * 查询CTC会议列表
     */
    @Override
    public SDKResult<List<Conference>> getConfList(String initiator, String qryType, Date beginTime, Date endTime,
        PagedList<Object> pageList, String confType2)
    {
        LOGGER.debug("getConfList() start");
        
        SDKResult<List<Conference>> result = new SDKResult<List<Conference>>();
        
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        XMLReqMsg reqMsg = new XMLReqMsg();
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(initiator);
        reqMsg.setHead(head);
        request.setPayload(reqMsg);
        try
        {
            XMLResMsg response =
                sendMessage(request, "openInterface/queryConf.action", ConfListResponse.class.getName());
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
            if (0 == result.getErrCode())
            {
                ConfListResponse resBean = (ConfListResponse)response.getBody();
                result.setResult(ctcCapabilityConvert.getConferenceListRest2Model(resBean));
            }
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("getConfList() error", e);
        }
        
        LOGGER.debug("getConfList() end");
        
        return result;
    }
    
    /* 
     * 查询CTC与会者列表
     */
    @Override
    public SDKResult<List<Terminal>> queryAttendees(String confId)
    {
        LOGGER.debug("queryAttendees() start");
        SDKResult<List<Terminal>> sdkResult = new SDKResult<List<Terminal>>();
        
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        request.setPayload(ctcCapabilityConvert.buildCtcConfIdReqMsg(confId));
        
        try
        {
            XMLResMsg result =
                sendMessage(request, "openInterface/queryAtt.action", QueryConfAttdResBean.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            if (0 == sdkResult.getErrCode())
            {
                List<Terminal> list = new ArrayList<Terminal>();
                Terminal terminal;
                QueryConfAttdResBean resBody = (QueryConfAttdResBean)result.getBody();
                if (null != resBody && null != resBody.getAttendees() && !resBody.getAttendees().isEmpty())
                {
                    for (Attendee item : resBody.getAttendees())
                    {
                        terminal = new Terminal();
                        terminal.setTerminalUri(item.getCee());
                        terminal.setSiteStatus(TerminalStatus.fromValue(item.getStatus()));
                        terminal.setAut(item.getAuth());
                        terminal.setJoinConfTime(item.getTime());
                        terminal.setName(item.getDisplayName());
                        terminal.setAccount(item.getEspaceAccount());
                        list.add(terminal);
                    }
                }
                
                sdkResult.setResult(list);
            }
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            sdkResult.setDescription(e.getSdkErrDesc());
            LOGGER.error("queryAttendees() error", e);
        }
        LOGGER.debug("queryAttendees() end");
        return sdkResult;
    }
    
    /* 
     * 升级语音会议为数据会议
     */
    @Override
    public SDKErrorCode upgradeAudio2DataConf(String account, String confId)
    {
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        request.setPayload(ctcCapabilityConvert.buildCtcConfIdReqMsg(confId, account));
        
        try
        {
            XMLResMsg result =
                sendMessage(request, "openInterface/upgrade.action", UpgradeAudio2DataConfReqBean.class.getName());
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("", e);
        }
        
        return sdkResult;
    }
    
}
