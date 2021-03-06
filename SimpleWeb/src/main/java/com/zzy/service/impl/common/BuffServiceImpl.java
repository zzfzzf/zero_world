package com.zzy.service.impl.common;

import com.zzy.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GBuff;
import com.zzy.repository.common.BuffRepository;
import com.zzy.service.common.BuffService;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class BuffServiceImpl extends BaseServiceImpl<GBuff> implements BuffService {
	@Autowired
	private BuffRepository buffRepository;
    @Autowired
	public BuffServiceImpl(CrudRepository<GBuff, String> crudRepository) {
		super(crudRepository); 
	}


}
