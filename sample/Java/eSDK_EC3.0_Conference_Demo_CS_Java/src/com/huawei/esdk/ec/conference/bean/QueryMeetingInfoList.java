package com.huawei.esdk.ec.conference.bean;

import java.util.List;

public class QueryMeetingInfoList {

	private String amount;
	private List<MeetingInfo> meetingInfoList;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public List<MeetingInfo> getMeetingInfoList() {
		return meetingInfoList;
	}

	public void setMeetingInfoList(List<MeetingInfo> meetingInfoList) {
		this.meetingInfoList = meetingInfoList;
	}

}
