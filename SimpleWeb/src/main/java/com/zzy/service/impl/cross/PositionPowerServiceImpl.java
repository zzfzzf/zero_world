package com.zzy.service.impl.cross;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.ZPositionPower;
import com.zzy.service.cross.PositionPowerService;
import com.zzy.base.BaseServiceImp;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class PositionPowerServiceImpl extends BaseServiceImp<ZPositionPower> implements PositionPowerService{
	@Autowired
	public PositionPowerServiceImpl(CrudRepository<ZPositionPower, String> crudRepository) {
		super(crudRepository);
	}
}
