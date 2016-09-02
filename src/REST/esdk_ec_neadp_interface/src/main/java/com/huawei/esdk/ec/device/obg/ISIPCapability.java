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
package com.huawei.esdk.ec.device.obg;

import java.util.List;

import com.huawei.esdk.ec.domain.model.SIP;
import com.huawei.esdk.ec.domain.model.bean.GatewayList;
import com.huawei.esdk.ec.domain.model.bean.SIPCondition;
import com.huawei.esdk.ec.domain.model.bean.SIPList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

public interface ISIPCapability
{
    /**
     * 添加SIP号码
     * @param userid
     * @param sip
     * @return
     */
    SDKErrorCode addSipNum(String userId, SIP sip);
    
    /**
     * 修改SIP号码
     * @param userId
     * @param sip
     * @return
     */
    SDKErrorCode modifySipNum(String userId, SIP sip);

    /**修改SIP号码密码
     * @param userId
     * @param sip
     * @return
     */
    SDKErrorCode modifySipPassword(String userId, SIP sip);

    /**
     * 删除SIP号码
     * @param userId
     * @param sip
     * @return
     */
    SDKErrorCode deleteSip(String userId, SIP sip);

    /**
     * 批量删除SIP号码
     * @param userId
     * @param sips
     * @return
     */
    SDKResult<SIPList> batchDeleteSip(String userId, List<SIP> sips);

    /**
     * 查询SIP号码
     * @param userId
     * @param sipCon
     * @return
     */
    SDKResult<SIPList> querySip(String userId, SIPCondition sipCon);

    /**
     * 查询网关列表
     * @param userId
     * @return
     */
    SDKResult<GatewayList> queryGateway(String userId);

    /**
     * 批量添加SIP号码
     * @param userId
     * @param sips
     * @return
     */
    SDKErrorCode addSipNums(String userId, String numStep, String uestep, String amount, SIP sip);
}
