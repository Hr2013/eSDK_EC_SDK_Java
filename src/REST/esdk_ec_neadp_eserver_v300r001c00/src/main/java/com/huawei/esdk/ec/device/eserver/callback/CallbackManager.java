package com.huawei.esdk.ec.device.eserver.callback;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CallbackManager
{
    private Map<String, String> callbackMap = new ConcurrentHashMap<String, String>();
    
    private static CallbackManager callbackManager;
    
    public static synchronized CallbackManager getInstance()
    {
        if (null == callbackManager)
        {
            callbackManager = new CallbackManager();
        }
        
        return callbackManager;
    }
    
    public boolean saveAppId(String sno, String appId)
    {
        if (null == sno)
        {
            return false;
        }
        
        if (null != callbackMap.get(sno))
        {
            return true;
        }
        try
        {
            callbackMap.put(sno, appId);
        }
        catch (Exception e)
        {
            return false;
        }
        
        return true;
    }
    
    public String getAppId(String sno)
    {
        String appId = callbackMap.get(sno);
        
        if (null != appId)
        {
            callbackMap.remove(sno);
            return appId;
        }
        
        return null;
    }
}
