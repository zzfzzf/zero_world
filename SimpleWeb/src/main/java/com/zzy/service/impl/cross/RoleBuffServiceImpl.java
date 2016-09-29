package com.zzy.service.impl.cross;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.GRoleBuff;
import com.zzy.repository.cross.RoleBuffRepository;
import com.zzy.service.cross.RoleBuffService;
import com.zzy.base.BaseServiceImp;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class RoleBuffServiceImpl extends BaseServiceImp<GRoleBuff> implements RoleBuffService{
	
	@Autowired
	private RoleBuffRepository rbRepository;
	@Autowired
	public RoleBuffServiceImpl(CrudRepository<GRoleBuff, String> crudRepository) {
		super(crudRepository);
	}

	@Override
	public List<GRoleBuff> findByRoleIdLike(String roleId) {
		return rbRepository.findByRoleIdLike(roleId);
	}
}
