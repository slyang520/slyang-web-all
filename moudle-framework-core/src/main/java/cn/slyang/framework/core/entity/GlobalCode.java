
package cn.slyang.framework.core.entity;

public enum GlobalCode {

	SUCCESS(200, "请求成功"),
	TOKEN_INVALID(101, "token失效"),
	USER_NOT_LOGIN(102, "用户没有登录"),
	AUTH_NOT_SUCCESS(103, "认证不通过"),
	SERVER_ERROR(500, "服务出现了意外的错误"),
	NOT_AUTHORITY(403, "当前没有权限");

	private int code;
	private String message;

	GlobalCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

}
