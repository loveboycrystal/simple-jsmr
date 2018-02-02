package com.loveboy.sys.user.form.query;

import java.util.ArrayList;
import java.util.Date;

import com.loveboy.commons.base.form.vo.PageParamVo;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;

public class SysUserForm extends SysUserInfoVo{
	
	private static final long serialVersionUID = 1L;

	private ArrayList<SysUserInfoVo> sysUserVoList;
	
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

	public ArrayList<SysUserInfoVo> getSysUserVoList() {
		return sysUserVoList;
	}

	public void setSysUserVoList(ArrayList<SysUserInfoVo> sysUserVoList) {
		this.sysUserVoList = sysUserVoList;
	}
	
	
	
}
