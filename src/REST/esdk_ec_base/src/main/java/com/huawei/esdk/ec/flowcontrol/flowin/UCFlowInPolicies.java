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

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.huawei.esdk.platform.flowcontrol.itf.IPolicies;

public class UCFlowInPolicies implements IPolicies
{
    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(UCFlowInPolicies.class);
    
    // 流控启动阈值和停止阈值的比例
    private final static double FC_BUFFERRATE = 0.9;
    
    // 二级流控与一级流控比例
    private final static double FC_LEVELRRATE = 1.2;

    // 流控级别定义
    private final static int LEVEL0 = 0;
    
    private final static int LEVEL1 = 1;
    
    private final static int LEVEL2 = 2;
    
    // 流控当前级别
    private static int fcDegree = 0;
    
    @Override
    public int loadEvaluate(long visitCount)
    {
    	//一级流控启动阈值
    	int soapCallThredshold1 = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("northSoapCallCapacity1"));
        double soapCallThredshold2 = soapCallThredshold1 * FC_LEVELRRATE; // 二级流控启动阈值
        double fcStopThredshold1 = soapCallThredshold1 * FC_BUFFERRATE; // 一级流控停止阈值
        double fcStopThredshold2 = soapCallThredshold2 * FC_BUFFERRATE; // 二级流控停止阈值
        
        long monitorKey = visitCount; // 记录当前流量值
        //LOGGER.info("*****************************线程id=" + Thread.currentThread().getId() + "，北向当前消息个数=" + monitorKey);
        // 根据当前流控等级进行评估
        switch (fcDegree)
        {
            case LEVEL0: // 上个状态为无流控
            {
                if (monitorKey > soapCallThredshold2)
                {
                    LOGGER.info("北向开启二级流控,消息量=" + monitorKey);
                    fcDegree = LEVEL2;
                }
                else if (monitorKey > soapCallThredshold1)
                {
                    LOGGER.info("北向开启一级流控,消息量=" + monitorKey);
                    fcDegree = LEVEL1;
                }
                break;
            }
            case LEVEL1:// 上个状态为一级流控
            {
                if (monitorKey > soapCallThredshold2)
                {
                    LOGGER.info("北向开启二级流控,消息量=" + monitorKey);
                    fcDegree = LEVEL2;
                }
                else if (monitorKey < fcStopThredshold1)
                {
                    LOGGER.info("北向关闭流控,消息量=" + monitorKey);
                    fcDegree = LEVEL0;
                }
                break;
            }
            case LEVEL2:// 上个状态为二级流控
            {
                if (monitorKey < fcStopThredshold1)
                {
                    LOGGER.info("北向关闭流控,消息量=" + monitorKey);
                    fcDegree = LEVEL0;
                }
                else if (monitorKey < fcStopThredshold2)
                {
                    LOGGER.info("北向关闭二级流控,消息量=" + monitorKey);
                    fcDegree = LEVEL1;
                }
                break;
            }
            default:
                break;
        }
        return fcDegree;
    }
}
