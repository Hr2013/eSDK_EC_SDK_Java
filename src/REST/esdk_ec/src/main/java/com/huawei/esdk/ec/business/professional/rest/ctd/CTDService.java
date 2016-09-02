/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ec.business.professional.rest.ctd;

import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.Call;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class CTDService
{
    public SDKErrorCode releaseCall(String ctdID)
        throws SDKException
    {
        if (null == ctdID)
        {
            SDKErrorCode sdkErrorCode = new SDKErrorCode();
            sdkErrorCode.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            return sdkErrorCode;
        }
        
        Call call = new Call(ctdID);
        return call.releaseCall();
    }
    
    public SDKResult<Call> getCallStatus(String callID)
        throws SDKException
    {
        Call call = new Call(callID);
        return call.getStatus();
    }
    
    public SDKResult<String> dialCall(Call call)
        throws SDKException
    {
        SDKResult<String> result = null;
        if (null == call)
        {
            // 必填参数校验
            result = new SDKResult<String>();
            result.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            result.setDescription(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return result;
        }

        result = call.dialCallRest(call);
        return result;
    }
}
