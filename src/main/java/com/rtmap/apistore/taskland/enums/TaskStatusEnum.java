package com.rtmap.apistore.taskland.enums;

public enum TaskStatusEnum {
	WAITING(1, "未开始"), PROCESSING(2, "进行中"), FINISH(3, "已完成"), REFUSE(4, "已拒绝"), CANCEL(5, "已取消"), DELETE(6, "已删除");

	TaskStatusEnum(int code, String desc) {
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
