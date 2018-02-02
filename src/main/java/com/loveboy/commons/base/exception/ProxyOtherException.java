package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class ProxyOtherException extends RestException{

	private static final long serialVersionUID = 741469949864240811L;

	public ProxyOtherException(Exception e) {
		super(SysConstant.ValidErrorCode.other_error.getDescription(),e);
	}

	public String getErrorCode() {
		return SysConstant.ValidErrorCode.other_error.getCode();
	}

}
