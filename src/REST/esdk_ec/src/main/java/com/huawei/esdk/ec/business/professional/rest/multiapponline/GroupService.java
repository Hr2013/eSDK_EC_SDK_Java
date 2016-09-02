package com.huawei.esdk.ec.business.professional.rest.multiapponline;

import com.huawei.esdk.ec.domain.model.multiapponline.Group;
import com.huawei.esdk.ec.domain.model.multiapponline.GroupMember;
import com.huawei.esdk.ec.domain.model.multiapponline.IMGroupInfo;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class GroupService
{
    public SDKResult<String> getIMGroup(String queryKey, String isNeedAmount, String count, String senderAppID,
        String senderType, String pageIndex)
        throws SDKException
    {
        return new IMGroupInfo().getIMGroup(queryKey, isNeedAmount, count, senderAppID, senderType, pageIndex);
    }
    
    public SDKResult<String> addGroup(Group imGroup)
        throws SDKException
    {
        return new IMGroupInfo().addGroup(imGroup);
    }
    
    public SDKResult<String> setGroup(Group imGroup)
        throws SDKException
    {
        return new IMGroupInfo().setGroup(imGroup);
    }
    
    public SDKResult<String> delGroup(Group imGroup)
        throws SDKException
    {
        return new IMGroupInfo().delGroup(imGroup);
    }
    
    public SDKResult<String> getGroupMembers(String appId, String imGroupID, String syncType, String stamp)
        throws SDKException
    {
        return new IMGroupInfo().getGroupMembers(appId, imGroupID, syncType, stamp);
    }
    
    public SDKResult<String> addGroupMembers(GroupMember groupMember)
        throws SDKException
    {
        return new IMGroupInfo().addGroupMembers(groupMember);
    }
    
    public SDKResult<String> delGroupMembers(GroupMember groupMember)
        throws SDKException
    {
        return new IMGroupInfo().delGroupMembers(groupMember);
    }
}
