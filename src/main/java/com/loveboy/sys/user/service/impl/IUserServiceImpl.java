package com.loveboy.sys.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.loveboy.commons.SysConstant;
import com.loveboy.commons.XCXConstant.XCXError;
import com.loveboy.commons.base.form.vo.ListDataVo;
import com.loveboy.commons.base.form.vo.PageParamVo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.service.impl.MybatisBaseServiceImpl;
import com.loveboy.commons.util.MD5Util;
import com.loveboy.sys.user.dao.IUserDaoMapper;
import com.loveboy.sys.user.form.query.SysUserForm;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;
import com.loveboy.sys.user.service.IUserService;

//import com.sun.tools.internal.jxc.apt.Const;

@Service("iUserService")
public class IUserServiceImpl extends MybatisBaseServiceImpl implements
		IUserService {

	@Autowired
	private IUserDaoMapper iUserDaoMapper;

	@Override
	public SysUserLoginVo getUserLoginVo(Long id, int userForm, int type) {
		return iUserDaoMapper.getUserLoginVo(id, userForm, type);
	}

	@Override
	public ResultInfoVo toLogin(String requestId, SysUserLoginVo sulvo) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		sulvo = iUserDaoMapper.getLoginUser(MD5Util.toMd5(sulvo.getPwd()),
				sulvo.getAccount());
		if (sulvo == null) {
			rinf.setResCode(SysConstant.BusinessErrorCode.login_error.getCode());
			rinf.setResMsg(SysConstant.BusinessErrorCode.login_error
					.getDescription());
		} else {
			ListDataVo<SysUserLoginVo> listDataVo = new ListDataVo<SysUserLoginVo>();
			listDataVo.setList(sulvo);
			rinf.setData(listDataVo);
			if (sulvo.getType().intValue() == SysConstant.UserType.mgr_user
					.getValue().intValue()) {
				rinf.setResCodeSuccess();
				rinf.setResMsg("login success");
			} else {
				rinf.setResCode(SysConstant.BusinessErrorCode.dont_mgr_user_error
						.getCode());
				rinf.setResMsg(SysConstant.BusinessErrorCode.dont_mgr_user_error
						.getDescription());
			}
			iUserDaoMapper.updateLoginTime(sulvo.getId());
		}

		return rinf;

	}

	@Override
	public ResultInfoVo getSysUserInfoList(String requestId,
			SysUserForm sysUserForm) {

		// 实例化返回的对象
		ResultInfoVo rinfo = new ResultInfoVo(requestId);
		try {
			// 获取分页参数
			PageParamVo pp = sysUserForm.getPageParamVo();

			// 进行分页
			Page<SysUserInfoVo> page = PageHelper.startPage(pp.getPageNum(),
					pp.getPageSize());
			List<SysUserInfoVo> sysUserInfoList = iUserDaoMapper
					.getSysUserInfoList(sysUserForm);

			// 返回查询的实体集合
			ListDataVo<ArrayList<SysUserInfoVo>> listData = new ListDataVo<ArrayList<SysUserInfoVo>>(
					(ArrayList<SysUserInfoVo>) sysUserInfoList);
			rinfo.setData(listData);

			System.out.println("共有用户信息条数：" + rinfo.getData().getTotalCount());

			rinfo.setResCodeSuccess();
			rinfo.setResMsg(" getSysUserInfoList success");
			return rinfo;
		} catch (Exception e) {
			rinfo.setResCodeAndDesc(XCXError.db_error);
			return rinfo;
		}
	}

	@Override
	public ResultInfoVo demoUsermapUnderscoreToCamelCase(String requestId,
			SysUserLoginVo sulvo) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		List<SysUserLoginVo> loginUserList = iUserDaoMapper.getLoginUserList();
		ListDataVo<List<SysUserLoginVo>> listDataVo = new ListDataVo<List<SysUserLoginVo>>();
		listDataVo.setList(loginUserList);
		rinf.setData(listDataVo);
		rinf.setResCodeSuccess();
		return rinf;
	}

	@Override
	public ResultInfoVo demoUserMapper(String requestId, SysUserLoginVo sulvo) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("account", "andy");
		List<SysUserLoginVo> usersList = iUserDaoMapper.getUsersList(param);
		ListDataVo<List<SysUserLoginVo>> listDataVo = new ListDataVo<List<SysUserLoginVo>>();
		listDataVo.setList(usersList);
		rinf.setData(listDataVo);
		rinf.setResCodeSuccess();
		return rinf;
	}

	@Override
	public ResultInfoVo getSysUserInfoById(String requestId,
			SysUserInfoVo sysUserInfoVo) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		SysUserInfoVo sysUserInfo = iUserDaoMapper
				.getSysUserInfoById(sysUserInfoVo.getId());
		rinf.setFastDataOk(sysUserInfo);
		return rinf;
	}

	@Override
	public boolean addSysLoginInfo(String requestId,
			SysUserLoginVo sysUserLoginVo) {
		try {
			int tpm = iUserDaoMapper.addSysUserLoginInfo(sysUserLoginVo);
			return tpm == 1 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 系统内部间接口调用
	 */
	public SysUserInfoVo getSysUserInfoByLoginId(Long id) {
		return iUserDaoMapper.getSysUserInfoById(id);
	}

}
