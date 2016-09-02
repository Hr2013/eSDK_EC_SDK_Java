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

import com.huawei.esdk.ec.northcommu.rest.callback.RestEServerListener;
import com.huawei.esdk.platform.callback.CallbackBase;
import com.huawei.esdk.platform.callback.itf.ICallback;
import com.huawei.esdk.platform.common.notification.NotifyDispatcher;

public class RestNotifyEServerCallback extends CallbackBase implements ICallback
{
    public RestNotifyEServerCallback(String url)
    {
        NotifyDispatcher<RestEServerListener> notifyDispatcher = new RestEServerNotifyDispatcher();
        RestEServerListener clientListener = new RestEServerListener(url);
        notifyDispatcher.registerListener(clientListener);
        super.setNotifyDispatcher(notifyDispatcher);
    }
}
