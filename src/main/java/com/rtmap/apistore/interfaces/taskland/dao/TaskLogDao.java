package com.rtmap.apistore.interfaces.taskland.dao;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.entity.TaskLog;

@WebRepository
public interface TaskLogDao {

	int deleteByPrimaryKey(@Param(value = "logId") String logId);

	int insert(TaskLog taskLog);

	TaskLog selectByPrimaryKey(@Param(value = "logId") String logId);

	PageList<TaskLog> selectByTaskId(@Param(value = "taskId") String taskId,
			@Param(value = "stateItems") Integer[] stateItems, PageQuery pageQuery);
}