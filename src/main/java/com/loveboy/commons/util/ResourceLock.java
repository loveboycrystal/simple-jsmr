package com.loveboy.commons.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 实体资源锁,防止多个线程操作同一个资源的锁,根据实体ID生成唯一锁,前提是实体ID的字符串唯一性 只适用于资源同时操作数量不多的系统
 * 
 * @author xuzhaojie
 * 
 *         2017-8-31 上午10:35:30
 */
public class ResourceLock {
	static Log log = LogFactory.getLog(ResourceLock.class);
	// 初始化ConcurrentHashMap锁载体
	private static final ConcurrentHashMap<String, AtomicInteger> lockMap = new ConcurrentHashMap<String, AtomicInteger>();

	public static AtomicInteger getAtomicInteger(String key) {
		if (lockMap.get(key) == null) {// 当实体ID锁资源为空,初始化锁
			lockMap.putIfAbsent(key, new AtomicInteger(0));// 初始化一个竞争数为0的原子资源
		}
		int count = lockMap.get(key).incrementAndGet();// 线程得到该资源,原子性+1
		log.info("争抢资源,资源ID为:" + key + ",当前争抢线程数:" + count);
		return lockMap.get(key);// 返回该ID资源锁
	}

	public static void giveUpAtomicInteger(String key) {
		if (key == null)
			return;
		if (lockMap.get(key) != null) {// 当实体ID资源不为空,才可以操作锁,防止抛出空指针异常
			int source = lockMap.get(key).decrementAndGet();// 线程释放该资源,原子性-1
			if (source <= 0) {// 当资源没有线程竞争的时候，就删除掉该锁,防止内存溢出
				lockMap.remove(key);
			}
			log.info("释放资源,资源ID为:" + key + ",当前争抢线程数:" + source + ",在线资源数量为:"
					+ lockMap.size());
		}
	}
}
