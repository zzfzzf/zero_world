package com.zzy.repository.cross;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zzy.domain.cross.GVocationSkill;

/** 
* @author zero
* @version 1.0.0
* @date:2016年4月1日
* @description:
*/
public interface VocationSkillRepository extends CrudRepository<GVocationSkill, String>{
	public List<GVocationSkill> findByVocationIdLike(String vocationId);
}

