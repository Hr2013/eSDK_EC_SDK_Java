package com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.domain.model.multiapponline.AppUserStates;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.AppUserStatesRequest;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.AppUserStatesResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.EsdkUserState;

public class AppUserStatesResourceConvert
{
    public AppUserStates getAppUserStatesRest2Model(AppUserStatesRequest request)
    {
        if (null == request)
        {
            return null;
        }
        
        AppUserStates appUserStates = new AppUserStates();
        appUserStates.setUser(request.getUser());
        appUserStates.setTargets(request.getTargets());
        appUserStates.setAppId(request.getAppId());
        appUserStates.setSenderType(request.getSenderType());
        
        return appUserStates;
    }
    
    public AppUserStatesResponse getAppUserStatesModel2Rest(AppUserStates appUserStates)
    {
        if (null == appUserStates)
        {
            return null;
        }
        
        AppUserStatesResponse response = new AppUserStatesResponse();
        
        response.setResult(appUserStates.getResult());
        response.setTargetStateList(convertTargetStateList(appUserStates.getTargetStateList()));
        
        return response;
    }
    
    private List<EsdkUserState> convertTargetStateList(
        List<com.huawei.esdk.ec.domain.model.multiapponline.EsdkUserState> targetStateList)
    {
        if (null == targetStateList || 0 == targetStateList.size())
        {
            return null;
        }
        
        List<EsdkUserState> esdkUserStates = new ArrayList<EsdkUserState>();
        
        for (com.huawei.esdk.ec.domain.model.multiapponline.EsdkUserState targetState : targetStateList)
        {
            esdkUserStates.add(convertTargetState(targetState));
        }
        
        return esdkUserStates;
    }
    
    private EsdkUserState convertTargetState(com.huawei.esdk.ec.domain.model.multiapponline.EsdkUserState targetState)
    {
        if (null == targetState)
        {
            return null;
        }
        
        EsdkUserState esdkUserState = new EsdkUserState();
        esdkUserState.setOrigin(targetState.getOrigin());
        esdkUserState.setTarget(targetState.getTarget());
        esdkUserState.setState(targetState.getState());
        esdkUserState.setClientType(targetState.getClientType());
        esdkUserState.setClientDesc(targetState.getClientDesc());
        esdkUserState.setOriginAppId(targetState.getOriginAppId());
        esdkUserState.setDeviceToken(targetState.getDeviceToken());
        
        return esdkUserState;
    }
}
