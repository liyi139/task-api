package com.rtmap.apistore.taskland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtmap.apistore.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.taskland.dao.TaskCommentDao;
import com.rtmap.apistore.taskland.dao.TaskFollowDao;
import com.rtmap.apistore.taskland.dao.TaskInfoDao;
import com.rtmap.apistore.taskland.dao.TaskLogDao;
import com.rtmap.apistore.taskland.entity.TaskComment;
import com.rtmap.apistore.taskland.entity.TaskInfo;
import com.rtmap.apistore.taskland.entity.TaskLog;
import com.rtmap.apistore.taskland.enums.LogOperateTypeEnum;
import com.rtmap.apistore.taskland.enums.TaskStatusEnum;
import com.rtmap.apistore.taskland.service.TaskOperateService;
import com.rtmap.apistore.util.IDGenerator;

@Service
public class TaskOperateServiceImpl implements TaskOperateService {

	@Autowired
	private TaskInfoDao taskInfoDao;
	@Autowired
	private TaskFollowDao taskFollowDao;
	@Autowired
	private TaskCommentDao taskCommentDao;

	private TaskLogDao taskLogDao;

	@Override
	public void addTask(TaskInfoBean taskInfoBean) {
		this.taskInfoDao.insert(taskInfoBean);
	}

	@Override
	public boolean delTask(String taskId, String userId) {
		TaskLog tasklog = new TaskLog();
		tasklog.setLogId(IDGenerator.getId());
		tasklog.setTaskId(taskId);
		tasklog.setOperateType(LogOperateTypeEnum.DELETE.getCode());
		return this.taskInfoDao.deleteByPrimaryKey(taskId) == 1;
	}

	@Override
	public boolean cancelTask(String taskId, String userId, String comment) {
		return updateTaskStatus(taskId, userId, comment, TaskStatusEnum.CANCEL.getCode(),
				LogOperateTypeEnum.CANCEL.getCode());
	}

	@Override
	public boolean finishTask(String taskId, String userId, String comment) {
		return updateTaskStatus(taskId, userId, comment, TaskStatusEnum.FINISH.getCode(),
				LogOperateTypeEnum.FINISH.getCode());
	}

	@Override
	public boolean refuseTask(String taskId, String userId, String comment) {
		return updateTaskStatus(taskId, userId, comment, TaskStatusEnum.REFUSE.getCode(),
				LogOperateTypeEnum.REFUSE.getCode());
	}

	@Override
	public boolean followTask(String taskId, boolean isFollow, String userId) {
		if(isFollow){
			//存在则不处理，不存在则插入
		}else{
			//存在则删除,不存在则不处理
		}
		return false;
	}

	@Override
	public boolean updateTask(TaskInfoBean taskInfoBean) {
		return false;
	}

	@Override
	public boolean assignTask(String taskId, String handler, String comment, String userId) {
		return false;
	}

	@Override
	public boolean urgeTask(String taskId, String handler, String comment, String userId) {
		return false;
	}

	private boolean updateTaskStatus(String taskId, String userId, String comment, Integer taskStatus,
			Integer logType) {
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskStatus(taskStatus);
		taskInfo.setTaskId(taskId);
		taskInfo.setModifier(userId);
		int count = this.taskInfoDao.updateByPrimaryKeySelective(taskInfo);
		if (count == 0) {
			return false;
		}
		TaskComment taskComment = new TaskComment();
		taskComment.setTaskId(taskId);
		taskComment.setComments(comment);
		taskComment.setReplier(userId);
		taskComment.setReplyType(logType);
		this.taskCommentDao.insert(taskComment);
		TaskLog tasklog = new TaskLog();
		tasklog.setLogId(IDGenerator.getId());
		tasklog.setTaskId(taskId);
		tasklog.setOperateType(logType);
		this.taskLogDao.insert(tasklog);
		return true;

	}

}
