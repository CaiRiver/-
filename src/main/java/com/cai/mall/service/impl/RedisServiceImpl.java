package com.cai.mall.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cai.mall.service.RedisService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service("redisServiceImpl")
public class RedisServiceImpl implements RedisService {
	
	private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.8.163");
	
	private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);
	
	@Override
	public boolean hasKey(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			return jedis.exists(key);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		
	}

	@Override
	public List<Map<String, String>> getProvince(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			 List list = JSON.parseArray(jedis.get(key), Map.class);
			 return list;
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}

	@Override
	public void setProvince(String key, List<Map<String, String>> value) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String valueStr = JSON.toJSONString(value);
			logger.info(">>>保存省份,{}" + valueStr);
			jedis.set(key, valueStr);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		
	}

	@Override
	public List<Map<String, String>> getCity(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			List list = JSON.parseArray(jedis.get(key), Map.class);
			return list;
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}

	@Override
	public void setCity(String key, List<Map<String, String>> value) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String jsonMsg = JSON.toJSONString(value);
			logger.info(">>>保存城市,{}" + jsonMsg);
			jedis.set(key, jsonMsg);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}
	
}
