package com.zzy.gate.logic.Impl;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.ResultValue;
import com.zzy.gate.logic.IOther;

/**
* @author Zeus
* @version 1.1
* @createTime :2016年7月27日 
* @description:
*/
public class OtherController  implements IOther{
	@Override
	public void getOnlineNum(IoAcceptor acceptor,IoSession session){
		JSONObject result = new JSONObject();
		// 目前一台服务器的情况 多个网关需要关联加减
		int onlineNum = acceptor.getManagedSessionCount();
		result.put("status", ResultValue.SUCCESS);
		result.put("onlineNum", onlineNum);
		session.write(result);
	}
}
