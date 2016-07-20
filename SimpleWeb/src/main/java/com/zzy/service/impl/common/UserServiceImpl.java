package com.zzy.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.ZUser;
import com.zzy.repository.common.UserRepository;
import com.zzy.service.common.UserService;
import com.zzy.service.cross.UserPositionService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class UserServiceImpl extends BaseServiceImp<ZUser> implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	public UserServiceImpl(CrudRepository<ZUser, String> crudRepository) {
		super(crudRepository);
	}

	@Override
	public List<ZUser> findByStatusNot(int status) {
		return userRepository.findByStatusNot(status);
	}
}
