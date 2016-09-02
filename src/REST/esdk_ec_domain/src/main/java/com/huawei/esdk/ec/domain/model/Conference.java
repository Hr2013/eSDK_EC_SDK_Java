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
package com.huawei.esdk.ec.domain.model;

import java.util.Date;
import java.util.List;

import com.huawei.esdk.ec.device.obg.ICTCCapability;
import com.huawei.esdk.ec.device.obg.IConfCapability;
import com.huawei.esdk.ec.domain.model.bean.ConfAgenda;
import com.huawei.esdk.ec.domain.model.bean.ConfPrefixList;
import com.huawei.esdk.ec.domain.model.bean.ConfStatus;
import com.huawei.esdk.ec.domain.model.bean.ConfType;
import com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam;
import com.huawei.esdk.ec.domain.model.bean.GlobalSRTPList;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryMeetingParam;
import com.huawei.esdk.ec.domain.model.bean.TerminalInConfInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * 会议类的基类
 * 
 */
public class Conference
{
    // 会议标识
    private String confId;
    
    // 会议类型
    private ConfType confType;
    
    // 扩展会议类型
    private String confTypeExt;
    
    // 会议状态
    private ConfStatus confStatus;
    
    // 会议主题
    private String subject;
    
    // 会议议程列表
    private List<ConfAgenda> confAgendaList;
    
    // 会议开始时间
    private Date startTime;
    
    // 会议结束时间
    private Date endTime;
    
    // 与会用户列表
    private List<Terminal> sites;
    
    // 会议的普通成员密码
    private String confMemberPwd;
    
    // 会议的主席密码
    private String confChairPwd;
    
    // 会议主席URI
    private String chairUri;
    
    // 会议发起人账号
    private String initiatorId;
    
    // 会议发起人名字
    private String initiatorName;
    
    // 是否支持背景音（保留字段）
    private boolean ifBackgroundMusic;
    
    // 会议背景音ID（保留字段）
    private String backgroundMusicId;
    
    // 会议创建时是否启动录音（保留字段）
    private boolean ifRecord;
    
    // 会议媒体属性(0001表示有消息聊天；0010表示有语音；0100表示有视频；1000表示有数据。)
    private int confMediaAttr;
    
    // 用户媒体类型第1位，音频；   第2位，视频； 第3位，数据。   如111，110。
    private String confMediaType;
    
    // 最大与会者人数
    private int mostNo;
    
    // RTP加密策略（0:不加密 1:强制加密 2:不强制加密）
    private int rtpPolicy;
    
    // TLS加密策略（0:不加密 1:强制加密 2:不强制加密）
    private int tlsPolicy;
    
    // MAA的部署ID
    private String deploymentId;
    
    //是否邀请会议主席入会
    private boolean ifInviteChairman;
    
    // 创建会议用户所属企业ID
    private String corpId;
    
    // 会议主席
    private Terminal chairman;
    
    //会议接入码
    private String accessCode;
    
    //录音接入码
    private String recordCode;
    
    //区域Id
    private String areaId;
    
    //时区
    private String timeZone;
    
    //
    private String maxVoice;
    
    //周期会议序列号, 唯一标示整个周期会议 
    private String cycleId;
    
    //BMU新增会议参数 start
    //操作用户Id
    private String userId;
    
    //网关IP
    private String gwIp;
    
    //
    private String enterPrompt;
    
    //
    private String leavePrompt;
    
    //会议类型：0语音，3数据
    private String confMode;
    
    //会议是否加密
    private String srtpmode;
    
    //返回消息码，0代表成功
    private String retcode;
    
    //返回消息体，记录成功消息或者失败具体信息
    private String retcontext;
    
    //会议字冠
    private String confprefix;
    
    //虚拟PBX ID
    private String subPbx;
    
    // queryJoinMeeting new add begin
    // 与会者身份:0：主席 1：来宾
    private int attidentity;
    
    // 预定者帐号
    private String keeper;
    
    // 来宾入会链接
    private String guestUrl;
    
    //主席入会链接，当与会者身份为来宾时值为空
    private String chairmanUrl;
    
    // queryJoinMeeting new add end
    
    /**
     * 与会人数，修改DTS2014070300531 
     */
    private String amount;
    
