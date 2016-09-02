package com.huawei.esdk.ec.domain.model.multiapponline;

import java.util.Date;

import com.huawei.esdk.ec.devices.eserver.multiapponline.IGroupIMCapability;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class GroupIMModel
{
    private String origin;
    
    private String target;
    
    private String flag;
    
    private String contentType;
    
    private String content;
    
    private String groupID;
    
    private Date deliverTime;
    
    private String originAppID;
    
    private String originAppName;
    
    private String senderType;
    
    private String msgEx;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        GroupIMModel.deviceManager = deviceManager;
    }
    
    public SDKResult<String> sendGroupIm(GroupIMModel groupIm)
        throws SDKException
    {
        IGroupIMCapability groupIMCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IGroupIMCapability.class);
        return groupIMCapability.sendGroupIm(groupIm);
    }
    
    public String getOrigin()
    {
        return origin;
    }
    
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }
    
    public String getTarget()
    {
        return target;
    }
    
    public void setTarget(String target)
    {
        this.target = target;
    }
    
    public String getFlag()
    {
        return flag;
    }
    
    public void setFlag(String flag)
    {
        this.flag = flag;
    }
    
    public String getContentType()
    {
        return contentType;
    }
    
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getGroupID()
    {
        return groupID;
    }
    
    public void setGroupID(String groupID)
    {
        this.groupID = groupID;
    }
    
    public Date getDeliverTime()
    {
        return deliverTime;
    }
    
    public void setDeliverTime(Date deliverTime)
    {
        this.deliverTime = deliverTime;
    }
    
    public String getOriginAppID()
    {
        return originAppID;
    }
    
    public void setOriginAppID(String originAppID)
    {
        this.originAppID = originAppID;
    }
    
    public String getOriginAppName()
    {
        return originAppName;
    }
    
    public void setOriginAppName(String originAppName)
    {
        this.originAppName = originAppName;
    }
    
    public String getSenderType()
    {
        return senderType;
    }
    
    public void setSenderType(String senderType)
    {
        this.senderType = senderType;
    }
    
    public String getMsgEx()
    {
        return msgEx;
    }
    
    public void setMsgEx(String msgEx)
    {
        this.msgEx = msgEx;
    }
}
