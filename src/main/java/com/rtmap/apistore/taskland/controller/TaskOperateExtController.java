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

/**
 * 任务田，任务操作
 *
 */
@Controller
@RequestMapping("/taskland")
public class TaskOperateExtController {
	private final static Logger logger = LoggerFactory.getLogger(TaskOperateExtController.class);
	@Autowired
	private TaskOperateService taskOperateService;

	/**
	 * 添加回复/评论任务接口
	 * 
	 * @param comment
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/comments", method = { RequestMethod.PUT })
	@ResponseBody
	public Object addComment(@RequestParam(required = true, value = "comment") String comment,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 删除回复/评论任务接口
	 * 
	 * @param commentId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/comments/{commentId}", method = { RequestMethod.DELETE })
	@ResponseBody
	public Object deleteComment(@PathVariable(value = "commentId") String commentId,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 添加任务附件接口
	 * 
	 * @param fileName
	 * @param filePath
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/attaches", method = { RequestMethod.POST })
	@ResponseBody
	public Object addAttach(@RequestParam(required = true, value = "fileName") String fileName,
			@RequestParam(required = true, value = "filePath") String filePath,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 删除任务附件接口
	 * 
	 * @param attachId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/attaches", method = { RequestMethod.DELETE })
	@ResponseBody
	public Object deleteAttach(@PathVariable(value = "attachId") String attachId,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 添加子任务接口
	 * 
	 * @param taskInfoBean
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/subtasks", method = { RequestMethod.POST })
	@ResponseBody
	public Object addSubTask(@RequestBody TaskInfoBean taskInfoBean,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}

	/**
	 * 删除子任务
	 * 
	 * @param subTaskId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/tasks/{taskId}/attaches/{subTaskId}", method = { RequestMethod.DELETE })
	@ResponseBody
	public Object deleteSubTask(@PathVariable(value = "subTaskId") String subTaskId,
			@RequestParam(required = true, value = "userId") String userId) {
		return null;
	}
}
