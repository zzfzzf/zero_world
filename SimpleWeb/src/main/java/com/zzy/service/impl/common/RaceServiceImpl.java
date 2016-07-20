package com.zzy.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GRace;
import com.zzy.service.common.RaceService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class RaceServiceImpl extends BaseServiceImp<GRace> implements RaceService{
	@Autowired
	public RaceServiceImpl(CrudRepository<GRace, String> crudRepository) {
		super(crudRepository);
	}
}
