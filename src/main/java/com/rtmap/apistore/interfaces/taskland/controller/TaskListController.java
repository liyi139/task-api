package com.rtmap.apistore.interfaces.taskland.controller;

import org.joda.time.DateTime;
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
import com.rtmap.apistore.interfaces.taskland.bean.TaskQueryParamBean;
import com.rtmap.apistore.interfaces.taskland.enums.TaskStatusEnum;
import com.rtmap.apistore.interfaces.taskland.service.TaskListService;

/**
 * 任务田，任务查询
 */
@Controller
@RequestMapping("/taskland/v1/")
public class TaskListController {
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(TaskListController.class);
	@Autowired
	private TaskListService taskListService;

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
			"/users/{userId}/tasks/{state:finished}/{period:today|yesterday|week|month}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		this.fillParams(state, period, queryParam);
		return taskListService.getUserTasks(userId, queryParam, this.initPapeQuery(queryParam));
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
			"/users/{userId}/tasks/origin/{state:finished}/{period:today|yesterday|week|month}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserOriginTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		this.fillParams(state, period, queryParam);
		return taskListService.getUserOriginTasks(userId, queryParam, this.initPapeQuery(queryParam));
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
			"/users/{userId}/tasks/assign/{state:finished}/{period:today|yesterday|week|month}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserAssignTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		this.fillParams(state, period, queryParam);
		return taskListService.getUserAssignTasks(userId, queryParam, this.initPapeQuery(queryParam));
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
			"/users/{userId}/tasks/follow/{state:finished}/{period:today|yesterday|week|month}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserFollowTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		this.fillParams(state, period, queryParam);
		return taskListService.getUserFollowTasks(userId, queryParam, this.initPapeQuery(queryParam));
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
			"/users/{userId}/tasks/pending/{state:finished}/{period:today|yesterday|week|month}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserPendingTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		this.fillParams(state, period, queryParam);
		return taskListService.getUserPendingTasks(userId, queryParam, this.initPapeQuery(queryParam));

	}

	/**
	 * 用户参与的任务列表查询接口
	 * 
	 * @param userId
	 * @param state
	 * @param period
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value = { "/users/{userId}/tasks/participate/",
			"/users/{userId}/tasks/participate/{state:processing|finished}/",
			"/users/{userId}/tasks/participate/{state:processing}/{period:today|tomorrow|other|expired}",
			"/users/{userId}/tasks/participate/{state:finished}/{period:today|yesterday|week|month}" }, method = {
					RequestMethod.GET })
	@ResponseBody
	public PageList<TaskInfoBean> getUserParticipateTasks(@PathVariable String userId, @PathVariable String state,
			@PathVariable String period, @RequestParam TaskQueryParamBean queryParam) {
		this.fillParams(state, period, queryParam);
		return taskListService.getUserParticipateTasks(userId, queryParam, this.initPapeQuery(queryParam));

	}

	/**
	 * 根据state、period填充查询所需的任务状态参数
	 * 
	 * @param state
	 */
	private void fillParams(String state, String period, TaskQueryParamBean queryParam) {
		if (state.equals("processing")) {
			queryParam.setTaskStatus(new Integer[] { TaskStatusEnum.PROCESSING.getCode() });
			if (period.equals("today")) {
				queryParam.setDeadline_begin(DateTime.now().toDate());
				queryParam.setDeadline_end(DateTime.now().toDate());
			} else if (period.equals("tomorrow")) {
				queryParam.setDeadline_begin(DateTime.now().plusDays(1).toDate());
				queryParam.setDeadline_end(DateTime.now().plusDays(1).toDate());
			} else if (period.equals("other")) {
				queryParam.setDeadline_begin(DateTime.now().plusDays(1).toDate());
				queryParam.setDeadline_end(DateTime.now().plusYears(10).toDate());
			} else if (period.equals("expired")) {
				queryParam.setDeadline_begin(DateTime.now().minusYears(10).toDate());
				queryParam.setDeadline_end(DateTime.now().minusDays(1).toDate());
			}
		}
		if (state.equals("finished")) {
			queryParam.setTaskStatus(new Integer[] { TaskStatusEnum.FINISH.getCode(), TaskStatusEnum.REFUSE.getCode(),
					TaskStatusEnum.CANCEL.getCode() });
			if (period.equals("today")) {
				queryParam.setModifyTime_begin(DateTime.now().withTimeAtStartOfDay().toDate());
				queryParam.setModifyTime_end(DateTime.now().toDate());
			} else if (period.equals("yesterday")) {
				queryParam.setModifyTime_begin(DateTime.now().withTimeAtStartOfDay().minusDays(1).toDate());
				queryParam.setModifyTime_end(DateTime.now().toDate());
			} else if (period.equals("week")) {
				queryParam.setModifyTime_begin(DateTime.now().withTimeAtStartOfDay().minusDays(7).toDate());
				queryParam.setModifyTime_end(DateTime.now().toDate());
			} else if (period.equals("month")) {
				queryParam.setModifyTime_begin(DateTime.now().withTimeAtStartOfDay().minusDays(30).toDate());
				queryParam.setModifyTime_end(DateTime.now().toDate());
			}
		}
	}

	private PageQuery initPapeQuery(TaskQueryParamBean queryParam) {
		PageQuery pageQuery = new PageQuery(queryParam.getCurPage(), queryParam.getLimit());
		pageQuery.setsColumns(queryParam.getSort());
		pageQuery.setsColumns(queryParam.getOrder());
		return pageQuery;
	}

}
