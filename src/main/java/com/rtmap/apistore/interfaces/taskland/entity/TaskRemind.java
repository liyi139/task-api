package com.rtmap.apistore.interfaces.taskland.entity;

import java.util.Date;

import com.rtmap.apistore.core.base.entity.IEntity;

public class TaskRemind implements IEntity{

	private static final long serialVersionUID = 7461558325921008239L;

	private String remindId;

	private String taskId;

	private String remindCont;

	private String remindUser;

	private String remindHandler;

	private String remindMode;

	private Integer remindType;

	private Date recordTime;

	public String getRemindId() {
		return remindId;
	}

	public void setRemindId(String remindId) {
		this.remindId = remindId == null ? null : remindId.trim();
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId == null ? null : taskId.trim();
	}

	public String getRemindCont() {
		return remindCont;
	}

	public void setRemindCont(String remindCont) {
		this.remindCont = remindCont == null ? null : remindCont.trim();
	}

	public String getRemindUser() {
		return remindUser;
	}

	public void setRemindUser(String remindUser) {
		this.remindUser = remindUser == null ? null : remindUser.trim();
	}

	public String getRemindHandler() {
		return remindHandler;
	}

	public void setRemindHandler(String remindHandler) {
		this.remindHandler = remindHandler == null ? null : remindHandler.trim();
	}

	public String getRemindMode() {
		return remindMode;
	}

	public void setRemindMode(String remindMode) {
		this.remindMode = remindMode == null ? null : remindMode.trim();
	}

	public Integer getRemindType() {
		return remindType;
	}

	public void setRemindType(Integer remindType) {
		this.remindType = remindType;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}