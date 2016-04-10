package com.rtmap.apistore.interfaces.taskland;

public class TasklandConstant {
	// 任务创建的默认提醒模式
	public static final String DEFAULT_REMIND_MODE = "001";
	// 任务创建的默认提醒成员
	public static final String DEFAULT_REMIND_MEMBER = "110";
	// 任务操作日志，操作内容字段默认的最大截取长度
	public static final int LOG_CONTENT_MAX_LENGTH = 30;
	// 任务创建，根节点任务的父任务编码
	public static final String TASK_PID_ROOT = "-1";
	// 任务列表默认分页记录条数
	public static final int DEFAULT_PAGE_LIMIT = 10;
}
