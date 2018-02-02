package com.loveboy.commons.util;

import org.apache.commons.lang3.StringUtils;

public class YhArrayUtils {

	//判断a数组中元素是否都属于b数组
	public static boolean containArray(Long[] a, Long[] b) {
		boolean flag = false;
		int k = 0;
		if (a.length <= b.length) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					if (a[i].equals(b[j])) {
						k++;
						continue;
					}
				}
			}
		}
		if (k == a.length) {
			flag = true;
		}
		return flag;
	}

	//将字符串数组转换为长整型数组
	public static Long[] strToLong(String idStr){
		if(StringUtils.isNotBlank(idStr)){
			String[] ids = idStr.split(",");
			Long[] str2 = new Long[ids.length];
			for (int i = 0; i < ids.length; i++) {
				str2[i] = Long.valueOf(ids[i]);
			}
			return str2;
		}else{
			return null;
		}
	}
	//将字符串数组转换为长整型数组
	public static Integer[] strToInteger(String idStr){
		if(StringUtils.isNotBlank(idStr)){
			String[] ids = idStr.split(",");
			Integer[] str2 = new Integer[ids.length];
			for (int i = 0; i < ids.length; i++) {
				str2[i] = Integer.valueOf(ids[i]);
			}
			return str2;
		}else{
			return null;
		}
	}
}
