package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class BossDoneException extends RestException{

	private static final long serialVersionUID = 741469949864240811L;

	public BossDoneException(Exception e) {
		super(SysConstant.ValidErrorCode.boss_done_error.getDescription(),e);
	}

	public String getErrorCode() {
		return SysConstant.ValidErrorCode.boss_done_error.getCode();
	}

}
