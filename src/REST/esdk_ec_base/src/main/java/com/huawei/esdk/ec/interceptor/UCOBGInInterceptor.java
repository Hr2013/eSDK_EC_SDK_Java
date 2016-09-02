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
package com.huawei.esdk.ec.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import com.huawei.esdk.ec.flowcontrol.flowout.UCFlowOutPerformer;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;

public class UCOBGInInterceptor extends AbstractPhaseInterceptor<Message>
{
    public UCOBGInInterceptor()
    {
        super(Phase.POST_PROTOCOL);
    }
    
    @Override
    public void handleMessage(Message message)
        throws Fault
    {
        UCFlowOutPerformer performer = ApplicationContextUtil.getBean("southFCPerformer");
        if (performer != null)
        {
            performer.sempRefill();
        }
    }
}
