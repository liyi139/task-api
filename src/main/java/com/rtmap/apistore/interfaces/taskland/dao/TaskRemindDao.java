package com.rtmap.apistore.interfaces.taskland.dao;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskRemind;

@WebRepository
public interface TaskRemindDao {

	int deleteByPrimaryKey(@Param(value = "remindId") String remindId);

	int deleteByTaskId(@Param(value = "taskId") String taskId);

	int insert(TaskRemind taskRemind);

	TaskRemind selectByPrimaryKey(@Param(value = "remindId") String remindId);
}