package com.zzy.service.impl.common;

import com.zzy.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GVocation;
import com.zzy.service.common.VocationService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class VocationServiceImpl extends BaseServiceImp<GVocation> implements VocationService{
	@Autowired
	public VocationServiceImpl(CrudRepository<GVocation, String> crudRepository) {
		super(crudRepository);
	}
}
