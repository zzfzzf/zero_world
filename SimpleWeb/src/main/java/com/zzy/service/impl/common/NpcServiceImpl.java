package com.zzy.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GNpc;
import com.zzy.service.common.NpcService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class NpcServiceImpl extends BaseServiceImp<GNpc> implements NpcService{
	@Autowired
	public NpcServiceImpl(CrudRepository<GNpc, String> crudRepository) {
		super(crudRepository);
	}
}
