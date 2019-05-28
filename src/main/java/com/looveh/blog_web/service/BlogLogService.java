package com.looveh.blog_web.service;

import com.looveh.blog_web.entity.BlogLogs;

/**
 * Author：looveh
 * Date：2019/5/28
 * Desc: This is Interface
 */

public interface BlogLogService {

    int saveLog(BlogLogs blogLogs);
}
