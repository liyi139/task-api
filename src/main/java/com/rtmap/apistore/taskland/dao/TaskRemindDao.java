package com.rtmap.apistore.taskland.dao;

import com.rtmap.apistore.taskland.entity.TaskRemind;

public interface TaskRemindDao {
    
    int deleteByPrimaryKey(String remindId);

    
    int insert(TaskRemind record);

    
    int insertSelective(TaskRemind record);

    
    TaskRemind selectByPrimaryKey(String remindId);

    
    int updateByPrimaryKeySelective(TaskRemind record);

    
    int updateByPrimaryKey(TaskRemind record);
}