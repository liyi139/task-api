package com.rtmap.apistore.interfaces.taskland.dao;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskRemind;

@WebRepository
public interface TaskRemindDao {

	int deleteByPrimaryKey(String remindId);

	int insert(TaskRemind taskRemind);

	TaskRemind selectByPrimaryKey(String remindId);
}