package com.rtmap.apistore.taskland.dao;

import com.rtmap.apistore.taskland.entity.TaskRemindLog;

public interface TaskRemindLogDao {
    
    int deleteByPrimaryKey(String remindId);

    
    int insert(TaskRemindLog record);

    
    int insertSelective(TaskRemindLog record);

    
    TaskRemindLog selectByPrimaryKey(String remindId);

    
    int updateByPrimaryKeySelective(TaskRemindLog record);

    
    int updateByPrimaryKey(TaskRemindLog record);
}