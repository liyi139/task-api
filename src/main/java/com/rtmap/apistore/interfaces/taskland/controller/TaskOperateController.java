package com.rtmap.apistore.interfaces.taskland.controller;

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

import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFlow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFollow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskRemind;
import com.rtmap.apistore.interfaces.taskland.service.TaskOperService;

/**
 * 任务田，任务操作
 */
@Controller
@RequestMapping("/taskland/v1/")
public class TaskOperateController {
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(TaskOperateController.class);
	@Autowired
	private TaskOperService taskOperateService;

	/**
	 * 添加任务接口
	 * 
	 * @param taskInfoBean
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks", method = { RequestMethod.POST })
	@ResponseBody
	public TaskInfoBean addTask(@RequestBody TaskInfoBean taskInfoBean,
			@RequestParam(required = true, value = "userId") String userId) {
		return taskOperateService.addTask(taskInfoBean, userId);
	}

	/**
	 * 删除任务接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}", method = { RequestMethod.DELETE })
	@ResponseBody
	public void deleteTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId) {
		this.taskOperateService.delTask(taskId, userId);
	}

	/**
	 * 取消任务接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/cancel", method = { RequestMethod.PATCH })
	@ResponseBody
	public void cancelTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId,
			@RequestParam(required = false, value = "comment") String comment) {
		this.taskOperateService.markCancel(taskId, comment, userId);
	}

	/**
	 * 任务标记完成接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/finish", method = { RequestMethod.PATCH })
	@ResponseBody
	public void finishTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId,
			@RequestParam(required = false, value = "comment") String comment) {
		this.taskOperateService.markFinish(taskId, comment, userId);
	}

	/**
	 * 任务拒绝接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/refuse", method = { RequestMethod.PATCH })
	@ResponseBody
	public void refuseTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId,
			@RequestParam(required = false, value = "comment") String comment) {
		this.taskOperateService.markRefuse(taskId, comment, userId);
	}

	/**
	 * 关注任务接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/follow", method = { RequestMethod.PUT })
	@ResponseBody
	public TaskFollow followTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId) {
		return this.taskOperateService.addFollow(taskId, true, userId);
	}

	/**
	 * 取消关注任务接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/unfollow", method = { RequestMethod.DELETE })
	@ResponseBody
	public void unfollowTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "userId") String userId) {
		this.taskOperateService.addFollow(taskId, false, userId);
	}

	/**
	 * 更新任务信息接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}", method = { RequestMethod.PATCH })
	@ResponseBody
	public TaskInfoBean updateTask(@RequestBody TaskInfoBean taskInfoBean,
			@RequestParam(required = true, value = "userId") String userId) {
		return this.taskOperateService.updateTask(taskInfoBean, userId);
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
	public TaskFlow assignTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "handler") String handler,
			@RequestParam(required = false, value = "comment") String comment,
			@RequestParam(required = true, value = "userId") String userId) {
		return this.taskOperateService.addAssignTaskFlow(taskId, handler, comment, userId);
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
	public TaskRemind urgeTask(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = true, value = "handler") String handler,
			@RequestParam(required = false, value = "comment") String comment,
			@RequestParam(required = true, value = "userId") String userId,
			@RequestParam(required = true, value = "remindMode") String remindMode) {
		return this.taskOperateService.addUrgeRemind(taskId, handler, comment, remindMode, userId);
	}

}
