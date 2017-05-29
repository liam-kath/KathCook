package com.kath.cook.service;

import com.kath.cook.domain.User;

public interface UserService {
	//用户注册
	public boolean regUser(User user);
	//用户登录
	public User loginUser(User user);
	
}
