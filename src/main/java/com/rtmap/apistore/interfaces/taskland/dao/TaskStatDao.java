package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TaskStatDao {
	/**
	 * 根据用户编码，分组（待办、发起、指派、关注）统计任务数量
	 * 
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> statCountByGroup(@Param(value = "userId") String userId);
}