package com.loveboy.sys.log.service;

import com.loveboy.commons.base.form.vo.LogInfoVo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.sys.log.from.query.LogQueryForm;

public interface LogsService {

	public void requestSysLogs(LogInfoVo logs);

	public void responseSysLogs(LogInfoVo logs);

	public ResultInfoVo getSysLogsList(String requestId, LogQueryForm logForm)
			throws Exception;

	public ResultInfoVo selectLogs(String requestId, LogQueryForm logForm);
}
