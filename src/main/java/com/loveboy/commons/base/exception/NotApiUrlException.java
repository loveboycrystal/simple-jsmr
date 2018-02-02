package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class NotApiUrlException extends RestException{

	private static final long serialVersionUID = 741469949864240811L;

	public NotApiUrlException(Exception e) {
		super(SysConstant.ValidErrorCode.url_notfound.getDescription(),e);
	}
	public NotApiUrlException() {
		super(SysConstant.ValidErrorCode.url_notfound.getDescription());
	}
	public String getErrorCode() {
		
		return SysConstant.ValidErrorCode.url_notfound.getCode();
	}

}
