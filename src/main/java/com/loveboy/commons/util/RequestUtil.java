package com.loveboy.commons.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class RequestUtil {
	
	private static final Logger  log =  Logger.getLogger(RequestUtil.class);
	
	
	 public  static String getIpAddr(HttpServletRequest request)  {
         String ip  =  request.getHeader( " x-forwarded-for " );
          if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
             ip  =  request.getHeader( " Proxy-Client-IP " );
         }
          if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
             ip  =  request.getHeader( " WL-Proxy-Client-IP " );
         }
          if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
            ip  =  request.getRemoteAddr();
        }
         return  ip;
    }
	 
	/**
	 * 生成用户请求编号
	 * @return  uuid
	 */
	public static String createRequstId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 生成用户APP用户tokenId
	 * @return  uuid
	 */
	public static String createTokenId(){
		return "yhtid"+UUID.randomUUID().toString().replaceAll("-", "");
	}
}
