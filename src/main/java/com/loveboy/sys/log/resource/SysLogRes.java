package com.loveboy.sys.log.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.loveboy.commons.YHFunction;
import com.loveboy.commons.annotation.CrossOrigin;
import com.loveboy.commons.annotation.ResourceLogInfo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.resource.MybatisBaseResource;
import com.loveboy.commons.util.ResponseUtil;
import com.loveboy.sys.log.from.query.LogQueryForm;
import com.loveboy.sys.log.service.LogsService;

@Component
@Path("/sys/logs")
public class SysLogRes extends MybatisBaseResource {

	private static final Logger log = Logger.getLogger(SysLogRes.class);

	@Autowired
	private LogsService logsService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getSysLogsListMgr")
	@ResourceLogInfo(moduleName = "系统日志模块", description = "查询日志", function = YHFunction.none)
	public ResultInfoVo getSysLogsList(
			@QueryParam("paramsJson") String paramsJson) {
		ResultInfoVo rinfo = null;
		try {
			LogQueryForm logForm = (LogQueryForm) JSON.parseObject(
					super.dataJson, LogQueryForm.class);
			rinfo = logsService.getSysLogsList(requestId, logForm);
			return rinfo;
		} catch (Exception e) {
			return ResponseUtil.outErrorMessage(super.requestId, e);
		}

	}

	/**
	 * 筛选后台日志
	 * 
	 * 徐兆杰 2017年9月27日 下午3:58:46
	 */
	@CrossOrigin("*")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/selectLogs")
	@ResourceLogInfo(moduleName = "日志模块", description = "筛选日志", function = YHFunction.none)
	public ResultInfoVo selectLogs(@QueryParam("paramsJson") String paramsJson) {
		log.info("begin selectLogs");
		LogQueryForm logInfoVoForm = JSON.parseObject(dataJson,
				LogQueryForm.class);
		ResultInfoVo rv = logsService.selectLogs(requestId, logInfoVoForm);
		return rv;
	}
}
