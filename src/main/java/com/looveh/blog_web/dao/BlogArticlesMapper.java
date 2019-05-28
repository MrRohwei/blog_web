package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogArticles;

public interface BlogArticlesMapper {

    int insert(BlogArticles record);

    int insertSelective(BlogArticles record);
}