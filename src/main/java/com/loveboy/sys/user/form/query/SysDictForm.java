package com.loveboy.sys.user.form.query;

import java.util.ArrayList;
import java.util.Date;

import com.loveboy.commons.base.form.vo.PageParamVo;
import com.loveboy.sys.user.form.vo.SysDictVo;

public class SysDictForm extends SysDictVo{
	
	private static final long serialVersionUID = 1L;

	private ArrayList<SysDictVo> sysDictVoList;
	
	private PageParamVo pageParamVo;
	
	private Date startDate;
	
	private Date endDate;
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public PageParamVo getPageParamVo() {
		return pageParamVo;
	}

	public void setPageParamVo(PageParamVo pageParamVo) {
		this.pageParamVo = pageParamVo;
	}

	public ArrayList<SysDictVo> getSysDictVoList() {
		return sysDictVoList;
	}

	public void setSysDictVoList(ArrayList<SysDictVo> sysDictVoList) {
		this.sysDictVoList = sysDictVoList;
	}

}
