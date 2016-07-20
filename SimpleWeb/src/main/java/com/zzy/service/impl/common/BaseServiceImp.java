package com.zzy.service.impl.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.service.common.BaseService;

/**
 * @author zero
 * @version 1.0.0
 * @param <E>
 * @date:2016年4月1日
 * @description:
 */
public class BaseServiceImp<E> implements BaseService<E> {
	
	public CrudRepository<E,String> crudRepository;
	
	public BaseServiceImp(CrudRepository<E, String> crudRepository) {
		this.crudRepository = crudRepository;
	}
 
	@Override 
	public int add(E entity) {
		crudRepository.save(entity);
		return 1;
	}

	@Override
	public int delete(E entity) {
		crudRepository.delete(entity);
		return 1;
	}

	@Override
	public int update(E entity) {
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
