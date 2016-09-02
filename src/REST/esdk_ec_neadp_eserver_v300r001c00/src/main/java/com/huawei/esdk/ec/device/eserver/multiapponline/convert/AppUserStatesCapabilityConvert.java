package com.huawei.esdk.ec.device.eserver.multiapponline.convert;

public class AppUserStatesCapabilityConvert
{
    /*
    public EsdkGetAppUserStateList getAppUserStatesModal2UDP(AppUserStates userStates)
    {
        if (null == userStates)
        {
            return null;
        }
        
        EsdkGetAppUserStateList appUserStateList = new EsdkGetAppUserStateList();
        appUserStateList.appId = userStates.getAppId();
        appUserStateList.user = userStates.getUser();
        appUserStateList.senderType = parseString2Byte(userStates.getSenderType());
        appUserStateList.targets = userStates.getTargets();
        
        return appUserStateList;
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
    
    public AppUserStates getAppUserStatesUDP2Modal(EsdkGetAppUserStateListAck ack)
    {
        if (null == ack)
        {
            return null;
        }
        
        AppUserStates userStates = new AppUserStates();
        userStates.setResult(String.valueOf(ack.result));
        userStates.setTargetStateList(convertTargetStateList(ack.targetStateList));
        
        return userStates;
    }
    
    private List<EsdkUserState> convertTargetStateList(
        List<message.EsdkGetAppUserStateListAck.EsdkUserState> targetStateList)
    {
        if (null == targetStateList || 0 == targetStateList.size())
        {
            return null;
        }
        
        List<EsdkUserState> esdkUserStates = new ArrayList<EsdkUserState>();
        
        for (message.EsdkGetAppUserStateListAck.EsdkUserState targetsState : targetStateList)
        {
            esdkUserStates.add(convertTargetState(targetsState));
        }
        
        return esdkUserStates;
    }
    
    private EsdkUserState convertTargetState(message.EsdkGetAppUserStateListAck.EsdkUserState targetsState)
    {
        if (null == targetsState)
        {
            return null;
        }
        
        EsdkUserState userState = new EsdkUserState();
        userState.setOrigin(targetsState.origin);
        userState.setTarget(targetsState.target);
        userState.setState(String.valueOf(targetsState.state));
        userState.setClientType(String.valueOf(targetsState.clientType));
        userState.setClientDesc(targetsState.clientDesc);
        userState.setOriginAppId(targetsState.originAppId);
        userState.setDeviceToken(targetsState.deviceToken);
        
        return userState;
    }
    */}
