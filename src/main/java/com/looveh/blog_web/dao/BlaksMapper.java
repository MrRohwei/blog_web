package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.Blaks;

public interface BlaksMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Blaks record);

    int insertSelective(Blaks record);

    Blaks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blaks record);

    int updateByPrimaryKey(Blaks record);
}