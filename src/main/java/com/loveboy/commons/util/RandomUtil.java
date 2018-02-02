package com.loveboy.commons.util;

import java.util.Random;

public class RandomUtil {

	/**
	 * 获取随机6位数
	 * @return
	 */
	public static int getSixNum() {
		Random random = new Random();
		int num = -1 ;
		num = (int)(random.nextDouble()*(1000000 - 100000) + 100000);
		return num;
	}
}
