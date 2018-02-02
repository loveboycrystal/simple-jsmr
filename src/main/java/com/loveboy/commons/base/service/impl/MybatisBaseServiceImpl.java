package com.loveboy.commons.base.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.loveboy.commons.base.service.MybatisBaseService;

@Service("mybatisBaseService")
public class MybatisBaseServiceImpl implements MybatisBaseService{
	protected Log log = LogFactory.getLog(getClass());
	
	
	
	
	
	
	
	
	
	public  Page<?> startPage(int pageNum, int pageSize){
		
		Page<?> page =  PageHelper.startPage(pageNum, pageSize,true);
		
		return page;
	}
	
	public  Page<?> startPage(int pageNum, int pageSize, boolean count){
		Page<?> page =  PageHelper.startPage(pageNum, pageSize,count);
		return page;
	}
	
	
}
