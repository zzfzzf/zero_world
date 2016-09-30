package com.zzy.service.impl.common;

import com.zzy.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GBag;
import com.zzy.repository.common.BagRepository;
import com.zzy.service.common.BagService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class BagServiceImpl extends BaseServiceImpl<GBag> implements BagService{

	@Autowired
	private BagRepository bagRepository;
    @Autowired
	public BagServiceImpl(CrudRepository<GBag, String> crudRepository) {
		super(crudRepository);
	}

}
