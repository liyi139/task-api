package com.rtmap.apistore.interfaces.taskland.enums;

public enum TaskSortEnum {
	UPDATE_TIME(1, "按最近更新", "MODIFY_TIME"), PRIORITY(2, "按紧急程度", "TASK_PRIORITY"), EXPIRE_DATE(3, "按到期日期",
			"DEADLINE"), CREATE_DATE(4, "按创建日期", "CREATE_TIME"), TASK_TYPE(5, "按任务类别", "TASK_TYPE");

	TaskSortEnum(int code, String desc, String column) {
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

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	private String desc;
	private String column;
}
