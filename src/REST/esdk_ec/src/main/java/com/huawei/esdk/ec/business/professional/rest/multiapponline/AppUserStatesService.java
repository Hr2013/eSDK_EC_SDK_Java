package com.huawei.esdk.ec.business.professional.rest.multiapponline;

import com.huawei.esdk.ec.domain.model.multiapponline.AppUserStates;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class AppUserStatesService
{
    public SDKResult<String> getAppUserStates(AppUserStates userStates)
        throws SDKException
    {
        return new AppUserStates().getAppUserStates(userStates);
    }
    
}
