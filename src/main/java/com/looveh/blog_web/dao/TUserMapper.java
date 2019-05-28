package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogUser;

import java.util.List;

public interface TUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    BlogUser selectByPrimaryKey(Integer id);

    List<BlogUser> selectByTUser(BlogUser record);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}