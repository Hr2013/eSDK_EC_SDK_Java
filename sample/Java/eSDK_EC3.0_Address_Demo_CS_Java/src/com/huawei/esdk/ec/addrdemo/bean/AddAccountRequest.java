package com.huawei.esdk.ec.addrdemo.bean;

import java.util.List;

public class AddAccountRequest {
	 private String userId;
	 private Account account;
	 private List<Account> accounts;
	 private List<String> accountIds;
	
	
	public List<String> getAccountIds() {
		return accountIds;
	}
	public void setAccountIds(List<String> accountIds) {
		this.accountIds = accountIds;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
