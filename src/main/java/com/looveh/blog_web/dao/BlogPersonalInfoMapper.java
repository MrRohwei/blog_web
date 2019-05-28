package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogPersonalInfo;

public interface BlogPersonalInfoMapper {

    int insert(BlogPersonalInfo record);

    int insertSelective(BlogPersonalInfo record);
}