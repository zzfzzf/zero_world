package com.zzy.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GArea;
import com.zzy.domain.base.GBag;
import com.zzy.repository.common.AreaRepository;
import com.zzy.repository.common.BagRepository;
import com.zzy.service.common.AreaService;
import com.zzy.service.common.BagService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class AreaServiceImpl extends BaseServiceImp<GArea> implements AreaService{

	@Autowired
	private AreaRepository areaRepository; 
    @Autowired
	public AreaServiceImpl(CrudRepository<GArea, String> crudRepository) {
		super(crudRepository);
	}

}
