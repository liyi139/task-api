package com.rtmap.apistore.interfaces.taskland.service;

import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;

public interface TaskOperateService {
	/**
	 * 添加任务
	 * 
	 * @param taskInfoBean
	 * @param userId
	 * @return
	 */
	public String addTask(TaskInfoBean taskInfoBean, String userId);

	/**
	 * 添加子任务
	 * 
	 * @param taskPid
	 * @param taskInfoBean
	 * @param userId
	 * @return
	 */
	public String addTask(String taskPid, TaskInfoBean taskInfoBean, String userId);

	/**
	 * 删除任务
	 * 
	 * @param taskId
	 * @param userId
	 * @return
	 */
	public boolean delTask(String taskId, String userId);

	/**
	 * 删除子任务
	 * 
	 * @param taskPid
	 * @param taskId
	 * @param userId
	 * @return
	 */
	public boolean delTask(String taskPid, String taskId, String userId);

	/**
	 * 任务标记取消
	 * 
	 * @param taskId
	 * @param comment
	 * @param userId
	 * @return
	 */
	public boolean markCancel(String taskId, String comment, String userId);

	/**
	 * 任务标记完成
	 * 
	 * @param taskId
	 * @param comment
	 * @param userId
	 * @return
	 */
	public boolean markFinish(String taskId, String comment, String userId);

	/**
	 * 任务标记拒绝
	 * 
	 * @param taskId
	 * @param comment
	 * @param userId
	 * @return
	 */
	public boolean markRefuse(String taskId, String comment, String userId);

	/**
	 * 添加任务关注
	 * 
	 * @param taskId
	 * @param isFollow
	 * @param userId
	 * @return
	 */
	public boolean addFollow(String taskId, boolean isFollow, String userId);

	/**
	 * 修改任务信息
	 * 
	 * @param taskInfoBean
	 * @param userId
	 * @return
	 */
	public boolean updateTask(TaskInfoBean taskInfoBean, String userId);

	/**
	 * 添加任务指派
	 * 
	 * @param taskId
	 * @param handler
	 * @param comment
	 * @param userId
	 * @return
	 */
	public boolean addAssignTaskFlow(String taskId, String handler, String comment, String userId);

	/**
	 * 添加任务催办
	 * 
	 * @param taskId
	 * @param handler
	 * @param comment
	 * @param remindMode
	 * @param userId
	 */
	public void addUrgeRemind(String taskId, String handler, String comment, String remindMode, String userId);

	/**
	 * 添加任务相关附件
	 * 
	 * @param taskId
	 * @param fileName
	 * @param filePath
	 * @param userId
	 * @return
	 */
	public String addAttachFile(String taskId, String fileName, String filePath, String userId);

	/**
	 * 删除任务相关附件
	 * 
	 * @param taskId
	 * @param attachId
	 * @param userId
	 */
	public void delAttachFile(String taskId, String attachId, String userId);

	/**
	 * 添加任务评论
	 * 
	 * @param taskId
	 * @param comment
	 * @param userId
	 * @return
	 */
	public String addTaskComment(String taskId, String comment, String userId);

	/**
	 * 删除任务评论
	 * 
	 * @param taskId
	 * @param commentId
	 * @param userId
	 */
	public void delTaskComment(String taskId, String commentId, String userId);

	/**
	 * 添加任务参与人
	 * 
	 * @param taskId
	 * @param participant
	 * @param userId
	 * @return
	 */
	public void addParticipant(String taskId, String participant, String userId);

	/**
	 * 删除任务参与人
	 * 
	 * @param taskId
	 * @param participant
	 * @param userId
	 */
	public void delParticipant(String taskId, String participant, String userId);

}
