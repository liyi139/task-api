package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFlow;

@WebRepository
public interface TaskFlowDao {

	/**
	 * 根据任务流转编码，删除任务流转信息
	 * 
	 * @param flowId
	 * @return
	 */
	int deleteByFlowIds(@Param(value = "flowId") String[] flowIds);

	/**
	 * 根据任务编码，删除任务相关流转信息
	 * 
	 * @param taskId
	 * @return
	 */
	int deleteByTaskId(@Param(value = "taskId") String taskId);

	/**
	 * 保存任务流转信息记录
	 * 
	 * @param taskFlow
	 * @return
	 */
	int insert(TaskFlow taskFlow);

	/**
	 * 根据任务流转编码，获取任务流转记录对象
	 * 
	 * @param flowId
	 * @return
	 */
	TaskFlow selectByFlowId(@Param(value = "flowId") String flowId);

	/**
	 * 根据任务编码，获取任务相关的流转信息对象列表
	 * 
	 * @param taskId
	 * @return
	 */
	List<TaskFlow> selectFlowsByTaskId(@Param(value = "taskId") String taskId);
}