    //end
    
    //U19 parameters start
    /**
     * 会议厅号
     */
    private Integer confRoom;
    
    /**
     * 是否超大会场 Boolean型
     */
    private Boolean isSuperConf;
    
    /**
     * SRTP模式  0：不加密, 1：加密 , 2强制加密
     */
    private String srtpUsageMode;
    
    /**
     * U19会议鉴权码
     */
    private String authKey;
    
    /**
     * U19会议状态
     */
    private Integer u19ConfStatus;
    
    /**
     * U19会议类型
     */
    private Integer u19ConfType;
    
    /**
     * 删除会议返回参数
     */
    private String msgContentLen;
    
    /**
     *  删除会议返回参数
     */
    private String recordNum;
    
    //U19 end
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        Conference.deviceManager = deviceManager;
    }
    
    public Conference(String confId)
    {
        setConfId(confId);
    }
    
    public Conference()
    {
        
    }
    
    // 发起会议
    public SDKResult<String> createConf(Conference confParam)
        throws SDKException
    {
        ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKResult<String> errorCode = ctcCapability.createConf(confParam);
        return errorCode;
    }
    
    // 发起会议
    public SDKResult<String> createConfRest(Conference confParam)
        throws SDKException
    {
        ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKResult<String> errorCode = ctcCapability.createConf(confParam);
        return errorCode;
    }
    
    // 添加与会者
    public SDKErrorCode addIntoConf(String ucAccount, List<Terminal> sitelist)
        throws SDKException
    {
        ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKErrorCode errorCode = ctcCapability.addIntoConf(ucAccount, sitelist, getConfId());
        return errorCode;
    }
    
    // 添加与会者
    public SDKErrorCode addIntoConfRest(String ucAccount, List<Terminal> sitelist)
        throws SDKException
    {
        ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKErrorCode errorCode = ctcCapability.addIntoConf(ucAccount, sitelist, getConfId());
        return errorCode;
    }
    
    // 修改与会者发话权
    public SDKErrorCode mdfyTalkMode(String ucAccount, String cee, int aut)
        throws SDKException
    {
        ICTCCapability ctc =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        
        SDKErrorCode errorCode = ctc.modifyTalkMode(ucAccount, confId, cee, aut);
        return errorCode;
    }
    
    // 修改与会者发话权
    public SDKErrorCode mdfyTalkModeRest(String ucAccount, String cee, int aut)
        throws SDKException
    {
        ICTCCapability ctc =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        
        SDKErrorCode errorCode = ctc.modifyTalkMode(ucAccount, confId, cee, aut);
        return errorCode;
    }
    
    // 踢出与会者
    public SDKErrorCode delFromConf(String ucAccount, List<Terminal> sitelist)
        throws SDKException
    {
        ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKErrorCode errorCode = ctcCapability.delFromConf(ucAccount, sitelist, getConfId());
        return errorCode;
    }
    
    // 踢出与会者
    public SDKErrorCode delFromConfRest(String ucAccount, List<Terminal> sitelist)
        throws SDKException
    {
        ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKErrorCode errorCode = ctcCapability.delFromConf(ucAccount, sitelist, getConfId());
        return errorCode;
    }
    
    // 终止CTC会议
    public SDKErrorCode releaseConf(String ucAccount)
        throws SDKException
    {
        
        ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKErrorCode errorCode = ctcCapability.releaseConf(ucAccount, getConfId());
        return errorCode;
    }
    
    // 终止CTC会议
    public SDKErrorCode releaseConfRest(String ucAccount)
        throws SDKException
    {
        
        ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKErrorCode errorCode = ctcCapability.releaseConf(ucAccount, getConfId());
        return errorCode;
    }
    
    /**
     * 查询CTC会议列表* *
     * @param ucAccount
     * @param qryType 查询类型 1.自己创建的预约会议 2.自己待参加的会议 3.全部
     * @param beginTime
     * @param endTime
     * @param confType2 
     * @param pageList 
     * @return
     * @throws SDKException 
     */
    public SDKResult<List<Conference>> getConfList(String initiator, String qryType, Date beginTime, Date endTime,
        PagedList<Object> pageList, String confType2)
        throws SDKException
    {
        ICTCCapability ctc =
            deviceManager.getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        return ctc.getConfList(initiator, qryType, beginTime, endTime, pageList, confType2);
    }
    
    public SDKResult<List<Conference>> getConfListRest(String initiator, String qryType, Date beginTime, Date endTime,
        PagedList<Object> pageList, String confType2)
        throws SDKException
    {
        ICTCCapability ctc =
            deviceManager.getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        return ctc.getConfList(initiator, qryType, beginTime, endTime, pageList, confType2);
    }
    
    // 主动入会
    public SDKErrorCode joinConf(String ucAccount, String siteNo, String siteName, String role)
        throws SDKException
    {
        ICTCCapability ctc =
            deviceManager.getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        return ctc.joinConf(confId, ucAccount, siteNo, siteName, role);
    }
    
    // 升级会议类型为多媒体
    public SDKErrorCode audioToVideoConf(String ucAccount)
        throws SDKException
    {
        SDKErrorCode sdkErrorCode;
        ICTCCapability ctc =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        sdkErrorCode = ctc.audioToVideoConf(ucAccount, confId);
        return sdkErrorCode;
    }
    
    // 升级语音会议为数据会议
    public SDKErrorCode upgradeAudioToDataConf(String account)
        throws SDKException
    {
        SDKErrorCode sdkErrorCode;
        ICTCCapability ctc =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        sdkErrorCode = ctc.upgradeAudio2DataConf(account, confId);
        return sdkErrorCode;
    }
    
    public SDKErrorCode upgradeAudioToDataConfRest(String account)
        throws SDKException
    {
        SDKErrorCode sdkErrorCode;
        ICTCCapability ctc =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        sdkErrorCode = ctc.upgradeAudio2DataConf(account, confId);
        return sdkErrorCode;
    }
    
    /**
     * 上报终端类型* @param ucAccount
     * @param confId
     * @param terminalType
     * @param terminalIP
     * @param location
     * @param maaDeployID
     * @param corpID
     * @return
     * @throws SDKException 
     */
    public SDKResult<TerminalInConfInfo> informTerminalType(String ucAccount, String terminalType, String terminalIP,
        String location)
        throws SDKException
    {
        ICTCCapability ctc =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        return ctc.informTerminalType(confId, ucAccount, terminalType, terminalIP, location);
    }
    
    public SDKResult<TerminalInConfInfo> informTerminalTypeRest(String ucAccount, String terminalType,
        String terminalIP, String location)
        throws SDKException
    {
        ICTCCapability ctc =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        return ctc.informTerminalType(confId, ucAccount, terminalType, terminalIP, location);
    }
    
    // 订阅会场状态变化通知
    public SDKErrorCode subConfStatus(String appId)
        throws SDKException
    {
        ICTCCapability ctc =
            deviceManager.getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKErrorCode result = ctc.subConfStatus(appId, confId);
        return result;
    }
    
    public SDKResult<List<Terminal>> queryAttendees(String confId)
        throws SDKException
    {
        ICTCCapability ctc =
            deviceManager.getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKResult<List<Terminal>> result = ctc.queryAttendees(confId);
        return result;
    }
    
    public SDKResult<List<Terminal>> queryAttendeesRest(String confId)
        throws SDKException
    {
        ICTCCapability ctc =
            deviceManager.getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                ICTCCapability.class);
        SDKResult<List<Terminal>> result = ctc.queryAttendees(confId);
        return result;
    }
    
    public List<Terminal> getSites()
    {
        return sites;
    }
    
    public void setSites(List<Terminal> sites)
    {
        this.sites = sites;
    }
    
    public String getDeploymentId()
    {
        return deploymentId;
    }
    
    public void setDeploymentId(String deploymentId)
    {
        this.deploymentId = deploymentId;
    }
    
    public String getCorpId()
    {
        return corpId;
    }
    
    public void setCorpId(String corpId)
    {
        this.corpId = corpId;
    }
    
    public Terminal getChairman()
    {
        return chairman;
    }
    
    public void setChairman(Terminal chairman)
    {
        this.chairman = chairman;
    }
    
    public String getConfId()
    {
        return confId;
    }
    
    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
    public ConfType getConfType()
    {
        return confType;
    }
    
    public void setConfType(ConfType confType)
    {
        this.confType = confType;
    }
    
    public ConfStatus getConfStatus()
    {
        return confStatus;
    }
    
    public void setConfStatus(ConfStatus confStatus)
    {
        this.confStatus = confStatus;
    }
    
    public String getSubject()
    {
        return subject;
    }
    
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    public List<ConfAgenda> getConfAgendaList()
    {
        return confAgendaList;
    }
    
    public void setConfAgendaList(List<ConfAgenda> confAgendaList)
    {
        this.confAgendaList = confAgendaList;
    }
    
    public Date getStartTime()
    {
        if (startTime == null)
            return null;
        return (Date)startTime.clone();
    }
    
    public void setStartTime(Date startTime)
    {
        this.startTime = (Date)startTime.clone();
    }
    
    public Date getEndTime()
    {
        if (endTime == null)
            return null;
        return (Date)endTime.clone();
    }
    
    public void setEndTime(Date endTime)
    {
        this.endTime = (Date)endTime.clone();
    }
    
    public String getConfMemberPwd()
    {
        return confMemberPwd;
    }
    
    public void setConfMemberPwd(String confMemberPwd)
    {
        this.confMemberPwd = confMemberPwd;
    }
    
    public String getConfChairPwd()
    {
        return confChairPwd;
    }
    
    public void setConfChairPwd(String confChairPwd)
    {
        this.confChairPwd = confChairPwd;
    }
    
    public String getChairUri()
    {
        return chairUri;
    }
    
    public void setChairUri(String chairUri)
    {
        this.chairUri = chairUri;
    }
    
    public String getInitiatorId()
    {
        return initiatorId;
    }
    
    public void setInitiatorId(String initiatorId)
    {
        this.initiatorId = initiatorId;
    }
    
    public String getInitiatorName()
    {
        return initiatorName;
    }
    
    public void setInitiatorName(String initiatorName)
    {
        this.initiatorName = initiatorName;
    }
    
    public boolean isIfBackgroundMusic()
    {
        return ifBackgroundMusic;
    }
    
    public void setIfBackgroundMusic(boolean ifBackgroundMusic)
    {
        this.ifBackgroundMusic = ifBackgroundMusic;
    }
    
    public String getBackgroundMusicId()
    {
        return backgroundMusicId;
    }
    
    public void setBackgroundMusicId(String backgroundMusicId)
    {
        this.backgroundMusicId = backgroundMusicId;
    }
    
    public boolean isIfRecord()
    {
        return ifRecord;
    }
    
    public void setIfRecord(boolean ifRecord)
    {
        this.ifRecord = ifRecord;
    }
    
    public int getConfMediaAttr()
    {
        return confMediaAttr;
    }
    
    public void setConfMediaAttr(int confMediaAttr)
    {
        this.confMediaAttr = confMediaAttr;
    }
    
    public int getMostNo()
    {
        return mostNo;
    }
    
    public void setMostNo(int mostNo)
    {
        this.mostNo = mostNo;
    }
    
    public int getRtpPolicy()
    {
        return rtpPolicy;
    }
    
    public void setRtpPolicy(int rtpPolicy)
    {
        this.rtpPolicy = rtpPolicy;
    }
    
    public int getTlsPolicy()
    {
        return tlsPolicy;
    }
    
    public void setTlsPolicy(int tlsPolicy)
    {
        this.tlsPolicy = tlsPolicy;
    }
    
    /** * @param ifInviteChairman the ifInviteChairman to set */
    public void setIfInviteChairman(boolean ifInviteChairman)
    {
        this.ifInviteChairman = ifInviteChairman;
    }
    
    /** * @return the ifInviteChairman */
    public boolean isIfInviteChairman()
    {
        return ifInviteChairman;
    }
    
    /** * @param confTypeExt the confTypeExt to set */
    public void setConfTypeExt(String confTypeExt)
    {
        this.confTypeExt = confTypeExt;
    }
    
    /** * @return the confTypeExt */
    public String getConfTypeExt()
    {
        return confTypeExt;
    }
    
    /** * @param accessCode the accessCode to set */
    public void setAccessCode(String accessCode)
    {
        this.accessCode = accessCode;
    }
    
    /** * @return the accessCode */
    public String getAccessCode()
    {
        return accessCode;
    }
    
    /** * @param recordCode the recordCode to set */
    public void setRecordCode(String recordCode)
    {
        this.recordCode = recordCode;
    }
    
    /** * @return the recordCode */
    public String getRecordCode()
    {
        return recordCode;
    }
    
    /** * @param areaId the areaId to set */
    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }
    
    /** * @return the areaId */
    public String getAreaId()
    {
        return areaId;
    }
    
    public String getTimeZone()
    {
        return timeZone;
    }
    
    public void setTimeZone(String timeZone)
    {
        this.timeZone = timeZone;
    }
    
    public String getMaxVoice()
    {
        return maxVoice;
    }
    
    public void setMaxVoice(String maxVoice)
    {
        this.maxVoice = maxVoice;
    }
    
    public String getCycleId()
    {
        return cycleId;
    }
    
    public void setCycleId(String cycleId)
    {
        this.cycleId = cycleId;
    }
    
    public String getConfMediaType()
    {
        return confMediaType;
    }
    
    public void setConfMediaType(String confMediaType)
    {
        this.confMediaType = confMediaType;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public SDKResult<GlobalSRTPList> queryGlobalSRTP(String userId, String gwip, String pageNum, String pageCount)
        throws SDKException
    {
        IConfCapability conf =
            deviceManager.getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                IConfCapability.class);
        SDKResult<GlobalSRTPList> result = conf.queryGlobalSRTP(userId, gwip, pageNum, pageCount);
        return result;
    }
    
    public SDKResult<ConfPrefixList> queryConfPrefix(String userId, String gwip)
        throws SDKException
    {
        IConfCapability conf =
            deviceManager.getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                IConfCapability.class);
        SDKResult<ConfPrefixList> result = conf.queryConfPrefix(userId, gwip);
        return result;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getGwIp()
    {
        return gwIp;
    }
    
    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }
    
    public String getEnterPrompt()
    {
        return enterPrompt;
    }
    
    public void setEnterPrompt(String enterPrompt)
    {
        this.enterPrompt = enterPrompt;
    }
    
    public String getLeavePrompt()
    {
        return leavePrompt;
    }
    
    public void setLeavePrompt(String leavePrompt)
    {
        this.leavePrompt = leavePrompt;
    }
    
    public String getConfMode()
    {
        return confMode;
    }
    
    public void setConfMode(String confMode)
    {
        this.confMode = confMode;
    }
    
    public String getSrtpmode()
    {
        return srtpmode;
    }
    
    public void setSrtpmode(String srtpmode)
    {
        this.srtpmode = srtpmode;
    }
    
    public String getRetcode()
    {
        return retcode;
    }
    
    public void setRetcode(String retcode)
    {
        this.retcode = retcode;
    }
    
    public String getRetcontext()
    {
        return retcontext;
    }
    
    public void setRetcontext(String retcontext)
    {
        this.retcontext = retcontext;
    }
    
    public String getConfprefix()
    {
        return confprefix;
    }
    
    public void setConfprefix(String confprefix)
    {
        this.confprefix = confprefix;
    }
    
    public String getSubPbx()
    {
        return subPbx;
    }
    
    public void setSubPbx(String subPbx)
    {
        this.subPbx = subPbx;
    }
    
    public String getAmount()
    {
        return amount;
    }
    
    public void setAmount(String amount)
    {
        this.amount = amount;
    }
    
    public Integer getConfRoom()
    {
        return confRoom;
    }
    
    public void setConfRoom(Integer confRoom)
    {
        this.confRoom = confRoom;
    }
    
    /**
     * 
     * BMU接口
     * 預約會議
     * @param conf
     * @return
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     * @since  [产品/模块版本]
     */
    public SDKResult<String> scheduleMeeting(Conference conf)
        throws SDKException
    {
        com.huawei.esdk.ec.device.bmu.ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                com.huawei.esdk.ec.device.bmu.ICTCCapability.class);
        SDKResult<String> errorCode = ctcCapability.scheduleMeeting(conf);
        return errorCode;
    }
    
    /**
     * 
     * BMU接口
     * 修改會議
     * @param conf
     * @return
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     * @since  [产品/模块版本]
     */
    public SDKErrorCode modifyMeeting(Conference conf)
        throws SDKException
    {
        com.huawei.esdk.ec.device.bmu.ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                com.huawei.esdk.ec.device.bmu.ICTCCapability.class);
        SDKErrorCode errorCode = ctcCapability.modifyMeeting(conf);
        return errorCode;
    }
    
    /**
     * 
     * BMU接口
     * 刪除會議
     * @param userId
     * @param params
     * @return
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     * @since  [产品/模块版本]
     */
    public SDKResult<List<DeleteMeetingParam>> deleteMeeting(String userId, List<DeleteMeetingParam> params)
        throws SDKException
    {
        com.huawei.esdk.ec.device.bmu.ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                com.huawei.esdk.ec.device.bmu.ICTCCapability.class);
        SDKResult<List<DeleteMeetingParam>> result = ctcCapability.deleteMeeting(userId, params);
        return result;
    }
    
    /**
     * 
     * BMU接口
     * 查詢會議
     * @param param
     * @return
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     * @since  [产品/模块版本]
     */
    public SDKResult<PagedList<Conference>> queryMeeting(QueryMeetingParam param)
        throws SDKException
    {
        com.huawei.esdk.ec.device.bmu.ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                com.huawei.esdk.ec.device.bmu.ICTCCapability.class);
        SDKResult<PagedList<Conference>> result = ctcCapability.queryMeeting(param);
        return result;
    }
    
    /**
     * 
     * BMU接口
     * 获取与会会议列表
     * @param param
     * @return
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     * @since  [产品/模块版本]
     */
    public SDKResult<PagedList<Conference>> queryJoinMeeting(QueryMeetingParam param)
        throws SDKException
    {
        com.huawei.esdk.ec.device.bmu.ICTCCapability ctcCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                com.huawei.esdk.ec.device.bmu.ICTCCapability.class);
        SDKResult<PagedList<Conference>> result = ctcCapability.queryJoinMeeting(param);
        return result;
    }
    
    public Boolean getIsSuperConf()
    {
        return isSuperConf;
    }
    
    public void setIsSuperConf(Boolean isSuperConf)
    {
        this.isSuperConf = isSuperConf;
    }
    
    public String getSrtpUsageMode()
    {
        return srtpUsageMode;
    }
    
    public void setSrtpUsageMode(String srtpUsageMode)
    {
        this.srtpUsageMode = srtpUsageMode;
    }
    
    public String getMsgContentLen()
    {
        return msgContentLen;
    }
    
    public void setMsgContentLen(String msgContentLen)
    {
        this.msgContentLen = msgContentLen;
    }
    
    public String getRecordNum()
    {
        return recordNum;
    }
    
    public void setRecordNum(String recordNum)
    {
        this.recordNum = recordNum;
    }
    
    public String getAuthKey()
    {
        return authKey;
    }
    
    public void setAuthKey(String authKey)
    {
        this.authKey = authKey;
    }
    
    public Integer getU19ConfStatus()
    {
        return u19ConfStatus;
    }
    
    public void setU19ConfStatus(Integer u19ConfStatus)
    {
        this.u19ConfStatus = u19ConfStatus;
    }
    
    public Integer getU19ConfType()
    {
        return u19ConfType;
    }
    
    public void setU19ConfType(Integer u19ConfType)
    {
        this.u19ConfType = u19ConfType;
    }
    
    public int getAttidentity()
    {
        return attidentity;
    }
    
    public void setAttidentity(int attidentity)
    {
        this.attidentity = attidentity;
    }
    
    public String getKeeper()
    {
        return keeper;
    }
    
    public void setKeeper(String keeper)
    {
        this.keeper = keeper;
    }
    
    public String getGuestUrl()
    {
        return guestUrl;
    }
    
    public void setGuestUrl(String guestUrl)
    {
        this.guestUrl = guestUrl;
    }
    
    public String getChairmanUrl()
    {
        return chairmanUrl;
    }
    
    public void setChairmanUrl(String chairmanUrl)
    {
        this.chairmanUrl = chairmanUrl;
    }
    
}
