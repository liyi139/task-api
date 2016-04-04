package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskComment;

@WebRepository
public interface TaskCommentDao {

	int deleteByPrimaryKey(@Param(value = "commentId") String commentId);

	int insert(TaskComment taskComment);

	TaskComment selectByPrimaryKey(@Param(value = "commentId") String commentId);

	int updateByPrimaryKeySelective(TaskComment taskComment);

	int updateByPrimaryKey(TaskComment taskComment);

	List<TaskComment> selectByTaskId(@Param(value = "taskId") String taskId);
}