package com.loveboy.commons;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.loveboy.commons.util.RedisDataSourceUtil;
/**
 * 初始化系统相关数据到缓存
 * @author chenes
 *
 */
public class ServletInit  extends HttpServlet {

	private static final Logger  log =  Logger.getLogger(ServletInit.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		//初始化字典
		
		//初始化
		 //  businessService.initDo()..
		
//		ServletContext sc = getServletContext();  
//        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
//        RedisHeartbeat redisHeartbeat = (RedisHeartbeat) ac.getBean("redisHeartbeat");
//        redisHeartbeat.start();
//		log.info("初始化系统数据完成(init data of system,finish )..");
//		RedisDataSourceUtil.setex("joy", 360, "chenes");
//		System.out.println(RedisDataSourceUtil.get("joy"));;
		
	}

}
