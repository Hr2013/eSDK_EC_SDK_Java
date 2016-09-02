package com.huawei.esdk.ec.conference.bean;

import java.util.List;

public class DeleteMeetingResponse {

	private String resultCode;
	private String resultContext;
	private List<DeleteMeetingParam> result;

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

	public List<DeleteMeetingParam> getResult() {
		return result;
	}

	public void setResult(List<DeleteMeetingParam> result) {
		this.result = result;
	}

}
