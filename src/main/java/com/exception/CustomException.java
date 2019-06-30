package com.exception;

import java.util.List;

import com.model.ErrorMO;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<ErrorMO> list;

	public CustomException() {
		super();
	}

	public CustomException(List<ErrorMO> list) {
		super();
		this.list = list;
	}

	public List<ErrorMO> getList() {
		return list;
	}

	public void setList(List<ErrorMO> list) {
		this.list = list;
	}

}
