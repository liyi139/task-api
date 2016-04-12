package com.rtmap.apistore.interfaces.taskland.bean;

import java.util.Date;

import com.rtmap.apistore.interfaces.taskland.TasklandConstant;
import com.rtmap.apistore.interfaces.taskland.enums.TaskSortEnum;

public class TaskQueryParamBean {
	// 任务类型
	private Integer[] taskType = null;
	// 任务状态
	private Integer[] taskStatus = null;
	// 任务优先级
	private Integer taskPriority = null;
	// 排序数据字段
	private String sort = TaskSortEnum.UPDATE_TIME.getColumn();
	// 排序方式
	private String order = "ASC";
	// 分页条数
	private Integer limit = TasklandConstant.DEFAULT_PAGE_LIMIT;
	// 当前页
	private Integer curPage = 1;

	// 搜索关键词
	private String q = null;

	// 到期日期开始时间
	private Date deadline_begin = null;

	// 到期日期结束时间
	private Date deadline_end = null;

	// 更新日期开始时间
	private Date modifyTime_begin = null;

	// 更新日期结束时间
	private Date modifyTime_end = null;
	// 指派人
	private String[] assigner = null;
	// 处理人
	private String[] handler = null;

	public String[] getAssigner() {
		return assigner;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public Date getDeadline_begin() {
		return deadline_begin;
	}

	public Date getDeadline_end() {
		return deadline_end;
	}

	public String[] getHandler() {
		return handler;
	}

	public Integer getLimit() {
		return limit;
	}

	public Date getModifyTime_begin() {
		return modifyTime_begin;
	}

	public Date getModifyTime_end() {
		return modifyTime_end;
	}

	public String getOrder() {
		return order;
	}

	public String getQ() {
		return q;
	}

	public String getSort() {
		return sort;
	}

	public Integer getTaskPriority() {
		return taskPriority;
	}

	public Integer[] getTaskStatus() {
		return taskStatus;
	}

	public Integer[] getTaskType() {
		return taskType;
	}

	public void setAssigner(String[] assigner) {
		this.assigner = assigner;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public void setDeadline_begin(Date deadline_begin) {
		this.deadline_begin = deadline_begin;
	}

	public void setDeadline_end(Date deadline_end) {
		this.deadline_end = deadline_end;
	}

	public void setHandler(String[] handler) {
		this.handler = handler;
	}

	public void setKeyword(String keyword) {
		this.q = keyword;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setModifyTime_begin(Date modifyTime_begin) {
		this.modifyTime_begin = modifyTime_begin;
	}

	public void setModifyTime_end(Date modifyTime_end) {
		this.modifyTime_end = modifyTime_end;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

	public void setTaskStatus(Integer[] taskStatus) {
		this.taskStatus = taskStatus;
	}

	public void setTaskType(Integer[] taskType) {
		this.taskType = taskType;
	}
}
