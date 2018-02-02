package com.loveboy.commons.base.form.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.loveboy.commons.SysConstant;
import com.loveboy.commons.XCXConstant;
import com.loveboy.commons.XCXConstant.XCXError;
import com.loveboy.commons.util.ResponseUtil;

@XmlAccessorType(XmlAccessType.FIELD)
public class ResultInfoVo {
	/**
	 * @JsonIgnore springMVC不输出属性对�? transient jersey 不输出属性对�?
	 */

	public SimpleResultVo toSimpleResultVo() {
		SimpleResultVo sinf = new SimpleResultVo(this.getReqId());
		sinf.setResCode(this.getResCode());
		sinf.setResMsg(this.getResMsg());
		sinf.setLogErrorMsg(this.getLogErrorMsg());
		return sinf;
	}

	public void setResCodeSuccess() {
		this.setResCode(SysConstant.SUCCESSED);
		this.setResMsg("请求成功");
	}

	public void setResCodeFailed() {
		this.setResCode(SysConstant.FAILED);
	}

	private String reqId;

	@XmlTransient
	private String serId; // 服务器id,用于日志查询时定位具体哪台服务器

	private Object resCode;

	private String resMsg;

	@XmlTransient
	private String logErrorMsg;

	private ListDataVo data;

	// boss服务返回确定该对象是否放置在何种作用域（request,session,application�?
	@XmlTransient
	private String scope;

	@XmlTransient
	private String scopeName;

	public ResultInfoVo(String reqId) {
		this.reqId = reqId;
	}

	public ResultInfoVo() {
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public void setResCodeAndDesc(XCXConstant.XCXError error) {
		this.resCode = error.getCode();
		this.resMsg = error.getDesc();
	}
	public void setResCodeAndDesc(XCXConstant.XCXError error,Exception e) {
		this.resCode = error.getCode();
		this.resMsg = error.getDesc();
		this.logErrorMsg = ResponseUtil.getExceptionMsg(e);
	}

	public Object getResCode() {
		return resCode;
	}

	public void setResCode(Object resCode) {
		this.resCode = resCode;
	}

	public void setResCode(XCXError error) {
		this.resCode = error.getCode();
		this.resMsg = error.getDesc();
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public ListDataVo getData() {
		return data;
	}

	public void setData(ListDataVo data) {
		this.data = data;
	}

	/**
	 * 设置数据集合
	 * 
	 * @param data
	 *            为dao查询结果集合List、或者单个实体
	 */
	public void setFastDataOk(Object data) {
		ArrayList list = new ArrayList();
		list.add(data);
		ListDataVo listData = new ListDataVo(list);
		this.setData(listData);
		this.setResCodeSuccess();
	}

	public ResultInfoVo(String reqId, int resCode, String resMsg) {
		super();
		this.reqId = reqId;
		this.resCode = resCode;
		this.resMsg = resMsg;
	}

	public ResultInfoVo(String reqId, String serId) {
		super();
		this.reqId = reqId;
		this.serId = serId;
	}

	public String getSerId() {
		return serId;
	}

	public void setSerId(String serId) {
		this.serId = serId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getScopeName() {
		return scopeName;
	}

	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}

	public String getLogErrorMsg() {
		return logErrorMsg;
	}

	public void setLogErrorMsg(String logErrorMsg) {
		this.logErrorMsg = logErrorMsg;
	}

}
