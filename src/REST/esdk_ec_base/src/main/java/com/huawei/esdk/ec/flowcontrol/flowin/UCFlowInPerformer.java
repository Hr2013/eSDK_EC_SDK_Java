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
package com.huawei.esdk.ec.flowcontrol.flowin;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import com.huawei.esdk.platform.flowcontrol.itf.IPerformer;

public class UCFlowInPerformer implements IPerformer
{
    private final static boolean NEEDFLOWCTRL = true;
    
    private final static boolean UNNEEDFLOWCTRL = false;
    
    // 当前流控等级
    private final static int LEVEL1 = 1;
    
    private final static int LEVEL2 = 2;
    
    // 当前消息业务类型 0: 未知; 1: IM； 2： 其他
    private final static int UNKNOWNMESSAGE = 1;
    
    private final static int IMMESSAGE = 1;
    
    private final static int OTHERMESSAGE = 2;
    
    // 当前流控等级状态 0：无流控 1：消息流控 2：其他控制消息流控
    private int currentFlowCtrlDegree = 0;
    
    @Override
    public void doFlowControl(int flowCtrlDegree)
    {
        this.currentFlowCtrlDegree = flowCtrlDegree;
        return;
    }
    
    // 对本消息进行流控
    @Override
    public boolean doFilter(Object message)
    {
        // 无流控时直接返回
        if (0 == currentFlowCtrlDegree)
        {
            return UNNEEDFLOWCTRL;
        }
        
        boolean result = false;
        // 需要分级流控，且大于系统负载量的消息被流控
        switch (currentFlowCtrlDegree)
        {
            case LEVEL1: // 一级流控 IM消息等被流控
            {
                SoapMessage soapMessage = (SoapMessage)message;
                if (IMMESSAGE == getMsgType(soapMessage)) // 判断是否是需要一级流控的消息
                {
                    result = NEEDFLOWCTRL;
                }
                break;
            }
            //Commented by zhili to fix FindBug issue: uses the same code for two switch clauses
//            case LEVEL2:// 二级流控 CTC消息等被流控
//            {
//                return NEEDFLOWCTRL;
//            }
            default:
            {
                result = NEEDFLOWCTRL;
            }
        }
        
        return result;
    }
    
    private int getMsgType(SoapMessage soapMessage)
    {
        if (null == soapMessage)
        {
            return UNKNOWNMESSAGE;
        }
        int msgType = UNKNOWNMESSAGE;
        
        QName actionName = (QName)soapMessage.get("javax.xml.ws.wsdl.port");
        if (null == actionName)
        {
            return UNKNOWNMESSAGE;
        }
        if (actionName.toString().contains("IM") && actionName.toString().contains("Port"))
        {
            msgType = IMMESSAGE;
        }
        else
        {
            msgType = OTHERMESSAGE;
        }
        return msgType;
    }
}
