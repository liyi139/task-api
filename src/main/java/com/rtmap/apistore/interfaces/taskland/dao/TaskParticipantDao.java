package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskParticipant;

@WebRepository
public interface TaskParticipantDao {

	/**
	 * 根据任务编码、参与人编码；删除任务参与人关联信息
	 * 
	 * @param taskId
	 * @param participant
	 * @return
	 */
	int deleteByParticipant(@Param(value = "taskId") String taskId, @Param(value = "participants") String[] participants);

	/**
	 * 根据任务编码，删除任务参与人关联信息
	 * 
	 * @param taskId
	 * @return
	 */
	int deleteByTaskId(@Param(value = "taskId") String taskId);

	/**
	 * 保存任务参与人关联信息
	 * 
	 * @param taskParticipant
	 * @return
	 */
	int insert(TaskParticipant taskParticipant);

	/**
	 * 根据任务编码，获取任务参与人关联信息
	 * 
	 * @param taskId
	 * @return
	 */
	List<TaskParticipant> selectParticipantsByTaskId(@Param(value = "taskId") String taskId);
}