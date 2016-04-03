package com.rtmap.apistore.interfaces.taskland.dao;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskAttachFile;

@WebRepository
public interface TaskAttachFileDao {

	int deleteByPrimaryKey(String attachId);

	int insert(TaskAttachFile taskAttachFile);

	TaskAttachFile selectByPrimaryKey(String attachId);

	int updateByPrimaryKeySelective(TaskAttachFile taskAttachFile);

	int updateByPrimaryKey(TaskAttachFile taskAttachFile);
}