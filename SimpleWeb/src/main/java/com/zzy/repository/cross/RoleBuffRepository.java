package com.zzy.repository.cross;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zzy.domain.cross.GRoleBuff;

/** 
* @author zero
* @version 1.0.0
* @date:2016年4月1日
* @description: 
*/
public interface RoleBuffRepository extends CrudRepository<GRoleBuff, String>{
	public List<GRoleBuff> findByRoleIdLike(String roleId);
}
