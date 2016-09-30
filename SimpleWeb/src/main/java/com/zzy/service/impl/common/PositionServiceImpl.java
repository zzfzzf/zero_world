package com.zzy.service.impl.common;

import com.zzy.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.ZPosition;
import com.zzy.service.common.PositionService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class PositionServiceImpl extends BaseServiceImpl<ZPosition> implements PositionService{
	@Autowired
	public PositionServiceImpl(CrudRepository<ZPosition, String> crudRepository) {
		super(crudRepository);
	}
}
