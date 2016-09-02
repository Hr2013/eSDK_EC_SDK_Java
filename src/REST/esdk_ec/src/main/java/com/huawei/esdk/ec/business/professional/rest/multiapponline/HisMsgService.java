package com.huawei.esdk.ec.business.professional.rest.multiapponline;

import com.huawei.esdk.ec.domain.model.multiapponline.HisMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.HisMsgInfoModel;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class HisMsgService
{
    public SDKResult<HisMsgInfoModel> getHisMsg(HisMsg hisMsg)
        throws SDKException
    {
        return new HisMsgInfoModel().getHisMsg(hisMsg);
    }
}
