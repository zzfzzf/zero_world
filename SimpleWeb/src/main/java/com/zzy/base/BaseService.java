package com.zzy.base;

import java.util.List;

/** 
* @author zero
* @version 1.0.0
* @date:2016年4月1日
* @description:
*/

public interface BaseService <E>{
	
	int add(E entity);
	int delete(E entity);  
	int update(E entity);
	E get(String id);
	List<E> list();    
}