package com.rtmap.apistore.interfaces.taskland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.bean.TaskQueryParamBean;
import com.rtmap.apistore.interfaces.taskland.dao.TaskInfoDao;
import com.rtmap.apistore.interfaces.taskland.service.TaskListService;

public class TaskListServiceImpl implements TaskListService {

	@Autowired
	private TaskInfoDao taskInfoDao;

	@Override
	public PageList<TaskInfoBean> getUserTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery) {
		return taskInfoDao.selectTaskListByCond(userId,"ALL", queryParm, pageQuery);
	}

	@Override
	public PageList<TaskInfoBean> getUserOriginTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery) {
		return taskInfoDao.selectTaskListByCond(userId,"ORIGIN", queryParm, pageQuery);
	}

	@Override
	public PageList<TaskInfoBean> getUserAssignTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery) {
		return taskInfoDao.selectTaskListByCond(userId,"ASSIGN", queryParm, pageQuery);
	}

	@Override
	public PageList<TaskInfoBean> getUserFollowTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery) {
		return taskInfoDao.selectTaskListByCond(userId,"FOLLOW", queryParm, pageQuery);
	}

	@Override
	public PageList<TaskInfoBean> getUserPendingTasks(String userId, TaskQueryParamBean queryParm,
			PageQuery pageQuery) {
		return taskInfoDao.selectTaskListByCond(userId,"PENDING", queryParm, pageQuery);
	}

}
