package com.kath.cook.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kath.cook.domain.User;
import com.kath.cook.service.UserService;
import com.kath.cook.service.impl.UserServiceImpl;
import com.kath.cook.utils.JsonResult;

@Controller
@RequestMapping("/UserController")
public class UserController {
	@Autowired
	private UserService userService = new UserServiceImpl();
	/*
	 * 用户注册
	 */
	@RequestMapping(value="/Register")
	public @ResponseBody JsonResult Register(User user) {
		JsonResult jsonResult = new JsonResult(userService.regUser(user));
		return jsonResult;
	}
	/*
	 * 用户登录
	 */
	@RequestMapping(value="/Login")
	public @ResponseBody JsonResult Login(User user){
		JsonResult jsonResult = new JsonResult(userService.loginUser(user));
		return jsonResult;
	}
	@RequestMapping(value="test")
	public @ResponseBody JsonResult Login1(HttpServletRequest request){
		String[] string = request.getParameterValues("name");
		String string2 = "["+string+"]";
//		JSONArray jsonArray = JSONArray.fromObject(string2);
//		if (jsonArray!=null) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				JSONObject jsonObject = jsonArray.getJSONObject(i);
//				System.out.println("*****"+jsonObject.getString("name"));
//			}
//		}
		for (int i = 0; i < string.length; i++) {
			System.out.println("******"+string[i]);
		}
		
		
		JsonResult jsonResult = new JsonResult();
		return jsonResult;
	}
}
