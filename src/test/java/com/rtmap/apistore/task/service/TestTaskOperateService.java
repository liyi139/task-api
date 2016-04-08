package com.rtmap.apistore.task.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtmap.apistore.core.base.test.BaseSpringTest;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.enums.TaskTypeEnum;
import com.rtmap.apistore.interfaces.taskland.service.TaskOperService;

public class TestTaskOperateService extends BaseSpringTest {
	@Autowired
	public TaskOperService taskOperateService;

	@Test
	public void test() {
		TaskInfoBean taskInfoBean = this.testAddTask("-1");
		String taskId = taskInfoBean.getTaskId();
		this.testFollowTask(taskInfoBean.getTaskId());
		this.testUpdateTask(taskInfoBean);
		this.testCancelTask(taskInfoBean.getTaskId());
		this.testRefuseTask(taskInfoBean.getTaskId());
		this.testFinishTask(taskInfoBean.getTaskId());
		this.testAssignTask(taskId);
		this.testAddUrgeRemind(taskId);
		String attachId = this.testAddAttachFile(taskId);
		this.testDelAttachFile(taskId, attachId);
		String commentId = this.testAddTaskComment(taskId);
		this.testDelTaskComment(taskId, commentId);
		this.testAddParticipant(taskId);
		this.testDelParticipant(taskId);
		this.testDelTask(taskInfoBean.getTaskId());
	}

	public TaskInfoBean testAddTask(String taskPid) {
		TaskInfoBean taskInfoBean = new TaskInfoBean();
		taskInfoBean.setTaskName("测试添加任务");
		taskInfoBean.setCreator("ADMIN");
		taskInfoBean.setTaskCont("测试");
		taskInfoBean.setCreator("ADMIN");
		taskInfoBean.setTaskType(TaskTypeEnum.WARN_TODO.getCode());
		String taskId = taskOperateService.addTask(taskPid, taskInfoBean, "ADMIN");
		Assert.assertNotNull(taskId);
		return taskInfoBean;
	}

	public void testDelTask(String taskId) {
		Assert.assertTrue(taskOperateService.delTask(taskId, "ADMIN"));
	}

	public void testCancelTask(String taskId) {
		Assert.assertTrue(taskOperateService.markCancel(taskId, "ADMIN", "测试取消任务"));
	}

	public void testFinishTask(String taskId) {
		Assert.assertTrue(taskOperateService.markFinish(taskId, "ADMIN", "测试任务标记完成"));
	}

	public void testRefuseTask(String taskId) {
		Assert.assertTrue(taskOperateService.markRefuse(taskId, "ADMIN", "测试任务拒绝"));
	}

	public void testFollowTask(String taskId) {
		Assert.assertTrue(taskOperateService.addFollow(taskId, true, "ADMIN"));
	}

	public void testUpdateTask(TaskInfoBean taskInfo) {
		taskInfo.setTaskName("修改任务名称");
		Assert.assertTrue(taskOperateService.updateTask(taskInfo, "ADMIN"));
	}

	public void testAssignTask(String taskId) {
		Assert.assertTrue(taskOperateService.addAssignTaskFlow(taskId, "DEMO", "测试指派任务", "ADMIN"));
	}

	public void testAddUrgeRemind(String taskId) {
		taskOperateService.addUrgeRemind(taskId, "ADMIN", "测试", "001", "ADMIN");
	}

	public String testAddAttachFile(String taskId) {
		return taskOperateService.addAttachFile(taskId, "文件测试", "test.doc", "ADMIN");
	}

	public void testDelAttachFile(String taskId, String attachId) {
		taskOperateService.delAttachFile(taskId, new String[] { attachId }, "ADMIN");
	}

	public String testAddTaskComment(String taskId) {
		return taskOperateService.addTaskComment(taskId, "测试", "ADMIN");
	}

	public void testDelTaskComment(String taskId, String commentId) {
		taskOperateService.delTaskComment(taskId, new String[] { commentId }, "ADMIN");
	}

	public void testAddParticipant(String taskId) {
		taskOperateService.addParticipant(taskId, "DEMO", "ADMIN");
	}

	public void testDelParticipant(String taskId) {
		taskOperateService.delTaskComment(taskId, new String[] { "DEMO" }, "ADMIN");
	}

}
