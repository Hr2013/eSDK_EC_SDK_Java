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

import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.huawei.ecs.client.ClientHandler;
import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.device.base.UCDeviceConnectionBase;
import com.huawei.esdk.ec.device.eserver.callback.EServerReceiveMessageCallBack;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class EServerConnection extends UCDeviceConnectionBase
{
    //    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    //    private static final String APPID = (String)deviceManager
    //        .queryDeviceInfo(ConfigManager.getInstance().getValue("esdk.ec_eserver_device")).get(0).get("reserver1");
    //        
    //    private static final String IS_OPEN_LOG = ConfigManager.getInstance().getValue("ec.multi.app.online.log.open");
    //    
    //    private static final String LOG_LEVEL = ConfigManager.getInstance().getValue("ec.multi.app.online.log.level");
    
    private EServerV3R1C00Device device;
    
    private ClientHandler clientHandler;
    
    private String user;
    
    private String pwd;
    
    public static volatile boolean isConnected = false;
    
    public EServerConnection(ClientHandler clientHandler, EServerV3R1C00Device serviceProxy, String user, String pwd)
    {
        super(user, pwd);
        this.clientHandler = clientHandler;
        this.device = serviceProxy;
        this.user = user;
        this.pwd = pwd;
    }
    
    @Override
    public Object getServiceProxy(Class<?>[] itfs)
    {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), itfs, device.getService(itfs));
    }
    
    @Override
    public boolean doHeartbeat(String connId)
    {
        return true;
    }
    
    @Override
    public boolean initConn(String connId)
    {
        synchronized (EServerConnection.class)
        {
            
            //            if (Boolean.parseBoolean(IS_OPEN_LOG))
            //            {
            //                MiniLogger.setLogger(
            //                    new SimpleLogger(System.getProperty("catalina.base") + "/logs/eServerSDK.log", 1024 * 1024 * 30));
            //                MiniLogger.setLogLevel(getLogLevel(LOG_LEVEL));
            //            }
            
            if (EServerConnection.isConnected)
            {
                return true;
            }
            
            List<String> serverList = new ArrayList<String>();
            serverList.addAll(getIPsBySap(device.getSap()));
            
            byte result = clientHandler.initClientHandler(getLocalIP(),
                serverList,
                user,
                pwd,
                EServerReceiveMessageCallBack.getInstance());
                
            if (0 == result)
            {
                EServerConnection.isConnected = true;
                return true;
            }
            
            return false;
        }
    }
    
    //    private LogLevel getLogLevel(String logLevel)
    //    {
    //        if (StringUtils.isEmpty(logLevel))
    //        {
    //            return LogLevel.INFO;
    //        }
    //        
    //        logLevel = logLevel.toUpperCase();
    //        
    //        switch (logLevel)
    //        {
    //            case "ALL":
    //                return LogLevel.ALL;
    //            case "DEBUG":
    //                return LogLevel.DEBUG;
    //            case "INFO":
    //                return LogLevel.INFO;
    //            case "WARN":
    //                return LogLevel.WARN;
    //            case "ERROR":
    //                return LogLevel.ERROR;
    //                
    //            default:
    //                return LogLevel.INFO;
    //        }
    //    }
    
    private static String getIPBySap(String sap)
    {
        if (null == sap)
        {
            return null;
        }
        
        String scheme = sap.substring(0, sap.indexOf("://"));
        String server = sap.substring(sap.indexOf("://") + 3, sap.indexOf("/", scheme.length() + 3));
        String IP = server.split(":")[0];
        
        return IP;
    }
    
    private List<String> getIPsBySap(String sap)
    {
        if (StringUtils.isEmpty(sap))
        {
            return null;
        }
        
        List<String> IPs = new ArrayList<String>();
        
        String regex = ";";
        String httpRegex = "://";
        
        if (!sap.contains(regex))
        {
            if (sap.contains(httpRegex))
            {
                sap = getIPBySap(sap);
            }
            
            IPs.add(sap);
        }
        else
        {
            for (String IP : sap.split(regex))
            {
                if (IP.contains(httpRegex))
                {
                    IP = getIPBySap(IP);
                }
                
                IPs.add(IP);
            }
        }
        
        return IPs;
    }
    
    /**
     * 获取本机IP
     */
    private static String getLocalIP()
    {
        String localIP = null;
        
        try
        {
            InetAddress inetAddress = InetAddress.getLocalHost();
            
            if (null != inetAddress)
            {
                localIP = inetAddress.getHostAddress();
            }
        }
        catch (UnknownHostException e)
        {
            SDKException exception = new SDKException(ErrInfo.SDK_SYSTEM_ERRORDESC);
            exception.setSdkErrCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            
            exception.printStackTrace();
        }
        
        return localIP;
    }
    
    @Override
    public void destroyConn(String connId)
    {
        return;
    }
    
    @Override
    public int getKeepAliveTimes()
    {
        return 0;
    }
    
    @Override
    public int getKeepAlivePeriod()
    {
        return 9 * 60;
    }
}
