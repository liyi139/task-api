package com.rtmap.apistore.interfaces.taskland.dao;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskLog;

@WebRepository
public interface TaskLogDao {

	int deleteByPrimaryKey(String logId);

	int insert(TaskLog taskLog);

	TaskLog selectByPrimaryKey(String logId);
}