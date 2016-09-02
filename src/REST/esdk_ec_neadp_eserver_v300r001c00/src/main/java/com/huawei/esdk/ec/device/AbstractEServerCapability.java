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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.huawei.ecs.bean.EsdkMsg;
import com.huawei.ecs.client.ClientHandler;
import com.huawei.ecs.util.CommonConst;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.device.eserver.bean.IMInfo;
import com.huawei.esdk.ec.device.eserver.callback.CallbackManager;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

import comm.udp.PriorityLevel;

public abstract class AbstractEServerCapability
{
    protected ClientHandler clientHandler;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    private static final String strategyTypeStr = (String)deviceManager
        .queryDeviceInfo(ConfigManager.getInstance().getValue("esdk.ec_eserver_device")).get(0).get("reserver2");
        
    private static Map<String, IMInfo> imInfoMap = new ConcurrentHashMap<String, IMInfo>();
    
    public AbstractEServerCapability(ClientHandler clientHandler)
    {
        this.clientHandler = clientHandler;
    }
    
    protected SDKResult<IMInfo> syncSendMessage(String sno, final EsdkMsg esdkMsg)
    {
        IMInfo imRequest = new IMInfo();
        imInfoMap.put(sno, imRequest);
        
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                clientHandler.sendMsg(esdkMsg);
            }
        }).start();
        
        SDKResult<IMInfo> result = new SDKResult<IMInfo>();
        
        try
        {
            // 设置超时时间30秒
            imRequest.getLatch().await(30, TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            result.setErrCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            result.setDescription(ErrInfo.SDK_SYSTEM_ERRORDESC);
            getImInfoMap().remove(sno);//及时移除对象，防止内存泄露
            
            return result;
        }
        
        result.setResult(imRequest);
        getImInfoMap().remove(sno);//及时移除对象，防止内存泄露
        
        return result;
    }
    
    /**
     * 异步发送方法
     */
    protected void asyncSendMessage(long sno, String appId, final EsdkMsg esdkMsg)
    {
        CallbackManager.getInstance().saveAppId(String.valueOf(sno), appId);
        
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                clientHandler.sendMsg(esdkMsg);
            }
        }).start();
    }
    
    public EsdkMsg buildEsdkMsg(String origin, Object msg, PriorityLevel priorityLevel)
    {
        EsdkMsg esdkMsg = new EsdkMsg();
        esdkMsg.setOrigin(origin);
        esdkMsg.setMsg(msg);
        esdkMsg.setPriorityLevel(priorityLevel);
        
        byte strategyType;
        
        try
        {
            strategyType = (byte)Integer.parseInt(strategyTypeStr);
        }
        catch (NumberFormatException e)
        {
            strategyType = CommonConst.STRATEGY_CYCLE;
        }
        
        esdkMsg.setStrategyType(strategyType);
        
        return esdkMsg;
    }
    
    protected PriorityLevel getPriorityLevelInt2Enum(Integer input)
    {
        if (null == input)
        {
            return PriorityLevel.NORMAL;
        }
        
        switch (input)
        {
            case 0:
                return PriorityLevel.HIGH;
                
            case 1:
                return PriorityLevel.NORMAL;
                
            case 2:
                return PriorityLevel.LOW;
                
            default:
                return PriorityLevel.NORMAL;
        }
    }
    
    public static Map<String, IMInfo> getImInfoMap()
    {
        return imInfoMap;
    }
}
