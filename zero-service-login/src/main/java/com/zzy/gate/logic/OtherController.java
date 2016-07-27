package com.zzy.gate.logic;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.ResultValue;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月27日 
* @description:
*/
public class OtherController {
	/**
	 * 查询在线人数
	 */
	public void getOnlineNum(IoAcceptor acceptor,IoSession session){
		JSONObject result = new JSONObject();
		// 目前一台服务器的情况 多个网关需要关联加减
		int onlineNum = acceptor.getManagedSessionCount();
		result.put("status", ResultValue.SUCCESS);
		result.put("onlineNum", onlineNum);
		session.write(result);
	}
}
