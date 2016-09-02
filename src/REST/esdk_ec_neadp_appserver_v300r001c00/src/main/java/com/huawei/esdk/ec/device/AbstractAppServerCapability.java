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
package com.huawei.esdk.ec.device;

import java.util.Date;
import java.util.UUID;

import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.common.UCConstant;
import com.huawei.esdk.ec.device.bean.XMLReqHeader;
import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.callback.CallbackItfInfo;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.bean.log.InterfaceLogBean;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.OSUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;
import com.huawei.esdk.platform.log.itf.IInterfaceLog;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;

public abstract class AbstractAppServerCapability
{
    protected ISDKProtocolAdapter protocolAdapter;
    
    private NotifyCollector collector = ApplicationContextUtil.getBean("notifyCollector");
    
    private String targetIP;
    
    public AbstractAppServerCapability(ISDKProtocolAdapter protocolAdapter)
    {
        this.protocolAdapter = protocolAdapter;
        this.targetIP = StringUtils.retrieveMachineAddr(protocolAdapter.getServiceAccessPoint());
    }
    
    private void doInterfaceLogReq(String messageId, String interfaceName)
    {
        InterfaceLogBean bean = new InterfaceLogBean();
        bean.setTransactionId(messageId);
        bean.setProduct("UC");
        bean.setInterfaceType("2");
        bean.setProtocolType("REST");
        bean.setReq(true);
        bean.setName(interfaceName);
        bean.setSourceAddr(OSUtils.getLocalIP());
        bean.setTargetAddr(targetIP);
        bean.setReqTime(new Date());
        
        IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
        logger.info(bean);
    }
    
    private void doInterfaceLogRes(String messageId, String resultCode)
    {
        InterfaceLogBean bean = new InterfaceLogBean();
        bean.setTransactionId(messageId);
        bean.setReq(false);
        bean.setRespTime(new Date());
        bean.setResultCode(resultCode);
        
        IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
        logger.info(bean);
    }
    
    protected XMLResMsg sendMessage(RestReqMessage request, String apiName, String resObjClass)
        throws ProtocolAdapterException
    {
        String uuid = UUID.randomUUID().toString();
        doInterfaceLogReq(uuid, apiName);
        
        XMLReqMsg payload = (XMLReqMsg)request.getPayload();
        MessageContext mc = ThreadLocalHolder.get();
        XMLReqHeader head = payload.getHead();
        if (null == head)
        {
            head = new XMLReqHeader();
            payload.setHead(head);
        }
        payload.getHead().setAppId((String)mc.getEntities().get(UCConstant.APP_ID_DEV));
        payload.getHead().setTag((String)mc.getEntities().get(UCConstant.PWD_DEV));
        
        XMLResMsg xmlResMsg = (XMLResMsg)protocolAdapter.syncSendMessage(request, apiName, resObjClass);
        
        if (null != xmlResMsg && null != xmlResMsg.getHead()
            && ErrInfo.SDK_UC_APPAGENT_RET.equals(xmlResMsg.getHead().getRetCode()))
        {
            // DTS2016012501626 连续多次调用接口，会出现接口调用不通的异常，返回错误码2130000010 
            String devId = ConfigManager.getInstance().getValue("esdk.ec_appserver_device");
            
            synchronized (AbstractAppServerCapability.class)
            {
                publishMessage(devId, ESDKConstant.NOTIFY_ITFNAME_DISCONNECT, devId);
                
                publishMessage(devId, ESDKConstant.NOTIFY_ITFNAME_CONNECT, devId);
            }
            
            payload.getHead().setAppId((String)mc.getEntities().get(UCConstant.APP_ID_DEV));
            payload.getHead().setTag((String) mc.getEntities().get(UCConstant.PWD_DEV));
            
            xmlResMsg = (XMLResMsg)protocolAdapter.syncSendMessage(request, apiName, resObjClass);
        }
        
        if(null != xmlResMsg)
            doInterfaceLogRes(uuid, xmlResMsg.getHead().getRetCode());
        else
            doInterfaceLogRes(uuid, "1");
        
        return xmlResMsg;
    }
    
    private void publishMessage(String devId, String itfName, String processorId)
    {
        CallbackMessage message = new CallbackMessage();
        CallbackItfInfo callbackItfInfo = new CallbackItfInfo();
        callbackItfInfo.setDevId(devId);
        callbackItfInfo.setItfName(itfName);
        callbackItfInfo.setNotifyMsgType(ESDKConstant.NOTIFY_MSG_TYPE_ESDK_EVENT);
        callbackItfInfo.setProcessorId(processorId);
        message.setCallbackItfInfo(callbackItfInfo);
        collector.publishNotify(message);
    }
}
