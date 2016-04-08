package com.rtmap.apistore.interfaces.taskland.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.core.web.page.SortRule;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.bean.TaskQueryParamBean;
import com.rtmap.apistore.interfaces.taskland.enums.TaskStatusEnum;
import com.rtmap.apistore.interfaces.taskland.service.TaskListService;

/**
 * 任务田，任务查询
 */
@Controller
@RequestMapping("/taskland/v1.0/")
public class TaskListController {
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(TaskListController.class);
	@Autowired
	private TaskListService taskListService;

	/**
	 * 全部任务列表查询接口
	 * 
	 * @param state
	 * @param period
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value = { "/tasks/", "/tasks/{state:processing|finished}/",
			"/tasks/{state:processing}/{period:today|tomorrow|other|expired}",
			"/tasks/{state:finished}/{period:today|yesterday|week|month|other}" }, method = { RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getAllTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		return null;
	}

	/**
	 * 用户全部任务列表查询接口
	 * 
	 * @param userId
	 * @param state
	 * @param period
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value = { "/users/{userId}/tasks/", "/users/{userId}/tasks/{state:processing|finished}/",
			"/users/{userId}/tasks/{state:processing}/{period:today|tomorrow|other|expired}",
			"/users/{userId}/tasks/{state:finished}/{period:today|yesterday|week|month|other}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserAllTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		return null;
	}

	/**
	 * 用户发起任务列表查询接口
	 * 
	 * @param userId
	 * @param state
	 * @param period
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value = { "/users/{userId}/tasks/origin/",
			"/users/{userId}/tasks/origin/{state:processing|finished}/",
			"/users/{userId}/tasks/origin/{state:processing}/{period:today|tomorrow|other|expired}",
			"/users/{userId}/tasks/origin/{state:finished}/{period:today|yesterday|week|month|other}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserOriginTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		return null;
	}

	/**
	 * 用户指派任务列表查询接口
	 * 
	 * @param userId
	 * @param state
	 * @param period
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value = { "/users/{userId}/tasks/assign/",
			"/users/{userId}/tasks/assign/{state:processing|finished}/",
			"/users/{userId}/tasks/assign/{state:processing}/{period:today|tomorrow|other|expired}",
			"/users/{userId}/tasks/assign/{state:finished}/{period:today|yesterday|week|month|other}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserAssignTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		return null;
	}

	/**
	 * 用户关注任务列表查询接口
	 * 
	 * @param userId
	 * @param state
	 * @param period
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value = { "/users/{userId}/tasks/follow/",
			"/users/{userId}/tasks/follow/{state:processing|finished}/",
			"/users/{userId}/tasks/follow/{state:processing}/{period:today|tomorrow|other|expired}",
			"/users/{userId}/tasks/follow/{state:finished}/{period:today|yesterday|week|month|other}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserFollowTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		return null;
	}

	/**
	 * 用户待处理的任务列表查询接口
	 * 
	 * @param userId
	 * @param state
	 * @param period
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value = { "/users/{userId}/tasks/pending/",
			"/users/{userId}/tasks/pending/{state:processing|finished}/",
			"/users/{userId}/tasks/pending/{state:processing}/{period:today|tomorrow|other|expired}",
			"/users/{userId}/tasks/pending/{state:finished}/{period:today|yesterday|week|month|other}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserPendingTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		return null;
	}
}
