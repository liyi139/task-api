package com.rtmap.apistore.interfaces.taskland.enums;

public enum TaskRemindTypeEnum {
	COMMON(1, "常规提醒"), URGE(2, "催办提醒"), OVERDUE(3, "超期提醒");
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

	private TaskRemindTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
