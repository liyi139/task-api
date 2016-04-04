package com.rtmap.apistore.interfaces.taskland.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.dao.TaskAttachFileDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskCommentDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskFlowDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskFollowDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskInfoDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskLogDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskParticipantDao;
import com.rtmap.apistore.interfaces.taskland.entity.TaskAttachFile;
import com.rtmap.apistore.interfaces.taskland.entity.TaskComment;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFlow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFollow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskLog;
import com.rtmap.apistore.interfaces.taskland.entity.TaskParticipant;
import com.rtmap.apistore.interfaces.taskland.enums.TaskOperTypeEnum;
import com.rtmap.apistore.interfaces.taskland.service.TaskQueryService;

public class TaskQueryServiceImpl implements TaskQueryService {
	@Autowired
	private TaskInfoDao taskInfoDao;
	@Autowired
	private TaskFollowDao taskFollowDao;
	@Autowired
	private TaskCommentDao taskCommentDao;
	@Autowired
	private TaskLogDao taskLogDao;
	@Autowired
	private TaskFlowDao taskFlowDao;
	@Autowired
	private TaskAttachFileDao taskAttachFileDao;
	@Autowired
	private TaskParticipantDao taskParticipantDao;

	@Override
	public TaskInfoBean getTaskById(String taskId) {
		return this.taskInfoDao.selectByPrimaryKey(taskId);
	}

	@Override
	public List<TaskAttachFile> getAttachesByTaskId(String taskId) {
		return this.taskAttachFileDao.selectByTaskId(taskId);
	}

	@Override
	public List<TaskLog> getStateLogsByTaskId(String taskId) {
		return this.taskLogDao.selectByTaskId(taskId,
				new Integer[] { TaskOperTypeEnum.CREATE.getCode(), TaskOperTypeEnum.ASSIGN.getCode(),
						TaskOperTypeEnum.CANCEL.getCode(), TaskOperTypeEnum.FINISH.getCode(),
						TaskOperTypeEnum.REFUSE.getCode() });
	}

	@Override
	public List<TaskLog> getOperLogsByTaskId(String taskId) {
		return this.taskLogDao.selectByTaskId(taskId);
	}

	@Override
	public List<TaskLog> getViewLogsByTaskId(String taskId) {
		return this.taskLogDao.selectByTaskId(taskId, new Integer[] { TaskOperTypeEnum.VIEW.getCode() });
	}

	@Override
	public List<TaskInfoBean> getSubTasksByTaskId(String taskId) {
		return this.taskInfoDao.selectByTaskPid(taskId);

	}

	@Override
	public List<TaskComment> getCommentsByTaskId(String taskId) {
		return this.taskCommentDao.selectByTaskId(taskId);
	}

	@Override
	public List<TaskParticipant> getParticipantByTaskId(String taskId) {
		return this.taskParticipantDao.selectByTaskId(taskId);
	}

	@Override
	public List<TaskFlow> getFlowsByTaskId(String taskId) {
		return this.taskFlowDao.selectByTaskId(taskId);
	}

	@Override
	public List<TaskFollow> getFollowersByTaskId(String taskId) {
		return this.taskFollowDao.selectByTaskId(taskId);
	}

}
