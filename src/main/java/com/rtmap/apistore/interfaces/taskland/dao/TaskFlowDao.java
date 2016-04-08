package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFlow;

@WebRepository
public interface TaskFlowDao {

	int deleteByPrimaryKey(@Param(value = "flowId") String flowId);

	int deleteByTaskId(@Param(value = "taskId") String taskId);

	int insert(TaskFlow taskFlow);

	TaskFlow selectByPrimaryKey(@Param(value = "flowId") String flowId);

	List<TaskFlow> selectByTaskId(@Param(value = "taskId") String taskId);
}