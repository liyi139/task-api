package com.rtmap.apistore.interfaces.taskland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.dao.TaskInfoDao;
import com.rtmap.apistore.interfaces.taskland.service.TaskListService;

public class TaskListServiceImpl implements TaskListService {

	@Autowired
	private TaskInfoDao TaskInfoDao;

	@Override
	public PageList<TaskInfoBean> getListByCond(String userId, Integer[] taskTypeAry, Integer[] taskStatusAry,
			PageQuery pageQuery) {
		return null;
	}

	@Override
	public PageList<TaskInfoBean> searchByKeywords(String userId, String keywords, PageQuery pageQuery) {
		return null;
	}



}
