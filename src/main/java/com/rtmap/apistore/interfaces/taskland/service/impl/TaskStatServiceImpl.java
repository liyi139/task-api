package com.rtmap.apistore.interfaces.taskland.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.rtmap.apistore.interfaces.taskland.dao.TaskStatDao;
import com.rtmap.apistore.interfaces.taskland.service.TaskStatService;

public class TaskStatServiceImpl implements TaskStatService {

	@Autowired
	private TaskStatDao taskStatDao;

	@Override
	public Map<String, Integer> statCount(String userId) {
		List<Map<String, Object>> list = taskStatDao.statCountByGroup(userId);
		Map<String, Integer> resultMap = Maps.newHashMapWithExpectedSize(list.size());
		for (Map<String, Object> map : list) {
			resultMap.put(String.valueOf(map.get("GRP")), (Integer) map.get("CNT"));
		}
		return resultMap;
	}
}
