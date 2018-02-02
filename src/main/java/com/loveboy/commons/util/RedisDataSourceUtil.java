package com.loveboy.commons.util;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisDataSourceUtil {
	
	private static final Logger log = Logger.getLogger(RedisDataSourceUtil.class);
	private final static String ip = SystemTool.getRedisProp("redis.ip");
	private static String port= SystemTool.getRedisProp("redis.port"); //"6380";
	private static String maxIdle= SystemTool.getRedisProp("redis.pool.maxIdle");
	private static String maxActive= SystemTool.getRedisProp("redis.pool.maxTotal");
	private static String maxWait= SystemTool.getRedisProp("redis.pool.maxWaitMillis");
	private static String eviTime= SystemTool.getRedisProp("redis.eviTime");
	private static int dbno = Integer.parseInt(SystemTool.getRedisProp("redis.database"));
	private static JedisPool jedisPool = null; 
	
	
	public static void main(String[] args) {
		//RedisDataSourceUtil.getJedis().hsetnx("tokenid","uid1", "a123");
		RedisDataSourceUtil.setex("joy", 20, "chenes");
		
	}
	
	/**
	 * reids 存储时间
	 * @param key 
	 * @param seconds
	 * @param value
	 */
    public static void setex(String key, int seconds, String value ){
    	Jedis jedis = null;
    	try {
    		jedis = getJedis();
    		log.info("jedis is "+jedis);
    	    String setex = jedis.set(key, value);//jedis.setex(key, seconds, value );
    	    jedis.expire(key, seconds);
    	    System.out.println("set key:"+key+" value:"+value + " seconds:"+seconds);
    	} catch(Exception e){
    		log.error("jedis zrange error！");
			log.error(e.toString());
			log.error(e.getStackTrace()[0]);
    	} finally {
    		//returnResource(jedis);
    	}
      }
    
    public static String  get(String key){
    	Jedis jedis = null;
    	 String returnVal = "";
    	try {
    		jedis = getJedis();
    		returnVal = jedis.get(key).toString();
    		return returnVal;
    	} catch(Exception e){
    		log.error("jedis zrange error！");
			log.error(e.toString());
			log.error(e.getStackTrace()[0]);
			return returnVal;
    	} 
      }
    
	
	 /** 
     * 构建redis连接池 
     * 单节点 
     * @param ip 
     * @param port 
     * @return JedisPool 
     */  
    private synchronized static  JedisPool getPool() {  
        if (jedisPool == null) {  
            JedisPoolConfig config = new JedisPoolConfig();  
            //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；  
            //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。  
            config.setMaxTotal(Integer.valueOf(maxActive));
            //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。  
            config.setMaxIdle(Integer.valueOf(maxIdle)); 
            config.setMinIdle(20);
            //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；  
            config.setMaxWaitMillis(Integer.valueOf(maxWait)*1000);  
            //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；  
            config.setTestOnBorrow(true);  
            config.setTestOnReturn(false);
            //连接检查间隔时间
            if(StringUtils.isBlank(eviTime)){
            	eviTime = "1800";
            }
            config.setTimeBetweenEvictionRunsMillis(Integer.valueOf(eviTime) * 1000);
            jedisPool = new JedisPool(config, ip,Integer.valueOf(port),10000);
        }  
        return jedisPool;    
    }  
    
    
    
    /**
     *@Description:获取Jedis对象
     *@author chenes  
     *@return
     */
    public synchronized static Jedis getJedis() {  
    	
        try {
        	//初始化连接池
        	jedisPool =  getPool();
        	System.out.println(jedisPool);
            if (jedisPool != null) {  
                int timeoutCount = 0;  
                while (true) {  
                    try {  
                    	Jedis jedis = jedisPool.getResource();
                    	jedis.select(dbno);
                        return jedis;  
                    } catch (Exception e) {  
                    	e.printStackTrace();
                        if (e instanceof JedisConnectionException) {  
                            log.info("getJedis连接失败{"+timeoutCount+"}次");  
                            Thread.sleep(50);
                            if (timeoutCount > 3) {  
                            	log.warn("Jedis获取失败，请管理员检查相关原因");
                                break;  
                            }  
                            timeoutCount++;  
                        } else {  
                        	printjedisPoolInfo(); 
                            log.error("GetJedis error,", e);  
                            break;  
                        }  
                    }  
                }  
            }else{
            	log.warn("jedisPool is null");
            }
            printjedisPoolInfo();
            return null;
        } catch (Exception e) {  
            log.error("Get jedis error : "+e);
            return null;
        }
    } 

    
    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
    	jedis.close();
    }
    
	public static void ClearRedisKeys(String match){
		Jedis jedis = null;
		try {
			
			jedis = getJedis();
			Set<String> keys = jedis.keys(match+"*");
			for(String key:keys){
				jedis.del(key);
			}
			
		}finally{
			if(jedis != null){
				returnResource(jedis);
			}else{
				System.out.println("jedis is null");
			}
		}
	}
	
	/**
	 *@Description:
	 *@author liuyingping-2017-3-28 
	 *@param key
	 *@param field
	 *@param value
	 *@return 成功返回Long,失败返回null
	 */
    public static Long hset(String key,String field,String value){
    	Jedis jedis = null;
    	try {
    		jedis = getJedis();
    	    return jedis.hset(key, field, value);
    	} catch(Exception e){
    		log.error("jedis hset error！");
			log.error(e.toString());
			log.error(e.getStackTrace()[0]);
    		return null;
    	} finally {
    		returnResource(jedis);
    	}
      }
    
	/**
	 *@Description:根据key及field获取对应的值
	 *@author liuyingping-2017-3-28 
	 *@param key
	 *@param field
	 *@param value
	 *@return 成功返回String,失败返回空
	 */
    public static String hget(String key,String field){
    	Jedis jedis = null;
    	try {
    		jedis = getJedis();
    	    return jedis.hget(key, field);
    	} catch(Exception e){
    		log.error("jedis hget error！");
			log.error(e.toString());
			log.error(e.getStackTrace()[0]);
    		return null;
    	} finally {
    		returnResource(jedis);
    	}
      }
    
    /**
     *@Description:计算jedis中某key集合的长度
     *@author liuyingping-2017-3-28 
     *@param key
     *@return 成功则返回Long,否则返回null
     */
    public static Long scard(String key){
    	Jedis jedis = null;
    	try {
    		jedis = getJedis();
    	    return jedis.scard(key);
    	} catch(Exception e){
    		log.error("jedis hset error！");
			log.error(e.toString());
			log.error(e.getStackTrace()[0]);
    		return null;
    	} finally {
    		returnResource(jedis);
    	}
      }
    
    /**
     *@Description:获取有序集合的所有值
     *@author liuyingping-2017-3-28 
     *@param key
     *@return 成功则返回set<String>值，否则返回null
     */
    public static Set<String> zrange(String key){
    	Jedis jedis = null;
    	try {
    		jedis = getJedis();
    	    return jedis.zrange(key, 0, -1);
    	} catch(Exception e){
    		log.error("jedis zrange error！");
			log.error(e.toString());
			log.error(e.getStackTrace()[0]);
    		return null;
    	} finally {
    		returnResource(jedis);
    	}
      }
    
    /**
     *@Description:根据Key进行删除
     *@author liuyingping-2017-3-28 
     *@param key
     */
    public static void delKey(String key){
    	Jedis jedis = null;
    	try {
    		jedis = getJedis();
    	    jedis.del(key);
    	} catch(Exception e){
    		log.error("jedis zrange error！");
			log.error(e.toString());
			log.error(e.getStackTrace()[0]);
    	} finally {
    		returnResource(jedis);
    	}
      }
    
    
    
    /**
     *@Description:输出Redis线程池相关的相关信息
     *@author liuyingping-2016-12-15
     */
    public static void printjedisPoolInfo(){
    	if(jedisPool != null){
	        log.info("jedisInfo:NumActive=" + jedisPool.getNumActive()  
	                + ", NumIdle=" + jedisPool.getNumIdle()  
	                + ", NumWaiters=" + jedisPool.getNumWaiters()  
	                + ", isClosed=" + jedisPool.isClosed());  
    	}else{
    		log.debug("管理员请注意：jedisPool is null!");
    	}
    }
}
