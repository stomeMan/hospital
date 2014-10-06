package com.tv189.api.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tv189.hospital.helper.JsonHelper;
import com.tv189.hospital.helper.StringHelper;

import redis.clients.jedis.Jedis;

public class RedisManager {
//	private static Logger logger = Logger.getLogger(RedisManager.class);
	private static RedisManager redisCacheManager;

	public static RedisManager getInstance() {
		if (redisCacheManager == null) {
			synchronized (Object.class) {
				if (redisCacheManager == null) {
					redisCacheManager = new RedisManager();
				}
			}
		}
		return redisCacheManager;
	}
	private RedisManager(){
		
	}
	private String get(String key) {
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null) {
			return null;
		}
		String value = jedis.get(key);
		RedisFactory.setJedis(jedis);
		return value;
	}

	private void set(String key, String objStr, Integer timeOut) {
		if(StringHelper.isNullOrEmpty(objStr)){
			return;
		}
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null) {
			return;
		}

		if (timeOut > 0) {
			jedis.setex(key, timeOut, objStr);
		} else {
			jedis.set(key, objStr);
		}
		RedisFactory.setJedis(jedis);
	}
	private void set(String key, String objStr){
		if(StringHelper.isNullOrEmpty(objStr)){
			return;
		}
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null) {
			return;
		}
		jedis.set(key, objStr);
	}
	public void remove(String cacheKey) {
		String key = cacheKey.replaceAll("#cacheKey#", cacheKey);
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null)
			return;

		jedis.del(key);
		RedisFactory.setJedis(jedis);
	}
	
	
	public void setHash(String key,String field,String value, Integer timeOut){
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null) {
			return;
		}
		if(timeOut > 0){
			jedis.hset(key, field, value);
			jedis.expire(key, timeOut);
		}else{
			jedis.hset(key, field, value);
		}
		RedisFactory.setJedis(jedis);
	}
	
	public String getInHashValue(String key,String field){
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null) {
			return null;
		}
		String str = null;
		if(jedis.hexists(key, field)){
			str = jedis.hget(key, field);
		}
		RedisFactory.setJedis(jedis);
		return str;
	}
	
	public List<String> getHashAllValue(String key){
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null) {
			return null;
		}
		List<String> allValuesList = null;
		if(jedis.exists(key)){
			allValuesList = new ArrayList<String>();
			allValuesList = jedis.hvals(key);
		}
		RedisFactory.setJedis(jedis);
		return allValuesList;
	}
	
	public Map<String,String> getHashHGetAll(String key){
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null) {
			return null;
		}
		Map<String,String> allFiledAndValueMap = null;
		if(jedis.exists(key)){
			allFiledAndValueMap = new HashMap<String, String>();
			allFiledAndValueMap = jedis.hgetAll(key);
		}
		RedisFactory.setJedis(jedis);
		return allFiledAndValueMap;
	}
	
	public void removeInHashObj(String key,String field){
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null) {
			return ;
		}
		
		jedis.hdel(key.getBytes(), field.getBytes());
		RedisFactory.setJedis(jedis);
	}
	
	public void removeHash(String key){
		Jedis jedis = RedisFactory.getJedis();
		if (jedis == null) {
			return ;
		}
		
		jedis.del(key.getBytes());
		RedisFactory.setJedis(jedis);
	}
	
	public void expirekey(String key, Integer timeOut){
		Jedis jedis = RedisFactory.getJedis();
		byte[] keyArr = key.getBytes();
		jedis.expire(keyArr, timeOut);
	}
	
	public boolean exits(String key){
		Jedis jedis = RedisFactory.getJedis();
		return jedis.exists(key);
	}
	
	public void hincrby(String key,String field, long times){
		Jedis jedis = RedisFactory.getJedis();
		jedis.hincrBy(key, field, times);
	}	
	public void mySet(String key,String value,Integer timeOut){
		set(key, value, timeOut);
	}
	
	public String myGet(String key){
		return get(key);
	}
	public String rpop(String key){
		Jedis jedis=RedisFactory.getJedis();
		return jedis.rpop(key);
	}
	public String lpop(String key){
		Jedis jedis=RedisFactory.getJedis();
		return jedis.lpop(key);
	}
	public void rpush(String key,String  jsonStr){
		Jedis jedis=RedisFactory.getJedis();
		jedis.rpush(key,jsonStr);
	}
	public void llen(String key){
		
	}
	public static void main(String[] args) {
		RedisManager rm= RedisManager.getInstance();
		rm.rpush("strs", "a");
		rm.rpush("strs", "b");
		rm.rpush("strs", "c");
		for(int i=0;i<3;i++){
			String str=rm.lpop("strs");
			System.out.println(str);
		}
		
	}
	
	
	
	
	

	

}
