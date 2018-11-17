package cn.slyang.framework.core.web;

import cn.slyang.framework.core.entity.GlobalCode;
import com.fasterxml.jackson.annotation.JsonInclude;

public class R {

	private int code;    // 全局code
	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Data data;

//	{
//		"code": 200,
//		"message": "请求成功"
//	}
	public static R ok() {
		return new R(GlobalCode.SUCCESS);
	}


//	{
//		"code": 200,
//		"message": "请求成功",
//		"data": {
//					"code": 0,
//					"data": {}
//				}
//	}
	public static R ok(Object data) {
		R r = new R(GlobalCode.SUCCESS);
		r.setData(new Data());
		r.getData().setData(data);
		return r;
	}


//	{
//		"code": 102,
//		"message": "用户没有登陆"
//	}
	public static R errorGlobal(GlobalCode globalCode) {
		return new R(globalCode);
	}

//	{
//		"code": 200,
//		"message": "请求成功",
//		"data": {
//					"code": 1,
//				  	"message": "用户账号余额不足"
//				}
//	}
	public static R errorBusiness(int code, String message) {
		R r = new R(GlobalCode.SUCCESS);
		r.setData(new Data());
		r.getData().setCode(code);
		r.getData().setMessage(message);
		return r;
	}

	public static R errorBusiness(int code, String message, Object data) {
		R r = new R(GlobalCode.SUCCESS);
		r.setData(new Data());
		r.getData().setCode(code);
		r.getData().setMessage(message);
		r.getData().setData(data);
		return r;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	private R(GlobalCode globalCode) {
		this.code = globalCode.getCode();
		this.message = globalCode.getMessage();
	}

	@Override
	public String toString() {
		return "R{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}

	private static class Data {
		private int code;   // 业务code
		private Object data;
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private String message;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "Data{" +
					"code=" + code +
					", data=" + data +
					", message='" + message + '\'' +
					'}';
		}
	}

}
