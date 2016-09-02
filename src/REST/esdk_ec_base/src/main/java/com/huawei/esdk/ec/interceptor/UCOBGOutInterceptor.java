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

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.flowcontrol.itf.IMonitor;
import com.huawei.esdk.platform.flowcontrol.itf.IPerformer;

public class UCOBGOutInterceptor extends AbstractPhaseInterceptor<Message>
{
    public UCOBGOutInterceptor()
    {
        super(Phase.PRE_STREAM);
    }
    
    // 南向SOAP消息发送拦截器
    public void handleMessage(Message message)
        throws Fault
    {
        // 通知流量监控模块
        IMonitor monitor = ApplicationContextUtil.getBean("southFCMonitor");
        if (monitor != null)
        {
            monitor.reportStatus(1); // 增加一次SOAP调用
            IPerformer performer = ApplicationContextUtil.getBean("southFCPerformer");
            if (performer != null)
            {
                if (performer.doFilter(null))
                {
                    monitor.reportStatus(-1); // 被流控消息不计入监控数据
                    SOAPException soapExc = new SOAPException("");
                    Fault fault = new Fault(soapExc);
                    fault.setFaultCode(new QName(Integer.toString(ESDKErrorCodeConstant.ERROR_CODE_SDK_SYSBUSY)));
                    throw fault;
                }
            }
        }
    }
}
