package com.loveboy.commons.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {

	/**
	 * 利用MD5进行加密 　　* @param str 待加密的字符串 　　* @return 加密后的字符串 　　* @throws
	 * NoSuchAlgorithmException 没有这种产生消息摘要的算法 　　 * @throws
	 * UnsupportedEncodingException 　　
	 */
	public static String toMd5(String str) {
		// 确定计算方法
		if (str == null) {
			return null;
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BASE64Encoder base64en = new BASE64Encoder();
		// 加密后的字符串
		String newstr = null;
		try {
			newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newstr;
	}

}
