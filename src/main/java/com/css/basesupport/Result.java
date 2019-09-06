package com.css.basesupport;

import lombok.Data;

import java.io.Serializable;

/**
 *   接口返回数据格式
 */

@Data
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	private String resultDesc = "操作成功！";

	/** 服务器端500 */
	public static final String SC_INTERNAL_SERVER_ERROR_500 = "500";
	/**  返回成功状态码200 OK*/
	public static final String SC_OK_200 = "200";

	/**
	 * 返回代码
	 */
	private String resultCode = "200";
	
	/**
	 * 返回数据对象 data
	 */
	private T result;
	
	/**
	 * 时间戳
	 */
	private long timestamp = System.currentTimeMillis();

	public Result() {
		
	}

	public Result<T> error500(String message) {
		this.resultDesc = message;
		this.resultCode = SC_INTERNAL_SERVER_ERROR_500;
		this.success = false;
		return this;
	}
	
	public static <T>Result success() {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setResultCode(SC_OK_200);
		return r;
	}

	public static <T>Result success(String msg) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setResultCode(SC_OK_200);
		r.setResultDesc(msg);
		return r;
	}
	
	public static Result<Object> success(Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setResultCode(SC_OK_200);
		r.setResult(data);
		return r;
	}
	
	public static <T>Result error(String msg) {
		return error(SC_INTERNAL_SERVER_ERROR_500, msg);
	}
	
	public static <T>Result error(String code, String msg) {
		Result<T> r = new Result<T>();
		r.setResultCode(SC_INTERNAL_SERVER_ERROR_500);
		r.setResultDesc(msg);
		r.setSuccess(false);
		return r;
	}

}