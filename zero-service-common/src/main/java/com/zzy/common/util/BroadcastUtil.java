package com.zzy.common.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年8月10日
 * @description:广播工具类
 */
public class BroadcastUtil {
	/**
	 * 广播给指定用户
	 */
	public static void sentToList(List<Long> idList,IoAcceptor acceptor,JSONObject json) {
		Map<Long, IoSession> map = acceptor.getManagedSessions();
		Iterator<Long> ir = idList.iterator();
		while(ir.hasNext()){
			Long id = ir.next();
			if(map.containsKey(id)){
				IoSession session = map.get(id);
				session.write(json);
			}
		}
	}

	/**
	 * 广播给所有用户
	 */
	public static void sentToAll(IoAcceptor acceptor,JSONObject json) {
		Map<Long, IoSession> map = acceptor.getManagedSessions();
		Iterator<Map.Entry<Long, IoSession>> ir=map.entrySet().iterator();
		while(ir.hasNext()){
			Map.Entry<Long, IoSession> entrys = ir.next();
			entrys.getValue().write(json);
		}
	}
	
	/**
	 * 广播给自己
	 */
	public static void sentToMe(IoSession session,JSONObject json){
		session.write(json);
	}
}
