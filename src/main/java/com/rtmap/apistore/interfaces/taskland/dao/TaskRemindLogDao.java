package com.rtmap.apistore.interfaces.taskland.dao;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskRemindLog;

@WebRepository
public interface TaskRemindLogDao {

	int deleteByPrimaryKey(String remindId);

	int insert(TaskRemindLog taskRemindLog);

	TaskRemindLog selectByPrimaryKey(String remindId);
}