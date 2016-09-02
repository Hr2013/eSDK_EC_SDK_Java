package com.huawei.esdk.ec.conference.bean;

import java.util.List;

public class DeleteMeeting {

	private String userId;
	private List<DeleteMeetingBaseParam> deleteItem;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DeleteMeetingBaseParam> getDeleteItem() {
		return deleteItem;
	}

	public void setDeleteItem(List<DeleteMeetingBaseParam> deleteItem) {
		this.deleteItem = deleteItem;
	}

}
