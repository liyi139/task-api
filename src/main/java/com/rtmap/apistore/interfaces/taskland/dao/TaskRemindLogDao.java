package com.rtmap.apistore.interfaces.taskland.dao;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskRemindLog;

@WebRepository
public interface TaskRemindLogDao {

	/**
	 * 根据任务提醒日志编码，删除提醒日志
	 * 
	 * @param remindId
	 * @return
	 */
	int deleteByRemindId(String remindId);

	/**
	 * 添加任务提醒日志
	 * 
	 * @param taskRemindLog
	 * @return
	 */
	int insert(TaskRemindLog taskRemindLog);

	/**
	 * 根据任务提醒日志编码，获取任务提醒日志对象
	 * 
	 * @param remindId
	 * @return
	 */
	TaskRemindLog selectByRemindId(String remindId);
}