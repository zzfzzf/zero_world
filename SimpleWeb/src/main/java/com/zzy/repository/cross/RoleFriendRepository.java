package com.zzy.repository.cross;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.zzy.domain.cross.GRoleFriend;

/** 
* @author zero
* @version 1.0.0
* @date:2016年4月1日
* @description:
*/
public interface RoleFriendRepository extends CrudRepository<GRoleFriend, String>{
	public Set<GRoleFriend> findByRoleIdLike(String roleId);
}
