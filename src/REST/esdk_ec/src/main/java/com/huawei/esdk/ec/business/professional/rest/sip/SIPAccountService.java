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
package com.huawei.esdk.ec.business.professional.rest.sip;

import java.util.List;

import com.huawei.esdk.ec.domain.model.SIP;
import com.huawei.esdk.ec.domain.model.bean.GatewayList;
import com.huawei.esdk.ec.domain.model.bean.SIPCondition;
import com.huawei.esdk.ec.domain.model.bean.SIPList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class SIPAccountService
{
    
    public SDKErrorCode addSIP(String userId, SIP sip)
        throws SDKException
    {
        return sip.addSIP(userId, sip);
    }
    
    public SDKErrorCode modifySIP(String userId, SIP sip)
        throws SDKException
    {
        return sip.modifySIP(userId, sip);
    }
    
    public SDKErrorCode modifySipPassword(String userId, SIP sip)
        throws SDKException
    {
        return sip.modifySipPassword(userId, sip);
    }
    
    public SDKErrorCode deleteSip(String userId, SIP sip)
        throws SDKException
    {
        return sip.deleteSip(userId, sip);
    }
    
    public SDKResult<SIPList> batchDeleteSip(String userId, List<SIP> sips)
        throws SDKException
    {
        return new SIP().batchDeleteSip(userId, sips);
    }
    
    public SDKResult<SIPList> querySip(String userId, SIPCondition sipCon)
        throws SDKException
    {
        return new SIP().querySip(userId, sipCon);
    }

    public SDKResult<GatewayList> queryGateway(String userId)
        throws SDKException
    {
        return new SIP().queryGateway(userId);
    }

    public SDKErrorCode addSIPs(String userId, String numStep, String uestep, String amount, SIP sip) throws SDKException
    {
        return new SIP().addSIPs(userId, numStep, uestep, amount, sip);
    }
    
}
