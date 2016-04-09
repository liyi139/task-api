package com.rtmap.apistore.interfaces.taskland.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.rtmap.apistore.common.annotation.WebRepository;
import com.rtmap.apistore.core.web.page.PageList;
import com.rtmap.apistore.interfaces.taskland.bean.TaskInfoBean;
import com.rtmap.apistore.interfaces.taskland.entity.TaskInfo;

@WebRepository
public interface TaskInfoDao {

	int deleteByPrimaryKey(@Param(value = "taskId") String taskId);

	int insert(TaskInfo taskInfo);

	int updateByPrimaryKeySelective(TaskInfo taskInfo);

	int updateByPrimaryKey(TaskInfo taskInfo);

	TaskInfoBean selectByPrimaryKey(@Param(value = "taskId") String taskId);

	List<TaskInfoBean> selectByTaskPid(@Param(value = "taskId") String taskPid);

	PageList<TaskInfoBean> selectByCond();

	String selectUserRoleByTaskId(@Param(value = "taskId") String taskId,@Param(value = "userId") String userId);
}