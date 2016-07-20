package com.zzy.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.ZPower;
import com.zzy.service.common.PowerService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class PowerServiceImpl extends BaseServiceImp<ZPower> implements PowerService{
	@Autowired
	public PowerServiceImpl(CrudRepository<ZPower, String> crudRepository) {
		super(crudRepository);
	}
}
