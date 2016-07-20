package com.zzy.repository.common;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zzy.domain.base.ZUser;

/** 
* @author zero
* @version 1.0.0
* @date:2016年4月1日
* @description:
*/
public interface UserRepository extends CrudRepository<ZUser, String>{
     List<ZUser> findByStatusNot(int status);    
}
