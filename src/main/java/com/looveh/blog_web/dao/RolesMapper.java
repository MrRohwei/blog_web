package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.Roles;

public interface RolesMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
}