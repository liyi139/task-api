package com.rtmap.apistore.interfaces.taskland.service;

import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;

public interface TaskQueryService {
	public TaskInfoBean getTaskById(String taskId);
}
