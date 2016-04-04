package com.rtmap.apistore.interfaces.taskland.entity;

import java.util.Date;

import com.rtmap.apistore.core.base.entity.IEntity;

public class TaskLog implements IEntity {

	private static final long serialVersionUID = -5721854706110370753L;

	private String logId;

	private String taskId;

	private Integer operateType;

	private String operateCont;

	private String operator;

	private Date operateTime;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId == null ? null : logId.trim();
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId == null ? null : taskId.trim();
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public String getOperateCont() {
		return operateCont;
	}

	public void setOperateCont(String operateCont) {
		this.operateCont = operateCont == null ? null : operateCont.trim();
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