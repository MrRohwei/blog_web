package com.looveh.blog_web.dao;


import com.looveh.blog_web.entity.UserRoles;

public interface UserRolesMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserRoles record);

    int insertSelective(UserRoles record);

    UserRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoles record);

    int updateByPrimaryKey(UserRoles record);
}