package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import java.util.List;

public class DelGroupMembersRequest
{
    private String origin;
    
    private String groupID;
    
    private String flag;
    
    private List<String> members;
    
    private String groupType;
    
    private String senderAppID;
    
    private String senderType;
    
    public String getOrigin()
    {
        return origin;
    }
    
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }
    
    public String getGroupID()
    {
        return groupID;
    }
    
    public void setGroupID(String groupID)
    {
        this.groupID = groupID;
    }
    
    public String getFlag()
    {
        return flag;
    }
    
    public void setFlag(String flag)
    {
        this.flag = flag;
    }
    
    public List<String> getMembers()
    {
        return members;
    }
    
    public void setMembers(List<String> members)
    {
        this.members = members;
    }
    
    public String getGroupType()
    {
        return groupType;
    }
    
    public void setGroupType(String groupType)
    {
        this.groupType = groupType;
    }
    
    public String getSenderAppID()
    {
        return senderAppID;
    }
    
    public void setSenderAppID(String senderAppID)
    {
        this.senderAppID = senderAppID;
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
