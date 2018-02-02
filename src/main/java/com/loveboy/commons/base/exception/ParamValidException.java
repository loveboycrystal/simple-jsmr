package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class ParamValidException extends RestException{

	private static final long serialVersionUID = 841469949864240812L;

	public ParamValidException() {
		super(SysConstant.ValidErrorCode.param_format_error.getDescription());
	}

	public String getErrorCode() {
		return SysConstant.ValidErrorCode.param_format_error.getCode();
	}

}
