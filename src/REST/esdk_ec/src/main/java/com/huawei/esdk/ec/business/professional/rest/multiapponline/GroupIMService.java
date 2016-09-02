package com.huawei.esdk.ec.business.professional.rest.multiapponline;

import com.huawei.esdk.ec.domain.model.multiapponline.GroupIMModel;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class GroupIMService
{
    public SDKResult<String> sendGroupIm(GroupIMModel groupIm)
        throws SDKException
    {
        return new GroupIMModel().sendGroupIm(groupIm);
    }
}
