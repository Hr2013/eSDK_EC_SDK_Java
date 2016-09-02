package com.huawei.esdk.ec.domain.model.multiapponline;

import java.util.List;

import com.huawei.esdk.ec.devices.eserver.multiapponline.IGroupCapability;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class IMGroupInfo extends MultiAppOnlineModel
{
    private List<IMGroup> imGroups;
    
    private String recordAmount;
    
    private String count;
    
    private String pageIndex;
    
    //GroupMembers
    private String groupId;
    
    private List<IMGroupUser> groupMembers;
    
    private String target;
    
    private List<String> addFailMemberList;
    
    private String syncType;
    
    private String stamp;
    
    private String resultCode;
    
    private String fixDiscuss;
    
    private String opType;
    
    private String existFlag;
    
    public String getExistFlag()
    {
        return existFlag;
    }
    
    public void setExistFlag(String existFlag)
    {
        this.existFlag = existFlag;
    }
    
    public String getFixDiscuss()
    {
        return fixDiscuss;
    }
    
    public void setFixDiscuss(String fixDiscuss)
    {
        this.fixDiscuss = fixDiscuss;
    }
    
    public String getOpType()
    {
        return opType;
    }
    
    public void setOpType(String opType)
    {
        this.opType = opType;
    }
    
    public String getSyncType()
    {
        return syncType;
    }
    
    public void setSyncType(String syncType)
    {
        this.syncType = syncType;
    }
    
    public String getStamp()
    {
        return stamp;
    }
    
    public void setStamp(String stamp)
    {
        this.stamp = stamp;
    }
    
    public String getTarget()
    {
        return target;
    }
    
    public void setTarget(String target)
    {
        this.target = target;
    }
    
    public List<String> getAddFailMemberList()
    {
        return addFailMemberList;
    }
    
    public void setAddFailMemberList(List<String> addFailMemberList)
    {
        this.addFailMemberList = addFailMemberList;
    }
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        IMGroupInfo.deviceManager = deviceManager;
    }
    
    public SDKResult<String> getIMGroup(String queryKey, String isNeedAmount, String count, String senderAppID,
        String senderType, String pageIndex)
        throws SDKException
    {
        IGroupCapability goupCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IGroupCapability.class);
        return goupCapability.getIMGroup(queryKey, isNeedAmount, count, senderAppID, senderType, pageIndex);
    }
    
    public SDKResult<String> addGroup(Group imGroup)
        throws SDKException
    {
        IGroupCapability goupCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IGroupCapability.class);
        return goupCapability.addGroup(imGroup);
    }
    
    public SDKResult<String> setGroup(Group imGroup)
        throws SDKException
    {
        IGroupCapability goupCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IGroupCapability.class);
        return goupCapability.setGroup(imGroup);
    }
    
    public SDKResult<String> delGroup(Group imGroup)
        throws SDKException
    {
        IGroupCapability goupCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IGroupCapability.class);
        return goupCapability.delGroup(imGroup);
    }
    
    public SDKResult<String> getGroupMembers(String appId, String imGroupID, String syncType, String stamp)
        throws SDKException
    {
        IGroupCapability goupCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IGroupCapability.class);
        return goupCapability.getGroupMembers(appId, imGroupID, syncType, stamp);
    }
    
    public SDKResult<String> addGroupMembers(GroupMember groupMember)
        throws SDKException
    {
        IGroupCapability goupCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IGroupCapability.class);
        return goupCapability.addGroupMembers(groupMember);
    }
    
    public SDKResult<String> delGroupMembers(GroupMember groupMember)
        throws SDKException
    {
        IGroupCapability goupCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"),
                IGroupCapability.class);
        return goupCapability.delGroupMembers(groupMember);
    }
    
    public List<IMGroup> getImGroups()
    {
        return imGroups;
    }
    
    public void setImGroups(List<IMGroup> imGroups)
    {
        this.imGroups = imGroups;
    }
    
    public String getPageIndex()
    {
        return pageIndex;
    }
    
    public String getRecordAmount()
    {
        return recordAmount;
    }
    
    public void setRecordAmount(String recordAmount)
    {
        this.recordAmount = recordAmount;
    }
    
    public String getCount()
    {
        return count;
    }
    
    public void setCount(String count)
    {
        this.count = count;
    }
    
    public void setPageIndex(String pageIndex)
    {
        this.pageIndex = pageIndex;
    }
    
    public String getGroupId()
    {
        return groupId;
    }
    
    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }
    
    public List<IMGroupUser> getGroupMembers()
    {
        return groupMembers;
    }
    
    public void setGroupMembers(List<IMGroupUser> groupMembers)
    {
        this.groupMembers = groupMembers;
    }
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
}
