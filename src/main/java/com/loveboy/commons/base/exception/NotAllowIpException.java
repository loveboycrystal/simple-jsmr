package com.loveboy.commons.base.exception;

import com.loveboy.commons.SysConstant;


public class NotAllowIpException extends RestException{

	private static final long serialVersionUID = 741469949864240812L;

	public NotAllowIpException(Exception e) {
		super(SysConstant.OperatorErrorCode.not_allow_ip.getDescription(),e);
	}
	
	public NotAllowIpException() {
		super(SysConstant.OperatorErrorCode.not_allow_ip.getDescription());
	}

	public String getErrorCode() {
		return SysConstant.OperatorErrorCode.not_allow_ip.getCode();
	}

}
