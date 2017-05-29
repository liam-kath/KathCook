package com.kath.cook.dao;

import java.util.List;

import com.kath.cook.domain.FoodsCook;

public interface FoodsCookMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByCookKey(Integer id);

    int insert(FoodsCook record);

    int insertSelective(FoodsCook record);

    List<FoodsCook> selectByAll();
    
    List<FoodsCook> selectByCookKey(Integer id);
    
    FoodsCook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoodsCook record);

    int updateByPrimaryKey(FoodsCook record);
}