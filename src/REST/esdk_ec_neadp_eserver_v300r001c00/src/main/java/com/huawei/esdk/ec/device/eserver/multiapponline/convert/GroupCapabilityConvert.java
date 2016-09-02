package com.huawei.esdk.ec.device.eserver.multiapponline.convert;

public class GroupCapabilityConvert
{
    /*
    public IMGroupQuery getIMGroupModal2UDP(String queryKey, String isNeedAmount, String count, String senderAppID,
        String senderType, String pageIndex)
    {
        IMGroupQuery imGroupQuery = new IMGroupQuery();
        imGroupQuery.queryKey = queryKey;
        imGroupQuery.isNeedAmount = isNeedAmount;
        
        if (null != parseString2Int(count))
        {
            imGroupQuery.count = parseString2Int(count);
        }
        
        imGroupQuery.senderAppID = senderAppID;
        
        imGroupQuery.senderType = parseString2Byte(senderType);
        
        if (null != parseString2Int(pageIndex))
        {
            imGroupQuery.pageIndex = parseString2Int(pageIndex);
        }
        
        return imGroupQuery;
    }
    
    public IMGroupInfo getIMGroupUDP2Rest(IMGroupQueryAck imGroupQueryAck)
    {
        if (imGroupQueryAck == null)
        {
            return null;
        }
        
        IMGroupInfo imGroupInfo = new IMGroupInfo();
        imGroupInfo.setPageIndex(String.valueOf(imGroupQueryAck.pageIndex));
        imGroupInfo.setRecordAmount(String.valueOf(imGroupQueryAck.recordAmount));
        imGroupInfo.setCount(String.valueOf(imGroupQueryAck.count));
        
        imGroupInfo.setImGroups(convertIMGroupList(imGroupQueryAck.imGroupList));
        imGroupInfo.setResultCode(String.valueOf(imGroupQueryAck.resultCode));
        
        return imGroupInfo;
    }
    
    private List<IMGroup> convertIMGroupList(List<data.userdata.basic.IMGroup> imGroupList)
    {
        if (null == imGroupList || 0 == imGroupList.size())
        {
            return null;
        }
        
        List<IMGroup> imGroups = new ArrayList<IMGroup>();
        
        for (data.userdata.basic.IMGroup imGroup : imGroupList)
        {
            imGroups.add(convertIMGroup(imGroup));
        }
        
        return imGroups;
    }
    
    private IMGroup convertIMGroup(data.userdata.basic.IMGroup imGroup)
    {
        if (null == imGroup)
        {
            return null;
        }
        
        IMGroup group = new IMGroup();
        group.setId(String.valueOf(imGroup.id));
        group.setName(imGroup.name);
        group.setOwner(imGroup.owner);
        group.setCapacity(imGroup.capacity);
        group.setManifesto(imGroup.manifesto);
        group.setJoinFlag(imGroup.joinFlag);
        group.setState(imGroup.state);
        group.setMemberList(convertMemberList(imGroup.memberList));
        group.setDesc(imGroup.desc);
        group.setPolicy(String.valueOf(imGroup.policy));
        group.setGroupType(String.valueOf(imGroup.groupType));
        group.setFixdiscuss(String.valueOf(imGroup.fixdiscuss));
        group.setSingleFileSpace(String.valueOf(imGroup.singleFileSpace));
        group.setLastGroupFileUploadTime(imGroup.lastGroupFileUploadTime);
        group.setAppId(imGroup.appId);
        group.setAppName(imGroup.appName);
        
        return group;
    }
    
    private List<IMGroupUser> convertMemberList(List<data.userdata.basic.IMGroupUser> memberList)
    {
        if (null == memberList || 0 == memberList.size())
        {
            return null;
        }
        
        List<IMGroupUser> imGroupUsers = new ArrayList<IMGroupUser>();
        
        for (data.userdata.basic.IMGroupUser imGroupUser : memberList)
        {
            imGroupUsers.add(convertMember(imGroupUser));
        }
        
        return imGroupUsers;
    }
    
    private IMGroupUser convertMember(data.userdata.basic.IMGroupUser imGroupUser)
    {
        if (null == imGroupUser)
        {
            return null;
        }
        
        IMGroupUser groupUser = new IMGroupUser();
        groupUser.setGroupID(String.valueOf(imGroupUser.groupID));
        groupUser.setType(imGroupUser.type);
        groupUser.setState(imGroupUser.state);
        groupUser.setUserAccount(imGroupUser.userAccount);
        groupUser.setUser(convertUser(imGroupUser.user));
        groupUser.setUserID(String.valueOf(imGroupUser.userID));
        
        return groupUser;
    }
    
    private User convertUser(data.userdata.basic.User user)
    {
        if (null == user)
        {
            return null;
        }
        
        User u = new User();
        u.setStaffId(String.valueOf(user.staffId));
        u.setUserAccount(user.userAccount);
        u.setStaffNo(user.staffNo);
        u.setUserName(user.userName);
        u.setNativeName(user.nativeName);
        u.setNickName(user.nickName);
        u.setqPinYin(user.qPinYin);
        u.setSex(user.sex);
        u.setBirthday(user.birthday);
        u.setAge(user.age);
        u.setMobile(user.mobile);
        u.setHomePhone(user.homePhone);
        u.setOfficePhone(user.officePhone);
        u.setShortPhone(user.shortPhone);
        u.setOtherPhone(user.otherPhone);
        u.setOtherPhone2(user.otherPhone2);
        u.setFax(user.fax);
        u.setEmail(user.email);
        u.setWebsite(user.website);
        u.setUnderwrite(user.underwrite);
        u.setDesc(user.desc);
        u.setAddr(user.addr);
        u.setPicId(user.picId);
        u.setCountry(user.country);
        u.setProvince(user.province);
        u.setCity(user.city);
        u.setZip(user.zip);
        u.setUcNo(user.ucNo);
        u.setVoIp(user.voIp);
        u.setIsSecrecy(user.isSecrecy);
        u.setTitle(user.title);
        u.setBindNo(user.bindNo);
        u.setDeptID(user.deptID);
        u.setState(user.state);
        u.setVoipMobile(user.voipMobile);
        u.setVoipOther(user.voipOther);
        u.setDeptNameEn(user.deptNameEn);
        u.setDeptNameCn(user.deptNameCn);
        u.setSeat(user.seat);
        u.setIpPhone(user.ipPhone);
        u.setOriginMobile(user.originMobile);
        u.setImageSyncTime(user.imageSyncTime);
        u.setOldStaffAccount(user.oldStaffAccount);
        u.setModifyTime(user.modifyTime);
        
        return u;
    }
    
    public message.Group addGroupModal2UDP(Group imGroup)
    {
        return buildGroup(imGroup, 0);
    }
    
    public message.Group delGroupModal2UDP(Group imGroup)
    {
        return buildGroup(imGroup, 1);
    }
    
    public message.Group setGroupModal2UDP(Group imGroup)
    {
        return buildGroup(imGroup, 2);
    }
    
    *//**
      * 0:创建群
      * 1:删除群
      * 2:修改群
      * 3:转让群
      */
    /*
    public message.Group buildGroup(Group imGroup, int opType)
    {
     if (null == imGroup)
     {
         return null;
     }
     
     message.Group group = new message.Group();
     
     group.origin = imGroup.getOrigin();
     group.groupID = imGroup.getGroupID();
     group.name = imGroup.getName();
     group.capacity = parseString2Int(imGroup.getCapacity());
     group.owner = imGroup.getOwner();
     
     group.joinFlag = parseString2Byte(imGroup.getJoinFlag());
     
     group.manifesto = imGroup.getManifesto();
     group.desc = imGroup.getDesc();
     
     group.groupType = parseString2Byte(imGroup.getGroupType());
     
     group.invitelist = convertList2Str(imGroup.getInviteList());
     group.fixDiscuss = "1".equals(imGroup.getFixDiscuss());//0:不固化；1:固化
     group.senderAppID = imGroup.getSenderAppID();
     
     group.senderType = parseString2Byte(imGroup.getSenderType());
     
     group.opType = (byte)opType;
     
     return group;
    }
    
    private String convertList2Str(List<String> strs)
    {
     if (null == strs || 0 == strs.size())
     {
         return null;
     }
     
     StringBuilder builder = null;
     
     for (String str : strs)
     {
         if (null == builder)
         {
             builder = new StringBuilder();
         }
         else
         {
             builder.append(";");
         }
         
         builder.append(str);
     }
     
     return builder.toString();
    }
    
    private byte parseString2Byte(String str)
    {
     try
     {
         return Byte.parseByte(str);
     }
     catch (NumberFormatException e)
     {
         return 0;
     }
    }
    
    private Integer parseString2Int(String str)
    {
     try
     {
         return Integer.parseInt(str);
     }
     catch (NumberFormatException e)
     {
         return null;
     }
    }
    
    private Long parseString2Long(String str)
    {
     try
     {
         return Long.parseLong(str);
     }
     catch (NumberFormatException e)
     {
         return null;
     }
    }
    
    public IMGroupInfo operateGroupUDP2Rest(GroupAck groupAck)
    {
     if (null == groupAck)
     {
         return null;
     }
     
     IMGroupInfo imGroupInfo = new IMGroupInfo();
     imGroupInfo.setTarget(groupAck.target);
     imGroupInfo.setGroupId(groupAck.groupID);
     imGroupInfo.setAddFailMemberList(groupAck.addFailMemberList);
     imGroupInfo.setResultCode(String.valueOf(groupAck.result));
     imGroupInfo.setOpType(String.valueOf(groupAck.opType));
     imGroupInfo.setFixDiscuss(groupAck.fixDiscuss);
     
     return imGroupInfo;
    }
    
    public IMGroupMemQuery getGroupMembersModal2UDP(String imGroupID, String syncType, String stamp)
    {
     IMGroupMemQuery imGroupMemQuery = new IMGroupMemQuery();
     
     imGroupMemQuery.imGroupID = parseString2Long(imGroupID);
     imGroupMemQuery.syncType = syncType;
     imGroupMemQuery.stamp = stamp;
     
     return imGroupMemQuery;
    }
    
    public IMGroupInfo getGroupMemberUDP2Rest(IMGroupMemQueryAck imGroupMemQueryAck)
    {
     if (imGroupMemQueryAck == null)
     {
         return null;
     }
     
     IMGroupInfo imGroupInfo = new IMGroupInfo();
     
     imGroupInfo.setGroupId(String.valueOf(imGroupMemQueryAck.imGroupID));
     imGroupInfo.setSyncType(imGroupMemQueryAck.syncType);
     imGroupInfo.setStamp(imGroupMemQueryAck.stamp);
     
     imGroupInfo.setGroupMembers(convertMemberList(imGroupMemQueryAck.memberList));
     
     imGroupInfo.setResultCode(String.valueOf(imGroupMemQueryAck.resultCode));
     
     imGroupInfo.setExistFlag(String.valueOf(imGroupMemQueryAck.existFlag));
     
     return imGroupInfo;
    }
    
    public JoinGroup addGroupMembersModal2UDP(GroupMember groupMember)
    {
     if (null == groupMember)
     {
         return null;
     }
     
     JoinGroup joinGroup = new JoinGroup();
     joinGroup.origin = groupMember.getOrigin();
     joinGroup.target = convertList2Str(groupMember.getTargets());
     joinGroup.groupID = groupMember.getGroupID();
     joinGroup.name = groupMember.getName();
     joinGroup.flag = parseString2Byte(groupMember.getFlag());
     joinGroup.desc = groupMember.getDesc();
     joinGroup.originName = groupMember.getOriginName();
     joinGroup.groupType = parseString2Byte(groupMember.getGroupType());
     joinGroup.msgId = parseString2Long(groupMember.getMsgId());
     joinGroup.senderAppID = groupMember.getSenderAppID();
     joinGroup.senderType = parseString2Byte(groupMember.getSenderType());
     
     return joinGroup;
    }
    
    public GroupMember addGroupMembersUDP2Rest(JoinGroupAck joinGroupAck)
    {
     if (null == joinGroupAck)
     {
         return null;
     }
     
     GroupMember groupMember = new GroupMember();
     groupMember.setOrigin(joinGroupAck.origin);
     groupMember.setTarget(joinGroupAck.target);
     groupMember.setGroupID(joinGroupAck.groupID);
     groupMember.setName(joinGroupAck.name);
     groupMember.setFlag(String.valueOf(joinGroupAck.flag));
     groupMember.setDesc(joinGroupAck.desc);
     groupMember.setOriginName(joinGroupAck.originName);
     groupMember.setGroupType(String.valueOf(joinGroupAck.groupType));
     groupMember.setSenderAppID(joinGroupAck.senderAppID);
     
     groupMember.setResult(String.valueOf(joinGroupAck.result));
     
     return groupMember;
    }
    
    public LeaveGroup delGroupMembersModal2UDP(GroupMember groupMember)
    {
     if (null == groupMember)
     {
         return null;
     }
     
     LeaveGroup leaveGroup = new LeaveGroup();
     leaveGroup.origin = groupMember.getOrigin();
     leaveGroup.groupID = groupMember.getGroupID();
     leaveGroup.flag = parseString2Byte(groupMember.getFlag());
     leaveGroup.members = convertList2Str(groupMember.getMembers());
     leaveGroup.groupType = parseString2Byte(groupMember.getGroupType());
     leaveGroup.senderAppID = groupMember.getSenderAppID();
     leaveGroup.senderType = parseString2Byte(groupMember.getSenderType());
     
     return leaveGroup;
    }
    
    public GroupMember delGroupMembersUDP2Rest(LeaveGroupAck leaveGroupAck)
    {
     if (null == leaveGroupAck)
     {
         return null;
     }
     
     GroupMember groupMember = new GroupMember();
     groupMember.setTarget(leaveGroupAck.target);
     groupMember.setGroupID(leaveGroupAck.groupID);
     groupMember.setFlag(String.valueOf(leaveGroupAck.flag));
     groupMember.setGroupType(String.valueOf(leaveGroupAck.groupType));
     groupMember.setSenderAppID(leaveGroupAck.senderAppID);
     groupMember.setResult(String.valueOf(leaveGroupAck.result));
     
     return groupMember;
    }
    */}
