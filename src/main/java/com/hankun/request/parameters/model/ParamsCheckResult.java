package com.hankun.request.parameters.model;

/**
 * 
 * 检测状态的回执
 * 
 *  isSuccess   true 检测通过，false 检测失败
 *  message  检测失败时会返回具体的原因
 * 
 * @author Hankun
 *
 */
public class ParamsCheckResult {
	

	public ParamsCheckResult(boolean isSuccess, String message) {
		super();
		this.isSuccess = isSuccess;
		this.message = message;
	}

	private boolean isSuccess = false;

	private String message;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
