package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

public class IMGroupUser
{
    private String groupID;
    
    private String type;
    
    private String state;
    
    private String userAccount;
    
    private User user;
    
    private String userID;
    
    public String getGroupID()
    {
        return groupID;
    }
    
    public void setGroupID(String groupID)
    {
        this.groupID = groupID;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public String getUserAccount()
    {
        return userAccount;
    }
    
    public void setUserAccount(String userAccount)
    {
        this.userAccount = userAccount;
    }
    
    public User getUser()
    {
        return user;
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
    
    public String getUserID()
    {
        return userID;
    }
    
    public void setUserID(String userID)
    {
        this.userID = userID;
    }
}
