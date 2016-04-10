package com.rtmap.apistore.interfaces.taskland.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.google.common.collect.Lists;
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
import com.rtmap.apistore.interfaces.taskland.entity.TaskFollow;
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

	@Override
	public TaskInfoBean addTask(TaskInfoBean taskInfoBean, String userId) {
		return addTask(TasklandConstant.TASK_PID_ROOT, taskInfoBean, userId);
	}

	@Override
	public TaskInfoBean addTask(String taskPid, TaskInfoBean taskInfoBean, String userId) {
		Assert.notNull(taskInfoBean.getTaskType(), "taskinfo.taskType is null");
		String taskId = IDGenerator.getId();
		taskInfoBean.setTaskId(taskId);
		taskInfoBean.setTaskPid(taskPid);
		taskInfoBean.setCreator(userId);
		taskInfoBean.setRemindMode(this.correctRemindMode(taskInfoBean.getRemindMember()));
		if (taskInfoBean.getBeginDate() == null) {
			taskInfoBean.setBeginDate(DateTime.now().toDate());
		}
		if (taskInfoBean.getRemindMember() == null) {
			taskInfoBean.setRemindMember(TasklandConstant.DEFAULT_REMIND_MEMBER);
		}
		taskInfoBean.setTaskPriority(this.correctTaskPriority(taskInfoBean.getTaskPriority()));
		taskInfoBean.setTaskStatus(this.correctTaskStatus(taskInfoBean.getTaskStatus(), taskInfoBean.getBeginDate()));
		logger.trace("创建任务{}", taskInfoBean.toString());
		this.taskInfoDao.insertTask(taskInfoBean);
		logger.trace("添加任务流转记录，TaskId:{},Assigner:{},Handler:{}",
				new Object[] { taskId, userId, taskInfoBean.getTaskHandler() });
		this.addAssignTaskFlow(taskId, taskInfoBean.getTaskHandler(), null, userId, true);
		List<TaskLog> logList = Lists.newArrayList();
		if (!taskPid.equals(TasklandConstant.TASK_PID_ROOT)) {
			logList.add(this.fillOperateLog(taskPid, TaskOperTypeEnum.CREATE_SUB, taskInfoBean.getTaskName(),
					taskInfoBean.getCreator()));
		}
		logList.add(this.fillOperateLog(taskId, TaskOperTypeEnum.CREATE, taskInfoBean.getTaskName(),
				taskInfoBean.getCreator()));
		this.taskLogDao.insertBatch(logList);
		return taskInfoBean;
	}

	@Override
	public void delTask(String taskPid, String[] taskIds, String userId) {
		logger.trace("删除任务,taskId:{}", StringUtils.join(taskIds, ","));
		List<Map<String, String>> list = this.taskInfoDao.selectIdNamesByIds(taskIds);
		this.taskInfoDao.deleteByTaskIds(taskIds);
		if (CollectionUtils.isNotEmpty(list)) {
			List<TaskLog> logList = Lists.newArrayList();
			for (Map<String, String> map : list) {
				if (!taskPid.equals(TasklandConstant.TASK_PID_ROOT)) {
					logList.add(this.fillOperateLog(taskPid, TaskOperTypeEnum.DELETE_SUB, map.get("NAME"), userId));
				}
				logList.add(this.fillOperateLog(map.get("ID"), TaskOperTypeEnum.DELETE, map.get("NAME"), userId));
			}
			this.taskLogDao.insertBatch(logList);
		}
	}

	@Override
	public void delTask(String taskId, String userId) {
		delTask(TasklandConstant.TASK_PID_ROOT, new String[] { taskId }, userId);
	}

	@Override
	public void markCancel(String taskId, String comment, String userId) {
		updateTaskStatus(taskId, userId, comment, TaskStatusEnum.CANCEL, TaskOperTypeEnum.CANCEL);
	}

	@Override
	public void markFinish(String taskId, String comment, String userId) {
		updateTaskStatus(taskId, userId, comment, TaskStatusEnum.FINISH, TaskOperTypeEnum.FINISH);
	}

	@Override
	public void markRefuse(String taskId, String comment, String userId) {
		updateTaskStatus(taskId, userId, comment, TaskStatusEnum.REFUSE, TaskOperTypeEnum.REFUSE);
	}

	@Override
	public TaskFollow addFollow(String taskId, boolean isFollow, String userId) {
		logger.trace("{}任务,taskId:{},{}", new Object[] { isFollow ? "关注" : "取消关注", taskId, userId });
		TaskFollow taskFollow = null;
		if (isFollow) {
			taskFollow = new TaskFollow(taskId, userId);
			this.taskFollowDao.insert(taskFollow);
		} else {
			this.taskFollowDao.deleteByFollow(taskId, userId);
		}
		this.taskLogDao.insert(this.fillOperateLog(taskId,
				isFollow ? TaskOperTypeEnum.FOLLOW : TaskOperTypeEnum.UNFOLLOW, userId, userId));
		return taskFollow;
	}

	@Override
	public TaskInfoBean updateTask(TaskInfoBean taskInfoBean, String userId) {
		taskInfoBean.setModifier(userId);
		if (StringUtils.isNotEmpty(taskInfoBean.getRemindMode())) {
			taskInfoBean.setRemindMode(this.correctRemindMode(taskInfoBean.getRemindMode()));
		}
		this.taskInfoDao.updateTask(taskInfoBean);
		logger.trace("修改任务信息,taskId:{},{}", new Object[] { taskInfoBean.getTaskId(), taskInfoBean.toString() });
		this.taskLogDao.insert(this.fillOperateLog(taskInfoBean.getTaskId(), TaskOperTypeEnum.MODIFY, "", userId));
		return this.taskInfoDao.selectByTaskId(taskInfoBean.getTaskId());
	}

	@Override
	public TaskFlow addAssignTaskFlow(String taskId, String handler, String comment, String userId) {
		return addAssignTaskFlow(taskId, handler, comment, userId, false);
	}

	private TaskFlow addAssignTaskFlow(String taskId, String handler, String comment, String userId, boolean isCreate) {
		TaskFlow taskFlow = new TaskFlow();
		taskFlow.setTaskId(taskId);
		taskFlow.setTaskHandler(handler);
		taskFlow.setFlowId(IDGenerator.getId());
		taskFlow.setTasAssigner(userId);
		logger.trace("任务指派,taskId:{},{}", new Object[] { taskId, handler });
		this.taskFlowDao.insert(taskFlow);
		if (StringUtils.isNotEmpty(comment)) {
			this.insertComment(taskId, userId, comment, TaskOperTypeEnum.ASSIGN, taskFlow.getFlowId());
		}
		if (!isCreate) {
			this.taskLogDao
					.insert(this.fillOperateLog(taskId, TaskOperTypeEnum.ASSIGN, userId + " 指派给 " + handler, userId));
		}
		return taskFlow;
	}

	@Override
	public TaskRemind addUrgeRemind(String taskId, String handler, String comment, String remindMode, String userId) {
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
		this.taskLogDao.insert(this.fillOperateLog(taskId, TaskOperTypeEnum.URGE,
				StringUtils.abbreviate(comment, TasklandConstant.LOG_CONTENT_MAX_LENGTH), userId));
		return taskRemind;
	}

	@Override
	public TaskAttachFile addAttachFile(String taskId, String fileName, String filePath, String userId) {
		TaskAttachFile taskAttachFile = new TaskAttachFile();
		taskAttachFile.setAttachId(IDGenerator.getId());
		taskAttachFile.setAttachName(fileName);
		taskAttachFile.setAttachPath(filePath);
		taskAttachFile.setOperator(userId);
		taskAttachFile.setTaskId(taskId);
		this.taskAttachFileDao.insert(taskAttachFile);
		this.taskLogDao.insert(this.fillOperateLog(taskId, TaskOperTypeEnum.ADD_ATTACH, fileName, userId));
		return taskAttachFile;
	}

	@Override
	public void delAttachFile(String taskId, String[] attachIds, String userId) {
		List<Map<String, String>> list = this.taskAttachFileDao.selectIdNamesByIds(attachIds);
		this.taskAttachFileDao.deleteByAttachIds(attachIds);
		for (Map<String, String> map : list) {
			this.taskLogDao.insert(this.fillOperateLog(taskId, TaskOperTypeEnum.DEL_ATTACH, map.get("NAME"), userId));
		}
	}

	@Override
	public TaskComment addTaskComment(String taskId, String comment, String userId) {
		TaskComment taskComment = this.insertComment(taskId, userId, comment, TaskOperTypeEnum.VIEW);
		this.taskLogDao.insert(this.fillOperateLog(taskId, TaskOperTypeEnum.ADD_COMMENT,
				StringUtils.abbreviate(comment, TasklandConstant.LOG_CONTENT_MAX_LENGTH), userId));
		return taskComment;

	}

	@Override
	public void delTaskComment(String taskId, String[] commentIds, String userId) {
		List<Map<String, String>> list = this.taskCommentDao.selectIdNamesByIds(commentIds);
		this.taskCommentDao.deleteByCommentIds(commentIds);
		for (Map<String, String> map : list) {
			this.taskLogDao.insert(this.fillOperateLog(taskId, TaskOperTypeEnum.DEL_COMMENT,
					StringUtils.abbreviate(map.get("NAME"), TasklandConstant.LOG_CONTENT_MAX_LENGTH), userId));
		}
	}

	@Override
	public TaskParticipant addParticipant(String taskId, String participant, String userId) {
		TaskParticipant taskParticipant = new TaskParticipant();
		taskParticipant.setOperator(userId);
		taskParticipant.setParticipant(participant);
		taskParticipant.setTaskId(taskId);
		this.taskParticipantDao.insert(taskParticipant);
		this.taskLogDao.insert(this.fillOperateLog(taskId, TaskOperTypeEnum.ADD_PARTICIPANT, participant, userId));
		return taskParticipant;
	}

	@Override
	public void delParticipant(String taskId, String[] participants, String userId) {
		this.taskParticipantDao.deleteByParticipant(taskId, participants);
		this.taskLogDao.insert(this.fillOperateLog(taskId, TaskOperTypeEnum.DEL_PARTICIPANT,
				StringUtils.join(participants, ","), userId));
	}

	private void updateTaskStatus(String taskId, String userId, String comment, TaskStatusEnum taskStatus,
			TaskOperTypeEnum logType) {
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskStatus(taskStatus.getCode());
		taskInfo.setTaskId(taskId);
		taskInfo.setModifier(userId);
		logger.trace("更新任务状态,taskId:{},{}:{}", new Object[] { taskId, taskStatus.getCode(), taskStatus.getDesc() });
		this.taskInfoDao.updateTask(taskInfo);
		this.insertComment(taskId, userId, comment, logType);
		this.taskLogDao.insert(this.fillOperateLog(taskId, logType, "", userId));
	}

	private TaskComment insertComment(String taskId, String userId, String comment, TaskOperTypeEnum logType) {
		return insertComment(taskId, userId, comment, logType, null);
	}

	private TaskComment insertComment(String taskId, String userId, String comment, TaskOperTypeEnum logType,
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
		return taskComment;
	}

	private TaskLog fillOperateLog(String taskId, TaskOperTypeEnum operateType, String operateCont, String operator) {
		TaskLog tasklog = new TaskLog();
		tasklog.setLogId(IDGenerator.getId());
		tasklog.setTaskId(taskId);
		tasklog.setOperateType(operateType.getCode());
		tasklog.setOperator(operator);
		if (StringUtils.isNotEmpty(operateCont)) {
			tasklog.setOperateCont(operateType.getDesc() + ":" + operateCont);
		}
		return tasklog;
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
