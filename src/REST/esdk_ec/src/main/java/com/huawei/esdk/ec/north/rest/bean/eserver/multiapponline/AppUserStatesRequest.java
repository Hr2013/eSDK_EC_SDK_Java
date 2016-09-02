package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import java.util.List;

public class AppUserStatesRequest
{
    private String user;
    
    private List<String> targets;
    
    private String appId;
    
    private String senderType;
    
    public String getUser()
    {
        return user;
    }
    
    public void setUser(String user)
    {
        this.user = user;
    }
    
    public List<String> getTargets()
    {
        return targets;
    }
    
    public void setTargets(List<String> targets)
    {
        this.targets = targets;
    }
    
    public String getAppId()
    {
        return appId;
    }
    
    public void setAppId(String appId)
    {
        this.appId = appId;
    }
    
    public String getSenderType()
    {
        return senderType;
    }
    
    public void setSenderType(String senderType)
    {
        this.senderType = senderType;
    }
    
}
