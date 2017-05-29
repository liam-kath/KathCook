package com.kath.cook.dao;

import java.util.List;

import com.kath.cook.domain.TepCook;

public interface TepCookMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByCookKey(Integer id);
    
    int insert(TepCook record);

    int insertSelective(TepCook record);

    TepCook selectByPrimaryKey(Integer id);
    
    List<TepCook> selectByAll();
    
    List<TepCook> selectByCookKey(Integer id);

    int updateByPrimaryKeySelective(TepCook record);

    int updateByPrimaryKey(TepCook record);
}