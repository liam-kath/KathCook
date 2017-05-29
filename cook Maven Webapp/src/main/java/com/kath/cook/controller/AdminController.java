package com.kath.cook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kath.cook.domain.Admin;
import com.kath.cook.service.AdminService;
import com.kath.cook.service.impl.AdminServiceImpl;
import com.kath.cook.utils.JsonResult;
@Controller
@RequestMapping("/AdminController")
public class AdminController {
	@Autowired
	private AdminService adminService = new AdminServiceImpl();
	@RequestMapping(value="/Login")
	public @ResponseBody JsonResult Login(Admin admin,HttpSession session){
		Admin admin2 = new Admin();
		admin2 = adminService.Login(admin);
		if (admin2!=null) {
			session.setAttribute("admin", admin2);
		}
		JsonResult jsonResult = new JsonResult(admin2);
		return jsonResult;
	}
}
