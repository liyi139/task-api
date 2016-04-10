package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskComment;

@WebRepository
public interface TaskCommentDao {

	/**
	 * 根据评论编码，删除任务关联评论信息
	 * 
	 * @param commentId
	 * @return
	 */
	int deleteByCommentIds(@Param(value = "commentIds") String[] commentIds);

	/**
	 * 根据任务编码，删除任务关联的所有评论信息
	 * 
	 * @param taskId
	 * @return
	 */
	int deleteByTaskId(@Param(value = "taskId") String taskId);

	/**
	 * 保存任务评论信息
	 * 
	 * @param taskComment
	 * @return
	 */
	int insert(TaskComment taskComment);

	/**
	 * 根据评论编码，获取任务关联的评论对象
	 * 
	 * @param commentId
	 * @return
	 */
	TaskComment selectByCommentId(@Param(value = "commentId") String commentId);
	
	/**
	 * 根据任务评论编码数组，获取任务评论编码对应任务评论
	 * 
	 * @param commentIds
	 * @return
	 */
	List<Map<String, String>> selectIdNamesByIds(@Param(value = "commentIds") String[] commentIds);
	

	/**
	 * 更新任务评论对象
	 * 
	 * @param taskComment
	 * @return
	 */
	int update(TaskComment taskComment);

	/**
	 * 根据任务编码，获取任务相关的所有评论对象列表
	 * 
	 * @param taskId
	 * @return
	 */
	List<TaskComment> selectCommentsByTaskId(@Param(value = "taskId") String taskId);
}