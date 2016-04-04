package com.rtmap.apistore.interfaces.taskland.entity;

import java.util.Date;

import com.rtmap.apistore.core.base.entity.IEntity;

public class TaskAttachFile implements IEntity {

	private static final long serialVersionUID = -3655654247664739489L;

	private String attachId;

	private String taskId;

	private String attachName;

	private String attachPath;

	private String operator;

	private Date operateTime;

	public String getAttachId() {
		return attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId == null ? null : attachId.trim();
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId == null ? null : taskId.trim();
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName == null ? null : attachName.trim();
	}

	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath == null ? null : attachPath.trim();
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