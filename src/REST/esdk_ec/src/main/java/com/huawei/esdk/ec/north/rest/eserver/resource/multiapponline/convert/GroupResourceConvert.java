package com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.domain.model.multiapponline.Group;
import com.huawei.esdk.ec.domain.model.multiapponline.GroupMember;
import com.huawei.esdk.ec.domain.model.multiapponline.IMGroup;
import com.huawei.esdk.ec.domain.model.multiapponline.IMGroupInfo;
import com.huawei.esdk.ec.domain.model.multiapponline.IMGroupUser;
import com.huawei.esdk.ec.domain.model.multiapponline.User;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.AddGroupMembersRequest;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.AddGroupMembersResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GroupResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.DelGroupMembersRequest;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.DelGroupMembersResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GetGroupMembersResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GetIMGroupResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GroupRequest;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class GroupResourceConvert
{
    public GetIMGroupResponse getIMGroupModel2Rest(IMGroupInfo imGroupInfo)
    {
        GetIMGroupResponse response = new GetIMGroupResponse();
        
        if (null != imGroupInfo)
        {
            response.setPageIndex(imGroupInfo.getPageIndex());
            response.setRecordAmount(imGroupInfo.getRecordAmount());
            response.setCount(imGroupInfo.getCount());
            response.setImGroupList(convertIMGroupList(imGroupInfo.getImGroups()));
            response.setResultCode(imGroupInfo.getResultCode());
        }
        
        return response;
    }
    
    private List<com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroup> convertIMGroupList(
        List<IMGroup> imGroupList)
    {
        if (null == imGroupList || 0 == imGroupList.size())
        {
            return null;
        }
        
        List<com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroup> imGroups =
            new ArrayList<com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroup>();
        
        for (IMGroup imGroup : imGroupList)
        {
            imGroups.add(convertIMGroup(imGroup));
        }
        
        return imGroups;
    }
    
    private com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroup convertIMGroup(IMGroup imGroup)
    {
        if (null == imGroup)
        {
            return null;
        }
        
        com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroup group =
            new com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroup();
        group.setId(imGroup.getId());
        group.setName(imGroup.getName());
        group.setOwner(imGroup.getOwner());
        group.setCapacity(imGroup.getCapacity());
        group.setManifesto(imGroup.getManifesto());
        group.setJoinFlag(imGroup.getJoinFlag());
        group.setState(imGroup.getState());
        group.setMemberList(convertMemberList(imGroup.getMemberList()));
        group.setDesc(imGroup.getDesc());
        group.setPolicy(imGroup.getPolicy());
        group.setGroupType(imGroup.getGroupType());
        group.setFixDiscuss(imGroup.getFixdiscuss());
        group.setSingleFileSpace(imGroup.getSingleFileSpace());
        group.setLastGroupFileUploadTime(imGroup.getLastGroupFileUploadTime());
        group.setAppId(imGroup.getAppId());
        group.setAppName(imGroup.getAppName());
        
        return group;
    }
    
    public Group buildGroup(GroupRequest request)
    {
        if (null == request)
        {
            return null;
        }
        
        Group group = new Group();
        group.setOrigin(request.getOrigin());
        group.setGroupID(request.getGroupID());
        group.setName(request.getName());
        group.setCapacity(request.getCapacity());
        group.setOwner(request.getOwner());
        group.setJoinFlag(request.getJoinFlag());
        group.setManifesto(request.getManifesto());
        group.setDesc(request.getDesc());
        group.setGroupType(request.getGroupType());
        group.setInviteList(request.getInviteList());
        group.setFixDiscuss(request.getFixDiscuss());
        group.setSenderAppID(request.getSenderAppID());
        group.setSenderType(request.getSenderType());
        
        return group;
    }
    
    public GetGroupMembersResponse getGroupMembersModel2Rest(IMGroupInfo imGroupInfo)
    {
        GetGroupMembersResponse response = new GetGroupMembersResponse();
        
        if (null != imGroupInfo)
        {
            response.setImGroupID(imGroupInfo.getGroupId());
            response.setSyncType(imGroupInfo.getSyncType());
            response.setStamp(imGroupInfo.getStamp());
            
            response.setMemberList(convertMemberList(imGroupInfo.getGroupMembers()));
            response.setResultCode(imGroupInfo.getResultCode());
            
            response.setExistFlag(imGroupInfo.getExistFlag());
        }
        
        return response;
    }
    
    private List<com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroupUser> convertMemberList(
        List<IMGroupUser> memberList)
    {
        if (null == memberList || 0 == memberList.size())
        {
            return null;
        }
        
        List<com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroupUser> imGroupUsers =
            new ArrayList<com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroupUser>();
        
        for (IMGroupUser imGroupUser : memberList)
        {
            imGroupUsers.add(convertMember(imGroupUser));
        }
        
        return imGroupUsers;
    }
    
    private com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroupUser convertMember(IMGroupUser imGroupUser)
    {
        if (null == imGroupUser)
        {
            return null;
        }
        
        com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroupUser groupUser =
            new com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.IMGroupUser();
        groupUser.setGroupID(String.valueOf(imGroupUser.getGroupID()));
        groupUser.setType(imGroupUser.getType());
        groupUser.setState(imGroupUser.getState());
        groupUser.setUserAccount(imGroupUser.getUserAccount());
        groupUser.setUser(convertUser(imGroupUser.getUser()));
        groupUser.setUserID(String.valueOf(imGroupUser.getUserID()));
        
        return groupUser;
    }
    
    private com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.User convertUser(User user)
    {
        if (null == user)
        {
            return null;
        }
        
        com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.User u =
            new com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.User();
        u.setStaffId(user.getStaffId());
        u.setUserAccount(user.getUserAccount());
        u.setStaffNo(user.getStaffNo());
        u.setUserName(user.getUserName());
        u.setNativeName(user.getNativeName());
        u.setNickName(user.getNickName());
        u.setqPinYin(user.getqPinYin());
        u.setSex(user.getSex());
        u.setBirthday(user.getBirthday());
        u.setAge(user.getAge());
        u.setMobile(user.getMobile());
        u.setHomePhone(user.getHomePhone());
        u.setOfficePhone(user.getOfficePhone());
        u.setShortPhone(user.getShortPhone());
        u.setOtherPhone(user.getOtherPhone());
        u.setOtherPhone2(user.getOtherPhone2());
        u.setFax(user.getFax());
        u.setEmail(user.getEmail());
        u.setWebsite(user.getWebsite());
        u.setUnderwrite(user.getUnderwrite());
        u.setDesc(user.getDesc());
        u.setAddr(user.getAddr());
        u.setPicId(user.getPicId());
        u.setCountry(user.getCountry());
        u.setProvince(user.getProvince());
        u.setCity(user.getCity());
        u.setZip(user.getZip());
        u.setUcNo(user.getUcNo());
        u.setVoIp(user.getVoIp());
        u.setIsSecrecy(user.getIsSecrecy());
        u.setTitle(user.getTitle());
        u.setBindNo(user.getBindNo());
        u.setDeptID(user.getDeptID());
        u.setState(user.getState());
        u.setVoipMobile(user.getVoipMobile());
        u.setVoipOther(user.getVoipOther());
        u.setDeptNameEn(user.getDeptNameEn());
        u.setDeptNameCn(user.getDeptNameCn());
        u.setSeat(user.getSeat());
        u.setIpPhone(user.getIpPhone());
        u.setOriginMobile(user.getOriginMobile());
        u.setImageSyncTime(user.getImageSyncTime());
        u.setOldStaffAccount(user.getOldStaffAccount());
        u.setModifyTime(user.getModifyTime());
        
        return u;
    }
    
    public GroupMember addGroupMembersRest2model(AddGroupMembersRequest request)
    {
        GroupMember groupMember = new GroupMember();
        groupMember.setOrigin(request.getOrigin());
        groupMember.setTargets(request.getTargets());
        groupMember.setGroupID(request.getGroupID());
        groupMember.setName(request.getName());
        groupMember.setFlag(request.getFlag());
        groupMember.setDesc(request.getDesc());
        groupMember.setOriginName(request.getOriginName());
        groupMember.setGroupType(request.getGroupType());
        groupMember.setMsgId(request.getMsgId());
        groupMember.setSenderAppID(request.getSenderAppID());
        groupMember.setSenderType(request.getSenderType());
        
        return groupMember;
    }
    
    public AddGroupMembersResponse addGroupMembersModel2Rest(GroupMember groupMember)
    {
        AddGroupMembersResponse response = new AddGroupMembersResponse();
        
        if (null != groupMember)
        {
            response.setOrigin(groupMember.getOrigin());
            response.setTarget(groupMember.getTarget());
            response.setGroupID(groupMember.getGroupID());
            response.setName(groupMember.getName());
            response.setFlag(groupMember.getFlag());
            response.setDesc(groupMember.getDesc());
            response.setOriginName(groupMember.getOriginName());
            response.setGroupType(groupMember.getGroupType());
            response.setSenderAppID(groupMember.getSenderAppID());
            response.setResult(groupMember.getResult());
        }
        
        return response;
    }
    
    public GroupMember delGroupMembersRest2model(DelGroupMembersRequest request)
    {
        GroupMember groupMember = new GroupMember();
        groupMember.setOrigin(request.getOrigin());
        groupMember.setGroupID(request.getGroupID());
        groupMember.setFlag(request.getFlag());
        groupMember.setMembers(request.getMembers());
        groupMember.setGroupType(request.getGroupType());
        groupMember.setSenderAppID(request.getSenderAppID());
        groupMember.setSenderType(request.getSenderType());
        
        return groupMember;
    }
    
    public DelGroupMembersResponse delGroupMembersModel2Rest(GroupMember groupMember)
    {
        DelGroupMembersResponse response = new DelGroupMembersResponse();
        
        if (null != groupMember)
        {
            response.setTarget(groupMember.getTarget());
            response.setGroupID(groupMember.getGroupID());
            response.setFlag(groupMember.getFlag());
            response.setGroupType(groupMember.getGroupType());
            response.setSenderAppID(groupMember.getSenderAppID());
            response.setResult(groupMember.getResult());
        }
        
        return response;
    }
    
    public GroupResponse addGroupModel2Rest(IMGroupInfo imGroupInfo)
    {
        GroupResponse response = new GroupResponse();
        
        if (null != imGroupInfo)
        {
            response.setTarget(imGroupInfo.getTarget());
            response.setGroupID(imGroupInfo.getGroupId());
            response.setAddFailMemberList(imGroupInfo.getAddFailMemberList());
            response.setFixDiscuss(imGroupInfo.getFixDiscuss());
            response.setResult(imGroupInfo.getResultCode());
            response.setOpType(imGroupInfo.getOpType());
        }
        
        return response;
    }
    
    public boolean validateTargets(List<String> strs)
    {
        if (null == strs || 0 == strs.size())
        {
            return true;
        }
        
        for (String str : strs)
        {
            if (StringUtils.isEmpty(str))
            {
                return true;
            }
        }
        
        return false;
    }
}
