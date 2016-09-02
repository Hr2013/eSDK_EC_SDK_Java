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
package com.huawei.esdk.ec.flowcontrol.flowout;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.huawei.esdk.platform.flowcontrol.itf.IController;
import com.huawei.esdk.platform.flowcontrol.itf.IPolicies;

public class UCFlowOutPolicies implements IPolicies
{
    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger
    .getLogger(UCFlowOutPolicies.class);
    
    private static int fcDegree = 0; // 流控等级
    
    private final static double FC_BUFFERRATE = 0.9; //流控启动阈值和停止阈值的比例
    
    @Override
    public int loadEvaluate(long visitCount)
    {
    	// 流控启动阈值
    	int soapCallThredshold = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("southSoapCallCapacity")); 
        double fcStophredshold = soapCallThredshold * FC_BUFFERRATE; // 一级流控关闭阈值
        
        switch (fcDegree)
        //根据流控等级动态评估流量状态
        {
            case 0:
            {
                if (visitCount > soapCallThredshold)
                {
                    LOGGER.info("南向开启一级流控 ,消息量=" + visitCount);
                    fcDegree = 1;
                    IController northController = (IController)ApplicationContextUtil.getBean("northFlowController");
                    northController.notifyFlowControlByNeed(true); // 通知北向开启流控
                }
                break;
            }
            case 1:
            {
                if (visitCount < fcStophredshold)
                {
                    LOGGER.info("南向关闭流控，消息量=" + visitCount);
                    fcDegree = 0;
                    IController northController = (IController)ApplicationContextUtil.getBean("northFlowController");
                    northController.notifyFlowControlByNeed(false); // 通知北向关闭流控
                }
                break;
            }
            default:
                break;
        }
        return fcDegree;
    }
}
