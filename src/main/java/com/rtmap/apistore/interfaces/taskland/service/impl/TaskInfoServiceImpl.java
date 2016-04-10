package com.rtmap.apistore.interfaces.taskland.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.core.web.page.PageQuery;
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
import com.rtmap.apistore.interfaces.taskland.service.TaskInfoService;

@Service
public class TaskInfoServiceImpl implements TaskInfoService {
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
		return this.taskInfoDao.selectByTaskId(taskId);
	}

	@Override
	public List<TaskAttachFile> getAttachesByTaskId(String taskId) {
		return this.taskAttachFileDao.selectAttachesByTaskId(taskId);
	}

	@Override
	public PageList<TaskLog> getStateLogsByTaskId(String taskId, PageQuery pageQuery) {
		return this.taskLogDao.selectLogsByTaskId(taskId,
				new Integer[] { TaskOperTypeEnum.CREATE.getCode(), TaskOperTypeEnum.ASSIGN.getCode(),
						TaskOperTypeEnum.CANCEL.getCode(), TaskOperTypeEnum.FINISH.getCode(),
						TaskOperTypeEnum.REFUSE.getCode() },
				pageQuery);
	}

	@Override
	public PageList<TaskLog> getOperLogsByTaskId(String taskId, PageQuery pageQuery) {
		return this.taskLogDao.selectLogsByTaskId(taskId, null, pageQuery);
	}

	@Override
	public PageList<TaskLog> getViewLogsByTaskId(String taskId, PageQuery pageQuery) {
		return this.taskLogDao.selectLogsByTaskId(taskId, new Integer[] { TaskOperTypeEnum.VIEW.getCode() }, pageQuery);
	}

	@Override
	public List<TaskInfoBean> getSubTasksByTaskId(String taskId) {
		return this.taskInfoDao.selectTaskListByPid(taskId);

	}

	@Override
	public List<TaskComment> getCommentsByTaskId(String taskId) {
		return this.taskCommentDao.selectCommentsByTaskId(taskId);
	}

	@Override
	public List<TaskParticipant> getParticipantByTaskId(String taskId) {
		return this.taskParticipantDao.selectParticipantsByTaskId(taskId);
	}

	@Override
	public List<TaskFlow> getFlowsByTaskId(String taskId) {
		return this.taskFlowDao.selectFlowsByTaskId(taskId);
	}

	@Override
	public List<TaskFollow> getFollowersByTaskId(String taskId) {
		return this.taskFollowDao.selectFollowsByTaskId(taskId);
	}

	@Override
	public String getUserRoleInTask(String taskId, String userId) {
		return this.taskInfoDao.selectUserRole(taskId, userId);
	}

}
