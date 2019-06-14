package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.Comments;
public interface CommentsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}