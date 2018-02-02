package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class BossURIException extends RestException{

	private static final long serialVersionUID = 741469949864240811L;

	public BossURIException(Exception e) {
		super(SysConstant.ValidErrorCode.boss_uri_error.getDescription(),e);
	}

	public String getErrorCode() {
		return SysConstant.ValidErrorCode.boss_uri_error.getCode();
	}

}
