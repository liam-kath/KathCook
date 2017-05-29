package com.kath.cook.service;

import java.util.List;

import com.kath.cook.domain.MainCook;

public interface CookService {
	//获取所有菜谱信息
	public List<MainCook> showCooks();
	//修改菜谱信息
	public boolean updateCooks(MainCook mainCooks);
	//添加菜谱信息
	public boolean insertCooks(MainCook mainCook);
	//模糊搜索菜谱信息
	public List<MainCook> searchCooks(String cook);
	//查看菜谱详细信息
	public MainCook showDetailCook(Integer id);
	//删除菜谱信息
	public boolean delCooks(Integer id);
	//删除菜谱步骤信息
	public int delTepCook(Integer id);
	//删除食物信息
	public int delFoodsCook(Integer id);
	
}
