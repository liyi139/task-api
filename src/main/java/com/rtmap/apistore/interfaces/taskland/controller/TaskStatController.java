package com.rtmap.apistore.interfaces.taskland.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rtmap.apistore.interfaces.taskland.service.TaskStatService;

/**
 * 任务田，任务统计
 *
 */
@Controller
@RequestMapping("/taskland/v1.0/")
public class TaskStatController {
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(TaskStatController.class);
	@Autowired
	private TaskStatService taskStatService;

	/**
	 * 用户任务数量统计接口
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "users/{userId}/tasks/stat", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, String> statTaskCount(@PathVariable(value = "userId") String userId) {
		return null;
	}
}
