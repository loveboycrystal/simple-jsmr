package com.loveboy.sys.user.service;

import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.service.MybatisBaseService;
import com.loveboy.sys.user.form.query.SysUserForm;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;

public interface IUserService extends MybatisBaseService{
	/**
	 *  验证用户登录
	 * @param requestId  请求编号
	 * @param sulvo  用户信息
	 * @return ResultInfoVo
	 */
	public ResultInfoVo toLogin(String requestId,SysUserLoginVo sulvo);
	
	
	/**
	 * 获取系统用户信息列表
	 * @param requestId
	 * @param sysUserForm
	 * @return
	 */
	public ResultInfoVo getSysUserInfoList(String requestId,SysUserForm sysUserForm);
	
	
	/**
	 * demo样例
	 *  通过 mybatis/mapper/SysLoginUser.xml 配置方式完成数据查询
	 * @param requestId 请求编号
	 * @param sulvo 登录用户对象
	 * @return ResultInfoVo
	 */
	public ResultInfoVo demoUserMapper(String requestId,SysUserLoginVo sulvo);
	
	
	/**
	 * demo样例
	 * 	通过 驼峰式命名自动映射设置实现数据查询
	 *  table field：  user_id    java vo field: userId
	 * @param requestId
	 * @param sulvo
	 * @return
	 */
	public ResultInfoVo demoUsermapUnderscoreToCamelCase(String requestId,SysUserLoginVo sulvo);
	
	
	/**
	 * 以下用户系统内部之间调用
	 * @param id
	 * @return
	 */
	public SysUserInfoVo getSysUserInfoByLoginId(Long id);
	
	/**
	 * 根据用户信息id获取用户登录对象
	 * @param id  		   用户信息表id
	 * @param userFrom   用户来源 0 壹号课堂，1JSM幼小，99系统
	 * @param type       用户类型 0 业务用户， 98 运营用户只能查看，99超管用户
	 * @return 用户登录的对象
	 */
	public SysUserLoginVo getUserLoginVo(Long id,int userForm,int type);
	
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	public ResultInfoVo getSysUserInfoById(String requestId,SysUserInfoVo sysUserInfoVo);
	
	
	/**
	 * 同步一个登录用户
	 * 模块级别account随机参数一个
	 *   1. 壹号课堂  yh手机号码 
	 *   2. JSM幼小 yx手机号码
	 * @param requestId 请求编号
	 * @param sysUserLoginVo 登录用户对象
	 * @return true 同步成功，false 同步失败
	 */
	public boolean addSysLoginInfo(String requestId,SysUserLoginVo sysUserLoginVo);
	
	
}

