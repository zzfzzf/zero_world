package com.zzy.service.impl.common;

import com.zzy.base.BaseServiceImp;
import com.zzy.domain.base.GMap;
import com.zzy.service.common.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class MapServiceImpl extends BaseServiceImp<GMap> implements MapService{
	@Autowired
	public MapServiceImpl(CrudRepository<GMap, String> crudRepository) {
		super(crudRepository);
	}
}
