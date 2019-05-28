package com.looveh.blog_web.service.impl;

import com.looveh.blog_web.dao.BlogLogsMapper;
import com.looveh.blog_web.entity.BlogLogs;
import com.looveh.blog_web.service.BlogLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author：looveh
 * Date：2019/5/28
 * Desc: This is Class
 */
@Service
public class BlogLogServiceImpl implements BlogLogService {

    @Autowired
    private BlogLogsMapper blogLogsMapper;

    @Override
    public int saveLog(BlogLogs blogLogs) {
        int insert = blogLogsMapper.insert(blogLogs);
        return insert;
    }
}
