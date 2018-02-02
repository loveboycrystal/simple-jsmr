package com.loveboy.sys.user.service;

import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.service.MybatisBaseService;
import com.loveboy.sys.user.form.query.SysDictForm;

public interface ISysDictService extends MybatisBaseService{
	 /**
	  * 根据类型获取字典
	  * @param param
	  * @return
	  */
	 public ResultInfoVo getSysDictByType(String requestId,SysDictForm sysDictForm);
}
