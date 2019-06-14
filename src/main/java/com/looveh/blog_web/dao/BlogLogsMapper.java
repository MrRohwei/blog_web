package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogLogs;

public interface BlogLogsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BlogLogs record);

    int insertSelective(BlogLogs record);

    BlogLogs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogLogs record);

    int updateByPrimaryKey(BlogLogs record);
}