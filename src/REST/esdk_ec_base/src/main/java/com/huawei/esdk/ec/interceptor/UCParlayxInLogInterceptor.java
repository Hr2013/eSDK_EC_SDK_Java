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

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.bean.log.LogBean;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.log.itf.LogInterface;

public class UCParlayxInLogInterceptor extends AbstractSoapInterceptor
{
    private static Logger LOGGER = Logger.getLogger(UCParlayxInLogInterceptor.class);
    
    public UCParlayxInLogInterceptor()
    {
        super(Phase.RECEIVE);
    }
    
    public void handleMessage(SoapMessage message)
        throws Fault
    {
        HttpServletRequest req = (HttpServletRequest)message.get("HTTP.REQUEST");
        
        //        HttpServletRequest httpRequest = (HttpServletRequest) message
        //                .get(AbstractHTTPDestination.HTTP_REQUEST);
        //        System.out.println("Request From the address : "
        //                + httpRequest.getRemoteAddr());
        String xml = "";
        InputStream is = null;
        CachedOutputStream os = null;
        try
        {
            // now get the request xml
            os = new CachedOutputStream();
            is = message.getContent(InputStream.class);
            if (null != is)
            {
                IOUtils.copy(is, os);
            }
            os.flush();
            message.setContent(InputStream.class, os.getInputStream());
            xml = IOUtils.toString(os.getInputStream());
        }
        catch (Exception ex)
        {
            LOGGER.error("handleMessage os close error", ex);
        }
        finally
        {
            try
            {
                if (null != os)
                {
                    os.close();
                }
            }
            catch (IOException e)
            {
                LOGGER.error("handleMessage os close error", e);
            }
            try
            {
                if (null != is)
                {
                    is.close();
                }
            }
            catch (IOException e)
            {
                LOGGER.error("handleMessage os close error", e);
            }
        }
        
        if (xml.contains("<soapenv:Body>"))
        {
            int start = xml.lastIndexOf("<soapenv:Body>") + 14;
            String xml1 = xml.substring(start);
            int start2 = xml1.indexOf(":") + 1;
            int end = xml1.indexOf(">");
            String interfaceName = xml1.substring(start2, end);
            String messageId = (String)message.getExchange().get(LoggingMessage.ID_KEY);
            if (messageId == null)
            {
                messageId = LoggingMessage.nextId();
                message.getExchange().put(LoggingMessage.ID_KEY, messageId);
            }
            
            LogBean bean = new LogBean();
            bean.setActionName(interfaceName);
            bean.setRequestTime(new Date());
            bean.setIp(req.getRemoteHost());
            bean.setPort(req.getRemotePort() + "");
            LogInterface log = ApplicationContextUtil.getBean("logManager");
            log.saveRequestLog(messageId, bean);
        }
    }
    
}
