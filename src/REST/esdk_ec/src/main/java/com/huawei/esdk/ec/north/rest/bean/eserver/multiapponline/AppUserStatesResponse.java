package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import java.util.List;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.callback.AbstractCallbackMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.AppUserStates;
import com.huawei.esdk.ec.domain.model.multiapponline.MultiAppOnlineModel;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.AppUserStatesResourceConvert;
import com.huawei.esdk.ec.northcommu.rest.callback.RestEServerListener;

public class AppUserStatesResponse extends AbstractCallbackMsg
{
    private String result;
    
    private List<EsdkUserState> targetStateList;
    
    public String getResult()
    {
        return result;
    }
    
    public void setResult(String result)
    {
        this.result = result;
    }
    
    public List<EsdkUserState> getTargetStateList()
    {
        return targetStateList;
    }
    
    public void setTargetStateList(List<EsdkUserState> targetStateList)
    {
        this.targetStateList = targetStateList;
    }
    
    @Override
    public void notifyCallbackMsg(RestEServerListener listener, MultiAppOnlineModel msg)
    {
        AppUserStatesResponse payload =
            new AppUserStatesResourceConvert().getAppUserStatesModel2Rest((AppUserStates)msg);
        processNorthSno(msg, payload);
        listener.sendCallbackMsg(payload, "appuserstate");
    }
}
