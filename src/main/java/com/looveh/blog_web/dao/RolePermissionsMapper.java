package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.RolePermissions;

public interface RolePermissionsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissions record);

    int insertSelective(RolePermissions record);

    RolePermissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermissions record);

    int updateByPrimaryKey(RolePermissions record);
}