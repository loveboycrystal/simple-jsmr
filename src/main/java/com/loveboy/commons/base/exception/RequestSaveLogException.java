package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class RequestSaveLogException extends RestException{

	private static final long serialVersionUID = 741469949864240812L;

	public RequestSaveLogException(Exception e) {
		super(SysConstant.BossDbOpertorErrorCode.req_save_log_error.getDescription(),e);
	}
	
	public RequestSaveLogException() {
		super(SysConstant.BossDbOpertorErrorCode.req_save_log_error.getDescription());
	}

	public String getErrorCode() {
		return SysConstant.BossDbOpertorErrorCode.req_save_log_error.getCode();
	}

}
