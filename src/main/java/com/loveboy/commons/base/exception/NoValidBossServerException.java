package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class NoValidBossServerException extends RestException{

	private static final long serialVersionUID = 741469949864240811L;

	public NoValidBossServerException() {
		super(SysConstant.ValidErrorCode.no_valid_server.getDescription());
	}

	public String getErrorCode() {
		return SysConstant.ValidErrorCode.no_valid_server.getCode();
	}

}
