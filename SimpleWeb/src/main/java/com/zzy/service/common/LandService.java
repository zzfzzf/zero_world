package com.zzy.service.common;

import java.util.Set;

import com.zzy.domain.base.GLand;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年6月30日 
* @decript:
*/
public interface LandService extends BaseService<GLand>{
	public Set<GLand> findByRoleIdLike(String roleId);
}
