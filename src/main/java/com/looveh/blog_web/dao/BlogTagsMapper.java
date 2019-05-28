package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogTags;

public interface BlogTagsMapper {

    int insert(BlogTags record);

    int insertSelective(BlogTags record);

}