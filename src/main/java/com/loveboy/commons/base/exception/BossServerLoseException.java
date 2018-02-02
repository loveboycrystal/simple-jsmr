package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class BossServerLoseException extends RestException{

	private static final long serialVersionUID = 741469949864240811L;

	public BossServerLoseException(Exception e) {
		super(SysConstant.ValidErrorCode.boss_lose.getDescription(),e);
	}

	public String getErrorCode() {
		return SysConstant.ValidErrorCode.boss_lose.getCode();
	}

}
