package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.callback.AbstractCallbackMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.GroupMember;
import com.huawei.esdk.ec.domain.model.multiapponline.MultiAppOnlineModel;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.GroupResourceConvert;
import com.huawei.esdk.ec.northcommu.rest.callback.RestEServerListener;

public class DelGroupMembersResponse extends AbstractCallbackMsg
{
    private String result;
    
    private String target;
    
    private String groupID;
    
    private String flag;
    
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
    
    public String getFlag()
    {
        return flag;
    }
    
    public void setFlag(String flag)
    {
        this.flag = flag;
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
        DelGroupMembersResponse payload = new GroupResourceConvert().delGroupMembersModel2Rest((GroupMember)msg);
        processNorthSno(msg, payload);
        listener.sendCallbackMsg(payload, "leavegroup");
    }
}
