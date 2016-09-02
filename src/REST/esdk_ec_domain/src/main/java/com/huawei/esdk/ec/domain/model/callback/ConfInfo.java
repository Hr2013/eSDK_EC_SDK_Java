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
package com.huawei.esdk.ec.domain.model.callback;

import java.util.List;

public class ConfInfo {
	/*
	 * 会议主题
	 */
	private String subject;
	
	/*
	 * 是否录音
	 */
	private String record;
	
	/*
	 * 主持人号码
	 */
	private String emCee;
	
	/*
	 * 创建者
	 */
	private String creator;
	
	/*
	 * 人数
	 */
	private int num;
	
	private List<ConfUser> users;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getEmCee() {
		return emCee;
	}

	public void setEmCee(String emCee) {
		this.emCee = emCee;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<ConfUser> getUsers() {
		return users;
	}

	public void setUsers(List<ConfUser> users) {
		this.users = users;
	}
}
