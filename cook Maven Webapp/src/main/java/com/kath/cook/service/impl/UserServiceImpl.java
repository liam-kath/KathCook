package com.kath.cook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kath.cook.dao.UserMapper;
import com.kath.cook.domain.User;
import com.kath.cook.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	public boolean regUser(User user) {
		int size = userMapper.selectByPassAcc(user).size();
		boolean bo = false;
		if (size > 0) {
			bo = false;
		}else {
			int a = userMapper.insert(user);
			if (a==1) {
				bo =  true;
			}			
		}		
		return bo;
	}

	public User loginUser(User user) {
		List<User> userlist = userMapper.selectByPassAcc(user);
		int size = userlist.size();
		if (size > 0) {
			return userlist.get(size-1);
		}
		return null;
	}

}
