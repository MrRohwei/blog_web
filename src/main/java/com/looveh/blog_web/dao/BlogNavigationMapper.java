package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogNavigation;

import java.util.List;

public interface BlogNavigationMapper {

    int insert(BlogNavigation record);

    int insertSelective(BlogNavigation record);

    BlogNavigation selectById(Integer id);

    List<BlogNavigation> selectList(BlogNavigation record);

    int update(BlogNavigation record);
}