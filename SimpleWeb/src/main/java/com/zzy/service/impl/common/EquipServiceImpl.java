package com.zzy.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GEquip;
import com.zzy.service.common.EquipService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class EquipServiceImpl extends BaseServiceImp<GEquip> implements EquipService{
	@Autowired
	public EquipServiceImpl(CrudRepository<GEquip, String> crudRepository) {
		super(crudRepository);
	} 
}
