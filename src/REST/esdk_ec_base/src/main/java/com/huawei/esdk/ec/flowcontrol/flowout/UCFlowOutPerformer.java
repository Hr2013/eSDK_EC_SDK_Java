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

import java.util.concurrent.Semaphore;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.huawei.esdk.platform.flowcontrol.itf.IPerformer;

public class UCFlowOutPerformer implements IPerformer
{
    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(UCFlowOutPerformer.class);
    
    private static int maxThreads = 0; // eSDK最大线程数，等待队列最大不能超过eSDK的Tomcat支持的最大线程数
    
    private final static int DEFAULT_MAXTHREADS = 250; //Tomcat默认配置 最大支持线程数
    
    static
    {
        try
        {
            maxThreads = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("maxThreads"));
            if (maxThreads <= 0)
            {
                throw new SDKException("");
            }
        }
        catch (SDKException e)
        {
            LOGGER.error("property MAXTHREADS get error", e);
            maxThreads = DEFAULT_MAXTHREADS; // 配置出错时 使用Tomcat默认配置
        }
    }
    
    private final static int MAXTHREADNUM = maxThreads;
    
    private int flowCtrlStatus = 0; // 当前流控状态 0: 无流控 1:一级流控
    
    private final Semaphore semp = new Semaphore(maxThreads, true); //信号量，用于消息线程等待
    
    @Override
    public void doFlowControl(int flowCtrlDegree)
    {
        this.flowCtrlStatus = flowCtrlDegree;
        return;
    }
    
    @Override
    public boolean doFilter(Object message)
    {
        if (0 == flowCtrlStatus) // 若无需流控，则返回
        {
            return false;
        }
        LOGGER.info("线程" + Thread.currentThread().getId() + "等待队列长度=======" + semp.getQueueLength() + "可用信号量"
            + semp.availablePermits());
        if (semp.getQueueLength() < MAXTHREADNUM) //检查排队队列是否已满
        {
            try
            {
                semp.acquire(); // 获取信号量，无信号量时加入等待队列
                LOGGER.info("线程" + Thread.currentThread().getId() + "获取信号量");
            }
            catch (InterruptedException e)
            {
                LOGGER.info("线程" + Thread.currentThread().getId() + "被中断", e);
            }
            return false;
        }
        else
        {
            // 超过等待队列长度，直接流控
            return true;
        }
    }
    
    public synchronized void sempRefill() // 信号量补充，南向消息返回时调用
    {
        if (semp.availablePermits() < MAXTHREADNUM)
        {
            LOGGER.info("线程" + Thread.currentThread().getId() + "释放信号量");
            semp.release();
        }
    }
}
