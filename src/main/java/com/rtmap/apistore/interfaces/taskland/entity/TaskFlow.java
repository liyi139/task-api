package com.rtmap.apistore.interfaces.taskland.entity;

import java.util.Date;

import com.rtmap.apistore.core.base.entity.IEntity;

public class TaskFlow implements IEntity {

	private static final long serialVersionUID = 1961580335533190173L;

	private String flowId;

	private String taskId;

	private String tasAssigner;

	private String taskHandler;

	private Date assignTime;

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId == null ? null : flowId.trim();
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId == null ? null : taskId.trim();
	}

	public String getTasAssigner() {
		return tasAssigner;
	}

	public void setTasAssigner(String tasAssigner) {
		this.tasAssigner = tasAssigner == null ? null : tasAssigner.trim();
	}

	public String getTaskHandler() {
		return taskHandler;
	}

	public void setTaskHandler(String taskHandler) {
		this.taskHandler = taskHandler == null ? null : taskHandler.trim();
	}

	public Date getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}
}