package com.loveboy.commons.base.exception;

public abstract class RestException extends Exception {
	private static final long serialVersionUID = 4579370021353668786L;
	
	public abstract String getErrorCode();
	
	
	public RestException(String message,Exception e)
	{
		super(message,e);
	}
	
	public RestException(String message)
	{
		super(message);
	}
	
	

}
