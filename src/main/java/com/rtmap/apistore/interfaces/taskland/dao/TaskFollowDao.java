package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFollow;

@WebRepository
public interface TaskFollowDao {

	/**
	 * 删除任务关注信息
	 * @param taskId
	 * @param follower
	 * @return
	 */
	int deleteByFollow(@Param(value = "taskId") String taskId, @Param(value = "follower") String follower);
	
	/**
	 * 根据任务编码，删除任务相关的关注信息
	 * @param taskIds
	 * @return
	 */
	int deleteByTaskId(@Param(value = "taskId") String taskIds);

	/**
	 * 保存任务关注信息
	 * @param taskFollow
	 * @return
	 */
	int insert(TaskFollow taskFollow);

	/**
	 * 根据任务编码，获取任务相关的关注信息列表
	 * @param taskId
	 * @return
	 */
	List<TaskFollow> selectFollowsByTaskId(@Param(value = "taskId") String taskId);
}