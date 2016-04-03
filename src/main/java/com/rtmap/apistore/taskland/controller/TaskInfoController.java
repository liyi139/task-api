package com.rtmap.apistore.taskland.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rtmap.apistore.taskland.service.TaskQueryService;

/**
 * 任务田，任务查询
 */
@Controller
@RequestMapping("/taskland")
public class TaskInfoController {
	private final static Logger logger = LoggerFactory.getLogger(TaskInfoController.class);
	@Autowired
	private TaskQueryService taskQueryService;

	/**
	 * 任务详情查询接口
	 * 
	 * @param taskId
	 *            任务编码
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}", method = { RequestMethod.GET })
	@ResponseBody
	public Object getTaskInfo(@PathVariable(value = "taskId") String taskId) {
		return null;
	}

	/**
	 * 任务相关附件查询接口
	 * 
	 * @param taskId
	 *            任务编码
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/attaches", method = { RequestMethod.GET })
	@ResponseBody
	public Object getTaskAttaches(@PathVariable(value = "taskId") String taskId) {
		return null;
	}

	/**
	 * 任务日志查询接口
	 * 
	 * @param taskId
	 *            任务编码
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/logs", method = { RequestMethod.GET })
	@ResponseBody
	public Object getTaskLogs(@PathVariable(value = "taskId") String taskId) {
		return null;
	}

	/**
	 * 任务子任务查询接口
	 * 
	 * @param taskId
	 *            任务编码
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/subtasks", method = { RequestMethod.GET })
	@ResponseBody
	public Object getTaskSubtasks(@PathVariable(value = "taskId") String taskId) {
		return null;
	}

	/**
	 * 任务评论/回复查询接口
	 * 
	 * @param taskId
	 *            任务编码
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/comments", method = { RequestMethod.GET })
	@ResponseBody
	public Object getTaskComments(@PathVariable(value = "taskId") String taskId) {
		return null;
	}

	/**
	 * 任务参与人查询接口
	 * 
	 * @param taskId
	 *            任务编码
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/participant", method = { RequestMethod.GET })
	@ResponseBody
	public Object getTaskParticipant(@PathVariable(value = "taskId") String taskId) {
		return null;
	}

	/**
	 * 任务指派流转查询接口
	 * 
	 * @param userId
	 *            用户编码
	 * @param taskId
	 *            任务编码
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/flow", method = { RequestMethod.GET })
	@ResponseBody
	public Object getTaskFlow(@PathVariable(value = "taskId") String taskId) {
		return null;
	}
}
