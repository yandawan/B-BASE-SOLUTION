package com.roncoo.eshop.inventory.dao.impl;

import com.roncoo.eshop.inventory.dao.RedisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Repository("redisDAO")
public class RedisDAOImpl implements RedisDAO {

	@Autowired
	private Jedis jedis;
	
	@Override
	public void set(String key, String value) {
		jedis.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedis.get(key);
	}

	@Override
	public void delete(String key) {
		jedis.del(key);
	}

}
