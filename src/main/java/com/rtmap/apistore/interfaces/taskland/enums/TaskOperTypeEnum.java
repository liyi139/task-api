package com.rtmap.apistore.interfaces.taskland.enums;

public enum TaskOperTypeEnum {
	VIEW(11, "查阅任务"), FOLLOW(13, "关注任务"), UNFOLLOW(14, "取消关注"), URGE(15, "催办任务"), 
	CREATE(21,"创建任务"),  MODIFY(22, "修改任务"), DELETE(23, "删除任务"), 
	FINISH(31, "标记完成"), REFUSE(32, "拒绝任务"), CANCEL(33, "取消任务"),
	ASSIGN(41, "转派任务"),
	CREATE_SUB(51, "创建子任务"), DELETE_SUB(52,"删除子任务"),
	ADD_ATTACH(53,"添加附件"), DEL_ATTACH(54,"删除附件"),
	ADD_PARTICIPANT(55,"添加参与人"), DEL_PARTICIPANT(56,"删除参与人"),
	ADD_COMMENT(57,"添加评论"), DEL_COMMENT(58,"删除评论");
	

	TaskOperTypeEnum(int code, String desc) {
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
