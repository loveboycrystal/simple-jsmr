package com.loveboy.sys.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loveboy.commons.SysConstant;
import com.loveboy.commons.base.form.vo.ListDataVo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.sys.user.dao.SysUserMybaitisDaoMapper;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;
import com.loveboy.sys.user.service.SysUserMybatisService;

@Service
public class SysUserMybatisServiceImpl implements SysUserMybatisService{
	
	@Autowired
	private SysUserMybaitisDaoMapper sysUserMybaitisDao;

	@Override
	public ResultInfoVo getSysUserInfoById(String requestId, Long userId) {
		ResultInfoVo rinfo = new ResultInfoVo(requestId);
		ListDataVo<SysUserInfoVo> listSysUser = new ListDataVo<SysUserInfoVo>();
		listSysUser.setList( sysUserMybaitisDao.getSysUserInfoById(userId));
		rinfo.setData(listSysUser);
		rinfo.setResCode(SysConstant.SUCCESSED);
		rinfo.setResMsg("query sysUserInfo success.");
		return rinfo;
	}

}
