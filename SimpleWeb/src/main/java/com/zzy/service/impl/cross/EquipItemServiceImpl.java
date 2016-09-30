package com.zzy.service.impl.cross;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.GEquipItem;
import com.zzy.service.cross.EquipItemService;
import com.zzy.base.BaseServiceImpl;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class EquipItemServiceImpl extends BaseServiceImpl<GEquipItem> implements EquipItemService{
	@Autowired
	public EquipItemServiceImpl(CrudRepository<GEquipItem, String> crudRepository) {
		super(crudRepository);
	}
}
