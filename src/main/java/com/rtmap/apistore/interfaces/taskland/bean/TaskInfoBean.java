package com.rtmap.apistore.interfaces.taskland.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.rtmap.apistore.interfaces.taskland.entity.TaskInfo;

public class TaskInfoBean extends TaskInfo {

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
