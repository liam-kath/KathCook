package com.kath.cook.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kath.cook.domain.FoodsCook;
import com.kath.cook.domain.MainCook;
import com.kath.cook.domain.TepCook;
import com.kath.cook.service.CookService;
import com.kath.cook.service.impl.CookServiceImpl;
import com.kath.cook.utils.JsonResult;

@Controller
@RequestMapping("/CookController")
public class CookController {
	@Autowired
	private CookService cookService = new CookServiceImpl();

	/*
	 * 菜谱上传
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody JsonResult upload(MainCook mainCook,
			@RequestParam(value = "file") MultipartFile[] file,
			@RequestParam(value = "foodName") String[] foodName,
			@RequestParam(value = "foodNumber") String[] foodNumber,
			@RequestParam(value = "cookTepDetail") String[] cookTepDetail,
			HttpServletRequest request) throws IllegalStateException,
			IOException {
		// 获得物理路径webapp所在路径
		String pathRoot = request.getSession().getServletContext()
				.getRealPath("");
		String path = "";
		List<TepCook> listTepCooks = new ArrayList<TepCook>();
		List<FoodsCook> listFoodsCooks = new ArrayList<FoodsCook>();
		if (file.length > 0) {
			for (int i = 0; i < file.length; i++) {
				if (file[i] != null) {
					TepCook tepCook = new TepCook();
					// 生成uuid作为文件名称
					String uuid = UUID.randomUUID().toString()
							.replaceAll("-", "");
					// 获得文件类型（可以判断如果不是图片，禁止上传）
					String contentType = file[i].getContentType();
					// 获得文件后缀名称
					String imageName = contentType.substring(contentType
							.indexOf("/") + 1);
					path = "/images/tep_images/" + uuid + "." + imageName;
					file[i].transferTo(new File(pathRoot + path));
					String pString = "/cook/images/tep_images/" + uuid + "."
							+ imageName;
					tepCook.setCookId(mainCook.getId());
					tepCook.setTepLink(pString);
					tepCook.setCookTepDetail(cookTepDetail[i]);
					listTepCooks.add(tepCook);
				}
			}
		}
		if (foodName.length > 0) {
			for (int i = 0; i < foodName.length; i++) {
				FoodsCook foodsCook = new FoodsCook();
				foodsCook.setCookId(mainCook.getId());
				foodsCook.setFoodName(foodName[i]);
				foodsCook.setFoodNumber(foodNumber[i]);
				listFoodsCooks.add(foodsCook);
			}
		}
		mainCook.setListfFoodsCooks(listFoodsCooks);
		mainCook.setListTepCooks(listTepCooks);
		JsonResult jsonResult = new JsonResult(
				cookService.insertCooks(mainCook));
		return jsonResult;
	}
	/*
	 * 修改菜谱信息
	 */
	@RequestMapping(value = "/updateCook", method = RequestMethod.POST)
	public @ResponseBody JsonResult updateCook(MainCook mainCook,
			@RequestParam(value = "file") MultipartFile[] file,
			@RequestParam(value = "foodName") String[] foodName,
			@RequestParam(value = "foodid") Integer[] foodid,
			@RequestParam(value = "foodNumber") String[] foodNumber,
			@RequestParam(value = "tepid") Integer[] tepid,
			@RequestParam(value = "cookTepDetail") String[] cookTepDetail,
			HttpServletRequest request) throws IllegalStateException,
			IOException {
		// 获得物理路径webapp所在路径
		String pathRoot = request.getSession().getServletContext()
				.getRealPath("");
		String path = "";
		List<TepCook> listTepCooks = new ArrayList<TepCook>();
		List<FoodsCook> listFoodsCooks = new ArrayList<FoodsCook>();
		if (file.length > 0) {
			int n = 0;
			for (int i = file.length; i < file.length; i--) {
				if (file[i] != null) {
					n=n+1;
					TepCook tepCook = new TepCook();
					// 生成uuid作为文件名称
					String uuid = UUID.randomUUID().toString()
							.replaceAll("-", "");
					// 获得文件类型（可以判断如果不是图片，禁止上传）
					String contentType = file[i].getContentType();
					// 获得文件后缀名称
					String imageName = contentType.substring(contentType
							.indexOf("/") + 1);
					path = "/images/tep_images/" + uuid + "." + imageName;
					file[i].transferTo(new File(pathRoot + path));
					String pString = "/cook/images/tep_images/" + uuid + "."
							+ imageName;
					tepCook.setCookId(mainCook.getId());
					tepCook.setTepLink(pString);
					tepCook.setCookTepDetail(cookTepDetail[cookTepDetail.length-n]);
					listTepCooks.add(tepCook);
				}
			}
		}
		if (tepid.length>0) {
			for (int i = 0; i < tepid.length; i++) {
				TepCook tepCook = new TepCook();
				tepCook.setId(tepid[i]);
				tepCook.setCookTepDetail(cookTepDetail[i]);
				listTepCooks.add(tepCook);
			}
		}
		if (foodName.length>0) {
			for (int i = 0; i < foodName.length; i++) {
				FoodsCook foodsCook = new FoodsCook();
				if (foodid[i]!=null) {
					foodsCook.setId(foodid[i]);
					foodsCook.setFoodName(foodName[i]);
					foodsCook.setFoodNumber(foodNumber[i]);
					listFoodsCooks.add(foodsCook);
				}else {
					foodsCook.setFoodName(foodName[i]);
					foodsCook.setFoodNumber(foodNumber[i]);
					listFoodsCooks.add(foodsCook);
				}
			}
		}
		mainCook.setListfFoodsCooks(listFoodsCooks);
		mainCook.setListTepCooks(listTepCooks);
		JsonResult jsonResult = new JsonResult(cookService.updateCooks(mainCook));
		return jsonResult;
	}
	/*
	 * 显示所有菜谱信息
	 */
	@RequestMapping(value="/showAllCooks")
	public @ResponseBody JsonResult showAllCooks(){
		return new JsonResult(cookService.showCooks());
	}
	/*
	 * 模糊查询菜谱信息
	 */
	@RequestMapping(value="/searchCooks")
	public @ResponseBody JsonResult searchCooks(String cookName){
		return new JsonResult(cookService.searchCooks(cookName));
	}
	/*
	 * 删除菜谱信息
	 */
	@RequestMapping(value="/delCook")
	public @ResponseBody JsonResult delCook(Integer id){
		return new JsonResult(cookService.delCooks(id));
	}
	/*
	 * 删除步骤信息
	 */
	@RequestMapping(value="/delTep")
	public @ResponseBody JsonResult delTep(Integer id){
		return new JsonResult(cookService.delTepCook(id));
	}
	/**
	 * 删除食材信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delFood")
	public @ResponseBody JsonResult delFood(Integer id){
		return new JsonResult(cookService.delFoodsCook(id));
	}
	/**
	 * 查询菜谱详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/showDetail")
	public @ResponseBody JsonResult showDetail(Integer id){
		return new JsonResult(cookService.showDetailCook(id));
	}
	
}
