package com.loveboy.sys.log.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.loveboy.commons.base.form.vo.LogInfoVo;
import com.loveboy.sys.log.from.query.LogQueryForm;

@Mapper
@Repository
public interface LogsDaoMapper {

	@Insert("INSERT INTO SYS_PROXY_LOG_INFO (REQ_ID, REQ_URL, REQ_METHOD, REQ_PARAM, REQ_IP, REQ_DATE, DONE_STATUS, BUSINESS_ID, MODULE_NAME, DESCRIPTION,request_type) "
			+ "VALUES (#{reqId}, #{reqUrl}, #{reqMethod}, #{reqParam}, #{reqIp}, #{reqDate}, '00', #{businessId}, #{moduleName}, #{description}, #{requestType})")
	public void requestSysLogs(LogInfoVo logs);

	@Update("update SYS_PROXY_LOG_INFO set DONE_STATUS=#{doneStatus},RESP_DATE=NOW(),RESP_DATA=#{respData},ERR_MSG=#{errMsg},USER_ID=#{userId}  WHERE REQ_ID=#{reqId}")
	public void responseSysLogs(LogInfoVo logs);

	public List<LogInfoVo> getSysLogsList(LogQueryForm logForm);

	/*@Insert("INSERT INTO yh_user_info_ext (yh_user_info_id) values(#{id})")
	public void saveTest(UserInfo u);*/

	public List<LogInfoVo> selectLogs(LogInfoVo log);
}
