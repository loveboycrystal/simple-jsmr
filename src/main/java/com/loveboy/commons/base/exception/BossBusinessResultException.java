package com.loveboy.commons.base.exception;



public class BossBusinessResultException extends RestException{
	
	private static final long serialVersionUID = 741469949864240811L;

	private String code;
	
	private String descript;

	public BossBusinessResultException(String descript, String code) {
		super(descript);
		this.code = code;
	}

	public String getErrorCode() {
		return this.code;
	}

}
