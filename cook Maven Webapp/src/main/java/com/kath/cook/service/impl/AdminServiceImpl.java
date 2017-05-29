package com.kath.cook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kath.cook.dao.AdminMapper;
import com.kath.cook.domain.Admin;
import com.kath.cook.domain.User;
import com.kath.cook.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	/*
	 * (non-Javadoc)
	 * @see com.kath.cook.service.AdminService#Login(com.kath.cook.domain.Admin)
	 */
	public Admin Login(Admin admin) {
		List<Admin> adminlist = adminMapper.selectByPassAcc(admin);
		int size = adminlist.size();
		if (size > 0) {
			return adminlist.get(size-1);
		}
		return null;
	}

}
