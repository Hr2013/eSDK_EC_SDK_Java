package com.huawei.esdk.ec.addrdemo.bean;

import java.util.List;

public class addAccountResponse<T> {
	private String resultCode;
	private String resultContext;
	private T result;	
	private String amount;
	private String successAmount;
	private String failedAmount;
	private List<String> accountIds;
	private List<FailedAccount> failedAccounts;
	private List<AccountResponse> accounts;	

	

	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	
	public List<AccountResponse> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountResponse> accounts) {
		this.accounts = accounts;
	}
	public String getSuccessAmount() {
		return successAmount;
	}
	public void setSuccessAmount(String successAmount) {
		this.successAmount = successAmount;
	}
	public String getFailedAmount() {
		return failedAmount;
	}
	public void setFailedAmount(String failedAmount) {
		this.failedAmount = failedAmount;
	}
	public List<String> getAccountIds() {
		return accountIds;
	}
	public void setAccountIds(List<String> accountIds) {
		this.accountIds = accountIds;
	}
	public List<FailedAccount> getFailedAccounts() {
		return failedAccounts;
	}
	public void setFailedAccounts(List<FailedAccount> failedAccounts) {
		this.failedAccounts = failedAccounts;
	}

	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultContext() {
		return resultContext;
	}
	public void setResultContext(String resultContext) {
		this.resultContext = resultContext;
	}

}
