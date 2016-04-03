package com.rtmap.apistore.task.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rtmap.apistore.core.base.test.BaseSpringTest;
import com.rtmap.apistore.core.holder.SpringContextHolder;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.enums.TaskTypeEnum;
import com.rtmap.apistore.interfaces.taskland.service.TaskOperateService;

public class TaskOperateServiceTest extends BaseSpringTest {
	@Autowired
	private TaskOperateService taskOperateService;

	@Test
	public void test() {
		TaskInfoBean taskInfoBean = this.testAddTask();
		this.testFollowTask(taskInfoBean.getTaskId());
		this.testUpdateTask(taskInfoBean);
		this.testCancelTask(taskInfoBean.getTaskId());
		this.testRefuseTask(taskInfoBean.getTaskId());
		this.testFinishTask(taskInfoBean.getTaskId());
		this.testAssignTask(taskInfoBean.getTaskId());
		this.testDelTask(taskInfoBean.getTaskId());
		System.out.println(SpringContextHolder.getBean("DIM"));
	}

	private TaskInfoBean testAddTask() {
		TaskInfoBean taskInfoBean = new TaskInfoBean();
		taskInfoBean.setTaskName("测试添加任务");
		taskInfoBean.setCreator("ADMIN");
		taskInfoBean.setTaskCont("测试");
		taskInfoBean.setCreator("ADMIN");
		taskInfoBean.setTaskType(TaskTypeEnum.WARN_TODO.getCode());
		String taskId = taskOperateService.addTask(taskInfoBean, "ADMIN");
		Assert.assertNotNull(taskId);
		return taskInfoBean;
	}

	private void testDelTask(String taskId) {
		Assert.assertTrue(taskOperateService.delTask(taskId, "ADMIN"));
	}

	private void testCancelTask(String taskId) {
		Assert.assertTrue(taskOperateService.markCancel(taskId, "ADMIN", "测试取消任务"));
	}

	private void testFinishTask(String taskId) {
		Assert.assertTrue(taskOperateService.markFinish(taskId, "ADMIN", "测试任务标记完成"));
	}

	private void testRefuseTask(String taskId) {
		Assert.assertTrue(taskOperateService.markRefuse(taskId, "ADMIN", "测试任务拒绝"));
	}

	private void testFollowTask(String taskId) {
		Assert.assertTrue(taskOperateService.addFollow(taskId, true, "ADMIN"));
	}

	private void testUpdateTask(TaskInfoBean taskInfo) {
		taskInfo.setTaskName("修改任务名称");
		Assert.assertTrue(taskOperateService.updateTask(taskInfo, "ADMIN"));
	}

	private void testAssignTask(String taskId) {
		Assert.assertTrue(taskOperateService.addAssignTaskFlow(taskId, "DEMO", "测试指派任务", "ADMIN"));
	}
}
