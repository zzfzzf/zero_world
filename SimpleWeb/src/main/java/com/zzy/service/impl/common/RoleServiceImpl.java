package com.zzy.service.impl.common;

import java.util.List;

import com.zzy.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GRole;
import com.zzy.repository.common.RoleRepository;
import com.zzy.service.common.RoleService;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年6月30日 
* @decript:
*/
@Service
public class RoleServiceImpl extends BaseServiceImpl<GRole> implements RoleService {
  
	@Autowired
	private RoleRepository roleRepository;
    @Autowired
	public RoleServiceImpl(CrudRepository<GRole, String> crudRepository) {
    	super(crudRepository);
	}
	@Override
	public List<GRole> findByStatusNot(int status) {
		return roleRepository.findByStatusNot(status); 
	}
	@Override
	public GRole findByName(String name) {
		return roleRepository.findByName(name);
	}
	@Override
	public List<GRole> findByAreaId(String id) {
		return roleRepository.findByAreaId(id);
	}
}
