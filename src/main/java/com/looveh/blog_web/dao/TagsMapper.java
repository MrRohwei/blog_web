package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.Tags;

public interface TagsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Tags record);

    int insertSelective(Tags record);

    Tags selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);
}