package com.zzy.service.impl.common;


import java.io.UnsupportedEncodingException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zzy.service.common.RedisService;

/**
 * 封装redis 缓存服务器服务接口  
 * @author zeus
 *         2012-12-16 上午3:09:18
 */
@Service
public class RedisServiceImpl implements RedisService{
	
	private String redisCode = "utf-8";    
	@Autowired
	private RedisTemplate<String,String> redisTemplate;
  
	/*	@Autowired()
    private RedisTemplate<String,String> redisTemplate;
    
    @PostConstruct 会在servlet启动的时候调用 先注入 后赋值给静态 
	public void redisTemplate(){
		EasyRedis.redisTemple=redisTemplate;
	} 
    // 用set方法注入
    @Autowired
    public void init(RedisTemplate<String,String> redisTemplate){
    	EasyRedis.redisTemple=redisTemplate;
    }*/
    
	public  long del(final String... keys) {
		return  redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				long result=0;
				for (int i = 0; i < keys.length; i++) {
					result=connection.del(keys[i].getBytes());
				}
				return result;
			}
			
		});
	}
  
	 @Override
	public  void set(final byte[] key, final byte[] value, final long liveTime) {
		redisTemplate.execute(new RedisCallback<Object>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key, value);
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }
                return 1L;
            }
        });
		
	}

	 
	public  void set(String key, String value, long liveTime) {
		set(key.getBytes(), value.getBytes(), liveTime);
	}

	 
	public  void set(String key, String value) {
		set(key, value, 0L);
	}

	 
	public  String get(final String key) {
		 return redisTemplate.execute(new RedisCallback<String>() {
	            public String doInRedis(RedisConnection connection) throws DataAccessException {
	                try {
	                    return new String(connection.get(key.getBytes()), redisCode);
	                } catch (UnsupportedEncodingException e) {
	                    e.printStackTrace();
	                }
	                return "";
	            }
	        });
	}


	 
	public  Set<String> Setkeys(String pattern) {
		 return redisTemplate.keys(pattern); 
	}

	 
	public  boolean exists(final String key) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
	}

	 
	public  String flushDB() {
		return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok"; 
            }
        });
	}

	 
	@Deprecated
	public  String flushAll() {
		return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushAll();
                return "ok"; 
            }
        });
	}
	
	 
	public  long dbSize() {
		return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
	}

	 
	public  String ping() {
		return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return "PONG".equals(connection.ping())?"ok":"error"; 
            }  
        });
	}

	


}