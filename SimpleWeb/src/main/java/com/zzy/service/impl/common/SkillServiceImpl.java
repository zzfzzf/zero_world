package com.zzy.service.impl.common;

import com.zzy.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GSkill;
import com.zzy.service.common.SkillService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class SkillServiceImpl extends BaseServiceImp<GSkill> implements SkillService{
	@Autowired
	public SkillServiceImpl(CrudRepository<GSkill, String> crudRepository) {
		super(crudRepository);
	}
}
