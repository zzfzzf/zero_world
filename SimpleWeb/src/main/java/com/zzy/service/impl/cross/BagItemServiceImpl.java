package com.zzy.service.impl.cross;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.GBagItem;
import com.zzy.service.cross.BagItemService;
import com.zzy.base.BaseServiceImp;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class BagItemServiceImpl extends BaseServiceImp<GBagItem> implements BagItemService{
	@Autowired
	public BagItemServiceImpl(CrudRepository<GBagItem, String> crudRepository) {
		super(crudRepository);
	}
}
