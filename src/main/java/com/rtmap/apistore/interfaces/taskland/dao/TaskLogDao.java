package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.entity.TaskLog;

@WebRepository
public interface TaskLogDao {

	/**
	 * 删除任务日志对象，根据任务编码
	 * 
	 * @param logId
	 * @return
	 */
	int deleteByLogId(@Param(value = "logId") String logId);

	/**
	 * 根据任务编码，删除任务相关的日志对象
	 * 
	 * @param taskId
	 * @return
	 */
	int deleteByTaskId(@Param(value = "taskId") String taskId);

	/**
	 * 保存任务日志
	 * 
	 * @param taskLog
	 * @return
	 */
	int insert(TaskLog taskLog);

	/**
	 * 批量保存任务日志
	 * @param taskLog
	 * @return
	 */
	int insertBatch(@Param(value = "taskLogs") List<TaskLog> taskLogs);
	
	/**
	 * 根据日志编码，获取任务日志对象
	 * 
	 * @param logId
	 * @return
	 */
	TaskLog selectByLogId(@Param(value = "logId") String logId);

	/**
	 * 根据任务编码、任务状态数组，获取满足条件的任务日志列表
	 * 
	 * @param taskId
	 * @param stateItems
	 * @param pageQuery
	 * @return
	 */
	PageList<TaskLog> selectLogsByTaskId(@Param(value = "taskId") String taskId,
			@Param(value = "states") Integer[] states, PageQuery pageQuery);
}