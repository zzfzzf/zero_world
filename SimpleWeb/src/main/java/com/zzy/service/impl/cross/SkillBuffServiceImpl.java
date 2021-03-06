package com.zzy.service.impl.cross;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.GSkillBuff;
import com.zzy.service.cross.SkillBuffService;
import com.zzy.base.BaseServiceImpl;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class SkillBuffServiceImpl extends BaseServiceImpl<GSkillBuff> implements SkillBuffService{
	@Autowired
	public SkillBuffServiceImpl(CrudRepository<GSkillBuff, String> crudRepository) {
		super(crudRepository);
	}
}
