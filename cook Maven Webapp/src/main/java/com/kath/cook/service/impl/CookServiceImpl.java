package com.kath.cook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kath.cook.dao.FoodsCookMapper;
import com.kath.cook.dao.MainCookMapper;
import com.kath.cook.dao.TepCookMapper;
import com.kath.cook.domain.FoodsCook;
import com.kath.cook.domain.MainCook;
import com.kath.cook.domain.TepCook;
import com.kath.cook.service.CookService;

@Service
public class CookServiceImpl implements CookService {
	@Autowired
	private MainCookMapper mainCookMapper;
	@Autowired
	private TepCookMapper tepCookMapper;
	@Autowired
	private FoodsCookMapper foodsCookMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kath.cook.service.CookService#showCooks()
	 */
	public List<MainCook> showCooks() {
		List<MainCook> listmMainCooks = new ArrayList<MainCook>();
		List<MainCook> list = mainCookMapper.selectByAll();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				MainCook mainCook = new MainCook();
				mainCook.setCookName(list.get(i).getCookName());
				mainCook.setId(list.get(i).getId());
				mainCook.setUserId(list.get(i).getUserId());
				if (foodsCookMapper.selectByCookKey(list.get(i).getId()).size() > 0) {
					mainCook.setListfFoodsCooks(foodsCookMapper
							.selectByCookKey(list.get(i).getId()));
				}
				if (tepCookMapper.selectByCookKey(list.get(i).getId()).size() > 0) {
					mainCook.setListTepCooks(tepCookMapper.selectByCookKey(list
							.get(i).getId()));
				}
				listmMainCooks.add(mainCook);
			}
		}
		return listmMainCooks;
	}
	/*
	 * (non-Javadoc)
	 * @see com.kath.cook.service.CookService#updateCooks(com.kath.cook.domain.MainCook)
	 */
	public boolean updateCooks(MainCook mainCooks) {
		List<TepCook> listTepCooks = mainCooks.getListTepCooks();
		List<FoodsCook> listFoodsCooks = mainCooks.getListfFoodsCooks();
		if (listTepCooks.size()>0) {
			for (int i = 0; i < listTepCooks.size(); i++) {
				if (listTepCooks.get(i).getId()!=null) {
					tepCookMapper.updateByPrimaryKeySelective(listTepCooks.get(i));
				}else {
					listTepCooks.get(i).setCookId(mainCooks.getId());
					tepCookMapper.insertSelective(listTepCooks.get(i));
				}
			}
		}
		if (listFoodsCooks.size()>0) {
			for (int i = 0; i < listFoodsCooks.size(); i++) {
				
				if (listFoodsCooks.get(i).getId()!=null) {
					foodsCookMapper.updateByPrimaryKeySelective(listFoodsCooks.get(i));
				}else {
					listFoodsCooks.get(i).setCookId(mainCooks.getId());
					foodsCookMapper.insertSelective(listFoodsCooks.get(i));
				}
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kath.cook.service.CookService#insertCooks(com.kath.cook.domain.MainCook
	 * )
	 */
	public boolean insertCooks(MainCook mainCook) {
		mainCookMapper.insertSelective(mainCook);
		if (mainCook.getListfFoodsCooks().size() > 0) {
			for (int i = 0; i < mainCook.getListfFoodsCooks().size(); i++) {
				foodsCookMapper.insertSelective(mainCook.getListfFoodsCooks()
						.get(i));
			}
		}
		if (mainCook.getListTepCooks().size() > 0) {
			for (int i = 0; i < mainCook.getListTepCooks().size(); i++) {
				tepCookMapper
						.insertSelective(mainCook.getListTepCooks().get(i));
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kath.cook.service.CookService#searchCooks(java.lang.String)
	 */
	public List<MainCook> searchCooks(String cook) {
		List<MainCook> listmMainCooks = new ArrayList<MainCook>();
		List<MainCook> list = mainCookMapper.searchCook(cook);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				MainCook mainCook = new MainCook();
				mainCook.setCookName(list.get(i).getCookName());
				mainCook.setId(list.get(i).getId());
				mainCook.setUserId(list.get(i).getUserId());
				if (foodsCookMapper.selectByCookKey(list.get(i).getId()).size() > 0) {
					mainCook.setListfFoodsCooks(foodsCookMapper
							.selectByCookKey(list.get(i).getId()));
				}
				if (tepCookMapper.selectByCookKey(list.get(i).getId()).size() > 0) {
					mainCook.setListTepCooks(tepCookMapper.selectByCookKey(list
							.get(i).getId()));
				}
				listmMainCooks.add(mainCook);
			}
		}

		return listmMainCooks;
	}
	/*
	 * (non-Javadoc)
	 * @see com.kath.cook.service.CookService#showDetailCook(java.lang.Integer)
	 */
	public MainCook showDetailCook(Integer id) {
		MainCook mainCook = mainCookMapper.selectByPrimaryKey(id);
		mainCook.setListfFoodsCooks(foodsCookMapper.selectByCookKey(mainCook.getId()));
		mainCook.setListTepCooks(tepCookMapper.selectByCookKey(mainCook.getId()));
		return mainCook;
	}
	/*
	 * (non-Javadoc)
	 * @see com.kath.cook.service.CookService#delCooks(java.lang.Integer)
	 */
	public boolean delCooks(Integer id) {
		tepCookMapper.deleteByCookKey(id);
		foodsCookMapper.deleteByCookKey(id);
		mainCookMapper.deleteByPrimaryKey(id);
		return true;
	}
	/*
	 * (non-Javadoc)
	 * @see com.kath.cook.service.CookService#delTepCook(java.lang.Integer)
	 */
	public int delTepCook(Integer id) {
		return tepCookMapper.deleteByPrimaryKey(id);
	}
	/*
	 * (non-Javadoc)
	 * @see com.kath.cook.service.CookService#delFoodsCook(java.lang.Integer)
	 */
	public int delFoodsCook(Integer id) {
		return foodsCookMapper.deleteByPrimaryKey(id);
	}

}
