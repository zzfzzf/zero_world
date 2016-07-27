
package com.zzy.gate.logic;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSession;

/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
public interface IOther {
	public void getOnlineNum(IoAcceptor acceptor,IoSession session);
}

