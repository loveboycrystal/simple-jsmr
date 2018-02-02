package com.loveboy.sys.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.loveboy.commons.base.dao.MybatisBaseDao;
import com.loveboy.sys.user.form.query.SysUserVoForm;
import com.loveboy.sys.user.form.vo.SysUserInfoVo;
import com.loveboy.sys.user.form.vo.SysUserVo;

@Mapper
@Repository
public interface ISysUserInfoDaoMapper extends MybatisBaseDao {

	int addSysUserInfo(SysUserInfoVo sysUserInfoVo);

	int updateSysUserInfo(SysUserInfoVo sysUserInfoVo);

	List<SysUserVo> getSysUsers(SysUserVoForm sysUserVoForm);

	SysUserVo getSysUserById(Long id);

}
