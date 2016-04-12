package com.rtmap.apistore.interfaces.taskland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.bean.TaskQueryParamBean;
import com.rtmap.apistore.interfaces.taskland.dao.TaskInfoDao;
import com.rtmap.apistore.interfaces.taskland.service.TaskListService;

@Service
public class TaskListServiceImpl implements TaskListService {

	@Autowired
	private TaskInfoDao taskInfoDao;

	@Override
	public PageList<TaskInfoBean> getUserTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery) {
		return taskInfoDao.selectTaskListByCond(userId, queryParm, pageQuery);
	}

	@Override
	public PageList<TaskInfoBean> getUserOriginTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery) {
		return taskInfoDao.selectOriginTaskListByCond(userId, queryParm, pageQuery);
	}

	@Override
	public PageList<TaskInfoBean> getUserAssignTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery) {
		return taskInfoDao.selectAssignTaskListByCond(userId, queryParm, pageQuery);
	}

	@Override
	public PageList<TaskInfoBean> getUserFollowTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery) {
		return taskInfoDao.selectFollowTaskListByCond(userId, queryParm, pageQuery);
	}

	@Override
	public PageList<TaskInfoBean> getUserPendingTasks(String userId, TaskQueryParamBean queryParm,
			PageQuery pageQuery) {
		return taskInfoDao.selectPendingTaskListByCond(userId, queryParm, pageQuery);
	}

	@Override
	public PageList<TaskInfoBean> getUserParticipateTasks(String userId, TaskQueryParamBean queryParm,
			PageQuery pageQuery) {
		return taskInfoDao.selectParticipateTaskListByCond(userId, queryParm, pageQuery);
	}
}
