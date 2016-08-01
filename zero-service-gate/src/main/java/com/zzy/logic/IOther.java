
package com.zzy.logic;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSession;

/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
public interface IOther {
	/**
	 * 查询在线人数
	 * @param acceptor session管理工具,从其中可获取当前管理session总数
	 * @param session  当前查询人的session
	 */
	public void getOnlineNum(IoAcceptor acceptor,IoSession session);
}

