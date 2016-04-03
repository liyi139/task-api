package com.rtmap.apistore.taskland.dao;

import com.rtmap.apistore.taskland.entity.TaskFollow;

public interface TaskFollowDao {
    
    int deleteByPrimaryKey(String taskId);

    
    int insert(TaskFollow record);

    
    int insertSelective(TaskFollow record);

    
    TaskFollow selectByPrimaryKey(String taskId);

    
    int updateByPrimaryKeySelective(TaskFollow record);

    
    int updateByPrimaryKey(TaskFollow record);
}