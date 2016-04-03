package com.rtmap.apistore.taskland.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rtmap.apistore.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.taskland.service.TaskOperateService;
import com.rtmap.apistore.util.IDGenerator;

/**
 * 任务田，任务操作
 *
 */
@Controller
@RequestMapping("/taskland")
public class TaskOperateController {
	private final static Logger logger = LoggerFactory.getLogger(TaskOperateController.class);
	@Autowired
	private TaskOperateService taskOperateService;

	/**
	 * 添加任务接口
	 * 
	 * @param taskInfoBean
	 * @return
	 */
	@RequestMapping(value = "/tasks", method = { RequestMethod.POST })
	@ResponseBody
	public String addTask(@RequestBody TaskInfoBean taskInfoBean,
			@RequestParam(required = true, value = "userId") String userId) {
		String taskId = IDGenerator.getId();
		taskInfoBean.setTaskId(taskId);
		this.taskOperateService.addTask(taskInfoBean);
		return taskId;
	}

	/**
	 * 删除任务接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}", method = { RequestMethod.DELETE })
	@ResponseBody
	public Object deleteTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 取消任务接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/cancel", method = { RequestMethod.PATCH })
	@ResponseBody
	public Object cancelTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId,
			@RequestParam(required = false, value = "comment") String comment) {
		return null;
	}

	/**
	 * 任务标记完成接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/finish", method = { RequestMethod.PATCH })
	@ResponseBody
	public Object finishTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId,
			@RequestParam(required = false, value = "comment") String comment) {
		return null;
	}

	/**
	 * 任务拒绝接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/refuse", method = { RequestMethod.PATCH })
	@ResponseBody
	public Object refuseTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId,
			@RequestParam(required = false, value = "comment") String comment) {
		return null;
	}

	/**
	 * 关注任务接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/follow", method = { RequestMethod.PUT })
	@ResponseBody
	public Object followTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 取消关注任务接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/unfollow", method = { RequestMethod.DELETE })
	@ResponseBody
	public Object unfollowTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 更新任务信息接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}", method = { RequestMethod.PATCH })
	@ResponseBody
	public Object updateTask(@RequestBody TaskInfoBean taskInfoBean,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 任务指派接口
	 * 
	 * @param taskId
	 * @param handler
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/assign", method = { RequestMethod.PUT })
	@ResponseBody
	public Object assignTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "handler") String handler,
			@RequestParam(required = false, value = "comment") String comment,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 任务催办接口
	 * 
	 * @param taskId
	 * @param handler
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/urge", method = { RequestMethod.PUT })
	@ResponseBody
	public Object urgeTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "handler") String handler,
			@RequestParam(required = false, value = "comment") String comment,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}
}
