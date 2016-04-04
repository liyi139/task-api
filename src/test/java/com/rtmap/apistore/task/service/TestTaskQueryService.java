package com.rtmap.apistore.task.service;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.service.TaskInfoService;

public class TestTaskQueryService extends TestTaskOperateService {
	@Autowired
	private TaskInfoService taskQueryService;

	@Override
	public void test() {
		TaskInfoBean taskInfoBean = this.testAddTask("-1");
		String taskId = taskInfoBean.getTaskId();
		this.testAddTask(taskId);
		this.testAddTask(taskId);
		TaskInfoBean taskInfoBean2 = taskQueryService.getTaskById(taskInfoBean.getTaskId());
		Assert.assertEquals(taskInfoBean.getTaskId(), taskInfoBean2.getTaskId());
		Assert.assertEquals(taskInfoBean2.getSubCount(), 2);
		this.testAddAttachFile(taskId);
		this.testAddAttachFile(taskId);
		Assert.assertEquals(taskQueryService.getAttachesByTaskId(taskId).size(), 2);
		this.testRefuseTask(taskId);
		List list = taskQueryService.getStateLogsByTaskId(taskId, new PageQuery(0, 10));
		Assert.assertTrue(list.size() > 0);
		list = taskQueryService.getViewLogsByTaskId(taskId, new PageQuery(0, 10));
		Assert.assertTrue(list.size() == 0);
		list = taskQueryService.getOperLogsByTaskId(taskId, new PageQuery(0, 10));
		Assert.assertTrue(list.size() > 0);
		Assert.assertTrue(taskQueryService.getSubTasksByTaskId(taskId).size() == 2);
		taskOperateService.addTaskComment(taskId, "TEST", "ADMIN");
		Assert.assertTrue(taskQueryService.getCommentsByTaskId(taskId).size() > 0);
		taskOperateService.addParticipant(taskId, "DEMO", "ADMIN");
		Assert.assertTrue(taskQueryService.getParticipantByTaskId(taskId).size() > 0);
		taskOperateService.addFollow(taskId, true, "ADMIN");
		Assert.assertTrue(taskQueryService.getFollowersByTaskId(taskId).size() > 0);
		taskOperateService.addFollow(taskId, false, "ADMIN");
		Assert.assertTrue(taskQueryService.getFollowersByTaskId(taskId).size() == 0);
		taskOperateService.addAssignTaskFlow(taskId, "DEMO", "测试", "ADMIN");
		Assert.assertTrue(taskQueryService.getFlowsByTaskId(taskId).size() > 0);

	}

}
