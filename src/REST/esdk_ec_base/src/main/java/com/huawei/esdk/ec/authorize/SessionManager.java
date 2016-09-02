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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SessionManager
{
    private static Map<String, SessionInfo> sessionMap = new ConcurrentHashMap<String, SessionInfo>();
    
    private static SessionManager instance = new SessionManager();
    
    private SessionManager()
    {
    }
    
    public static synchronized SessionManager getInstance()
    {
        return instance;
    }
    
    public synchronized boolean saveSDKSession(String userId)
    {
        return saveSDKSession(userId, null);
    }
    
    public synchronized boolean saveSDKSession(String userId, SessionInfo info)
    {
        if (null == userId)
        {
            return false;
        }
        
        if (null == info)
        {
            info = sessionMap.get(userId);
            if (null == info)
            {
                info = new SessionInfo();
            }
        }
        
        sessionMap.put(userId, info);
        
        return true;
    }
    
    public synchronized boolean isSDKSessionExists(String sdkSession)
    {
        return sessionMap.containsKey(sdkSession);
    }
    
    public synchronized SessionInfo getSDKSession(String userId)
    {
        return sessionMap.get(userId);
    }
    
    public synchronized void removeSDKSession(String sdkSession)
    {
        sessionMap.remove(sdkSession);
    }
    
    public synchronized boolean saveSecretKey(String sdkSession, byte[] secretKey)
    {
        return saveSecretKey(sdkSession, secretKey, null);
    }
    
    public synchronized boolean saveSecretKey(String sdkSession, byte[] secretKey, byte[] iv)
    {
        if (null == sdkSession)
        {
            return false;
        }
        
        SessionInfo info = sessionMap.get(sdkSession);
        if (null == info)
        {
            info = new SessionInfo();
        }
        info.setSecretKey(secretKey);
        info.setIv(iv);
        
        sessionMap.put(sdkSession, info);
        return true;
    }
}
