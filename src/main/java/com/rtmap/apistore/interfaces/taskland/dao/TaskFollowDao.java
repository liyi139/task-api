package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFollow;

@WebRepository
public interface TaskFollowDao {

	int delete(@Param(value = "taskId") String taskId, @Param(value = "follower") String follower);
	
	int deleteByTaskId(@Param(value = "taskId") String taskId);

	int insert(@Param(value = "taskId") String taskId, @Param(value = "follower") String follower);

	List<TaskFollow> selectByTaskId(@Param(value = "taskId") String taskId);
}