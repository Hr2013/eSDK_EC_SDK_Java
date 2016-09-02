package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import java.util.List;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.callback.AbstractCallbackMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.IMGroupInfo;
import com.huawei.esdk.ec.domain.model.multiapponline.MultiAppOnlineModel;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.GroupResourceConvert;
import com.huawei.esdk.ec.northcommu.rest.callback.RestEServerListener;

public class GetGroupMembersResponse extends AbstractCallbackMsg
{
    private String resultCode;
    
    private String imGroupID;
    
    private String syncType;
    
    private String stamp;
    
    private List<IMGroupUser> memberList;
    
    private String existFlag;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getImGroupID()
    {
        return imGroupID;
    }
    
    public void setImGroupID(String imGroupID)
    {
        this.imGroupID = imGroupID;
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
    
    public List<IMGroupUser> getMemberList()
    {
        return memberList;
    }
    
    public void setMemberList(List<IMGroupUser> memberList)
    {
        this.memberList = memberList;
    }
    
    public String getExistFlag()
    {
        return existFlag;
    }
    
    public void setExistFlag(String existFlag)
    {
        this.existFlag = existFlag;
    }
    
    @Override
    public void notifyCallbackMsg(RestEServerListener listener, MultiAppOnlineModel msg)
    {
        GetGroupMembersResponse payload = new GroupResourceConvert().getGroupMembersModel2Rest((IMGroupInfo)msg);
        processNorthSno(msg, payload);
        listener.sendCallbackMsg(payload, "imgroupmem");
    }
    
}
