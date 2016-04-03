package com.rtmap.apistore.interfaces.taskland.dao;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskInfo;

@WebRepository
public interface TaskInfoDao {

	int deleteByPrimaryKey(@Param(value = "taskId") String taskId);

	int insert(TaskInfo taskInfo);

	TaskInfo selectByPrimaryKey(@Param(value = "taskId") String taskId);

	int updateByPrimaryKeySelective(TaskInfo taskInfo);

	int updateByPrimaryKey(TaskInfo taskInfo);
}