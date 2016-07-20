package com.zzy.service.cross;

import java.util.List;

import com.zzy.domain.cross.GVocationSkill;
import com.zzy.service.common.BaseService;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年6月30日 
* @decript:
*/
public interface VocationSkillService extends BaseService<GVocationSkill>{
	public List<GVocationSkill> findByVocationIdLike(String vocationId);
}
