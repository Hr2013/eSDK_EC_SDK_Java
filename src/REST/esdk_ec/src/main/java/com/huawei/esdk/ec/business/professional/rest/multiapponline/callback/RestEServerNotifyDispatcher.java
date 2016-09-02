/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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
package com.huawei.esdk.ec.business.professional.rest.multiapponline.callback;

import com.huawei.esdk.ec.domain.model.multiapponline.MultiAppOnlineModel;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.AddGroupMembersResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.AppUserStatesResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.DelGroupMembersResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GetGroupMembersResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GetIMGroupResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GroupIMResponse;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GroupResponse;
import com.huawei.esdk.ec.northcommu.rest.callback.RestEServerListener;
import com.huawei.esdk.platform.common.notification.NotifyDispatcher;

/**
 * EServer通知分发类
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class RestEServerNotifyDispatcher extends NotifyDispatcher<RestEServerListener>
{
    @Override
    public boolean notifyToOneListener(RestEServerListener listener, String ntfId, Object msg, Object additionalInfo)
    {
        int index = Integer.parseInt(ntfId);
        
        AbstractCallbackMsg[] objArr =
            {new GroupResponse(), new GetIMGroupResponse(), new GetGroupMembersResponse(),
                new AddGroupMembersResponse(), new DelGroupMembersResponse(), new GroupIMResponse(),
                new AppUserStatesResponse()};
        objArr[index].notifyCallbackMsg(listener, (MultiAppOnlineModel)msg);
        
        return true;
    }
    
}
