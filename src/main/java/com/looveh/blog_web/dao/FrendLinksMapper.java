package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.FrendLinks;

public interface FrendLinksMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(FrendLinks record);

    int insertSelective(FrendLinks record);

    FrendLinks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrendLinks record);

    int updateByPrimaryKey(FrendLinks record);
}