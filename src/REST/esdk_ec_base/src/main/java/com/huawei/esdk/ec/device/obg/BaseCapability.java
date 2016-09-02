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
package com.huawei.esdk.ec.device.obg;


import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.huawei.esdk.ec.common.UCConstant;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.log.InterfaceLogBean;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.OSUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.commu.itf.ICXFSOAPProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;
import com.huawei.esdk.platform.log.itf.IInterfaceLog;

public abstract class BaseCapability
{
    private static final Logger LOGGER = Logger.getLogger(BaseCapability.class);
    
    private ICXFSOAPProtocolAdapter cxfSOAPProtocolAdapter;

    public BaseCapability(ICXFSOAPProtocolAdapter cxfSOAPProtocolAdapter)
    {
        this.cxfSOAPProtocolAdapter = cxfSOAPProtocolAdapter;
    }

    /**
     * 
     * @param requestMessage : 南向请求消息
     * @param srcMethod : 请求消息名称
     * @return ： 南向返回消息
     * @throws ProtocolAdapterException 
     */
    @SuppressWarnings("unchecked")
    public <T1> T1 sendProtocolMessage(Object requestMessage, String srcMethod, Class<?> serviceClass) throws ProtocolAdapterException
    {
        // send message to Device of OBG
        String uuid = UUID.randomUUID().toString();
        String targetIP = StringUtils.retrieveMachineAddr(cxfSOAPProtocolAdapter.getServiceAccessPoint());
        doInterfaceLogReq(uuid, srcMethod, targetIP);
        
        T1 res = (T1) cxfSOAPProtocolAdapter
                    .syncSendMessageWithCxf(
                            requestMessage,
                            serviceClass.getName(),
                            srcMethod);
        
        try
        {
            Integer resultCode = (Integer)org.apache.commons.beanutils.PropertyUtils.getSimpleProperty(res, "res");
            doInterfaceLogRes(uuid, resultCode + "");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            doInterfaceLogRes(uuid, "");
        }
        return res;
    }
    
    private void doInterfaceLogReq(String messageId, String interfaceName, String targetIP)
    {
        InterfaceLogBean bean = new InterfaceLogBean();
        bean.setTransactionId(messageId);
        bean.setProduct("UC");
        bean.setInterfaceType("2");
        bean.setProtocolType("SOAP");
        bean.setReq(true);
        bean.setName(interfaceName);
        bean.setSourceAddr(OSUtils.getLocalIP());
        bean.setTargetAddr(targetIP);
        bean.setReqTime(new Date());
        
        IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
        logger.info(bean);
    }
    
    private void doInterfaceLogRes(String messageId, String resultCode)
    {
        InterfaceLogBean bean = new InterfaceLogBean();
        bean.setTransactionId(messageId);
        bean.setReq(false);
        bean.setRespTime(new Date());
        bean.setResultCode(resultCode);
        
        IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
        logger.info(bean);
    }
    
    
    /**
     * 
     * c03L 对鉴权信息进行赋值
     * @param bean : 需要赋值的对象
     * 
     */
    public void setInvokerInfoProperties(Object bean)
    {
        try
        {
            String appId = "";
            String pwd = "";
            
            MessageContext mc = ThreadLocalHolder.get();
            if (mc != null)
            {
                appId = (String)mc.getEntities().get(UCConstant.APP_ID_ESG);
                pwd = (String)mc.getEntities().get(UCConstant.PWD_ESG);
            }
            
            PropertyUtils.setSimpleProperty(bean, "invokerName", appId);
            PropertyUtils.setSimpleProperty(bean, "invokerPassword", pwd);
        }
        catch (IllegalAccessException e)
        {
            LOGGER.warn("", e);
        }
        catch (InvocationTargetException e)
        {
            LOGGER.warn("", e);
        }
        catch (NoSuchMethodException e)
        {
            LOGGER.warn("", e);
        }
    }
    
    /**
     * 
     * c03BMP 对鉴权信息进行赋值
     * @param bean : 需要赋值的对象
     * 
     */
    public void setInvokerInfoProperties(Object bean, boolean isEncryptPwd)
    {
        try
        {
            String appId = "";
            String pwd = "";
            
            MessageContext mc = ThreadLocalHolder.get();
            if (mc != null)
            {
                appId = (String)mc.getEntities().get(UCConstant.APP_ID_ESG);
                pwd = (String)mc.getEntities().get(UCConstant.PWD_ESG);
            }
            
            PropertyUtils.setSimpleProperty(bean, "invokerName", appId);
            PropertyUtils.setSimpleProperty(bean, "invokerPassword", pwd);
        }
        catch (IllegalAccessException e)
        {
            LOGGER.warn("", e);
        }
        catch (InvocationTargetException e)
        {
            LOGGER.warn("", e);
        }
        catch (NoSuchMethodException e)
        {
            LOGGER.warn("", e);
        }
    }
}
