package com.zzy.service.common;

import java.util.Set;

/**
 * redis工具扩展接口
 * @author Administrator
 *
 */

public interface RedisService {
	  /**
     * 通过key删除
     * 
     * @param key
     */
    public  abstract long del(String... keys);

    /**
     * 添加key value 并且设置存活时间(byte)
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public abstract void set(byte[] key, byte[] value, long liveTime);

    /**
     * 添加key value 并且设置存活时间
     * @param key
     * @param value
     * @param liveTime
     *         单位秒
     */
    public abstract void set(String key, String value, long liveTime);

    /**
     * 添加key value
     * @param key
     * @param value
     */
    public abstract void set(String key, String value);

    /**
    /**
     * 获取redis value (String)
     * @param key
     * @return
     */
    public abstract String get(String key);

    /**
     * 通过正则匹配keys
     * @param <T>
     * 
     * @param pattern
     * @return 
     */
    public abstract Set<?> Setkeys(String pattern); 

    /**
     * 检查key是否已经存在
     * 
     * @param key
     * @return
     */
    public abstract boolean exists(String key);

    /**
     * 清空redis(某个db库) 所有数据
     * 
     * @return
     */
    public abstract String flushDB();
    
    /**
     * 清空redis 所有数据
     * 
     * @return
     */
    public abstract String flushAll();

    /**
     * 查看redis里有多少数据
     */
    public abstract long dbSize();

    /**
     * 检查是否连接成功
     * 
     * @return
     */
    public abstract String ping();

}
