package com.looveh.blog_web.service;

import com.looveh.blog_web.controller.admin.blogs.dto.PageBlogDto;
import com.looveh.blog_web.entity.Blogs;

/**
 * @Author Looveh
 * @Date 2019/6/14/014 14:34
 * @Version 1.0
 * @Desc TODO
 **/
public interface BlogsService {

    PageBlogDto findList(Blogs blogs);

    Integer createBlog(Blogs blogs);
}
