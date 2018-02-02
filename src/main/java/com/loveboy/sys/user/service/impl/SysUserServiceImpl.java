package com.loveboy.sys.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.loveboy.commons.XCXConstant;
import com.loveboy.commons.XCXConstant.XCXError;
import com.loveboy.commons.base.form.vo.ListDataVo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.service.impl.MybatisBaseServiceImpl;
import com.loveboy.commons.util.MD5Util;
import com.loveboy.sys.user.dao.ISysUserInfoDaoMapper;
import com.loveboy.sys.user.dao.IUserDaoMapper;
import com.loveboy.sys.user.form.query.SysUserVoForm;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;
import com.loveboy.sys.user.form.vo.SysUserVo;
import com.loveboy.sys.user.service.SysUserService;

@Service
public class SysUserServiceImpl extends MybatisBaseServiceImpl implements
		SysUserService {

	public final static String PWD = "111111";

	@Autowired
	private ISysUserInfoDaoMapper iSysUserInfoDaoMapper;

	@Autowired
	private IUserDaoMapper iUserDaoMapper;

	@Override
	public ResultInfoVo saveOrUpdateSysUserInfo(String requestId,
			SysUserVo sysUserVo) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		boolean updateFlag = true;
		Date now = new Date();
		//UserInfo loginInfo = null;
		SysUserLoginVo sysUserLoginVoTemp = iUserDaoMapper
				.selectSysUserLoginInfoByAccount(sysUserVo.getAccount());
		if (sysUserLoginVoTemp == null) {// 不存在帐号即可注册
			sysUserVo.setCreateTime(now);
			sysUserVo.setLastLoginTime(now);
			sysUserVo.setStatus(Integer
					.parseInt(XCXConstant.XCXStatus.status_enable.getCode()
							.toString()));// 正常状态
			sysUserVo.setUserFrom(99);// 99为系统用户
			sysUserVo.setPwd(MD5Util.toMd5(PWD));// 默认密码
			SysUserInfoVo infoVo = toSysUserInfoVo(sysUserVo);
			iSysUserInfoDaoMapper.addSysUserInfo(infoVo);
			sysUserVo.setUserInfoId(infoVo.getId());
			SysUserLoginVo loginVo = toSysUserLoginVo(sysUserVo);
			iUserDaoMapper.addSysUserLoginInfo(loginVo);
			log.info("新增用户成功,帐号为:" + sysUserVo.getAccount());
		} else {
			SysUserLoginVo loginVo = toSysUserLoginVo(sysUserVo);
			loginVo.setId(sysUserLoginVoTemp.getId());
			iUserDaoMapper.updateSysUserLoginInfo(loginVo);
			SysUserInfoVo infoVo = toSysUserInfoVo(sysUserVo);
			infoVo.setId(sysUserLoginVoTemp.getUserInfoId());
			iSysUserInfoDaoMapper.updateSysUserInfo(infoVo);
			log.info("更改用户成功,帐号为:" + sysUserVo.getAccount());
		}
		rinf.setResCodeSuccess();
		//rinf.setData(new ListDataVo<UserInfo>(loginInfo));
		return rinf;
	}

	@Override
	public ResultInfoVo selectSysUserInfo(String requestId,
			SysUserVoForm sysUserVoForm) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		try {
			Page<Object> page = PageHelper.startPage(sysUserVoForm
					.getPageParamVo().getPageNum(), sysUserVoForm
					.getPageParamVo().getPageSize());
			List<SysUserVo> list = iSysUserInfoDaoMapper
					.getSysUsers(sysUserVoForm);
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

	private SysUserInfoVo toSysUserInfoVo(SysUserVo sysUserVo) {
		SysUserInfoVo info = new SysUserInfoVo();
		info.setAddress(sysUserVo.getAddress());
		info.setCreateTime(sysUserVo.getCreateTime());
		info.setDepartId(sysUserVo.getDepartId());
		info.setName(sysUserVo.getName());
		info.setPhone(sysUserVo.getPhone());
		return info;
	}

	private SysUserLoginVo toSysUserLoginVo(SysUserVo sysUserVo) {
		SysUserLoginVo loginVo = new SysUserLoginVo();
		loginVo.setAccount(sysUserVo.getAccount());
		loginVo.setCreateTime(sysUserVo.getCreateTime());
		loginVo.setPwd(sysUserVo.getPwd());
		loginVo.setQqId(sysUserVo.getQqId());
		loginVo.setStatus(sysUserVo.getStatus());
		loginVo.setType(sysUserVo.getType());
		loginVo.setUserFrom(sysUserVo.getUserFrom());
		loginVo.setUserInfoId(sysUserVo.getUserInfoId());
		loginVo.setWbId(sysUserVo.getWbId());
		loginVo.setWxId(sysUserVo.getWxId());
		return loginVo;
	}

	@Override
	public ResultInfoVo getSysUserById(String requestId, SysUserVo sysUserVo) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		SysUserVo u = null;
		try {
			u = iSysUserInfoDaoMapper.getSysUserById(sysUserVo.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (u != null) {
			rinf.setResCodeSuccess();
			rinf.setData(new ListDataVo<SysUserVo>(u));
		} else {
			rinf.setResCodeAndDesc(XCXConstant.XCXError.data_not_found_error);
			log.info("没有找到相关用户信息");
		}
		return rinf;
	}

	@Override
	public ResultInfoVo resetPWD(String requestId, SysUserLoginVo sysUserLoginVo) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		sysUserLoginVo.setPwd(MD5Util.toMd5(PWD));// 默认密码
		iUserDaoMapper.updateSysUserLoginInfo(sysUserLoginVo);
		log.info("重置密码,id为:" + sysUserLoginVo.getId());
		rinf.setResCodeSuccess();
		return rinf;
	}

	@Override
	public ResultInfoVo modiPWD(String requestId, SysUserVoForm sysUserVoForm) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		if (sysUserVoForm.getNewPwd().equals(sysUserVoForm.getConfirmPwd())) {
			rinf.setResCodeAndDesc(XCXError.pwd_not_equal);
			log.info("输入两次密码不一致...");
			return rinf;
		}
		SysUserLoginVo sysUserLoginVoTemp = iUserDaoMapper
				.selectSysUserLoginInfoByAccount(sysUserVoForm.getAccount());
		if (sysUserLoginVoTemp == null
				|| !sysUserLoginVoTemp.getPwd().equals(
						MD5Util.toMd5(sysUserVoForm.getPwd()))) {
			rinf.setResCodeAndDesc(XCXError.oldpwd_not_equal);
			log.info("旧密码不匹配...");
			return rinf;

		}
		SysUserLoginVo sysUserLoginVo = new SysUserLoginVo();
		sysUserLoginVo.setId(sysUserLoginVoTemp.getId());
		sysUserLoginVo.setPwd(MD5Util.toMd5(sysUserVoForm.getNewPwd()));
		iUserDaoMapper.updateSysUserLoginInfo(sysUserLoginVo);
		log.info("修改用户密码,帐号为:" + sysUserVoForm.getAccount());
		rinf.setResCodeSuccess();
		return rinf;
	}
}
