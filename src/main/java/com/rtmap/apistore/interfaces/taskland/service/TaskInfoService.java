package com.rtmap.apistore.interfaces.taskland.service;

import java.util.List;
import java.util.Map;

import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.entity.TaskAttachFile;
import com.rtmap.apistore.interfaces.taskland.entity.TaskComment;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFlow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFollow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskLog;
import com.rtmap.apistore.interfaces.taskland.entity.TaskParticipant;

public interface TaskInfoService {
	/**
	 * 根据任务编码查询任务信息
	 * 
	 * @param taskId
	 * @return
	 */
	public TaskInfoBean getTaskById(String taskId);

	/**
	 * 根据任务编码查询任务相关附件
	 * 
	 * @param taskId
	 * @return
	 */
	public List<TaskAttachFile> getAttachesByTaskId(String taskId);

	/**
	 * 根据任务编码获取任务状态变更日志
	 * 
	 * @param taskId
	 * @return
	 */
	public PageList<TaskLog> getStateLogsByTaskId(String taskId, PageQuery pageQuery);

	/**
	 * 根据任务编码获取任务操作流水日志
	 * 
	 * @param taskId
	 * @return
	 */
	public PageList<TaskLog> getOperLogsByTaskId(String taskId, PageQuery pageQuery);

	/**
	 * 根据任务编码获取任务查看日志
	 * 
	 * @param taskId
	 * @return
	 */
	public PageList<TaskLog> getViewLogsByTaskId(String taskId, PageQuery pageQuery);

	/**
	 * 根据任务编码获取子任务
	 * 
	 * @param taskId
	 * @return
	 */
	public List<TaskInfoBean> getSubTasksByTaskId(String taskId);

	/**
	 * 根据任务编码获取任务评论
	 * 
	 * @param taskId
	 * @return
	 */
	public List<TaskComment> getCommentsByTaskId(String taskId);

	/**
	 * 根据任务编码获取任务参与人
	 * 
	 * @param taskId
	 * @return
	 */
	public List<TaskParticipant> getParticipantByTaskId(String taskId);

	/**
	 * 根据任务编码获取任务指派
	 * 
	 * @param taskId
	 * @return
	 */
	public List<TaskFlow> getFlowsByTaskId(String taskId);

	/**
	 * 根据任务编码获取所有任务参与人
	 * 
	 * @param taskId
	 * @return
	 */
	public List<TaskFollow> getFollowersByTaskId(String taskId);

	/**
	 * 获取用户在任务中的角色
	 * 
	 * @param taskId
	 * @param userId
	 * @return
	 */
	public String getUserRoleInTask(String taskId, String userId);

}
