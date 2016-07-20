package com.zzy.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GBuilding;
import com.zzy.service.common.BuffService;
import com.zzy.service.common.BuildService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class BuildServiceImpl extends BaseServiceImp<GBuilding> implements BuildService {
	@Autowired
	public BuildServiceImpl(CrudRepository<GBuilding, String> crudRepository) {
		super(crudRepository);
	}
}
