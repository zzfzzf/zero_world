package com.zzy.repository.common;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zzy.domain.base.GRole;

/** 
* @author zero
* @version 1.0.0
* @date:2016年4月1日
* @description:
*/
public interface RoleRepository extends CrudRepository<GRole, String>{
	List<GRole> findByStatusNot(int status);
}
