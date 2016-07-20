package com.zzy.repository.common;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.zzy.domain.base.GLand;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/ 
public interface LandRepository extends CrudRepository<GLand,String>{
	public Set<GLand> findByRoleIdLike(String roleId);
}
