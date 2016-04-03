package com.rtmap.apistore.taskland.dao;

import com.rtmap.apistore.taskland.entity.TaskLog;

public interface TaskLogDao {
    
    int deleteByPrimaryKey(String logId);

    
    int insert(TaskLog record);

    
    int insertSelective(TaskLog record);

    
    TaskLog selectByPrimaryKey(String logId);

    
    int updateByPrimaryKeySelective(TaskLog record);

    
    int updateByPrimaryKey(TaskLog record);
}