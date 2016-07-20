package com.zzy.repository.cross;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zzy.domain.cross.GRoleSkill;

/** 
* @author zero
* @version 1.0.0
* @date:2016年4月1日
* @description:
*/

public interface RoleSkillRepository extends CrudRepository<GRoleSkill, String>{
	public List<GRoleSkill> findByRoleIdLike(String roleId);
	
/*	@Query("select grs from GRoleSkill grs where grs.roleId = :roleId")
	public List<GRoleSkill> findByRoleId(@Param(value = "roleId") String roleId);
*/
	}
