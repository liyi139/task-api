package com.rtmap.apistore.interfaces.taskland.enums;

public enum TaskPriorityEnum {
	COMMON(1, "正常"), URGENT(2, "紧急"), VERY_URGENT(3, "非常紧急");
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

	private TaskPriorityEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
