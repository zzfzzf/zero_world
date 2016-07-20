package com.zzy.repository.common;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zzy.domain.base.GBuff;
import com.zzy.domain.cross.GVocationSkill;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
public interface BuffRepository extends CrudRepository<GBuff, String>{
	
}
