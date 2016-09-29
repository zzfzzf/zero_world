package com.zzy.service.impl.cross;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.GVocationSkill;
import com.zzy.repository.cross.VocationSkillRepository;
import com.zzy.service.cross.VocationSkillService;
import com.zzy.base.BaseServiceImp;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class VocationSkillServiceImpl extends BaseServiceImp<GVocationSkill> implements VocationSkillService{
	@Autowired
	private VocationSkillRepository vsRepository;
	@Autowired
	public VocationSkillServiceImpl(CrudRepository<GVocationSkill, String> crudRepository) {
		super(crudRepository);
	}
	public List<GVocationSkill> findByVocationIdLike(String vocationId){
		return vsRepository.findByVocationIdLike(vocationId);
	}
}
