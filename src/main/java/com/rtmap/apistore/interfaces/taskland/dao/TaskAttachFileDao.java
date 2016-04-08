package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskAttachFile;

@WebRepository
public interface TaskAttachFileDao {

	int deleteByPrimaryKey(@Param(value = "attachId") String attachId);
	
	int deleteByTaskId(@Param(value = "taskId") String taskId);
	

	int insert(TaskAttachFile taskAttachFile);

	TaskAttachFile selectByPrimaryKey(@Param(value = "attachId") String attachId);

	int updateByPrimaryKeySelective(TaskAttachFile taskAttachFile);

	int updateByPrimaryKey(TaskAttachFile taskAttachFile);

	List<TaskAttachFile> selectByTaskId(@Param(value = "taskId") String taskId);
}