package com.huawei.esdk.ec.addrdemo.bean;

import java.util.List;

public class addSipAccountRequest {
	 private String userId;
	 private SIPAccount sip;
	 private List<SIPAccount> sips;
	 private String numStep;
	 private String amount;
	 private String ueStep;
	 private String exactSearch;
	 private String type;
	 private String value;
	 private String pageCount;
	 private String pageNum;
	 
	 
	public List<SIPAccount> getSips() {
		return sips;
	}
	public void setSips(List<SIPAccount> sips) {
		this.sips = sips;
	}
	public String getNumStep() {
		return numStep;
	}
	public void setNumStep(String numStep) {
		this.numStep = numStep;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUeStep() {
		return ueStep;
	}
	public void setUeStep(String ueStep) {
		this.ueStep = ueStep;
	}
	public String getExactSearch() {
		return exactSearch;
	}
	public void setExactSearch(String exactSearch) {
		this.exactSearch = exactSearch;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPageCount() {
		return pageCount;
	}
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public SIPAccount getSip() {
		return sip;
	}
	public void setSip(SIPAccount sip) {
		this.sip = sip;
	}
	 
}
