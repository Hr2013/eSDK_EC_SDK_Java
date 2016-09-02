package com.huawei.esdk.ec.conference.bean;

public class AddAttendee {
	private String userId;
	private String gwIp;
	private String subPbx;
	private String confId;
	private String account;
	private String attNumber;
	private String attType;
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGwIp() {
		return gwIp;
	}

	public void setGwIp(String gwIp) {
		this.gwIp = gwIp;
	}

	public String getSubPbx() {
		return subPbx;
	}

	public void setSubPbx(String subPbx) {
		this.subPbx = subPbx;
	}

	public String getConfId() {
		return confId;
	}

	public void setConfId(String confId) {
		this.confId = confId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAttNumber() {
		return attNumber;
	}

	public void setAttNumber(String attNumber) {
		this.attNumber = attNumber;
	}

	public String getAttType() {
		return attType;
	}

	public void setAttType(String attType) {
		this.attType = attType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
