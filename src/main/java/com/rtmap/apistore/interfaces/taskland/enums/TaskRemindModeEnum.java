package com.rtmap.apistore.interfaces.taskland.enums;

public enum TaskRemindModeEnum {
	SMS(100, "短信提醒"), EMAIL(10, "邮件提醒"), PAGE(1, "邮件提醒");
	TaskRemindModeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

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

	private int code;

	private String desc;

}
