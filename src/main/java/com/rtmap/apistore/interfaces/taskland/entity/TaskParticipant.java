package com.rtmap.apistore.interfaces.taskland.entity;

import java.util.Date;

import com.rtmap.apistore.core.base.entity.IEntity;

public class TaskParticipant implements IEntity {

	private static final long serialVersionUID = -1406773827496177325L;

	private String taskId;

	private String participant;

	private String operator;

	private Date operateTime;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId == null ? null : taskId.trim();
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant == null ? null : participant.trim();
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
}