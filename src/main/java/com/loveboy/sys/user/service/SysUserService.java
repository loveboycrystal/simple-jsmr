package com.loveboy.sys.user.service;

import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.service.MybatisBaseService;
import com.loveboy.sys.user.form.query.SysUserVoForm;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;
import com.loveboy.sys.user.form.vo.SysUserVo;

public interface SysUserService extends MybatisBaseService {

	public ResultInfoVo saveOrUpdateSysUserInfo(String requestId,
			SysUserVo sysUserVo);

	public ResultInfoVo selectSysUserInfo(String requestId,
			SysUserVoForm sysUserVoForm);

	public ResultInfoVo getSysUserById(String requestId, SysUserVo sysUserVo);

	public ResultInfoVo resetPWD(String requestId, SysUserLoginVo sysUserLoginVo);

	public ResultInfoVo modiPWD(String requestId, SysUserVoForm sysUserVoForm);
}
