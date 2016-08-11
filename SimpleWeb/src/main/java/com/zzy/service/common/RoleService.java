package com.zzy.service.common;

import java.util.List;

import com.zzy.domain.base.GRole;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年6月30日 
* @decript:
*/
public interface RoleService extends BaseService<GRole>{
	// 查找status不为10的 (有效的)
	List<GRole> findByStatusNot(int status);
	
	GRole findByName(String name);
	
	List<GRole> findByAreaId(String id);
}
