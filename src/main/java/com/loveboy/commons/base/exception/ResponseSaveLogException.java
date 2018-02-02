package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class ResponseSaveLogException extends RestException{

	private static final long serialVersionUID = 74112349864240812L;

	public ResponseSaveLogException(Exception e) {
		super(SysConstant.BossDbOpertorErrorCode.resp_save_log_error.getDescription(),e);
	}

	public String getErrorCode() {
		return SysConstant.BossDbOpertorErrorCode.resp_save_log_error.getCode();
	}

}
