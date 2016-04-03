package com.rtmap.apistore.taskland.enums;

public enum LogOperateTypeEnum {
	VIEW(10, "查阅任务"), REPLY(11, "回复任务"), FOLLOW(12, "关注任务"), CREATE(20, "创建任务"), MODIFY(21, "修改任务"), DELETE(22,
			"删除任务"), ASSIGN(23, " 转派任务"), FINISH(31, "标记完成"), REFUSE(32, "拒绝任务"), CANCEL(33, "取消任务");

	LogOperateTypeEnum(int code, String desc) {
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
