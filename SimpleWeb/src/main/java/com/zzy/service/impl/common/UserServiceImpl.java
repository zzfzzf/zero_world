package com.zzy.service.impl.common;

import java.util.List;

import com.zzy.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.ZUser;
import com.zzy.repository.common.UserRepository;
import com.zzy.service.common.UserService;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class UserServiceImpl extends BaseServiceImpl<ZUser> implements UserService{
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

	@Override
	public ZUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean login(ZUser user) {
		ZUser tuser= userRepository.findByUsername(user.getUsername());
		boolean result = false;
		if(tuser != null){
			result = user.getPassword().equals(tuser.getPassword());
		}
		return result;
	}
}
