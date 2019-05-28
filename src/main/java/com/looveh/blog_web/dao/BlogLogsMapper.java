package com.looveh.blog_web.dao;

import com.looveh.blog_web.entity.BlogLogs;

public interface BlogLogsMapper {

    int insert(BlogLogs record);

    int insertSelective(BlogLogs record);

}