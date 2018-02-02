package com.loveboy.sys.user.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.loveboy.commons.SysConstant;
import com.loveboy.commons.SysInit;
import com.loveboy.commons.YHFunction;
import com.loveboy.commons.annotation.CrossOrigin;
import com.loveboy.commons.annotation.ResourceLogInfo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.form.vo.SimpleResultVo;
import com.loveboy.commons.base.resource.MybatisBaseResource;
import com.loveboy.commons.util.ResponseUtil;
import com.loveboy.commons.util.SecretWordUtil;
import com.loveboy.sys.user.form.query.SysUserForm;
import com.loveboy.sys.user.form.query.SysUserVoForm;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;
import com.loveboy.sys.user.form.vo.SysUserVo;
import com.loveboy.sys.user.service.IUserService;
import com.loveboy.sys.user.service.SysUserService;

@Component
@Path("/yh/sysUser")
public class IUserRes extends MybatisBaseResource {

	private static final Logger log = Logger.getLogger(IUserRes.class);

	@Autowired
	private IUserService iUserService;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysInit sysInit;



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/toLogin")
	@ResourceLogInfo(moduleName = "系统用户模块", description = "登录系统", function = YHFunction.login)
	public SimpleResultVo toLogin(@QueryParam("paramsJson") String paramsJson) {
		SimpleResultVo srinfo = null;
		try {
			String decodeStr = SecretWordUtil.getDecodeStr(paramsJson);
			SysUserLoginVo sulvo =  json.parseObject(decodeStr,SysUserLoginVo.class);
			ResultInfoVo rinf = iUserService.toLogin(requestId, sulvo);
			srinfo = rinf.toSimpleResultVo();
			// if(String.valueOf(srinfo.getResCode() ).equals(
			// SysConstant.BusinessErrorCode.dont_mgr_user_error ) ||
			// SysConstant.isResultSuccess(srinfo.getResCode())){
			if (!String.valueOf(srinfo.getResCode()).equals(SysConstant.BusinessErrorCode.login_error.getCode())) {
				sysInit.initLoginSession(request.getSession(),(SysUserLoginVo) rinf.getData().getList());
			}

			return srinfo;
		} catch (Exception e) {
			return ResponseUtil.outSimpleErrorMessage(super.requestId, e);
		}

	}





	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/toLogout")
	@ResourceLogInfo(moduleName = "系统用户模块", description = "登出系统", function = YHFunction.logout)
	public SimpleResultVo toLogout() {
		SimpleResultVo rinfo = null;
		try {
			rinfo = new SimpleResultVo(requestId);
			rinfo.setResCodeSuccess();
			rinfo.setResMsg(request.getSession().getId() + " logout success");
			request.getSession().removeAttribute("loginUser");
			return rinfo;
		} catch (Exception e) {
			return ResponseUtil.outSimpleErrorMessage(super.requestId, e);
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getSysUserInfoList")
	@ResourceLogInfo(moduleName = "系统用户模块", description = "获取系统用户信息列表", function = YHFunction.none)
	public ResultInfoVo getSysUserInfoList(
			@QueryParam("paramsJson") String paramsJson) {
		ResultInfoVo rinfo = null;
		try {
			SysUserForm sysUserForm = JSON.parseObject(super.dataJson,
					SysUserForm.class);
			rinfo = iUserService.getSysUserInfoList(requestId, sysUserForm);
			return rinfo;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId, e);
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getSysUserInfo")
	@CrossOrigin("*")
	@ResourceLogInfo(moduleName = "系统用户模块", description = "获取系统用户信息", function = YHFunction.none)
	public ResultInfoVo getSysUserById(
			@QueryParam("paramsJson") String paramsJson) {
		ResultInfoVo rinfo = null;
		try {
			log.info(super.dataJson);
			SysUserInfoVo suinfo = JSON.parseObject(super.dataJson,
					SysUserInfoVo.class);
			rinfo = iUserService.getSysUserInfoById(requestId, suinfo);

			//
			// SysUserLoginVo sysUserLoginVo = new SysUserLoginVo();
			// sysUserLoginVo.setAccount("yx18675967476");
			// sysUserLoginVo.setUserFrom(SysConstant.UserFrom.yh.getValue());
			// sysUserLoginVo.setStatus(SysConstant.UserStatus.normal.getValue());
			// sysUserLoginVo.setType(SysConstant.UserType.brow_user.getValue());
			//
			// iUserService.addSysLoginInfo(requestId, sysUserLoginVo);
			//
			// log.info(sysUserLoginVo.getId());

			return rinfo;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId, e);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getSysUsers")
	@CrossOrigin("*")
	@ResourceLogInfo(moduleName = "系统用户模块", description = "获取系统用户信息", function = YHFunction.none)
	public ResultInfoVo getSysUsers(@QueryParam("paramsJson") String paramsJson) {
		try {
			log.info("begin getSysUsers");
			SysUserVoForm sysUserVoForm = JSON.parseObject(dataJson,
					SysUserVoForm.class);
			ResultInfoVo rv = sysUserService.selectSysUserInfo(requestId,
					sysUserVoForm);
			return rv;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId, e);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saveSysUser")
	@CrossOrigin("*")
	@ResourceLogInfo(moduleName = "系统用户模块", description = "保存系统用户信息", function = YHFunction.none)
	public ResultInfoVo saveSysUser(@QueryParam("paramsJson") String paramsJson) {
		try {
			log.info("begin saveSysUser");
			SysUserVo sysUserVo = JSON.parseObject(dataJson, SysUserVo.class);
			ResultInfoVo rv = sysUserService.saveOrUpdateSysUserInfo(requestId,
					sysUserVo);
			return rv;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId, e);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getSysUserVoById")
	@CrossOrigin("*")
	@ResourceLogInfo(moduleName = "系统用户模块", description = "系统用户信息", function = YHFunction.none)
	public ResultInfoVo getSysUserVoById(
			@QueryParam("paramsJson") String paramsJson) {
		try {
			log.info("begin getSysUserVoById");
			SysUserVo sysUserVo = JSON.parseObject(dataJson, SysUserVo.class);
			ResultInfoVo rv = sysUserService.getSysUserById(requestId,
					sysUserVo);
			return rv;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId, e);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/resetPwdMgr")
	@CrossOrigin("*")
	@ResourceLogInfo(moduleName = "系统用户模块", description = "系统用户信息", function = YHFunction.none)
	public ResultInfoVo resetPwd(@QueryParam("paramsJson") String paramsJson) {
		try {
			log.info("begin resetPwd");
			SysUserLoginVo sysUserLoginVo = JSON.parseObject(dataJson,
					SysUserLoginVo.class);
			ResultInfoVo rv = sysUserService
					.resetPWD(requestId, sysUserLoginVo);
			return rv;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId, e);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/modiPwdMgr")
	@CrossOrigin("*")
	@ResourceLogInfo(moduleName = "系统用户模块", description = "系统用户信息", function = YHFunction.none)
	public ResultInfoVo modiPwd(@QueryParam("paramsJson") String paramsJson) {
		try {
			log.info("begin modiPwd");
			SysUserVoForm sysUserVo = JSON.parseObject(dataJson,
					SysUserVoForm.class);
			ResultInfoVo rv = sysUserService.modiPWD(requestId, sysUserVo);
			return rv;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId, e);
		}
	}
}
