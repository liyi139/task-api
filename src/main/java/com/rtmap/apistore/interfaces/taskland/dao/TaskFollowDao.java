package com.rtmap.apistore.interfaces.taskland.dao;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;

@WebRepository
public interface TaskFollowDao {

	int delete(@Param(value = "taskId") String taskId, @Param(value = "follower") String follower);

	int insert(@Param(value = "taskId") String taskId, @Param(value = "follower") String follower);
}