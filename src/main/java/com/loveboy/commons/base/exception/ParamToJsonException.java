package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class ParamToJsonException extends RestException{

	private static final long serialVersionUID = 741469949864240811L;

	public ParamToJsonException(Exception e) {
		super(SysConstant.BossDbOpertorErrorCode.param_to_obj_error.getDescription(),e);
	}
	public ParamToJsonException() {
		super(SysConstant.BossDbOpertorErrorCode.param_to_obj_error.getDescription());
	}
	public String getErrorCode() {
		
		return SysConstant.BossDbOpertorErrorCode.param_to_obj_error.getCode();
	}

}
