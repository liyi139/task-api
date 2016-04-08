package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskParticipant;

@WebRepository
public interface TaskParticipantDao {

	int delete(@Param(value = "taskId") String taskId, @Param(value = "participant") String participant);

	int deleteByTaskId(@Param(value = "taskId") String taskId);

	int insert(TaskParticipant taskParticipant);

	List<TaskParticipant> selectByTaskId(@Param(value = "taskId") String taskId);
}