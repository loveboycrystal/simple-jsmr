package com.loveboy.commons;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.loveboy.commons.util.ResponseUtil;


@Service
public class RedisHeartbeat extends Thread {
	private static final Logger log = Logger.getLogger(RedisHeartbeat.class);
	
	private final String heartBeatKey = "heartbeat";
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public void run() {
		Object tmpStr = null; 
		while (true) {
			try {
				
				tmpStr = redisTemplate.opsForValue().get(heartBeatKey);
				if(tmpStr == null || "".equals(tmpStr)){
					redisTemplate.opsForValue().set(heartBeatKey, "0000");
				}
				log.info("redis heartbeat str :"+tmpStr.toString());
				this.sleep(1000*30);
			} catch (Exception e) {
				try {
					redisTemplate.opsForValue().set(heartBeatKey, "0000");
					log.info("redis heartbeat error " + ResponseUtil.getExceptionMsg(e));
					this.sleep(1000*30);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}

