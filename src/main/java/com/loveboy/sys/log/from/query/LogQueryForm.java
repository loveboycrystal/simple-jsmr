package com.loveboy.sys.log.from.query;

import java.util.Date;

import com.loveboy.commons.base.form.vo.LogInfoVo;
import com.loveboy.commons.base.form.vo.PageParamVo;

public class LogQueryForm extends LogInfoVo {

	private PageParamVo pageParamVo;
	
	private Date startTime;
	
	private Date endTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public PageParamVo getPageParamVo() {
		return pageParamVo;
	}

	public void setPageParamVo(PageParamVo pageParamVo) {
		this.pageParamVo = pageParamVo;
	}

	
	
	
}
