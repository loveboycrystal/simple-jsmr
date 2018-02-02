package com.loveboy.sys.user.service;

import com.loveboy.commons.base.form.vo.ResultInfoVo;

public interface SysUserMybatisService {
	/**
	 * 根据用户ID获取用户信息
	 * @param reqId
	 * @param userId
	 * @return
	 */
	public ResultInfoVo getSysUserInfoById(String requestId,Long userId) ;
}
