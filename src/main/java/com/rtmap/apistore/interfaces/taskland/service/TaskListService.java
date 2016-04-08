package com.rtmap.apistore.interfaces.taskland.service;

import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;

public interface TaskListService {
	/**
	 * 根据任务类型、任务状态查询任务列表
	 * 
	 * @param userId
	 * @param taskTypeAry
	 * @param taskStatusAry
	 * @param sort
	 * @param order
	 * @param pageQuery
	 * @return
	 */
	public PageList<TaskInfoBean> getListByCond(String userId, Integer[] taskTypeAry, Integer[] taskStatusAry,
			PageQuery pageQuery);

	/**
	 * 根据任务标题模糊查询任务列表
	 * 
	 * @param userId
	 * @param keywords
	 * @param sort
	 * @param order
	 * @param pageQuery
	 * @return
	 */
	public PageList<TaskInfoBean> searchByKeywords(String userId, String keywords, PageQuery pageQuery);
}
