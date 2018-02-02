package com.loveboy.commons.util;

import com.sun.jersey.core.util.Base64;



public class SecretWordUtil {
	/**
	 * 解密(open char)
	 * @param str
	 * @return
	 */
	public static String getDecodeStr(String str) throws Exception{
		try {
			str = str.replace(" ", "+");
			return new String(Base64.decode(str.getBytes()),"UTF-8");
		} catch (Exception e) {
			throw new Exception(e);
		}
		
	}

	/**
	 * 加密(close char)
	 * @param str
	 * @return
	 */
	public static String getEncodeStr(String str){
		return new String(Base64.encode(str.getBytes()));
	}


}
