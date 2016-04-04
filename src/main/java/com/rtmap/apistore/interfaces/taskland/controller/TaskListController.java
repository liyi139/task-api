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

import com.rtmap.apistore.interfaces.taskland.service.TaskQueryService;

/**
 * 任务田，任务查询
 */
@Controller
@RequestMapping("/taskland/v1.0/")
public class TaskListController {
	private final static Logger logger = LoggerFactory.getLogger(TaskListController.class);
	@Autowired
	private TaskQueryService taskFlowService;

	/**
	 * 查询任务列表
	 */
	private Object _list(String userId, String[] taskTypeAry, String[] taskStatusAry, String sort, String order,
			Integer limit, Integer offset) {
		return null;
	}

	/**
	 * 搜索任务列表
	 */
	private Object _search(String userId, String keywords, String sort, String order, Integer limit, Integer offset) {
		return null;
	}

	/**
	 * 任务搜索接口（按用户权限查询）
	 */
	@RequestMapping(value = "/usrs/{userId}/tasks/search", method = { RequestMethod.GET })
	@ResponseBody
	public Object search(@RequestParam(required = false, value = "userId") String userId,
			@RequestParam(required = true, value = "q") String keywords,
			@RequestParam(required = false, defaultValue = "MODIFY_TIME", value = "sort") String sort,
			@RequestParam(required = false, defaultValue = "DESC", value = "order") String order,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer offset) {
		return _search(userId, keywords, sort, order, limit, offset);
	}

	/**
	 * 任务搜索接口
	 */
	@RequestMapping(value = "/tasks/search", method = { RequestMethod.GET })
	@ResponseBody
	public Object search(@RequestParam(required = true, value = "q") String keywords,
			@RequestParam(required = false, defaultValue = "MODIFY_TIME", value = "sort") String sort,
			@RequestParam(required = false, defaultValue = "DESC", value = "order") String order,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer offset) {
		return _search(null, keywords, sort, order, limit, offset);
	}

	/**
	 * 查询任务列表接口
	 */
	@RequestMapping(value = "/tasks", method = { RequestMethod.GET })
	@ResponseBody
	public Object list(@RequestParam(required = false, value = "taskType") String[] taskTypeAry,
			@RequestParam(required = false, value = "taskStatus") String[] taskStatusAry,
			@RequestParam(required = false, defaultValue = "MODIFY_TIME", value = "sort") String sort,
			@RequestParam(required = false, defaultValue = "DESC", value = "order") String order,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer offset) {
		return _list(null, taskTypeAry, taskStatusAry, sort, order, limit, offset);
	}

	/**
	 * 查询任务列表接口(按用户权限)
	 */
	@RequestMapping(value = "/users/{userId}/tasks", method = { RequestMethod.GET })
	@ResponseBody
	public Object list(@PathVariable(value = "userId") String userId,
			@RequestParam(required = false, value = "taskType") String[] taskTypeAry,
			@RequestParam(required = false, value = "taskStatus") String[] taskStatusAry,
			@RequestParam(required = false, defaultValue = "MODIFY_TIME", value = "sort") String sort,
			@RequestParam(required = false, defaultValue = "DESC", value = "order") String order,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer offset) {
		return _list(userId, taskTypeAry, taskStatusAry, sort, order, limit, offset);
	}

	/**
	 * 待处理的任务列表查询接口
	 */
	@RequestMapping(value = "/users/{userId}/tasks/pendinges", method = { RequestMethod.GET })
	@ResponseBody
	public Object listPending(@PathVariable(value = "userId") String userId,
			@RequestParam(required = false, value = "taskType") String[] taskTypeAry,
			@RequestParam(required = false, value = "taskStatus") String[] taskStatusAry,
			@RequestParam(required = false, defaultValue = "MODIFY_TIME", value = "sort") String sort,
			@RequestParam(required = false, defaultValue = "DESC", value = "order") String order,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer offset) {
		return _list(userId, taskTypeAry, taskStatusAry, sort, order, limit, offset);
	}

	/**
	 * 用户待处理的任务列表查询接口
	 */
	@RequestMapping(value = "/tasks/pendinges", method = { RequestMethod.GET })
	@ResponseBody
	public Object listPending(@RequestParam(required = false, value = "taskType") String[] taskTypeAry,
			@RequestParam(required = false, value = "taskStatus") String[] taskStatusAry,
			@RequestParam(required = false, defaultValue = "MODIFY_TIME", value = "sort") String sort,
			@RequestParam(required = false, defaultValue = "DESC", value = "order") String order,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer offset) {
		return _list(null, taskTypeAry, taskStatusAry, sort, order, limit, offset);
	}

	/**
	 * 用户关注的任务列表查询接口
	 */
	@RequestMapping(value = "/users/{userId}/tasks/follows", method = { RequestMethod.GET })
	@ResponseBody
	public Object listFollow(@PathVariable(value = "userId") String userId,
			@RequestParam(required = false, value = "taskType") String[] taskTypeAry,
			@RequestParam(required = false, value = "taskStatus") String[] taskStatusAry,
			@RequestParam(required = false, defaultValue = "MODIFY_TIME", value = "sort") String sort,
			@RequestParam(required = false, defaultValue = "DESC", value = "order") String order,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer offset) {
		return _list(userId, taskTypeAry, taskStatusAry, sort, order, limit, offset);
	}

	/**
	 * 用户发起的任务列表查询接口
	 */
	@RequestMapping(value = "/users/{userId}/tasks/origins", method = { RequestMethod.GET })
	@ResponseBody
	public Object listOrigin(@PathVariable(value = "userId") String userId,
			@RequestParam(required = false, value = "taskType") String[] taskTypeAry,
			@RequestParam(required = false, value = "taskStatus") String[] taskStatusAry,
			@RequestParam(required = false, defaultValue = "MODIFY_TIME", value = "sort") String sort,
			@RequestParam(required = false, defaultValue = "DESC", value = "order") String order,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer offset) {
		return _list(userId, taskTypeAry, taskStatusAry, sort, order, limit, offset);
	}
}
