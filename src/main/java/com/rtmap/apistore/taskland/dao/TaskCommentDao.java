package com.rtmap.apistore.taskland.dao;

import com.rtmap.apistore.taskland.entity.TaskComment;

public interface TaskCommentDao {
    
    int deleteByPrimaryKey(String commentId);

    
    int insert(TaskComment record);

    
    int insertSelective(TaskComment record);

    
    TaskComment selectByPrimaryKey(String commentId);

    
    int updateByPrimaryKeySelective(TaskComment record);

    
    int updateByPrimaryKey(TaskComment record);
}