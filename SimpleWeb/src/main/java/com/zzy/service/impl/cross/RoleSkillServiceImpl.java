package com.zzy.service.impl.cross;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.GRoleSkill;
import com.zzy.repository.cross.RoleSkillRepository;
import com.zzy.service.cross.RoleSkillService;
import com.zzy.base.BaseServiceImpl;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript: 角色技能类
*/
@Service
public class RoleSkillServiceImpl extends BaseServiceImpl<GRoleSkill> implements RoleSkillService{
	@Autowired
	private RoleSkillRepository rsRespository;
	@Autowired
	public RoleSkillServiceImpl(CrudRepository<GRoleSkill, String> crudRepository) {
		super(crudRepository);
	}

	@Override
	public List<GRoleSkill> findByRoleId(String roleId) {
		return rsRespository.findByRoleIdLike(roleId);
	}
}
