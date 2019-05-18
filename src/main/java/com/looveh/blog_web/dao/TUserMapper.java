package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.TUser;

import java.util.List;

public interface TUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    List<TUser> selectByTUser(TUser record);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}