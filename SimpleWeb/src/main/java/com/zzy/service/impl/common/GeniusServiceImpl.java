package com.zzy.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GGenius;
import com.zzy.service.common.GeniusService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class GeniusServiceImpl extends BaseServiceImp<GGenius> implements GeniusService{
	@Autowired
	public GeniusServiceImpl(CrudRepository<GGenius, String> crudRepository) {
		super(crudRepository);
	}
}
