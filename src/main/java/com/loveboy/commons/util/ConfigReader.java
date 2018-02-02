package com.loveboy.commons.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 * Title: 配置文件读取器
 * </p>
 * 
 * @version 1.0
 */
public class ConfigReader {
	
	/**
	 * 系统配置文件key
	 * @author chenes
	 *
	 */
	public enum ProKeys{
		SYSTEM_CONFIG_FILE("/config/system_test.properties"),
		WX_CONFIG_FILE("/config/wxpay.properties"),
		REDIS_CONFIG_FILE("/config/redis.properties");
		private String proKey;
		ProKeys(String proKey){
			this.proKey = proKey;
		}

		public String getProKey() {
			return proKey;
		}
		
	}
	
	
    
	static public Properties getMappingForSystemPropInstance() {
		return getMappingPropInstance(ConfigReader.ProKeys.SYSTEM_CONFIG_FILE.getProKey());
	}
	
	static public Properties getMappingForWXPropInstance() {
		return getMappingPropInstance(ConfigReader.ProKeys.WX_CONFIG_FILE.getProKey());
	}
	static public Properties getMappingForRedisPropInstance() {
		return getMappingPropInstance(ConfigReader.ProKeys.REDIS_CONFIG_FILE.getProKey());
	}
	
	
	static public Map<String, Properties> mappingConfig = new HashMap<String, Properties>();


	
	
	static public Properties getMappingPropInstance(String key) {
		if (mappingConfig.containsKey(key)) {
			return mappingConfig.get(key);
		}
		Properties mappingForSystemProp = new Properties();
		InputStream in = null;
		try {
			in = ConfigReader.class.getResourceAsStream(key);
			mappingForSystemProp.load(in);
			mappingConfig.put(key, mappingForSystemProp);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			mappingForSystemProp = null;
		} catch (IOException ex) {
			ex.printStackTrace();
			mappingForSystemProp = null;
		} catch (Exception ex) {
			ex.printStackTrace();
			mappingForSystemProp = null;
		} finally{
			if(in!=null){
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return mappingConfig.get(key);
	}

	/**
	 * 重置所有
	 */
	static public void resetAll() {
		mappingConfig.clear();
	}
	
	/**
	 * 重置某个文件
	 */
	static public void resetPropertiesByKey(String key) {
		mappingConfig.remove(key);
	}

}
