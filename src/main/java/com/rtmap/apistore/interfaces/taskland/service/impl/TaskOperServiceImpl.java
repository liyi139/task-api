package com.rtmap.apistore.interfaces.taskland.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.rtmap.apistore.core.exception.BaseRuntimeException;
import com.rtmap.apistore.interfaces.taskland.TasklandConstant;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.dao.TaskAttachFileDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskCommentDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskFlowDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskFollowDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskInfoDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskLogDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskParticipantDao;
import com.rtmap.apistore.interfaces.taskland.dao.TaskRemindDao;
import com.rtmap.apistore.interfaces.taskland.entity.TaskAttachFile;
import com.rtmap.apistore.interfaces.taskland.entity.TaskComment;
import com.rtmap.apistore.interfaces.taskland.entity.TaskFlow;
import com.rtmap.apistore.interfaces.taskland.entity.TaskInfo;
import com.rtmap.apistore.interfaces.taskland.entity.TaskLog;
import com.rtmap.apistore.interfaces.taskland.entity.TaskParticipant;
import com.rtmap.apistore.interfaces.taskland.entity.TaskRemind;
import com.rtmap.apistore.interfaces.taskland.enums.TaskOperTypeEnum;
import com.rtmap.apistore.interfaces.taskland.enums.TaskPriorityEnum;
import com.rtmap.apistore.interfaces.taskland.enums.TaskRemindModeEnum;
import com.rtmap.apistore.interfaces.taskland.enums.TaskRemindTypeEnum;
import com.rtmap.apistore.interfaces.taskland.enums.TaskStatusEnum;
import com.rtmap.apistore.interfaces.taskland.service.TaskOperService;
import com.rtmap.apistore.util.IDGenerator;

@Service
public class TaskOperServiceImpl implements TaskOperService {
	private final static Logger logger = LoggerFactory.getLogger(TaskOperServiceImpl.class);

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
	private TaskRemindDao taskRemindDao;
	@Autowired
	private TaskAttachFileDao taskAttachFileDao;
	@Autowired
	private TaskParticipantDao taskParticipantDao;

	public String addTask(TaskInfoBean taskInfoBean, String userId) {
		return addTask(TasklandConstant.TASK_PID_ROOT, taskInfoBean, userId);
	}

	@Override
	public String addTask(String taskPid, TaskInfoBean taskInfoBean, String userId) {
		Assert.notNull(taskInfoBean.getTaskType(), "taskinfo.taskType is null");
		String taskId = IDGenerator.getId();
		taskInfoBean.setTaskId(taskId);
		taskInfoBean.setTaskPid(taskPid);
		taskInfoBean.setCreator(userId);
		taskInfoBean.setRemindMode(this.correctRemindMode(taskInfoBean.getRemindMember()));
		taskInfoBean.setTaskPriority(this.correctTaskPriority(taskInfoBean.getTaskPriority()));
		taskInfoBean.setTaskStatus(this.correctTaskStatus(taskInfoBean.getTaskStatus(), taskInfoBean.getBeginDate()));
		logger.trace("创建任务{}", taskInfoBean.toString());
		this.taskInfoDao.insert(taskInfoBean);
		logger.trace("添加任务流转记录，TaskId:{},Assigner:{},Handler:{}",
				new Object[] { taskId, userId, taskInfoBean.getTaskHandler() });
		this.addAssignTaskFlow(taskId, taskInfoBean.getTaskHandler(), null, userId, true);
		this.insertOperateLog(taskId,
				taskPid.equals(TasklandConstant.TASK_PID_ROOT) ? TaskOperTypeEnum.CREATE : TaskOperTypeEnum.CREATE_SUB,
				taskInfoBean.getCreator());
		return taskId;
	}

	@Override
	public boolean delTask(String taskPid, String taskId, String userId) {
		logger.trace("删除任务,taskId:{}", taskId);
		boolean isSuccess = this.taskInfoDao.deleteByPrimaryKey(taskId) == 1;
		if (isSuccess) {
			this.insertOperateLog(taskId, taskPid.equals(TasklandConstant.TASK_PID_ROOT) ? TaskOperTypeEnum.DELETE
					: TaskOperTypeEnum.DELETE_SUB, userId);
		} else {
			logger.error("删除任务失败！任务编码[{}]不存在！", taskId);
			throw new BaseRuntimeException("任务编码[" + taskId + "]不存在！");
		}
		return isSuccess;
	}

	@Override
	public boolean delTask(String taskId, String userId) {
		return delTask(TasklandConstant.TASK_PID_ROOT, taskId, userId);
	}

	@Override
	public boolean markCancel(String taskId, String comment, String userId) {
		return updateTaskStatus(taskId, userId, comment, TaskStatusEnum.CANCEL, TaskOperTypeEnum.CANCEL);
	}

	@Override
	public boolean markFinish(String taskId, String comment, String userId) {
		return updateTaskStatus(taskId, userId, comment, TaskStatusEnum.FINISH, TaskOperTypeEnum.FINISH);
	}

