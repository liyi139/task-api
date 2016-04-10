package com.rtmap.apistore.interfaces.taskland.service;

import java.util.Map;

public interface TaskStatService {

	/**
	 * 根据用户id，按类别统计任务数量(待办、发起的、指派的、关注的）
	 * 
	 * @param userId
	 * @return
	 */
	public Map<String, Integer> statCount(String userId);
}
