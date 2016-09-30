package com.zzy.service.impl.cross;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.ZUserPosition;
import com.zzy.service.cross.UserPositionService;
import com.zzy.base.BaseServiceImpl;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class UserPositionServiceImpl extends BaseServiceImpl<ZUserPosition> implements UserPositionService{
	@Autowired
	public UserPositionServiceImpl(CrudRepository<ZUserPosition, String> crudRepository) {
		super(crudRepository);
	}
}