	@Override
	public boolean markRefuse(String taskId, String comment, String userId) {
		return updateTaskStatus(taskId, userId, comment, TaskStatusEnum.REFUSE, TaskOperTypeEnum.REFUSE);
	}

	@Override
	public boolean addFollow(String taskId, boolean isFollow, String userId) {
		boolean isSuccess = false;
		logger.trace("{}任务,taskId:{},{}", new Object[] { isFollow ? "关注" : "取消关注", taskId, userId });
		if (isFollow) {
			isSuccess = this.taskFollowDao.insert(taskId, userId) == 1;
		} else {
			isSuccess = this.taskFollowDao.delete(taskId, userId) == 1;
		}
		if (isSuccess) {
			this.insertOperateLog(taskId, isFollow ? TaskOperTypeEnum.FOLLOW : TaskOperTypeEnum.UNFOLLOW, taskId,
					userId);
		}
		return isSuccess;
	}

	@Override
	public boolean updateTask(TaskInfoBean taskInfoBean, String userId) {
		taskInfoBean.setModifier(userId);
		if (StringUtils.isNotEmpty(taskInfoBean.getRemindMode())) {
			taskInfoBean.setRemindMode(this.correctRemindMode(taskInfoBean.getRemindMode()));
		}
		boolean isSuccess = this.taskInfoDao.updateByPrimaryKeySelective(taskInfoBean) == 1;
		logger.trace("修改任务信息,taskId:{},{}", new Object[] { taskInfoBean.getTaskId(), taskInfoBean.toString() });
		if (isSuccess) {
			this.insertOperateLog(taskInfoBean.getTaskId(), TaskOperTypeEnum.MODIFY, userId);
		} else {
			logger.error("修改任务信息失败!任务编码:[{}]", taskInfoBean.getTaskId());
			throw new BaseRuntimeException("修改任务信息失败!任务编码:[" + taskInfoBean.getTaskId() + "]");
		}
		return isSuccess;
	}

	@Override
	public boolean addAssignTaskFlow(String taskId, String handler, String comment, String userId) {
		return addAssignTaskFlow(taskId, handler, comment, userId, false);
	}

	private boolean addAssignTaskFlow(String taskId, String handler, String comment, String userId, boolean isCreate) {
		TaskFlow taskFlow = new TaskFlow();
		taskFlow.setTaskId(taskId);
		taskFlow.setTaskHandler(handler);
		taskFlow.setFlowId(IDGenerator.getId());
		taskFlow.setTasAssigner(userId);
		logger.trace("任务指派,taskId:{},{}", new Object[] { taskId, handler });
		boolean isSuccess = this.taskFlowDao.insert(taskFlow) == 1;
		if (isSuccess) {
			if (StringUtils.isNotEmpty(comment)) {
				this.insertComment(taskId, userId, comment, TaskOperTypeEnum.ASSIGN, taskFlow.getFlowId());
			}
			if (!isCreate) {
				this.insertOperateLog(taskId, TaskOperTypeEnum.ASSIGN, userId + "->" + handler, userId);
			}
		}
		return isSuccess;
	}

	@Override
	public void addUrgeRemind(String taskId, String handler, String comment, String remindMode, String userId) {
		TaskRemind taskRemind = new TaskRemind();
		taskRemind.setTaskId(taskId);
		taskRemind.setRemindId(IDGenerator.getId());
		taskRemind.setRemindUser(handler);
		taskRemind.setRemindType(TaskRemindTypeEnum.URGE.getCode());
		taskRemind.setRemindCont(comment);
		taskRemind.setRemindMode(this.correctRemindMode(remindMode));
		taskRemind.setRemindUser(userId);
		logger.trace("添加任务催办,taskId:{},{}", new Object[] { taskId, comment });
		this.taskRemindDao.insert(taskRemind);
		this.insertOperateLog(taskId, TaskOperTypeEnum.URGE,
				StringUtils.abbreviate(comment, TasklandConstant.LOG_CONTENT_MAX_LENGTH), userId);
	}

	@Override
	public String addAttachFile(String taskId, String fileName, String filePath, String userId) {
		TaskAttachFile taskAttachFile = new TaskAttachFile();
		taskAttachFile.setAttachId(IDGenerator.getId());
		taskAttachFile.setAttachName(fileName);
		taskAttachFile.setAttachPath(filePath);
		taskAttachFile.setOperator(userId);
		taskAttachFile.setTaskId(taskId);
		this.taskAttachFileDao.insert(taskAttachFile);
		this.insertOperateLog(taskId, TaskOperTypeEnum.ADD_ATTACH, fileName, userId);
		return taskAttachFile.getAttachId();
	}

	@Override
	public void delAttachFile(String taskId, String attachId, String userId) {
		TaskAttachFile attachFile = this.taskAttachFileDao.selectByPrimaryKey(attachId);
		if (attachFile != null) {
			this.taskAttachFileDao.deleteByPrimaryKey(attachId);
			this.insertOperateLog(taskId, TaskOperTypeEnum.DEL_ATTACH, attachFile.getAttachName(), userId);
		}
	}

