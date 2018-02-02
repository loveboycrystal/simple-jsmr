package com.loveboy.sys.user.resource;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loveboy.commons.YHFunction;
import com.loveboy.commons.annotation.ResourceLogInfo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.resource.MybatisBaseResource;
import com.loveboy.commons.util.ResponseUtil;
import com.loveboy.commons.util.SecretWordUtil;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;
import com.loveboy.sys.user.service.SysUserMybatisService;

@Component
@Path("/yh/mybatisUser")
public class MybatisSysUserResource extends MybatisBaseResource{
	
	//private static final Log  log = LogFactory.getLog(MybatisSysUserResource.class);
	
	private static final Logger  log =  Logger.getLogger(MybatisSysUserResource.class);
	
	@Autowired
	private  SysUserMybatisService sysUserMybatisService;
	
	
	@POST  
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getUserMgr")
	@ResourceLogInfo(moduleName="系统用户",description="根据ID获取用户信息",function=YHFunction.none)
	public ResultInfoVo getMybatisUser(@QueryParam("paramsJson") String paramsJson){
		log.debug(requestId);
		ResultInfoVo rinfo = null;
		try {
			SysUserInfoVo suser = (SysUserInfoVo) json.parse(dataJson);
			
			rinfo = sysUserMybatisService.getSysUserInfoById(requestId, suser.getId());
			
			return rinfo;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId,e);
		}
		
    }
	
	
	
}
