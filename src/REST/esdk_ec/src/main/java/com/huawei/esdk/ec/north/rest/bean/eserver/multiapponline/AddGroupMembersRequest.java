package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import java.util.List;

public class AddGroupMembersRequest
{
    private String origin;
    
    private List<String> targets;
    
    private String groupID;
    
    private String name;
    
    private String flag;
    
    private String desc;
    
    private String originName;
    
    private String groupType;
    
    private String msgId;
    
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
    
    public List<String> getTargets()
    {
        return targets;
    }
    
    public void setTargets(List<String> targets)
    {
        this.targets = targets;
    }
    
    public String getGroupID()
    {
        return groupID;
    }
    
    public void setGroupID(String groupID)
    {
        this.groupID = groupID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getFlag()
    {
        return flag;
    }
    
    public void setFlag(String flag)
    {
        this.flag = flag;
    }
    
    public String getDesc()
    {
        return desc;
    }
    
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    
    public String getOriginName()
    {
        return originName;
    }
    
    public void setOriginName(String originName)
    {
        this.originName = originName;
    }
    
    public String getGroupType()
    {
        return groupType;
    }
    
    public void setGroupType(String groupType)
    {
        this.groupType = groupType;
    }
    
    public String getMsgId()
    {
        return msgId;
    }
    
    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
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
