package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogUser;

public interface BlogUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    BlogUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}