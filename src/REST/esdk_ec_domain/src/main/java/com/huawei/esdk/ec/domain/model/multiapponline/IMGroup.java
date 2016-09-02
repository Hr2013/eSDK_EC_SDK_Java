package com.huawei.esdk.ec.domain.model.multiapponline;

import java.util.List;

public class IMGroup
{
    private String id;
    
    private String name;
    
    private String owner;
    
    private String capacity;
    
    private String manifesto;
    
    private String joinFlag;
    
    private String state;
    
    private List<IMGroupUser> memberList;
    
    private String desc;
    
    private String policy;
    
    private String groupType;
    
    private String fixdiscuss;
    
    private String singleFileSpace;
    
    private String lastGroupFileUploadTime;
    
    private String appId;
    
    private String appName;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getOwner()
    {
        return owner;
    }
    
    public void setOwner(String owner)
    {
        this.owner = owner;
    }
    
    public String getCapacity()
    {
        return capacity;
    }
    
    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }
    
    public String getManifesto()
    {
        return manifesto;
    }
    
    public void setManifesto(String manifesto)
    {
        this.manifesto = manifesto;
    }
    
    public String getJoinFlag()
    {
        return joinFlag;
    }
    
    public void setJoinFlag(String joinFlag)
    {
        this.joinFlag = joinFlag;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public List<IMGroupUser> getMemberList()
    {
        return memberList;
    }
    
    public void setMemberList(List<IMGroupUser> memberList)
    {
        this.memberList = memberList;
    }
    
    public String getDesc()
    {
        return desc;
    }
    
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    
    public String getPolicy()
    {
        return policy;
    }
    
    public void setPolicy(String policy)
    {
        this.policy = policy;
    }
    
    public String getGroupType()
    {
        return groupType;
    }
    
    public void setGroupType(String groupType)
    {
        this.groupType = groupType;
    }
    
    public String getFixdiscuss()
    {
        return fixdiscuss;
    }
    
    public void setFixdiscuss(String fixdiscuss)
    {
        this.fixdiscuss = fixdiscuss;
    }
    
    public String getSingleFileSpace()
    {
        return singleFileSpace;
    }
    
    public void setSingleFileSpace(String singleFileSpace)
    {
        this.singleFileSpace = singleFileSpace;
    }
    
    public String getLastGroupFileUploadTime()
    {
        return lastGroupFileUploadTime;
    }
    
    public void setLastGroupFileUploadTime(String lastGroupFileUploadTime)
    {
        this.lastGroupFileUploadTime = lastGroupFileUploadTime;
    }
    
    public String getAppId()
    {
        return appId;
    }
    
    public void setAppId(String appId)
    {
        this.appId = appId;
    }
    
    public String getAppName()
    {
        return appName;
    }
    
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
}
