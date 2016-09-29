package com.zzy.service.impl.common;

import java.util.Set;

import com.zzy.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GLand;
import com.zzy.repository.common.LandRepository;
import com.zzy.service.common.LandService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class LandServiceImpl extends BaseServiceImp<GLand> implements LandService{
	@Autowired
	private LandRepository landRepository;
	@Autowired
	public LandServiceImpl(CrudRepository<GLand, String> crudRepository) {
		super(crudRepository);
	}

	@Override
	public Set<GLand> findByRoleIdLike(String roleId) {
		return landRepository.findByRoleIdLike(roleId);
	}
}
