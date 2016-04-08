package com.rtmap.apistore.interfaces.taskland.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.entity.TaskAttachFile;
import com.rtmap.apistore.interfaces.taskland.entity.TaskComment;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFlow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskInfo;
import com.rtmap.apistore.interfaces.taskland.entity.TaskLog;
import com.rtmap.apistore.interfaces.taskland.entity.TaskParticipant;
import com.rtmap.apistore.interfaces.taskland.service.TaskInfoService;

/**
 * 任务田，任务查询
 */
@Controller
@RequestMapping("/taskland/v1.0/")
public class TaskInfoController {
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(TaskInfoController.class);
	@Autowired
	private TaskInfoService taskInfoService;

	/**
	 * 任务详情查询接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}", method = { RequestMethod.GET })
	@ResponseBody
	public TaskInfo getTaskInfo(@PathVariable(value = "taskId") String taskId) {
		return this.taskInfoService.getTaskById(taskId);
	}

	/**
	 * 任务相关附件查询接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/attaches", method = { RequestMethod.GET })
	@ResponseBody
	public List<TaskAttachFile> getAttaches(@PathVariable(value = "taskId") String taskId) {
		return this.taskInfoService.getAttachesByTaskId(taskId);
	}

	/**
	 * 任务操作日志查询接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/logs", method = { RequestMethod.GET })
	@ResponseBody
	public PageList<TaskLog> getLogs(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer curPage) {
		return this.taskInfoService.getOperLogsByTaskId(taskId, new PageQuery(curPage, limit));
	}

	/**
	 * 任务查阅日志查询接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/logs/view", method = { RequestMethod.GET })
	@ResponseBody
	public PageList<TaskLog> getViewLogs(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer curPage) {
		return this.taskInfoService.getViewLogsByTaskId(taskId, new PageQuery(curPage, limit));
	}

	/**
	 * 任务状态变更日志查询接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/logs/state", method = { RequestMethod.GET })
	@ResponseBody
	public PageList<TaskLog> getStateLogs(@PathVariable(value = "taskId") String taskId,
			@RequestParam(required = false, value = "limit") Integer limit,
			@RequestParam(required = false, value = "offset") Integer curPage) {
		return this.taskInfoService.getStateLogsByTaskId(taskId, new PageQuery(curPage, limit));
	}

	/**
	 * 任务子任务查询接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/subtasks", method = { RequestMethod.GET })
	@ResponseBody
	public List<TaskInfoBean> getSubtasks(@PathVariable(value = "taskId") String taskId) {
		return this.taskInfoService.getSubTasksByTaskId(taskId);
	}

	/**
	 * 任务评论/回复查询接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/comments", method = { RequestMethod.GET })
	@ResponseBody
	public List<TaskComment> getComments(@PathVariable(value = "taskId") String taskId) {
		return this.taskInfoService.getCommentsByTaskId(taskId);
	}

	/**
	 * 任务参与人查询接口
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/participant", method = { RequestMethod.GET })
	@ResponseBody
	public List<TaskParticipant> getParticipant(@PathVariable(value = "taskId") String taskId) {
		return this.taskInfoService.getParticipantByTaskId(taskId);
	}

	/**
	 * 任务指派流转查询接口
	 * 
	 * @param userId
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/flow", method = { RequestMethod.GET })
	@ResponseBody
	public List<TaskFlow> getTaskFlow(@PathVariable(value = "taskId") String taskId) {
		return this.taskInfoService.getFlowsByTaskId(taskId);
	}

	/**
	 * 获取用户在任务中的角色(orginer:发起人、assigner:指派人、follower:关注人、handler:处理人、participant
	 * :参与人)
	 * 
	 * @param userId
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/users/{userId}/tasks/{taskId}/roles", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, Boolean> getUserRoleInTask(@PathVariable(value = "userId") String userId,
			@PathVariable(value = "taskId") String taskId) {
		//TODO
		return null;
	}
}
