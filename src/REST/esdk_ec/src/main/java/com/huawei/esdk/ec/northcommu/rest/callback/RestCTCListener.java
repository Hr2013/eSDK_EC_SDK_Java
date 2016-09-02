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
package com.huawei.esdk.ec.northcommu.rest.callback;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.domain.model.callback.ConfInfo;
import com.huawei.esdk.ec.domain.model.callback.ConfUser;
import com.huawei.esdk.ec.north.rest.bean.ctc.ConfInfoBean;
import com.huawei.esdk.ec.north.rest.bean.ctc.ConfStatusBean;
import com.huawei.esdk.ec.north.rest.bean.ctc.ConfUserBean;
import com.huawei.esdk.ec.north.rest.bean.ctc.ConfUserStatusBean;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.bean.rest.ResHeaderBean;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.commu.itf.IProtocolAdapterManager;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class RestCTCListener
{
	private static final Logger LOGGER = Logger.getLogger(RestCTCListener.class);
    
    private ISDKProtocolAdapter restProtocolAdapter;
    
    private IProtocolAdapterManager protocolAdapterManager = ApplicationContextUtil.getBean("protocolAdapterManager");
    
    public RestCTCListener(String sap)
    {
    	restProtocolAdapter = protocolAdapterManager.getProtocolInstanceByType(ESDKConstant.PROTOCOL_ADAPTER_TYPE_REST, sap);
    }
    
    public void notifyConfCeeState(String confId, String cee, String status)
    {
    	ConfUserStatusBean payload = new ConfUserStatusBean();
    	payload.setConfId(confId);
    	payload.setCee(cee);
    	payload.setStatus(status);
    	sendCallbackMsg(payload, "conf cee status");
    }
    
    public void notifyConfState(String confId, String status)
    {
    	ConfStatusBean payload = new ConfStatusBean();
    	payload.setConfId(confId);
    	payload.setStatus(status);
    	sendCallbackMsg(payload, "conf status");
    }
    
    public void notifyConfInfo(ConfInfo confInfo)
    {
    	ConfInfoBean payload = new ConfInfoBean();
    	payload.setCreator(confInfo.getCreator());
    	payload.setEmCee(confInfo.getEmCee());
    	payload.setNum(confInfo.getNum());
    	payload.setRecord(confInfo.getRecord());
    	payload.setSubject(confInfo.getSubject());
    	
    	List<ConfUserBean> users = new ArrayList<ConfUserBean>();
    	ConfUserBean user;
    	for (ConfUser item : confInfo.getUsers())
    	{
    		user = new ConfUserBean();
    		user.setCee(item.getCee());
    		user.setDisplayName(item.getDisplayName());
    		user.setEspaceAccount(item.getEspaceAccount());
    		user.setMediaType(item.getMediaType());
    		user.setRole(item.getRole());
    		user.setState(item.getState());
    		user.setUserType(item.getUserType());
    		
    		users.add(user);
    	}
    	
    	payload.setUsers(users);
    	sendCallbackMsg(payload, "conf info");
    }
    
    private void sendCallbackMsg(Object payload, String messageType)
    {
    	try
        {
        	RestReqMessage req = new RestReqMessage();
        	req.getHttpHeaders().put("Content-Type", "application/json");
        	req.setMediaType("json");
        	req.setHttpMethod("POST");
        	req.setPayload(payload);
        	Object result = restProtocolAdapter.syncSendMessage(req, null, ResHeaderBean.class.getName());
        	ResHeaderBean resBean;
        	if (result instanceof ResHeaderBean)
        	{
        		resBean = (ResHeaderBean) result;
        	}
        	else
        	{
        		resBean = new ResHeaderBean();
        	}
        	if (!"0".equals(resBean.getResultCode()))
        	{
        		LOGGER.warn(resBean.getResultCode() + "-" + resBean.getResultDesc());
        		LOGGER.warn(messageType + " callback message is not processed successfully by client");
        	}
        }
        catch (ProtocolAdapterException e)
        {
            LOGGER.error(messageType + " callback error", e);
            LOGGER.warn("Callback message is not processed successfully by client");
        }
        catch(Exception e)
        {
        	LOGGER.error(messageType , e);
        	LOGGER.warn("Callback message is not processed successfully by client");
        }
    }
}
