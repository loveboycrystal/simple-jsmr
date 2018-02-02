package com.loveboy.commons;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loveboy.commons.util.RedisDataSourceUtil;
import com.loveboy.commons.util.RequestUtil;
import com.loveboy.commons.util.SystemTool;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;
import com.loveboy.sys.user.service.IUserService;

@Service
public class SysInit {

	@Autowired
	private IUserService iUserService;


	public void initLoginSession(HttpSession session, SysUserLoginVo loginUser) {
		// 用户登录信息 sys_user_login
		session.setAttribute("loginUser", loginUser);
		// 用户详情信息 sys_user_info 管理用户信息
		if (loginUser.getType() == SysConstant.UserType.mgr_user.getValue()
				&& loginUser.getUserFrom() == SysConstant.UserFrom.sys
						.getValue()) {
			SysUserInfoVo sysUserInfo = iUserService.getSysUserInfoByLoginId(loginUser.getUserInfoId());
			session.setAttribute("loginUserInfo", sysUserInfo);
		}

	}

	/**
	 * 
	 * @param str json
	 * @return
	 */
	public String setXCXTokenIdUser(String str) {
		String token = RequestUtil.createTokenId();
		int lifeDays = Integer.parseInt(SystemTool.getSystemProp("tokenIdTimeout"));
		RedisDataSourceUtil.setex(token, lifeDays , str);
		return token;
	}

}
