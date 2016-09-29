package com.zzy.service.cross;

import java.util.List;

import com.zzy.domain.cross.GRoleBuff;
import com.zzy.base.BaseService;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年6月30日 
* @decript:
*/
public interface RoleBuffService extends BaseService<GRoleBuff>{
	public List<GRoleBuff> findByRoleIdLike(String roleId);
}
