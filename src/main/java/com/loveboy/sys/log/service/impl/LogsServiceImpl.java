package com.loveboy.sys.log.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.loveboy.commons.XCXConstant;
import com.loveboy.commons.base.form.vo.ListDataVo;
import com.loveboy.commons.base.form.vo.LogInfoVo;
import com.loveboy.commons.base.form.vo.PageParamVo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.service.impl.MybatisBaseServiceImpl;
import com.loveboy.sys.log.dao.LogsDaoMapper;
import com.loveboy.sys.log.from.query.LogQueryForm;
import com.loveboy.sys.log.service.LogsService;

@Service
public class LogsServiceImpl extends MybatisBaseServiceImpl implements
		LogsService {

	@Autowired
	private LogsDaoMapper logsDaoMapper;

	@Override
	public void requestSysLogs(LogInfoVo logs) {
		try {
			logsDaoMapper.requestSysLogs(logs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void responseSysLogs(LogInfoVo logs) {
		logsDaoMapper.responseSysLogs(logs);
	}

	@Override
	public ResultInfoVo getSysLogsList(String requestId, LogQueryForm logForm) {
		// 实例化返回的对象
		ResultInfoVo rinfo = new ResultInfoVo(requestId);
		// 获取分页参数
		PageParamVo pp = logForm.getPageParamVo();
		// 进行分页
		Page<LogInfoVo> page = PageHelper.startPage(pp.getPageNum(),
				pp.getPageSize());
		ArrayList<LogInfoVo> sysLogsList = (ArrayList<LogInfoVo>) logsDaoMapper
				.getSysLogsList(logForm);
		// 返回查询的实体集合
		ListDataVo<ArrayList<LogInfoVo>> listData = new ListDataVo<ArrayList<LogInfoVo>>(
				(ArrayList<LogInfoVo>) sysLogsList);
		rinfo.setData(listData);
		rinfo.setResCodeSuccess();
		rinfo.setResMsg(" getSysLogsList success");
		return rinfo;
	}

	@Override
	public ResultInfoVo selectLogs(String requestId, LogQueryForm logInfoVoForm) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		log.info(requestId + "开始执行日志筛选...");
		try {
			Page<Object> page = PageHelper.startPage(logInfoVoForm
					.getPageParamVo().getPageNum(), logInfoVoForm
					.getPageParamVo().getPageSize());
			PageHelper.orderBy("REQ_DATE desc");
			List<LogInfoVo> list = logsDaoMapper.selectLogs(logInfoVoForm);
			ListDataVo vo = new ListDataVo(list);
			vo.setTotalCount(page.getTotal());
			rinf.setResCodeSuccess();
			rinf.setData(vo);
		} catch (Exception e) {
			e.printStackTrace();
			rinf.setResCodeAndDesc(XCXConstant.XCXError.db_error);
		}
		return rinf;
	}
}
