package com.kath.cook.dao;

import java.util.List;

import com.kath.cook.domain.MainCook;

public interface MainCookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MainCook record);

    int insertSelective(MainCook record);

    MainCook selectByPrimaryKey(Integer id);
    
    List<MainCook> searchCook(String cookName);
    
    List<MainCook> selectByAll();

    int updateByPrimaryKeySelective(MainCook record);

    int updateByPrimaryKey(MainCook record);
}