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
package com.huawei.esdk.ec.device;

import java.util.Map;

import com.huawei.esdk.ec.device.appserver.bean.QueryAddrListResponse;
import com.huawei.esdk.ec.device.appserver.bean.QueryEmployeeResponse;
import com.huawei.esdk.ec.device.appserver.bean.QueryEnterpriseResponse;
import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.utils.JAXBUtils;
import com.huawei.esdk.platform.commu.itf.AbstractProtocolAdatperCustProvider;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class UCAppServerRestCustProvider extends AbstractProtocolAdatperCustProvider
{
    
    @Override
    public Object preProcessReq(Object reqMessage)
    {
        RestReqMessage request = (RestReqMessage)reqMessage;
        request.setMediaType("xml");
        return request;
    }
    
    @Override
    public Map<String, String> getRequestHeaders()
    {
        return null;
    }
    
    @Override
    public String getContent4Sending(Object reqMessage)
    {
        RestReqMessage restReq = (RestReqMessage)reqMessage;
        
        XMLReqMsg reqMsg = (XMLReqMsg)restReq.getPayload();
        
        if (null != reqMsg.getBody())
        {
            String bodyAsString = JAXBUtils.bean2Xml(reqMsg.getBody(), reqMsg.getBody().getClass(), true);
            if (null != bodyAsString && bodyAsString.indexOf("<body>") > -1)
            {
                bodyAsString = bodyAsString.replaceAll("<body>", "").replaceAll("</body>", "");
            }
            
            reqMsg.setBodyAsString(bodyAsString);
        }
        
        String result = JAXBUtils.bean2Xml(reqMsg, reqMsg.getClass(), false, false);
        
        return result;
    }
    
    @Override
    public Object preSend(Object reqMessage)
    {
        return reqMessage;
    }
    
    @Override
    public String reBuildNewUrl(String url, String interfaceName)
    {
        if (interfaceName.startsWith("/"))
        {
            return "/appServer" + interfaceName;
        }
        else
        {
            return "/appServer/" + interfaceName;
        }
    }
    
    @Override
    public Object postSend(Object resMessage)
        throws ProtocolAdapterException
    {
        return resMessage;
    }
    
    @Override
    public Object postBuildRes(Object resMessage, String resObjClass)
        throws ProtocolAdapterException
    {
        String payload = (String)resMessage;
        
        if (null != resObjClass && resObjClass.equals(QueryEnterpriseResponse.class.getName()))
        {
            if (payload.indexOf("departmentList") < payload.indexOf("employeeList"))
            {
                payload = payload.replaceFirst("paramlist", "departmentList");
                if (0 <= payload.indexOf("<departmentList type=\"departmentList\">"))
                {
                    payload = payload.replaceFirst("paramlist", "departmentList");
                }
                payload = payload.replaceFirst("paramlist", "employeeList");
                if (0 <= payload.indexOf("<employeeList type=\"employeeList\">"))
                {
                    payload = payload.replaceFirst("paramlist", "employeeList");
                }
            }
            else if (payload.indexOf("departmentList") > payload.indexOf("employeeList"))
            {
                payload = payload.replaceFirst("paramlist", "employeeList");
                if (0 <= payload.indexOf("<employeeList type=\"employeeList\">"))
                {
                    payload = payload.replaceFirst("paramlist", "employeeList");
                }
                payload = payload.replaceFirst("paramlist", "departmentList");
                if (0 <= payload.indexOf("<departmentList type=\"departmentList\">"))
                {
                    payload = payload.replaceFirst("paramlist", "departmentList");
                }
            }
        }
        // TODO 调用接口不成功时，res=null
        XMLResMsg res = (XMLResMsg)JAXBUtils.xml2Bean(XMLResMsg.class, payload);
        
        if (null != res && "0".equals(res.getHead().getRetCode()) && null != resObjClass)
        {
            Object body = null;
            try
            {
                if (0 <= payload.indexOf("paramlist") || resObjClass.equals(QueryAddrListResponse.class.getName())
                    || resObjClass.equals(QueryEmployeeResponse.class.getName())
                    || resObjClass.equals(QueryEnterpriseResponse.class.getName()))
                {
                    res.setBodyAsString(payload.substring(payload.indexOf("<body>"), payload.indexOf("</body>") + 7));
                    body = JAXBUtils.xml2Bean(Class.forName(resObjClass), res.getBodyAsString());
                }
                else if (0 <= payload.indexOf("<body>"))
                {
                    res.setBodyAsString(payload.substring(payload.indexOf("<body>") + 6, payload.indexOf("</body>")));
                    body = JAXBUtils.xml2Bean(Class.forName(resObjClass), res.getBodyAsString());
                }
            }
            catch (ClassNotFoundException e)
            {
                throw new ProtocolAdapterException("Class not found error", ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
            }
            
            res.setBody(body);
        }
        return res;
    }
    
    public AccountInfo getProtocolAuthInfo()
    {
        AccountInfo result = new AccountInfo();
        MessageContext mc = ThreadLocalHolder.get();
        result.setUserId((String)mc.getEntities().get(ESDKConstant.DEVICE_USER_ID));
        result.setPassword((String)mc.getEntities().get(ESDKConstant.DEVICE_PLAIN_PWD));
        return result;
    }
}
