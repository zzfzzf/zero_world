package com.zzy.service.impl.common;

import com.zzy.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GArea;
import com.zzy.repository.common.AreaRepository;
import com.zzy.service.common.AreaService;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class AreaServiceImpl extends BaseServiceImpl<GArea> implements AreaService{

	@Autowired
	private AreaRepository areaRepository; 
    @Autowired
	public AreaServiceImpl(CrudRepository<GArea, String> crudRepository) {
		super(crudRepository);
	}

}
