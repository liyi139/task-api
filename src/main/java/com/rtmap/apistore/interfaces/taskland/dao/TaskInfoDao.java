package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.bean.TaskQueryParamBean;
import com.rtmap.apistore.interfaces.taskland.entity.TaskInfo;

@WebRepository
public interface TaskInfoDao {

	/**
	 * 根据任务编码，删除任务对象
	 * 
	 * @param taskId
	 * @return
	 */
	int deleteByTaskIds(@Param(value = "taskIds") String[] taskIds);

	/**
	 * 保存任务对象
	 * 
	 * @param taskInfo
	 * @return
	 */
	int insertTask(TaskInfo taskInfo);

	/**
	 * 更新任务对象
	 * 
	 * @param taskInfo
	 * @return
	 */
	int updateTask(TaskInfo taskInfo);

	/**
	 * 根据任务编码获取任务对象
	 * 
	 * @param taskId
	 * @return
	 */
	TaskInfoBean selectByTaskId(@Param(value = "taskId") String taskId);

	/**
	 * 根据任务编码数组，获取任务编码对应任务名称
	 * 
	 * @param taskIds
	 * @return
	 */
	List<Map<String, String>> selectIdNamesByIds(@Param(value = "taskIds") String[] taskIds);

	/**
	 * 根据任务编码，获取所有子任务对象
	 * 
	 * @param taskPid
	 * @return
	 */
	List<TaskInfoBean> selectTaskListByPid(@Param(value = "taskId") String taskPid);

	/**
	 * 根据任务编码、用户编码，获取用户在此任务中的角色：发起人、指派人、处理人、参与人
	 * 
	 * @param taskId
	 * @param userId
	 * @return
	 */
	String selectUserRole(@Param(value = "taskId") String taskId, @Param(value = "userId") String userId);

	/**
	 * 根据筛选条件获取符合条件的任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	PageList<TaskInfoBean> selectTaskListByCond(@Param(value = "userId") String userId,
			@Param(value = "queryParm") TaskQueryParamBean queryParm, PageQuery pageQuery);

	/**
	 * 根据筛选条件获取符合条件的用户发起任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	PageList<TaskInfoBean> selectOriginTaskListByCond(@Param(value = "userId") String userId,
			@Param(value = "queryParm") TaskQueryParamBean queryParm, PageQuery pageQuery);

	/**
	 * 根据筛选条件获取符合条件的用户指派任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	PageList<TaskInfoBean> selectAssignTaskListByCond(@Param(value = "userId") String userId,
			@Param(value = "queryParm") TaskQueryParamBean queryParm, PageQuery pageQuery);

	/**
	 * 根据筛选条件获取符合条件的用户关注任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	PageList<TaskInfoBean> selectFollowTaskListByCond(@Param(value = "userId") String userId,
			@Param(value = "queryParm") TaskQueryParamBean queryParm, PageQuery pageQuery);

	/**
	 * 根据筛选条件获取符合条件的用户待办任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	PageList<TaskInfoBean> selectPendingTaskListByCond(@Param(value = "userId") String userId,
			@Param(value = "queryParm") TaskQueryParamBean queryParm, PageQuery pageQuery);
	
	/**
	 * 根据筛选条件获取符合条件的用户参与的任务对象列表
	 * 
	 * @param userId
	 * @param queryParm
	 * @param pageQuery
	 * @return
	 */
	PageList<TaskInfoBean> selectParticipateTaskListByCond(@Param(value = "userId") String userId,
			@Param(value = "queryParm") TaskQueryParamBean queryParm, PageQuery pageQuery);	

}