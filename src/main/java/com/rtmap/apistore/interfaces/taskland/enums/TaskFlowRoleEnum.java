package com.rtmap.apistore.interfaces.taskland.enums;

public enum TaskFlowRoleEnum {
	ORIGINATOR("发起人"), ASSIGNER("指派人"), HANDLER("处理人"), FOLLOWER("参与人");

	private String code;

	private String desc;

	private TaskFlowRoleEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private TaskFlowRoleEnum(String desc) {
		this.code = this.name();
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static TaskFlowRoleEnum getEnumByCode(String code) {
		return TaskFlowRoleEnum.valueOf(code.toUpperCase());
	}
}
