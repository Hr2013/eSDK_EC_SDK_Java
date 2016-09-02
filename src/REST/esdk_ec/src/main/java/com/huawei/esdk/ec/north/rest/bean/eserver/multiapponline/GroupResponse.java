package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import java.util.List;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.callback.AbstractCallbackMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.IMGroupInfo;
import com.huawei.esdk.ec.domain.model.multiapponline.MultiAppOnlineModel;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.GroupResourceConvert;
import com.huawei.esdk.ec.northcommu.rest.callback.RestEServerListener;

public class GroupResponse extends AbstractCallbackMsg
{
    private String result;
    
    private String target;
    
    private String groupID;
    
    private List<String> addFailMemberList;
    
    private String fixDiscuss;
    
    private String opType;
    
    public String getResult()
    {
        return result;
    }
    
    public void setResult(String result)
    {
        this.result = result;
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
    
    public List<String> getAddFailMemberList()
    {
        return addFailMemberList;
    }
    
    public void setAddFailMemberList(List<String> addFailMemberList)
    {
        this.addFailMemberList = addFailMemberList;
    }
    
    @Override
    public void notifyCallbackMsg(RestEServerListener listener, MultiAppOnlineModel msg)
    {
        GroupResponse payload = new GroupResourceConvert().addGroupModel2Rest((IMGroupInfo)msg);
        processNorthSno(msg, payload);
        listener.sendCallbackMsg(payload, "group");
    }
}
