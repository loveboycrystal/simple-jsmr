package com.loveboy.commons.base.resource;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.loveboy.commons.base.service.MybatisBaseService;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;
import com.loveboy.sys.user.service.IUserService;

@Component
public class MybatisBaseResource {

	private static final Logger log = Logger
			.getLogger(MybatisBaseResource.class);

	/**
	 * resourceInterceptor AOP初始化相关请求所需
	 */
	public String requestId;
	
	public String dataJson;

	@Autowired
	public MybatisBaseService mybatisBaseService;

	
	@Autowired
	private IUserService iUserService;

	@Context
	public HttpServletRequest request;

	@Context
	public HttpServletResponse response;

	@Context
	public UriInfo uriInfo;

	public JSON json;

	
	public MybatisBaseResource() {
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	
	/**
	 * 用户登录表信息
	 * @return
	 */
	public SysUserLoginVo userLoginInfo(){
		return (SysUserLoginVo) request.getSession().getAttribute("loginUser");
	}
	
	/**
	 * 系统用户登录详情信息
	 * @return
	 */
	public SysUserInfoVo userMgrInfo(){
		return (SysUserInfoVo) request.getSession().getAttribute("loginUserInfo");
	}
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public UriInfo getUriInfo() {
		return uriInfo;
	}

	public Object getAttribute(String key) {
		Object object = request.getSession().getAttribute(key);
		if (object == null || "".equals(object))
			return null;
		return object;
	}

	public void setAttribute(String key, Object object) {
		if (object == null) {
			request.getSession().setAttribute(key, "");
			return;
		}
		if (!(object instanceof Serializable)) {
			throw new RuntimeException("对象没有序列化");
		}
		request.getSession().setAttribute(key, object);
	}

	public void removeAttribute(String key) {
		request.getSession().removeAttribute(key);
	}

	public String getDataJson() {
		return dataJson;
	}

	public void setDataJson(String dataJson) {
		this.dataJson = dataJson;
	}

	public JSON getJson() {
		return json;
	}

	public void setJson(JSON json) {
		this.json = json;
	}
	
	
}
