package com.huawei.esdk.ec.addrdemo.bean;

import java.util.List;

public class SIPList {
	private String amount;
	private List<SIPAccount> sips;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public List<SIPAccount> getSips() {
		return sips;
	}
	public void setSips(List<SIPAccount> sips) {
		this.sips = sips;
	}
	
}
