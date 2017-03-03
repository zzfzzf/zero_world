package com.zzy.common.util;

import java.util.*;

import com.zzy.common.base.ResultValue;
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
     * 发送给所有在线角色
     * @param acceptor session管理器
     * @param json     数据
     */
    public static void sentMessage(IoAcceptor acceptor, JSONObject json) {
        Map<Long, IoSession> map = acceptor.getManagedSessions();
        Iterator<Map.Entry<Long, IoSession>> ir = map.entrySet().iterator();
        while (ir.hasNext()) {
            ir.next().getValue().write(json);
        }
    }

    /**
     * 发送给不包括Excluded的所有在线角色
     * @param acceptor session管理器
     * @param json     数据
     */
    public static void sentMessage(IoAcceptor acceptor, JSONObject json, Collection<Long> Exclude) {
        Iterator<Map.Entry<Long, IoSession>> ir = acceptor.getManagedSessions().entrySet().iterator();
        Map.Entry<Long, IoSession> entry;
        while (ir.hasNext()) {
            Iterator<Long> cir = Exclude.iterator();
            entry = ir.next();
            while (cir.hasNext()) {
                Nothing.doNothing(entry.getKey() != cir.next()? entry.getValue().write(json):Nothing.doNothing());
            }
        }
    }

    /**
     * 发送给指定集合对象
     * @param collection
     * @param acceptor
     * @param json
     */
    public static void sentMessage(Collection<Long> collection, IoAcceptor acceptor, JSONObject json) {
        Map<Long, IoSession> map = acceptor.getManagedSessions();
        Iterator<Long> ir = collection.iterator();
        Long id;
        while (ir.hasNext()) {
            id = ir.next();
            Nothing.doNothing(map.containsKey(id)?map.get(id).write(json):Nothing.doNothing());
        }
    }

    /**
     * 遍历集合广播
     */
    private static JSONObject foreach(Collection<Long> collection, Map<Long, IoSession> map, JSONObject json) {
        if (Objects.nonNull(collection)) {
            Iterator<Long> ir = collection.iterator();
            Long id;
            while (ir.hasNext()) {
                id = ir.next();
                Nothing.doNothing(map.containsKey(id)?map.get(id).write(json):Nothing.doNothing());
            }
        }
        return json;
    }

    /**
     * 返回请求给自己
     */
    private static JSONObject sentToMe(IoSession session, JSONObject json) {
        session.write(json);
        return json;
    }

    /**
     * 发送信息(自己和集合列表)
     * @param collection
     * @param acceptor
     * @param json
     */
    public static void sentMessage(Collection<Long> collection, IoAcceptor acceptor, IoSession session, JSONObject json) {
        Nothing.doNothing(Objects.nonNull(acceptor) ? foreach(collection, acceptor.getManagedSessions(), json) : sentToMe(session, json));
    }
}

