package com.tv189.api.cache;

import org.apache.log4j.Logger;

import com.tv189.hospital.helper.CacheConfigHelper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisFactory {
	private static Logger logger = Logger.getLogger(RedisFactory.class);

	private static JedisPool mastJedisPool;

	static {
		JedisPoolConfig jedisConfig = new JedisPoolConfig();
		 jedisConfig.setMaxActive(-1);
//		jedisConfig.setMaxActive(100);
		jedisConfig.setMaxIdle(50);
		jedisConfig.setMaxWait(15000);

		mastJedisPool = new JedisPool(jedisConfig, CacheConfigHelper.getCacheIP(),
				CacheConfigHelper.getCachePort());

	}

	/**
	 * 通过资源ID获得缓存连接，以后按实际数据量可扩展成多缓存服务器，根据hash取所在缓存服务器 另，需保证同一个资源ID的缓存，保存在同一台服务器上
	 * 
	 * @param preKey
	 *            缓存key前缀
	 * @return
	 */
	public static Jedis getJedis() {
		try {
			return mastJedisPool.getResource();
		} catch (Exception e) {
			logger.error(
					"获取master-cache连接失败Ip:" + CacheConfigHelper.getCacheIP()
							+ ";prot:" + CacheConfigHelper.getCachePort() + "，原因："
							+ e.getMessage(), e);
		}
		return null;
	}

	public static void setJedis(Jedis jedis) {
		mastJedisPool.returnResource(jedis);
	}

//	public static void main(String... args) {
//		Jedis jedis = RedisFactory.getJedis();
//		jedis.set
//	}
}
