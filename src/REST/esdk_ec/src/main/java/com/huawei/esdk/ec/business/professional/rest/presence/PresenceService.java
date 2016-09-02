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
package com.huawei.esdk.ec.business.professional.rest.presence;

import java.util.List;

import com.huawei.esdk.ec.domain.model.UserState;
import com.huawei.esdk.ec.domain.model.UserStateListAck;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 用户状态业务层
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  com.huawei.esdk.ec.business.professional.rest.presence.PresenceService
 * @since eSDK EC V100R003C00
 */
public class PresenceService
{
    
    /** 
     * 批量查询用户状态
     * @author wangxiaobo/wWX233376
     * @param user
     * @param queryUsers
     * @return
     * @throws SDKException
     * @see com.huawei.esdk.ec.business.professional.rest.presence.PresenceService
     */
    public SDKResult<UserStateListAck> queryUCListPresence(List<String> queryUsers)
        throws SDKException
    {
        return new UserState().queryUCPresence(queryUsers);
    }
}
