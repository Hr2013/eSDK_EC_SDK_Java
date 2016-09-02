package com.huawei.esdk.ec.devices.eserver.multiapponline;

import com.huawei.esdk.ec.domain.model.multiapponline.AppUserStates;
import com.huawei.esdk.platform.common.SDKResult;

public interface IAppUserStatesCapability
{
    SDKResult<String> getAppUserStates(AppUserStates userStates);
}
