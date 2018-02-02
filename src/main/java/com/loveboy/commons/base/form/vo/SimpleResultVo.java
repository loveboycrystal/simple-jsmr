package com.loveboy.commons.base.form.vo;

import com.loveboy.commons.SysConstant;
import com.owlike.genson.annotation.JsonIgnore;

public class SimpleResultVo {
	
	/**
	 * @JsonIgnore springMVC不输出属性对�?
	 * transient jersey 不输出属性对�?
	 */
	private String reqId;
	
	private Object resCode;
	
	private String resMsg;

	private transient String logErrorMsg;
	
	public SimpleResultVo(){}
	public SimpleResultVo(String reqId) {
		super();
		this.reqId = reqId;
	}

	public Object getResCode() {
		return resCode;
	}

	public void setResCode(Object resCode) {
		this.resCode = resCode;
	}
	
	public void setResCodeSuccess() {
		this.resCode = SysConstant.SUCCESSED;
	}
	public void setResCodeFailed() {
		this.resCode = SysConstant.FAILED;
	}

	
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	@JsonIgnore
	public String getLogErrorMsg() {
		return logErrorMsg;
	}

	public void setLogErrorMsg(String logErrorMsg) {
		this.logErrorMsg = logErrorMsg;
	}
	
	
	
	
}
