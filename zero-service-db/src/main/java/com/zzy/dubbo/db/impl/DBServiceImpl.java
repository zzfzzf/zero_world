package com.zzy.dubbo.db.impl;

import com.zzy.common.util.ByteUtil;
import com.zzy.common.util.SerializeUtil;
import com.zzy.dubbo.db.DBService;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Set;

/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年8月3日
 * @description:
 */
public class DBServiceImpl implements DBService {

	private Jedis jedis = new Jedis("localhost");

	@Override
	public long del(String... keys) {
		for (int i = 0; i < keys.length; i++) {
			jedis.del(keys[i]);
		}
		return 0;
	}

	@Override
	public void set(byte[] key, byte[] value, long liveTime) {
		int seconds = (int) (liveTime - System.currentTimeMillis() / 1000);
		jedis.setex(key, seconds, value);
	}

	@Override
	public void set(String key, String value, long liveTime) {
		int seconds = (int) (liveTime - System.currentTimeMillis() / 1000);
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
	public Set<?> setkeys(String pattern) {
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

	@Override
	public void setObj(String key, Object object) throws IOException {
		byte bytes[];
		if (object instanceof Integer) {
			bytes = ByteUtil.int2bytes((Integer) object);
		} else if (object instanceof Long) {
			bytes = ByteUtil.long2bytes((Long) object);
		} else {
			bytes = SerializeUtil.serialize(object);
		}
		jedis.set(key.getBytes(), bytes);
	}

	@Override
	public Object getObj(String key,Class<? extends Object> c) throws Exception {
		byte bytes[]=jedis.get(key.getBytes());
		if(Integer.class.getName().equals(c.getName())){
		    return ByteUtil.bytes2int(bytes);
		}else if(Long.class.getName().equals(c.getName())){
			return ByteUtil.bytes2long(bytes);
		}else{
			return SerializeUtil.unserialize(bytes);
		}
	}
}
