package com.rtmap.apistore.interfaces.taskland.bean;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.rtmap.apistore.interfaces.taskland.entity.TaskInfo;

public class TaskInfoBean extends TaskInfo {

	private static final long serialVersionUID = 8110316171412373257L;

	// 任务处理人
	private String taskHandler;

	// 子任务编码（逗号分割）
	private String subTaskIds;

	// 子任务数量
	private int subCount;

	// 处理中的子任务数量
	private int subProcessCount;

	public int getSubProcessCount() {
		return subProcessCount;
	}

	public void setSubProcessCount(int subProcessCount) {
		this.subProcessCount = subProcessCount;
	}

	public String[] getSubTasks() {
		if (StringUtils.isNotEmpty(subTaskIds)) {
			return this.subTaskIds.split(",");
		}
		return new String[] {};
	}

	public String getSubTaskIds() {
		return subTaskIds;
	}

	public void setSubTaskIds(String subTaskIds) {
		this.subTaskIds = subTaskIds;
	}

	public int getSubCount() {
		return subCount;
	}

	public void setSubCount(int subCount) {
		this.subCount = subCount;
	}

	public String getTaskHandler() {
		return taskHandler;
	}

	public void setTaskHandler(String taskHandler) {
		this.taskHandler = taskHandler;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

	public int getSubTaskCount() {
		return subCount;
	}

	public void setSubTaskCount(int subTaskCount) {
		this.subCount = subTaskCount;
	}

	public TaskInfoBean() {

	}

	public TaskInfoBean(TaskInfo taskInfo) {
		try {
			BeanUtils.copyProperties(this, taskInfo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
