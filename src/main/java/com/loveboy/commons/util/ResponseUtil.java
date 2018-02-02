package com.loveboy.commons.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.loveboy.commons.SysConstant;
import com.loveboy.commons.base.form.vo.LogInfoVo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.form.vo.SimpleResultVo;
import com.loveboy.sys.log.service.LogsService;

@Service
public class ResponseUtil {
	
	
	@Autowired
	private static LogsService logsService;

	
	private static final Logger  log =  Logger.getLogger(ResponseUtil.class);
	

	
	public  static ResultInfoVo outErrorMessage(String sessionId,Exception e)
	{
		String errMsg = ResponseUtil.getExceptionMsg(e);
		log.error("reqId:"+sessionId+"\t"+errMsg);
		ResultInfoVo rinfo = new ResultInfoVo(sessionId);
		rinfo.setResMsg("boss done failed");
		rinfo.setLogErrorMsg(errMsg);
		if(e instanceof  JSONException){
			rinfo.setResCode(SysConstant.BossDbOpertorErrorCode.param_to_obj_error.getCode());
			rinfo.setResMsg(SysConstant.BossDbOpertorErrorCode.param_to_obj_error.getDescription());
		}else{
			//e.printStackTrace();
			rinfo.setResCode(SysConstant.FAILED);
		}
		//更新用户操作失败日志
		LogInfoVo logVo = new LogInfoVo();
		logVo.setReqId(sessionId);
		logVo.setErrMsg(rinfo.getLogErrorMsg());
		logVo.setDoneStatus(String.valueOf(rinfo.getResCode()));
		return rinfo;
	}
	
	public  static SimpleResultVo outSimpleErrorMessage(String sessionId,Exception e)
	{
		String errMsg = ResponseUtil.getExceptionMsg(e);
		log.error("reqId:"+sessionId+"\t"+errMsg);
		SimpleResultVo srinfo = new SimpleResultVo(sessionId);
		srinfo.setResMsg("boss done failed");
		srinfo.setLogErrorMsg(errMsg);
		srinfo.setResCode(SysConstant.FAILED);
		//更新用户操作失败日志
		LogInfoVo logVo = new LogInfoVo();
		logVo.setReqId(sessionId);
		logVo.setRespData(JSON.toJSONString(srinfo));
		logVo.setErrMsg(srinfo.getLogErrorMsg());
		logVo.setDoneStatus(String.valueOf(srinfo.getResCode()));
		
		return srinfo;
	}
	
	 public static String getExceptionMsg(Exception e){
		 StringBuffer errMsg = new StringBuffer();
		 StackTraceElement ste =e.getStackTrace()[0];
		 errMsg.append(e.toString());
		 errMsg.append(" by class "+ste.getClassName()+"."+ste.getMethodName()+"()");
		 errMsg.append(" in err line number "+ste.getLineNumber());
//         System.out.println(ste.getClassName());
//         System.out.println(ste.getFileName());
//         System.out.println(ste.getLineNumber());
//         System.out.println(ste.getMethodName());
		 
		 
		 return errMsg.toString();
		 
	 }
}
