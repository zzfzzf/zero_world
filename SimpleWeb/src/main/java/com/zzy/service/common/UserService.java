package com.zzy.service.common;

import java.util.List;

import com.zzy.base.BaseService;
import com.zzy.domain.base.ZUser;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年6月30日 
* @decript:
*/
public interface UserService extends BaseService<ZUser> {
	List<ZUser> findByStatusNot(int status);
	ZUser findByUsername(String username);
	boolean login(ZUser user);
}
