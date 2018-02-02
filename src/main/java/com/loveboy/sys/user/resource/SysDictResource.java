package com.loveboy.sys.user.resource;


import javax.ws.rs.GET;
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
import com.loveboy.sys.user.form.query.SysDictForm;
import com.loveboy.sys.user.service.ISysDictService;

@Component
@Path("/yh/sysDict")
public class SysDictResource extends MybatisBaseResource{
	
	private static final Logger  log =  Logger.getLogger(SysDictResource.class);

	@Autowired
	private ISysDictService sysDictService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getByType")
	@ResourceLogInfo(moduleName="字典",description="根据类型获取字典信息",function=YHFunction.getDict)
	public ResultInfoVo getSysDictByType(@QueryParam("paramsJson") String paramsJson){
		ResultInfoVo rinfo = null;
		try {
			SysDictForm sysDictForm = (SysDictForm)json.parse(dataJson);
			rinfo = sysDictService.getSysDictByType(requestId, sysDictForm);
			
			return rinfo;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId,e);
		}
		
    }
	
}
