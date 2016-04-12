package com.rtmap.apistore.task.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskQueryParamBean;
import com.rtmap.apistore.interfaces.taskland.service.TaskListService;

public class TestTaskListService extends TestTaskOperateService {
	@Autowired
	private TaskListService taskListService;

	@Override
	public void test() {
		TaskQueryParamBean taskQueryParamBean = new TaskQueryParamBean();
		// taskQueryParamBean.setTaskType(new Integer[]{1,2});
		// taskQueryParamBean.setDeadline_begin(DateTime.now().minusDays(5).toDate());
		// taskQueryParamBean.setDeadline_end(DateTime.now().toDate());
		// taskQueryParamBean.setQ("test");
		this.taskListService.getUserTasks("ADMIN", taskQueryParamBean, new PageQuery(2, 10));
		// this.taskListService.getUserOriginTasks("ADMIN", new
		// TaskQueryParamBean(), new PageQuery(1, 10));
		// this.taskListService.getUserAssignTasks("ADMIN", new
		// TaskQueryParamBean(), new PageQuery(1, 10));
		// this.taskListService.getUserPendingTasks("ADMIN", new
		// TaskQueryParamBean(), new PageQuery(1, 10));
		// this.taskListService.getUserFollowTasks("ADMIN", new
		// TaskQueryParamBean(), new PageQuery(1, 10));
	}

}
