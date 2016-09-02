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
package com.huawei.esdk.ec.device.appserver.callback.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userinfo", propOrder = {
		"cee","state","displayName","espaceAccount","role","mediaType","ucType"
})
public class CTCConfUser {
	private String cee;
	
	private String state;
	
	@XmlElement(name = "displayname")
	private String displayName;
	
	private String espaceAccount;
	
	private String role;
	
	private String mediaType;
	
	private String ucType;

	public String getCee() {
		return cee;
	}

	public void setCee(String cee) {
		this.cee = cee;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEspaceAccount() {
		return espaceAccount;
	}

	public void setEspaceAccount(String espaceAccount) {
		this.espaceAccount = espaceAccount;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getUcType() {
		return ucType;
	}

	public void setUcType(String ucType) {
		this.ucType = ucType;
	}
}
