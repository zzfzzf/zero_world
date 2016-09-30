package com.zzy.service.impl.common;

import com.zzy.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GItems;
import com.zzy.service.common.ItemService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class ItemServiceImpl extends BaseServiceImpl<GItems> implements ItemService{
	@Autowired
	public ItemServiceImpl(CrudRepository<GItems, String> crudRepository) {
		super(crudRepository);
	}
}
