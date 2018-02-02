package com.loveboy.sys.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.loveboy.commons.base.dao.MybatisBaseDao;
import com.loveboy.sys.user.form.query.SysUserForm;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;

@Mapper
@Repository
public interface IUserDaoMapper extends MybatisBaseDao {
	@Select("SELECT * FROM SYS_USER_LOGIN WHERE PWD=#{pwd} AND ACCOUNT=#{account}")
	// ${userId}
	@Results({ @Result(id = true, property = "id", column = "ID"),
			@Result(property = "account", column = "ACCOUNT"),
			@Result(property = "wxId", column = "WX_ID"),
			@Result(property = "qqId", column = "QQ_ID"),
			@Result(property = "wbId", column = "WB_ID"),
			@Result(property = "pwd", column = "PWD"),
			@Result(property = "type", column = "TYPE"),
			@Result(property = "status", column = "STATUS"),
			@Result(property = "userFrom", column = "USER_FROM"),
			@Result(property = "createTime", column = "CREATE_TIME"),
			@Result(property = "lastLoginTime", column = "LAST_LOGIN_TIME"),
			@Result(property = "userInfoId", column = "USER_INFO_ID") })
	public SysUserLoginVo getLoginUser(@Param("pwd") String pwd,
			@Param("account") String account);

	@Select("SELECT * FROM SYS_USER_LOGIN WHERE 1=1 ORDER BY CREATE_TIME DESC")
	public List<SysUserLoginVo> getLoginUserList();

	@Update("update SYS_USER_LOGIN set LAST_LOGIN_TIME=NOW() WHERE ID=#{id}")
	public int updateLoginTime(@Param("id") Long id);

	/**
	 * 查询系统用户信息
	 * 
	 * @param sysUserForm
	 *            查询条件表单
	 * @return 返回用户列表集合
	 */
	public List<SysUserInfoVo> getSysUserInfoList(SysUserForm sysUserForm);

	/**
	 * 注解 和 xml配置组合方式
	 * 
	 * @param param
	 * @return
	 */
	public List<SysUserLoginVo> getUsersList(HashMap<String, Object> param);

	@Select("SELECT * FROM SYS_USER_INFO WHERE ID=#{id}")
	
	public SysUserInfoVo getSysUserInfoById(@Param("id") Long id);

	/**
	 * 插入用户登录数据
	 * 
	 * @return
	 */
	public int addSysUserLoginInfo(SysUserLoginVo sysUserLoginVo);

	public SysUserLoginVo selectSysUserLoginInfoByAccount(
			@Param("account") String account);

	public SysUserLoginVo selectSysUserLoginInfoByQQ(@Param("qq") String qq);

	public SysUserLoginVo selectSysUserLoginInfoByWX(@Param("wx") String wx);

	public SysUserLoginVo selectSysUserLoginInfoByWB(@Param("wb") String wb);

	public int updateSysUserLoginInfo(SysUserLoginVo sysUserLoginVo);
	
	@Select("SELECT * FROM SYS_USER_LOGIN WHERE USER_INFO_ID=#{id} AND USER_FROM=#{userFrom} AND TYPE=#{type}")
	public SysUserLoginVo getUserLoginVo(@Param("id")Long id, @Param("userFrom")int userFrom, @Param("type")int type);

}














