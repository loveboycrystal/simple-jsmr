package com.loveboy.sys.user.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.loveboy.commons.base.dao.MybatisBaseDao;
import com.loveboy.sys.user.form.vo.SysDictVo;

@Mapper
@Repository
public interface ISysDictDaoMapper extends MybatisBaseDao{
	 /**
	  * 根据类型获取字典
	  * @param param
	  * @return
	  */
	 public ArrayList<SysDictVo> getSysDictByType(String type);
	
}
