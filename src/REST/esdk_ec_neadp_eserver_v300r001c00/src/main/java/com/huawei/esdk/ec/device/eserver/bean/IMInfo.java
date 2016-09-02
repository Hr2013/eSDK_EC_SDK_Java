package com.huawei.esdk.ec.device.eserver.bean;

import java.util.concurrent.CountDownLatch;

import message.ChatAck;
import message.SystemNoticeForEsdkAck;
import message.UserStateListAck;

public class IMInfo
{
    private String sap;
    
    private CountDownLatch latch;
    
    private UserStateListAck userStateListAck;
    
    private ChatAck chatAck;
    
    private SystemNoticeForEsdkAck deptChatAck;
    
    //    private GetAppInfoAck appInfoAck;
    
    public String getSap()
    {
        return sap;
    }
    
    public void setSap(String sap)
    {
        this.sap = sap;
    }
    
    public CountDownLatch getLatch()
    {
        if (null == latch)
        {
            latch = new CountDownLatch(1);
        }
        
        return latch;
    }
    
    public UserStateListAck getUserStateListAck()
    {
        return userStateListAck;
    }
    
    public void setUserStateListAck(UserStateListAck userStateListAck)
    {
        this.userStateListAck = userStateListAck;
    }
    
    public ChatAck getChatAck()
    {
        return chatAck;
    }
    
    public void setChatAck(ChatAck chatAck)
    {
        this.chatAck = chatAck;
    }
    
    public SystemNoticeForEsdkAck getDeptChatAck()
    {
        return deptChatAck;
    }
    
    public void setDeptChatAck(SystemNoticeForEsdkAck deptChatAck)
    {
        this.deptChatAck = deptChatAck;
    }
    
    //    public GetAppInfoAck getAppInfoAck()
    //    {
    //        return appInfoAck;
    //    }
    //    
    //    public void setAppInfoAck(GetAppInfoAck appInfoAck)
    //    {
    //        this.appInfoAck = appInfoAck;
    //    }
    
}