	@Override
	public String addTaskComment(String taskId, String comment, String userId) {
		String commentId = this.insertComment(taskId, userId, comment, TaskOperTypeEnum.VIEW);
		this.insertOperateLog(taskId, TaskOperTypeEnum.ADD_COMMENT,
				StringUtils.abbreviate(comment, TasklandConstant.LOG_CONTENT_MAX_LENGTH), userId);
		return commentId;

	}

	@Override
	public void delTaskComment(String taskId, String commentId, String userId) {
		this.taskCommentDao.deleteByPrimaryKey(commentId);
		TaskComment taskComment = this.taskCommentDao.selectByPrimaryKey(commentId);
		if (taskComment != null) {
			this.taskCommentDao.deleteByPrimaryKey(commentId);
			this.insertOperateLog(taskId, TaskOperTypeEnum.DEL_ATTACH,
					StringUtils.abbreviate(taskComment.getComments(), 100), userId);
		}
	}

	@Override
	public void addParticipant(String taskId, String participant, String userId) {
		TaskParticipant taskParticipant = new TaskParticipant();
		taskParticipant.setOperator(userId);
		taskParticipant.setParticipant(participant);
		taskParticipant.setTaskId(taskId);
		this.taskParticipantDao.insert(taskParticipant);
		this.insertOperateLog(taskId, TaskOperTypeEnum.ADD_PARTICIPANT, participant, userId);
	}

	@Override
	public void delParticipant(String taskId, String participant, String userId) {
		this.taskParticipantDao.delete(taskId, participant);
		this.insertOperateLog(taskId, TaskOperTypeEnum.DEL_PARTICIPANT, participant, userId);
	}

	private boolean updateTaskStatus(String taskId, String userId, String comment, TaskStatusEnum taskStatus,
			TaskOperTypeEnum logType) {
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskStatus(taskStatus.getCode());
		taskInfo.setTaskId(taskId);
		taskInfo.setModifier(userId);
		logger.trace("更新任务状态,taskId:{},{}:{}", new Object[] { taskId, taskStatus.getCode(), taskStatus.getDesc() });
		int count = this.taskInfoDao.updateByPrimaryKeySelective(taskInfo);
		if (count == 1) {
			this.insertComment(taskId, userId, comment, logType);
			this.insertOperateLog(taskId, logType, userId);
		} else {
			logger.error("更新任务状态[]失败！任务编码[{}]不存在！", taskStatus.getDesc(), taskId);
			throw new BaseRuntimeException("任务编码[" + taskId + "]不存在！");
		}
		return true;

	}

	private String insertComment(String taskId, String userId, String comment, TaskOperTypeEnum logType) {
		return insertComment(taskId, userId, comment, logType, null);
	}

	private String insertComment(String taskId, String userId, String comment, TaskOperTypeEnum logType,
			String flowId) {
		TaskComment taskComment = new TaskComment();
		taskComment.setTaskId(taskId);
		taskComment.setCommentId(IDGenerator.getId());
		taskComment.setComments(comment);
		taskComment.setReplier(userId);
		taskComment.setReplyType(logType.getCode());
		if (StringUtils.isNotEmpty(flowId)) {
			taskComment.setFlowId(flowId);
		}
		logger.trace("记录任务评论信息,taskId:{}", taskId);
		this.taskCommentDao.insert(taskComment);
		return taskComment.getCommentId();
	}

	private void insertOperateLog(String taskId, TaskOperTypeEnum operateType, String operator) {
		this.insertOperateLog(taskId, operateType, null, operator);
	}

	private void insertOperateLog(String taskId, TaskOperTypeEnum operateType, String operateCont, String operator) {
		TaskLog tasklog = new TaskLog();
		tasklog.setLogId(IDGenerator.getId());
		tasklog.setTaskId(taskId);
		tasklog.setOperateType(operateType.getCode());
		tasklog.setOperator(operator);
		if (StringUtils.isNotEmpty(operateCont)) {
			tasklog.setOperateCont(operateType.getDesc() + ":" + operateCont);
		}
		logger.trace("记录任务操作[{}]日志,LogId:{},TaskId:{},Content:{}",
				new Object[] { operateType.getDesc(), tasklog.getLogId(), taskId, operateCont });
		this.taskLogDao.insert(tasklog);
	}

	private String correctRemindMode(String remindMode) {
		String remindStr = TasklandConstant.DEFAULT_REMIND_MODE;
		if (StringUtils.isNotEmpty(remindMode)) {
			remindStr = StringUtils.leftPad(remindMode, TaskRemindModeEnum.values().length, "0");
		}
		return remindStr;
	}

	private Integer correctTaskPriority(Integer priority) {
		if (priority == null || priority == 0) {
			return TaskPriorityEnum.COMMON.getCode();
		}
		return priority;
	}

	private Integer correctTaskStatus(Integer status, Date beginDate) {
		if (status == null || status == 0) {
			if (beginDate != null && DateTime.now().isBefore(beginDate.getTime())) {
				return TaskStatusEnum.WAITING.getCode();
			} else {
				return TaskStatusEnum.PROCESSING.getCode();
			}
		} else {
			return status;
		}
	}
}
