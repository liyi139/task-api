package com.rtmap.apistore.taskland.dao;

import com.rtmap.apistore.taskland.entity.TaskAttachFile;

public interface TaskAttachFileDao {
    
    int deleteByPrimaryKey(String attachId);

    
    int insert(TaskAttachFile record);

    
    int insertSelective(TaskAttachFile record);

    
    TaskAttachFile selectByPrimaryKey(String attachId);

    
    int updateByPrimaryKeySelective(TaskAttachFile record);

    
    int updateByPrimaryKey(TaskAttachFile record);
}