package com.loveboy.commons.base.form.vo;

import java.util.Date;

public class LogInfoVo {
	private String reqId; //请求编号
	
	private String reqUrl; //请求url
	
	private String reqParam; //请求参数
	
	private Date reqDate; //请求时间
	
	private String reqIp;  //用户发起ip
	
	private Date respDate; //响应时间
	
	private String respData; //响应数据
	
	private String doneStatus; //处理状态 返回码  00 已受理
	
	private  String errMsg;
	
	private String reqMethod;
	
	private int requestType; // 0  用户操作  ;1 Mgr 后台操作
	
	private String businessId;
	
	private String moduleName;
	
	private String description;
	
	private Long userId;
	
	private String name="";
	
	private String nickname="";

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}


	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	
	public String getRespData() {
		return respData;
	}

	public void setRespData(String respData) {
		this.respData = respData;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public Date getRespDate() {
		return respDate;
	}

	public void setRespDate(Date respDate) {
		this.respDate = respDate;
	}

	
	

	public String getDoneStatus() {
		return doneStatus;
	}

	public void setDoneStatus(String doneStatus) {
		this.doneStatus = doneStatus;
	}

	public String getReqParam() {
		return reqParam;
	}

	public void setReqParam(String reqParam) {
		this.reqParam = reqParam;
	}

	public String getReqMethod() {
		return reqMethod;
	}

	public void setReqMethod(String reqMethod) {
		this.reqMethod = reqMethod;
	}

	

	
	
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getReqIp() {
		return reqIp;
	}

	public void setReqIp(String reqIp) {
		this.reqIp = reqIp;
	}

	public int getRequestType() {
		return requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
	
	
	
}
