package com.rtmap.apistore.interfaces.taskland.dao;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskRemind;

@WebRepository
public interface TaskRemindDao {

	/**
	 * 根据任务提醒编码，删除任务提醒对象
	 * 
	 * @param remindId
	 * @return
	 */
	int deleteByRemindId(@Param(value = "remindId") String remindId);

	/**
	 * 根据任务编码，删除任务相关的提醒对象
	 * 
	 * @param taskId
	 * @return
	 */
	int deleteByTaskId(@Param(value = "taskId") String taskId);

	/**
	 * 保存任务提醒对象
	 * 
	 * @param taskRemind
	 * @return
	 */
	int insert(TaskRemind taskRemind);

	/**
	 * 根据任务提醒编码，获取任务提醒对象
	 * 
	 * @param remindId
	 * @return
	 */
	TaskRemind selectByRemindId(@Param(value = "remindId") String remindId);
}