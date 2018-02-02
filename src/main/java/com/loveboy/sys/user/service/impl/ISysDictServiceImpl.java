package com.loveboy.sys.user.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.loveboy.commons.XCXConstant.XCXError;
import com.loveboy.commons.base.form.vo.ListDataVo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.service.impl.MybatisBaseServiceImpl;
import com.loveboy.sys.user.dao.ISysDictDaoMapper;
import com.loveboy.sys.user.form.query.SysDictForm;
import com.loveboy.sys.user.form.vo.SysDictVo;
import com.loveboy.sys.user.service.ISysDictService;

@Service
public class ISysDictServiceImpl extends MybatisBaseServiceImpl implements ISysDictService{
	
	@Autowired
	private ISysDictDaoMapper iSysDictDao;

	@Override
	public ResultInfoVo getSysDictByType(String requestId,SysDictForm sysDictForm) {
		ResultInfoVo rinf = new ResultInfoVo(requestId);
		String type = sysDictForm.getType();
		try{
			Page<Object> page =	PageHelper.startPage(sysDictForm.getPageParamVo()
					.getPageNum(), sysDictForm.getPageParamVo().getPageSize());
			
			ArrayList<SysDictVo> dictList = iSysDictDao.getSysDictByType(type);
			if(dictList!=null && dictList.size()>0){
				ListDataVo<ArrayList<SysDictVo>> listDataVo = new ListDataVo<ArrayList<SysDictVo>>(dictList);
				listDataVo.setTotalCount(page.getTotal());
				rinf.setData(listDataVo);
				rinf.setResCodeSuccess();
				rinf.setResMsg("query SysDictVo success");
			}else{
				rinf.setResCodeFailed();
				rinf.setResMsg("query SysDictVo error");
			}
			return rinf;
		}catch(Exception e){
			rinf.setResCodeAndDesc(XCXError.db_error);
			return rinf;
		}
	}
	

}
