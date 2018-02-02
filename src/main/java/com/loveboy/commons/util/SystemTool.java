package com.loveboy.commons.util;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @Description: 系统工具
 * @Function 提供系统公共方法
 * @Author: chenes
 */
public class SystemTool {
	public final static Log LOG = LogFactory.getLog(SystemTool.class);

	private SystemTool() {
	}

	private static Properties mappingForSystemProp = ConfigReader.getMappingForSystemPropInstance();
	private static Properties mappingForWXProp = ConfigReader.getMappingForWXPropInstance();
	private static Properties mappingForRedisProp = ConfigReader.getMappingForRedisPropInstance();
	
	/**
	 * 获取配置属性值
	 * 
	 * @return
	 */
	public static String getSystemProp(String key) {
		try {
			return mappingForSystemProp.getProperty(key);
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	 * 获取配置属性值
	 * 
	 * @return
	 */
	public static String getWXProp(String key) {
		try {
			return mappingForWXProp.getProperty(key);
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	 * 获取配置属性值
	 * 
	 * @return
	 */
	public static String getRedisProp(String key) {
		try {
			return mappingForRedisProp.getProperty(key);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 获取字符串编码
	 * @param str
	 * @return
	 */
	public static String getEncoding(String str) {      
	    String encode = "GB2312";      
	    try {      
           if(str.equals(new String(str.getBytes(encode), encode))) {      
              String s = encode;      
              return s;      
           }      
	    }catch(Exception exception) {}      
	    encode = "ISO-8859-1";      
	    try {      
	       if(str.equals(new String(str.getBytes(encode), encode))) {      
	          String s1 = encode;      
	          return s1;      
	       }      
	    }catch(Exception exception1) {}      
	    encode = "UTF-8";      
	    try {      
	       if(str.equals(new String(str.getBytes(encode), encode))) {      
	          String s2 = encode;      
	          return s2;      
	       }      
	    }catch (Exception exception2) {}      
	    encode = "GBK";      
	    try {      
	       if (str.equals(new String(str.getBytes(encode), encode))) {      
	           String s3 = encode;      
	           return s3;      
	       }      
	    }catch (Exception exception3) {}      
	    return "";      
	} 
}
