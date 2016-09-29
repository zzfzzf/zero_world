package com.zzy.service.cross;

import java.util.Set;

import com.zzy.domain.cross.GRoleFriend;
import com.zzy.base.BaseService;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年6月30日 
* @decript:
*/
public interface RoleFriendService extends BaseService<GRoleFriend>{
	public Set<GRoleFriend> findByRoleIdLike(String roleId);
}
