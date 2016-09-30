package com.zzy.service.impl.cross;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.GRaceGenius;
import com.zzy.service.cross.RaceGeniusService;
import com.zzy.base.BaseServiceImpl;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class RaceGeniusServiceImpl extends BaseServiceImpl<GRaceGenius> implements RaceGeniusService {
	@Autowired
	public RaceGeniusServiceImpl(CrudRepository<GRaceGenius, String> crudRepository) {
		super(crudRepository);
	}
}
