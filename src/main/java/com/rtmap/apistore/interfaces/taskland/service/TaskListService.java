package com.rtmap.apistore.interfaces.taskland.service;

import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.bean.TaskQueryParamBean;

public interface TaskListService {

	/**
	 * 根据用户编码、筛选条件获取符合条件的用户参与的任务对象列表
	 * 
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	public PageList<TaskInfoBean> getUserTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery);

	/**
	 * 根据用户编码、筛选条件获取符合条件的用户参与的任务对象列表
	 * 
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	public PageList<TaskInfoBean> getUserOriginTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery);

	/**
	 * 根据用户编码、任务筛选条件获取符合条件的用户指派任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	public PageList<TaskInfoBean> getUserAssignTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery);

	/**
	 * 根据用户编码、任务筛选条件获取符合条件的用户关注任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	public PageList<TaskInfoBean> getUserFollowTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery);

	/**
	 * 根据用户编码、任务筛选条件获取符合条件的用户待处理任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	public PageList<TaskInfoBean> getUserPendingTasks(String userId, TaskQueryParamBean queryParm, PageQuery pageQuery);

	/**
	 * 根据用户编码、任务筛选条件获取符合条件的用户参与的任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	public PageList<TaskInfoBean> getUserParticipateTasks(String userId, TaskQueryParamBean queryParm,
			PageQuery pageQuery);

}
