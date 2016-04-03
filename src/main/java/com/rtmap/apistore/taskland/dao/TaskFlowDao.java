package com.rtmap.apistore.taskland.dao;

import com.rtmap.apistore.taskland.entity.TaskFlow;

public interface TaskFlowDao {
    
    int deleteByPrimaryKey(String flowId);

    
    int insert(TaskFlow record);

    
    int insertSelective(TaskFlow record);

    
    TaskFlow selectByPrimaryKey(String flowId);

    
    int updateByPrimaryKeySelective(TaskFlow record);

    
    int updateByPrimaryKey(TaskFlow record);
}