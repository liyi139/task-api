package com.rtmap.apistore.taskland.dao;

import com.rtmap.apistore.taskland.entity.TaskInfo;

public interface TaskInfoDao {
    
    int deleteByPrimaryKey(String taskId);

    
    int insert(TaskInfo record);

    
    int insertSelective(TaskInfo record);

    
    TaskInfo selectByPrimaryKey(String taskId);

    
    int updateByPrimaryKeySelective(TaskInfo record);

    
    int updateByPrimaryKey(TaskInfo record);
}