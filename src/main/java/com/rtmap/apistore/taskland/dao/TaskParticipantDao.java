package com.rtmap.apistore.taskland.dao;

import com.rtmap.apistore.taskland.entity.TaskParticipant;

public interface TaskParticipantDao {
    
    int deleteByPrimaryKey(String taskId);

    
    int insert(TaskParticipant record);

    
    int insertSelective(TaskParticipant record);

    
    TaskParticipant selectByPrimaryKey(String taskId);

    
    int updateByPrimaryKeySelective(TaskParticipant record);

    
    int updateByPrimaryKey(TaskParticipant record);
}