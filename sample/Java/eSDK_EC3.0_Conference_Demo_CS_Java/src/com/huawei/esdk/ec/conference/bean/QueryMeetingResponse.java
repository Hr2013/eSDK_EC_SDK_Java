package com.huawei.esdk.ec.conference.bean;

public class QueryMeetingResponse {

	private String resultCode;
	private String resultContext;
	private QueryMeetingInfoList queryMeetingInfoList;

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

	public QueryMeetingInfoList getQueryMeetingInfoList() {
		return queryMeetingInfoList;
	}

	public void setQueryMeetingInfoList(
			QueryMeetingInfoList queryMeetingInfoList) {
		this.queryMeetingInfoList = queryMeetingInfoList;
	}

}
