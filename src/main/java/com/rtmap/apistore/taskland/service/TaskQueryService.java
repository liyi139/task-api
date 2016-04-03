package com.rtmap.apistore.taskland.service;

import com.rtmap.apistore.taskland.bean.TaskInfoBean;

public interface TaskQueryService {
	public TaskInfoBean getTaskById(String taskId);
}
