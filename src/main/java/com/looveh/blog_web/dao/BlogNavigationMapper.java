package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogNavigation;

public interface BlogNavigationMapper {

    int insert(BlogNavigation record);

    int insertSelective(BlogNavigation record);


}