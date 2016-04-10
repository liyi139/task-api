package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.interfaces.taskland.entity.TaskAttachFile;

@WebRepository
public interface TaskAttachFileDao {

	/**
	 * 根据附件编码，删除任务关联附件
	 * 
	 * @param attachId
	 * @return
	 */
	int deleteByAttachIds(@Param(value = "attachIds") String[] attachIds);

	/**
	 * 根据任务编码，删除任务关联附件
	 * 
	 * @param taskId
	 * @return
	 */
	int deleteByTaskId(@Param(value = "taskId") String taskId);

	/**
	 * 保存任务关联附件信息
	 * 
	 * @param taskAttachFile
	 * @return
	 */
	int insert(TaskAttachFile taskAttachFile);

	/**
	 * 根据附件编码，获取任务关联附件信息
	 * 
	 * @param attachId
	 * @return
	 */
	TaskAttachFile selectByAttachId(@Param(value = "attachId") String attachId);

	/**
	 * 根据任务附件编码数组，获取任务附件编码对应任务附件名称
	 * 
	 * @param attachIds
	 * @return
	 */
	List<Map<String, String>> selectIdNamesByIds(@Param(value = "attachIds") String[] attachIds);

	/**
	 * 更新任务关联附件信息
	 * 
	 * @param taskAttachFile
	 * @return
	 */
	int update(TaskAttachFile taskAttachFile);

	/**
	 * 根据任务编码，获取任务关联附件列表
	 * 
	 * @param taskId
	 * @return
	 */
	List<TaskAttachFile> selectAttachesByTaskId(@Param(value = "taskId") String taskId);

}