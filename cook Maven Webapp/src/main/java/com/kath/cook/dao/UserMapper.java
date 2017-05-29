package com.kath.cook.dao;

import java.util.List;

import com.kath.cook.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);
    
    List<User> selectByPassAcc(User user);
    
    List<User> selectByAcc(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}