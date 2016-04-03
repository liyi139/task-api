package com.rtmap.apistore.taskland.entity;

import java.util.Date;

public class TaskComment {
    
    private String commentId;

    
    private String taskId;

    
    private String flowId;

    
    private Integer replyType;

    
    private String comments;

    
    private String replier;

    
    private Date replyTime;

    
    public String getCommentId() {
        return commentId;
    }

    
    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    
    public String getTaskId() {
        return taskId;
    }

    
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    
    public String getFlowId() {
        return flowId;
    }

    
    public void setFlowId(String flowId) {
        this.flowId = flowId == null ? null : flowId.trim();
    }

    
    public Integer getReplyType() {
        return replyType;
    }

    
    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    
    public String getComments() {
        return comments;
    }

    
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    
    public String getReplier() {
        return replier;
    }

    
    public void setReplier(String replier) {
        this.replier = replier == null ? null : replier.trim();
    }

    
    public Date getReplyTime() {
        return replyTime;
    }

    
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}