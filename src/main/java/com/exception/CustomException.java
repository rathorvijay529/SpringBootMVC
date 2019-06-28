package com.exception;

public class CustomException extends RuntimeException {

	private String errormsg;
	private Integer errorCode;

	public CustomException(String errormsg, Integer errorCode) {
		super();
		this.errormsg = errormsg;
		this.errorCode = errorCode;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	
}
