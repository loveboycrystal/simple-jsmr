package com.loveboy.sys.user.form.query;

import java.util.Date;

import com.loveboy.commons.base.form.vo.PageParamVo;
import com.loveboy.sys.user.form.vo.SysUserVo;

public class SysUserVoForm extends SysUserVo {
	private PageParamVo pageParamVo;

	public PageParamVo getPageParamVo() {
		return pageParamVo;
	}

	public void setPageParamVo(PageParamVo pageParamVo) {
		this.pageParamVo = pageParamVo;
	}

	private Date startTime;

	private Date endTime;

	private String newPwd;
	private String confirmPwd;

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

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

}
