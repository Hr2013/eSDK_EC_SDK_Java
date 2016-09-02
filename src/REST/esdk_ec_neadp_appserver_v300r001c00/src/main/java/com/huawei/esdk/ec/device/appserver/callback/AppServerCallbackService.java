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
package com.huawei.esdk.ec.device.appserver.callback;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.appserver.callback.bean.CTCConfInfo;
import com.huawei.esdk.ec.device.appserver.callback.bean.CTCConfState;
import com.huawei.esdk.ec.device.appserver.callback.bean.CTCConfUser;
import com.huawei.esdk.ec.device.appserver.callback.bean.CTCUserState;
import com.huawei.esdk.ec.domain.model.callback.CeeStatus;
import com.huawei.esdk.ec.domain.model.callback.ConfInfo;
import com.huawei.esdk.ec.domain.model.callback.ConfStatus;
import com.huawei.esdk.ec.domain.model.callback.ConfUser;
import com.huawei.esdk.ec.southcommu.callback.CallbackSouthBase;
import com.huawei.esdk.platform.callback.ISouthCallbackService;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.JAXBUtils;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class AppServerCallbackService extends CallbackSouthBase implements ISouthCallbackService {
	private static final Logger LOGGER = Logger.getLogger(AppServerCallbackService.class);
	
	@Override
	public String processCallbackMessage(String inMessage) {
		String res;
		if (StringUtils.isEmpty(inMessage))
		{
			res = "The incoming callback message is empty";
			LOGGER.warn(res);
			return res;
		}
		
		if (inMessage.contains("notify_ctcuserstate"))
		{
			res = processUserStateMsg(inMessage);
		}
		else if (inMessage.contains("notify_ctcconferstate"))
		{
			res = processConferStateMsg(inMessage);
		}
		else if (inMessage.contains("notify_ctcconfinfo"))
		{
			res = processConfInfoMsg(inMessage);
		}
		else
		{
			res = "The incoming callback message cannot be recognized by eSDK.";
		}
		
		return res;
	}
	
	private String processUserStateMsg(String inMsg)
	{
		CTCUserState userState = (CTCUserState) JAXBUtils.xml2Bean(CTCUserState.class, inMsg);
		CeeStatus payload = new CeeStatus();
		payload.setConfId(userState.getBean().getConfId());
		payload.setCee(userState.getBean().getCee());
		payload.setStatus(userState.getBean().getStatus());
		
		CallbackMessage callbackMessage = buildCallbackMessage(payload, null, "ctcuserstate", "ctc");		
		callbackMessage.getCallbackItfInfo().setDevId(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"));
		callbackMessage.getCallbackItfInfo().setConnectionId("_");
		notifyCollector.publishNotify(callbackMessage);
		return "<notify-ctcuserstate-res></notify-ctcuserstate-res>";
	}
	
	private String processConferStateMsg(String inMsg)
	{
		CTCConfState confState = (CTCConfState) JAXBUtils.xml2Bean(CTCConfState.class, inMsg);
		ConfStatus payload = new ConfStatus();
		payload.setConfId(confState.getBean().getConfId());
		payload.setStatus(confState.getBean().getStatus());
		
		CallbackMessage callbackMessage = buildCallbackMessage(payload, null, "ctcconferstate", "ctc");		
		callbackMessage.getCallbackItfInfo().setDevId(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"));
		callbackMessage.getCallbackItfInfo().setConnectionId("_");
		notifyCollector.publishNotify(callbackMessage);
		return "<notify-ctcconferstate-res></notify-ctcconferstate-res>";
	}
	
	private String processConfInfoMsg(String inMsg)
	{
		CTCConfInfo confInfo = (CTCConfInfo) JAXBUtils.xml2Bean(CTCConfInfo.class, inMsg);
		
		CallbackMessage callbackMessage = buildCallbackMessage(convertConfInfo(confInfo), null, "ctcconfinfo", "ctc");		
		callbackMessage.getCallbackItfInfo().setDevId(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"));
		callbackMessage.getCallbackItfInfo().setConnectionId("_");
		notifyCollector.publishNotify(callbackMessage);
		return "<notify-ctcconfinfo-res></notify-ctcconfinfo-res>";
	}
	
	private ConfInfo convertConfInfo(CTCConfInfo confInfo)
	{
		ConfInfo result = new ConfInfo();
		result.setSubject(confInfo.getBean().getSbj());
		result.setRecord(confInfo.getBean().getRecord());
		result.setEmCee(confInfo.getBean().getEmcee());
		result.setCreator(confInfo.getBean().getCreator());
		
		List<CTCConfUser> origUsers = confInfo.getBean().getUsers();
		List<ConfUser> users = new ArrayList<ConfUser>();
		ConfUser user;
		
		if (null != origUsers)
		{
			for (CTCConfUser item : origUsers)
			{
				user = new ConfUser();
				user.setCee(item.getCee());
				user.setDisplayName(item.getDisplayName());
				user.setEspaceAccount(item.getEspaceAccount());
				user.setMediaType(item.getMediaType());
				user.setRole(item.getRole());
				user.setState(item.getState());
				user.setUserType(item.getUcType());
				
				users.add(user);
			}
		}
		result.setUsers(users);
		
		try
		{
			result.setNum(NumberUtils.parseIntValue(confInfo.getBean().getNum()));
		}
		catch(Exception e)
		{
			LOGGER.error(confInfo.getBean().getNum() + " is not a valid number", e);
			result.setNum(users.size());
		}
		
		return result;
	}
}
