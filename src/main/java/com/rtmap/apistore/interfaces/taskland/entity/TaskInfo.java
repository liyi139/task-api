package com.rtmap.apistore.interfaces.taskland.entity;

import java.util.Date;

import com.rtmap.apistore.core.base.entity.IEntity;

public class TaskInfo implements IEntity{
    
	private static final long serialVersionUID = 777934690298608941L;


	private String taskId;

    
    private String taskName;

    
    private String taskCont;

    
    private Integer taskStatus;

    
    private Integer taskType;

    
    private Integer taskPriority;

    
    private String taskRelate;

    
    private String taskRelateJson;

    
    private String taskPid;

    
    private Date beginDate;

    
    private Date deadline;

    
    private String remindMode;

    
    private String remindMember;

    
    private Integer remindExpireDays;

    
    private String creator;

    
    private Date createTime;

    
    private String modifier;

    
    private Date modifyTime;

    
    private Integer lft;

    
    private Integer rgt;

    
    public String getTaskId() {
        return taskId;
    }

    
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    
    public String getTaskName() {
        return taskName;
    }

    
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    
    public String getTaskCont() {
        return taskCont;
    }

    
    public void setTaskCont(String taskCont) {
        this.taskCont = taskCont == null ? null : taskCont.trim();
    }

    
    public Integer getTaskStatus() {
        return taskStatus;
    }

    
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    
    public Integer getTaskType() {
        return taskType;
    }

    
    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    
    public Integer getTaskPriority() {
        return taskPriority;
    }

    
    public void setTaskPriority(Integer taskPriority) {
        this.taskPriority = taskPriority;
    }

    
    public String getTaskRelate() {
        return taskRelate;
    }

    
    public void setTaskRelate(String taskRelate) {
        this.taskRelate = taskRelate == null ? null : taskRelate.trim();
    }

    
    public String getTaskRelateJson() {
        return taskRelateJson;
    }

    
    public void setTaskRelateJson(String taskRelateJson) {
        this.taskRelateJson = taskRelateJson == null ? null : taskRelateJson.trim();
    }

    
    public String getTaskPid() {
        return taskPid;
    }

    
    public void setTaskPid(String taskPid) {
        this.taskPid = taskPid == null ? null : taskPid.trim();
    }

    
    public Date getBeginDate() {
        return beginDate;
    }

    
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    
    public Date getDeadline() {
        return deadline;
    }

    
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    
    public String getRemindMode() {
        return remindMode;
    }

    
    public void setRemindMode(String remindMode) {
        this.remindMode = remindMode == null ? null : remindMode.trim();
    }

    
    public String getRemindMember() {
        return remindMember;
    }

    
    public void setRemindMember(String remindMember) {
        this.remindMember = remindMember == null ? null : remindMember.trim();
    }

    
    public Integer getRemindExpireDays() {
        return remindExpireDays;
    }

    
    public void setRemindExpireDays(Integer remindExpireDays) {
        this.remindExpireDays = remindExpireDays;
    }

    
    public String getCreator() {
        return creator;
    }

    
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    
    public Date getCreateTime() {
        return createTime;
    }

    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
    public String getModifier() {
        return modifier;
    }

    
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    
    public Date getModifyTime() {
        return modifyTime;
    }

    
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    
    public Integer getLft() {
        return lft;
    }

    
    public void setLft(Integer lft) {
        this.lft = lft;
    }

    
    public Integer getRgt() {
        return rgt;
    }

    
    public void setRgt(Integer rgt) {
        this.rgt = rgt;
    }
}