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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huawei.esdk.ec.device.obg.client.IClientMsgCapability;
import com.huawei.esdk.ec.devices.v200r001c03.client.UCV2R1C03IClientMsgCapability;
import com.huawei.esdk.ec.domain.model.bean.MessageInfo;
import com.huawei.esdk.ec.domain.model.bean.MsgType;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryMsgCondition;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * 即时消息模型
 * 
 */
public class InstanceMessage
{
    // 消息发送方(UC账号、AppId等)
    private String sender;

    // 消息发送者姓名
    private String senderName;

    // 消息接收方
    private String receiver;

    // 消息类型：IM，SMS
    private MsgType msgType;

    // 消息收发用户间类型
    private Integer msgUserType;

    // 消息提交时间
    private Date dateTime;

    // 消息编码格式
    private String encoding;

    // 消息内容
    private String content;

    // 服务器分配的该消息的ID
    private String msgId;

    // 消息主题
    private String subject;

    // 消息优先级
    private int priority;

    // 是否需要状态报告
    private boolean isReport;

    // 接受方类型
    private Integer recvType;

    // 接收消息的群组Id
    private String groupId;

    // 群组文档Id 固定群消息填写固定群ID，临时群消息填写临时群ID
    private List<String> groupIds;

    // 群组管理员账号
    private String creator;
    
    // 群组创建者URL
    private String creatorURL;
    
    //消息类型  1：点对点消息； 2：群组消息
    private String messageType;

    private static IDeviceManager deviceManager = (IDeviceManager) ApplicationContextUtil
            .getBean("deviceManager");

    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }

    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        InstanceMessage.deviceManager = deviceManager;
    }

    public InstanceMessage()
    {

    }

    // 发送消息 ----如果是UC用户则需登录
    public SDKErrorCode sendMessage(String ucAccount, InstanceMessage im)
            throws SDKException
    {
        SDKErrorCode sdkErrorCode;
        IClientMsgCapability client = getDeviceManager().getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                IClientMsgCapability.class);

        sdkErrorCode = client.sendMessage(ucAccount, im);
        return sdkErrorCode;
    }

    /**
     * 回收消息
     * @author k00207574
     */
    public SDKErrorCode withdrawMessage(InstanceMessage im) throws SDKException
    {
        IClientMsgCapability client = getDeviceManager().getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                IClientMsgCapability.class);
        return client.withdrawMessage(im);
    }

    // 个人或群组消息通知回调
    public SDKErrorCode notifyMessage(InstanceMessage im, List<String> groupIds)
    {
        return null;
    }

    /**
     * 用户置消息状态为已读消息 edit by w00208247
     * @throws SDKException
     */
    public SDKErrorCode markMsgReadFlag(QueryMsgCondition msgCond)
            throws SDKException
    {
        UCV2R1C03IClientMsgCapability client = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UCV2R1C03IClientMsgCapability.class);
        return client.markMsgReadFlag(sender, msgCond, msgId);
    }

    /**
     * 获取未读及离线消息记录
     *  edit by w00208247
     */
    public SDKResult<PagedList<MessageInfo>> getUnReadMessage(PagedList<Integer> pageList)
            throws SDKException
    {
        UCV2R1C03IClientMsgCapability client = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UCV2R1C03IClientMsgCapability.class);
        //此处传入时间戳， 产需需要的时间是UTC秒时间，及date.getTime()/1000
        String timeStamp = "";
        if (null != dateTime)
        {
            timeStamp = dateTime.getTime()/1000+"";
        }
      
        return client.getMessage(sender,messageType,timeStamp, pageList);
    }

    /**
     * 获取即时消息记录getMsgLog edit by w00208247
     * @author k00207574
     */
    public SDKResult<PagedList<MessageInfo>> getMessageLog(
            QueryMsgCondition msgCondition, PagedList<Integer> pageList)
            throws SDKException
    {
        UCV2R1C03IClientMsgCapability client = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UCV2R1C03IClientMsgCapability.class);
        return client.getMsgLog(sender, msgCondition, pageList);
    }

    /**
     * 发送临时群消息sendChatMessage edit by w00208247
     */
    public SDKErrorCode sendChatMessage(InstanceMessage im)
    {
        return null;
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getReceiver()
    {
        return receiver;
    }

    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
    }

    public MsgType getMsgType()
    {
        return msgType;
    }

    public void setMsgType(MsgType msgType)
    {
        this.msgType = msgType;
    }

    public Date getDateTime()
    {
        if(dateTime == null)
            return null;
        return (Date)dateTime.clone();
    }

    public void setDateTime(Date dateTime)
    {
        this.dateTime = (Date)dateTime.clone();
    }

    public String getEncoding()
    {
        return encoding;
    }

    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getMsgId()
    {
        return msgId;
    }

    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public boolean isReport()
    {
        return isReport;
    }

    public void setReport(boolean isReport)
    {
        this.isReport = isReport;
    }

    public Integer getRecvType()
    {
        return recvType;
    }

    public void setRecvType(Integer recvType)
    {
        this.recvType = recvType;
    }

    public Integer getMsgUserType()
    {
        return msgUserType;
    }

    public void setMsgUserType(Integer msgUserType)
    {
        this.msgUserType = msgUserType;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public List<String> getGroupIds()
    {
        if (null == groupIds)
        {
            groupIds = new ArrayList<String>();
        }
        return groupIds;
    }

    public void setGroupIds(List<String> groupIds)
    {
        this.groupIds = groupIds;
    }

    public String getCreator()
    {
        return creator;
    }

    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    public String getSenderName()
    {
        return senderName;
    }

    public void setSenderName(String senderName)
    {
        this.senderName = senderName;
    }

    /** * @param messageType the messageType to set */
    public void setMessageType(String messageType)
    {
        this.messageType = messageType;
    }

    /** * @return the messageType */
    public String getMessageType()
    {
        return messageType;
    }

	public String getCreatorURL() {
		return creatorURL;
	}

	public void setCreatorURL(String creatorURL) {
		this.creatorURL = creatorURL;
	}

}
