package com.rtmap.apistore.taskland.service;

import com.rtmap.apistore.taskland.bean.TaskInfoBean;

public interface TaskOperateService {
	public void addTask(TaskInfoBean taskInfoBean);

	public boolean delTask(String taskId, String userId);

	public boolean cancelTask(String taskId, String userId, String comment);

	public boolean finishTask(String taskId, String userId, String comment);

	public boolean refuseTask(String taskId, String userId, String comment);

	public boolean followTask(String taskId, boolean isFollow, String userId);

	public boolean updateTask(TaskInfoBean taskInfoBean);

	public boolean assignTask(String taskId, String handler, String comment, String userId);

	public boolean urgeTask(String taskId, String handler, String comment, String userId);

}
