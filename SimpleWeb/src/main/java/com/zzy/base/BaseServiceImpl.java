package com.zzy.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.zzy.utils.UUIDUtils;
import org.springframework.data.repository.CrudRepository;

import com.zzy.base.BaseService;

/**
 * @author zero
 * @version 1.0.0
 * @param <E>
 * @date:2016年4月1日
 * @description:
 */
public class BaseServiceImpl<E extends BaseEntity> implements BaseService<E> {
	
	public CrudRepository<E,String> crudRepository;
	
	public BaseServiceImpl(CrudRepository<E, String> crudRepository) {
		this.crudRepository = crudRepository;
	}
 
	@Override 
	public Integer add(E entity) {
		entity.setId(UUIDUtils.uuid32());
		crudRepository.save(entity);
		return 1;
	}

	@Override
	public Integer delete(E entity) {
		crudRepository.delete(entity);
		return 1;
	}

	@Override
	public Integer update(E entity) {
		crudRepository.save(entity);
		return 1;
	}
    
	@Override
	public E get(String id) {
		return crudRepository.findOne(id); 
	}

	@Override
	public List<E> list() {
		List<E> list=new ArrayList<E>();
		Iterator<E> it=crudRepository.findAll().iterator();
		while(it.hasNext()){
			list.add(it.next());
		}
		return list;
	}
}
