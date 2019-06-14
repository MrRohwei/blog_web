package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.Blogs;

import java.util.List;

public interface BlogsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Blogs record);

    int insertSelective(Blogs record);

    Blogs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blogs record);

    int updateByPrimaryKeyWithBLOBs(Blogs record);

    int updateByPrimaryKey(Blogs record);

    List<Blogs> selectByBlogs(Blogs record);
}