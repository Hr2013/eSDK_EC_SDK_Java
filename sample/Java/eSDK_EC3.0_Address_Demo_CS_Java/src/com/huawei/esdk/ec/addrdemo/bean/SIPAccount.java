package com.huawei.esdk.ec.addrdemo.bean;

public class SIPAccount {
	private String gwIp;
	private String subPbx;
	private String localGwIp;
	private String joint;
	private String sipUe;
	private String ueType;
	private String number;
	private String longNum;
	private String rightLevel;
	private String addPrefix;
	private String deleteSipUe;
	private SIPAuth sipAuth;
	private String bOutgoingRights;
	private String cOutgoingRights;
	private USMSip usmSip;
	
	
	public String getbOutgoingRights() {
		return bOutgoingRights;
	}
	public void setbOutgoingRights(String bOutgoingRights) {
		this.bOutgoingRights = bOutgoingRights;
	}
	public String getcOutgoingRights() {
		return cOutgoingRights;
	}
	public void setcOutgoingRights(String cOutgoingRights) {
		this.cOutgoingRights = cOutgoingRights;
	}
	

	public USMSip getUsmSip() {
		return usmSip;
	}
	public void setUsmSip(USMSip usmSip) {
		this.usmSip = usmSip;
	}
	public String getDeleteSipUe() {
		return deleteSipUe;
	}
	public void setDeleteSipUe(String deleteSipUe) {
		this.deleteSipUe = deleteSipUe;
	}
	public String getGwIp() {
		return gwIp;
	}
	public void setGwIp(String gwIp) {
		this.gwIp = gwIp;
	}
	
	public String getAddPrefix() {
		return addPrefix;
	}
	public void setAddPrefix(String addPrefix) {
		this.addPrefix = addPrefix;
	}
	public String getSubPbx() {
		return subPbx;
	}
	public void setSubPbx(String subPbx) {
		this.subPbx = subPbx;
	}
	public String getLocalGwIp() {
		return localGwIp;
	}
	public void setLocalGwIp(String localGwIp) {
		this.localGwIp = localGwIp;
	}
	public String getJoint() {
		return joint;
	}
	public void setJoint(String joint) {
		this.joint = joint;
	}
	public String getSipUe() {
		return sipUe;
	}
	public void setSipUe(String sipUe) {
		this.sipUe = sipUe;
	}
	public String getUeType() {
		return ueType;
	}
	public void setUeType(String ueType) {
		this.ueType = ueType;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLongNum() {
		return longNum;
	}
	public void setLongNum(String longNum) {
		this.longNum = longNum;
	}
	public String getRightLevel() {
		return rightLevel;
	}
	public void setRightLevel(String rightLevel) {
		this.rightLevel = rightLevel;
	}
	public SIPAuth getSipAuth() {
		return sipAuth;
	}
	public void setSipAuth(SIPAuth sipAuth) {
		this.sipAuth = sipAuth;
	}

}
