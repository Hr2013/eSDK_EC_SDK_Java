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
package com.huawei.esdk.uc.professional.local.bean;

/**
 * 查询账号操作返回的账号信息
 */
public class QueryAccountInfo 
{
    /**
     * 账号类型：0-普通账号，2-UC账号
     */
	private String accountType;
	/**
	 * 账号ID
	 */
	private String accountId;
	/**
	 * 登录账号
	 */
	private String loginName;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 用户性别
	 */
	private String sex;
	/**
	 * 家庭电话
	 */
	private String homePhone;
	/**
	 * 手机
	 */
	private String cellPhone;
	/**
	 * 办公电话
	 */
	private String officePhone;
	/**
	 * 短号
	 */
	private String shortPhone;
	/**
	 * 其它号码
	 */
	private String otherPhone;
	/**
	 * 传真号码
	 */
	private String fax;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 职务
	 */
	private String title;
	/**
	 * 账号归属部门ID
	 */
	private String departmentId;
	/**
	 * 账号级别ID
	 */
	private String userLevel;
	/**
	 * 账号角色ID
	 */
	private String roleId;
	/**
	 * UC账号绑定的SIP号码
	 */
	private String bindNum;
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getShortPhone() {
		return shortPhone;
	}
	public void setShortPhone(String shortPhone) {
		this.shortPhone = shortPhone;
	}
	public String getOtherPhone() {
		return otherPhone;
	}
	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddr(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getBindNum() {
		return bindNum;
	}
	public void setBindNum(String bindNum) {
		this.bindNum = bindNum;
	}

}
