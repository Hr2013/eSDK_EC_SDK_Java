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


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"sbj","record","emcee","creator","num","users"
})
public class ConfInfoBean {
    private String sbj;
    
    private String record;
    
    private String emcee;
    
    private String creator;
    
    private String num;
    
    @XmlElementWrapper(name = "users")
    @XmlElement(name = "userinfo")
    private List<CTCConfUser> users;

	public String getSbj() {
		return sbj;
	}

	public void setSbj(String sbj) {
		this.sbj = sbj;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getEmcee() {
		return emcee;
	}

	public void setEmcee(String emcee) {
		this.emcee = emcee;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public List<CTCConfUser> getUsers() {
		return users;
	}

	public void setUsers(List<CTCConfUser> users) {
		this.users = users;
	}
}
