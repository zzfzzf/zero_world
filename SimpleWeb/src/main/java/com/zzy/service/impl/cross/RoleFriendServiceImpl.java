package com.zzy.service.impl.cross;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.cross.GRoleFriend;
import com.zzy.repository.cross.RoleFriendRepository;
import com.zzy.service.cross.RoleFriendService;
import com.zzy.base.BaseServiceImp;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class RoleFriendServiceImpl extends BaseServiceImp<GRoleFriend> implements RoleFriendService{
	
	@Autowired
	private RoleFriendRepository frRepository;
	@Autowired
	public RoleFriendServiceImpl(CrudRepository<GRoleFriend, String> crudRepository) {
		super(crudRepository);
	}

	@Override
	public Set<GRoleFriend> findByRoleIdLike(String roleId) {
		return frRepository.findByRoleIdLike(roleId);
	}
	 
}
