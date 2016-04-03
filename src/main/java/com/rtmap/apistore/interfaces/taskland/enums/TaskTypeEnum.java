package com.rtmap.apistore.interfaces.taskland.enums;

public enum TaskTypeEnum {
	WARN_TODO(1, "告警任务"), BUSI_GOAL_TODO(2, "业务目标"), MKT_TODO(3, "营销待办");
	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private TaskTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
