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
package com.huawei.esdk.ec.business.professional.rest.ctc.callback;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.domain.model.callback.CeeStatus;
import com.huawei.esdk.ec.domain.model.callback.ConfInfo;
import com.huawei.esdk.ec.domain.model.callback.ConfStatus;
import com.huawei.esdk.ec.northcommu.rest.callback.RestCTCListener;
import com.huawei.esdk.platform.common.notification.NotifyDispatcher;

/**
 * CTC通知分发类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK UC V100R003C20]
 */
public class RestCTCNotifyDispatcher extends NotifyDispatcher<RestCTCListener>
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(RestCTCNotifyDispatcher.class);
    
    @Override
    public boolean notifyToOneListener(RestCTCListener listener, String ntfId, Object msg, Object additionalInfo)
    {
        if ("ctcuserstate".equals(ntfId))
        {
        	CeeStatus status = (CeeStatus)msg;
            listener.notifyConfCeeState(status.getConfId(), status.getCee(), status.getStatus());
        }
        else if ("ctcconferstate".equals(ntfId))
        {
        	ConfStatus status = (ConfStatus)msg;
            listener.notifyConfState(status.getConfId(), status.getStatus());
        }
        else if ("ctcconfinfo".equals(ntfId))
        {
        	ConfInfo confInfo = (ConfInfo)msg;
        	listener.notifyConfInfo(confInfo);
        }
        else
        {
            LOGGER.debug("RestCTCNotifyDispatcher notifyToOneListener error!");
        }
        
        return true;
    }
    
}
