package com.rtmap.apistore.interfaces.taskland.service;

import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;

public interface TaskListService {
	/**
	 * @param userId
	 * @param taskTypeAry
	 * @param taskStatusAry
	 * @param sort
	 * @param order
	 * @param pageQuery
	 * @return
	 */
	public PageList list(String userId, String[] taskTypeAry, String[] taskStatusAry, String sort, String order,
			PageQuery pageQuery);

	/**
	 * @param userId
	 * @param keywords
	 * @param sort
	 * @param order
	 * @param pageQuery
	 * @return
	 */
	public PageList search(String userId, String keywords, String sort, String order, PageQuery pageQuery);
}
