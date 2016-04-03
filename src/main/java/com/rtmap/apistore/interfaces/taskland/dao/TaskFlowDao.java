package com.rtmap.apistore.interfaces.taskland.dao;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFlow;

@WebRepository
public interface TaskFlowDao {

	int deleteByPrimaryKey(String flowId);

	int insert(TaskFlow taskFlow);

	TaskFlow selectByPrimaryKey(String flowId);
}