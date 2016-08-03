package com.zzy.db.impl;

import java.util.Set;

import com.zzy.db.DBService;

import redis.clients.jedis.Jedis;

/**
* @author Zeus
* @version 1.1
* @createTime:2016年8月3日 
* @description:
*/
public class DBServiceImpl implements DBService{

	private Jedis jedis=new Jedis("localhost");
	
	@Override
	public long del(String... keys) {
		for(int i=0;i<keys.length;i++){
			jedis.del(keys[i]);
		}
		return 0;
	}

	@Override
	public void set(byte[] key, byte[] value, long liveTime) {
		int seconds = (int) (liveTime-System.currentTimeMillis()/1000);
		jedis.setex(key, seconds, value);
	}

	@Override
	public void set(String key, String value, long liveTime) {
		int seconds = (int) (liveTime-System.currentTimeMillis()/1000);
		jedis.setex(key, seconds, value);
	}

	@Override
	public void set(String key, String value, int seconds) {
		jedis.setex(key, seconds, value);
	}

	@Override
	public void set(byte[] key, byte[] value, int seconds) {
		jedis.setex(key, seconds, value);
	}
	
	@Override
	public void set(String key, String value) {
		jedis.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedis.get(key);
	}

	@Override
	public Set<?> Setkeys(String pattern) {
		return jedis.keys(pattern);
	}

	@Override
	public boolean exists(String key) {
		return jedis.exists(key);
	}

	@Override
	public String flushDB() {
		return jedis.flushDB();
	}

	@Override
	public String flushAll() {
		return jedis.flushAll();
	}

	@Override
	public long dbSize() {
		return jedis.dbSize();
	}

	@Override
	public String ping() {
		return jedis.ping();
	}
}
