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
package com.huawei.esdk.ec.authorize;

import com.huawei.esdk.ec.authorize.SessionInfo;
import com.huawei.esdk.ec.authorize.SessionManager;
import com.huawei.esdk.ec.common.UCConstant;
import com.huawei.esdk.platform.authorize.itf.AbstractAuthorizeAdapter;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.bean.callback.CallbackItfInfo;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;

public class RestSimpleAuthorize extends AbstractAuthorizeAdapter
{
    private NotifyCollector collector;
    
    public RestSimpleAuthorize(String businessName)
    {
        super(businessName);
    }
    
    public String getAdapterType()
    {
        return "rest";
    }
    
    @Override
    public boolean reqMsgMatchesBuiness(String funcName, Object message)
    {
        if (StringUtils.isNotEmpty(funcName) && funcName.contains("rest/ec"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public boolean needAuthorize(String funcName, Object message)
    {
        return true;
    }
    
    @Override
    public String authorize(Object message)
    {
        MessageContext mc = ThreadLocalHolder.get();
        AccountInfo acctInfo = (AccountInfo)mc.getEntities().get(ESDKConstant.ACCT_INFO_ESDK);
        
        SessionInfo sessionInfo = SessionManager.getInstance().getSDKSession(acctInfo.getUserId());
        //If login already, then no need to login again
        if (null != sessionInfo && sessionInfo.isLogged() && sessionInfo.getPwd().equals(acctInfo.getPassword()))
        {
            return "0";
        }
        //Otherwise, need login session
        String devId = ConfigManager.getInstance().getValue("esdk.ec_appserver_device");
        publishMessage(devId, ESDKConstant.NOTIFY_ITFNAME_CONNECT, devId);
        String successFlag = (String)mc.getEntities().get(UCConstant.UC_DEV_LOGIN_STATUS);
        
        if ("0".equals(successFlag))
        {
            if (null == sessionInfo)
            {
                sessionInfo = new SessionInfo();
            }
            sessionInfo.setUserId(acctInfo.getUserId());
            sessionInfo.setPwd(acctInfo.getPassword());
            SessionManager.getInstance().saveSDKSession(acctInfo.getUserId(), sessionInfo);
            sessionInfo.setLogged(true);
        }
        return successFlag;
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
    
    public NotifyCollector getCollector()
    {
        return collector;
    }
    
    public void setCollector(NotifyCollector collector)
    {
        this.collector = collector;
    }
}
