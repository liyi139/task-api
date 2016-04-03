package com.rtmap.apistore.taskland.entity;

import java.util.Date;

public class TaskFollow {
    
    private String taskId;

    
    private String follower;

    
    private Date followTime;

    
    public String getTaskId() {
        return taskId;
    }

    
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    
    public String getFollower() {
        return follower;
    }

    
    public void setFollower(String follower) {
        this.follower = follower == null ? null : follower.trim();
    }

    
    public Date getFollowTime() {
        return followTime;
    }

    
    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
}