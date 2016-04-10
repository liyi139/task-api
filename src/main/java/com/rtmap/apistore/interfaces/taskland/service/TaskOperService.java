package com.rtmap.apistore.interfaces.taskland.service;

import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.entity.TaskAttachFile;
import com.rtmap.apistore.interfaces.taskland.entity.TaskComment;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFlow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFollow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskParticipant;
import com.rtmap.apistore.interfaces.taskland.entity.TaskRemind;

public interface TaskOperService {
	/**
	 * 添加任务
	 * 
	 * @param taskInfoBean
	 * @param userId
	 * @return
	 */
	public TaskInfoBean addTask(TaskInfoBean taskInfoBean, String userId);

	/**
	 * 添加子任务
	 * 
	 * @param taskPid
	 * @param taskInfoBean
	 * @param userId
	 * @return
	 */
	public TaskInfoBean addTask(String taskPid, TaskInfoBean taskInfoBean, String userId);

	/**
	 * 删除任务
	 * 
	 * @param taskId
	 * @param userId
	 * @return
	 */
	public void delTask(String taskId, String userId);

	/**
	 * 删除子任务
	 * 
	 * @param taskPid
	 * @param taskId
	 * @param userId
	 * @return
	 */
	public void delTask(String taskPid, String[] taskIds, String userId);

	/**
	 * 任务标记取消
	 * 
	 * @param taskId
	 * @param comment
	 * @param userId
	 * @return
	 */
	public void markCancel(String taskId, String comment, String userId);

	/**
	 * 任务标记完成
	 * 
	 * @param taskId
	 * @param comment
	 * @param userId
	 * @return
	 */
	public void markFinish(String taskId, String comment, String userId);

	/**
	 * 任务标记拒绝
	 * 
	 * @param taskId
	 * @param comment
	 * @param userId
	 * @return
	 */
	public void markRefuse(String taskId, String comment, String userId);

	/**
	 * 添加任务关注
	 * 
	 * @param taskId
	 * @param isFollow
	 * @param userId
	 * @return
	 */
	public TaskFollow addFollow(String taskId, boolean isFollow, String userId);

	/**
	 * 修改任务信息
	 * 
	 * @param taskInfoBean
	 * @param userId
	 * @return
	 */
	public TaskInfoBean updateTask(TaskInfoBean taskInfoBean, String userId);

	/**
	 * 添加任务指派
	 * 
	 * @param taskId
	 * @param handler
	 * @param comment
	 * @param userId
	 * @return
	 */
	public TaskFlow addAssignTaskFlow(String taskId, String handler, String comment, String userId);

	/**
	 * 添加任务催办
	 * 
	 * @param taskId
	 * @param handler
	 * @param comment
	 * @param remindMode
	 * @param userId
	 */
	public TaskRemind addUrgeRemind(String taskId, String handler, String comment, String remindMode, String userId);

	/**
	 * 添加任务相关附件
	 * 
	 * @param taskId
	 * @param fileName
	 * @param filePath
	 * @param userId
	 * @return
	 */
	public TaskAttachFile addAttachFile(String taskId, String fileName, String filePath, String userId);

	/**
	 * 删除任务相关附件
	 * 
	 * @param taskId
	 * @param attachId
	 * @param userId
	 */
	public void delAttachFile(String taskId, String[] attachId, String userId);

	/**
	 * 添加任务评论
	 * 
	 * @param taskId
	 * @param comment
	 * @param userId
	 * @return
	 */
	public TaskComment addTaskComment(String taskId, String comment, String userId);

	/**
	 * 删除任务评论
	 * 
	 * @param taskId
	 * @param commentId
	 * @param userId
	 */
	public void delTaskComment(String taskId, String[] commentId, String userId);

	/**
	 * 添加任务参与人
	 * 
	 * @param taskId
	 * @param participant
	 * @param userId
	 * @return
	 */
	public TaskParticipant addParticipant(String taskId, String participant, String userId);

	/**
	 * 删除任务参与人
	 * 
	 * @param taskId
	 * @param participant
	 * @param userId
	 */
	public void delParticipant(String taskId, String[] participant, String userId);

}
