package com.rtmap.apistore.interfaces.taskland.dao;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskComment;

@WebRepository
public interface TaskCommentDao {

	int deleteByPrimaryKey(String commentId);

	int insert(TaskComment taskComment);

	TaskComment selectByPrimaryKey(String commentId);

	int updateByPrimaryKeySelective(TaskComment taskComment);

	int updateByPrimaryKey(TaskComment taskComment);
}