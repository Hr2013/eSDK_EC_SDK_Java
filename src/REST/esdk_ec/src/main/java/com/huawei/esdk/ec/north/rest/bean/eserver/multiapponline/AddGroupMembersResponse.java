package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.callback.AbstractCallbackMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.GroupMember;
import com.huawei.esdk.ec.domain.model.multiapponline.MultiAppOnlineModel;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.GroupResourceConvert;
import com.huawei.esdk.ec.northcommu.rest.callback.RestEServerListener;

public class AddGroupMembersResponse extends AbstractCallbackMsg
{
    private String result;
    
    private String origin;
    
    private String target;
    
    private String groupID;
    
    private String name;
    
    private String flag;
    
    private String desc;
    
    private String originName;
    
    private String groupType;
    
    private String senderAppID;
    
    public String getResult()
    {
        return result;
    }
    
    public void setResult(String result)
    {
        this.result = result;
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
    
    public String getSenderAppID()
    {
        return senderAppID;
    }
    
    public void setSenderAppID(String senderAppID)
    {
        this.senderAppID = senderAppID;
    }
    
    @Override
    public void notifyCallbackMsg(RestEServerListener listener, MultiAppOnlineModel msg)
    {
        AddGroupMembersResponse payload = new GroupResourceConvert().addGroupMembersModel2Rest((GroupMember)msg);
        processNorthSno(msg, payload);
        listener.sendCallbackMsg(payload, "joingroup");
    }
}
