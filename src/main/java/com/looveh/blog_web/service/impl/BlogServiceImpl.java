package com.looveh.blog_web.service.impl;

import com.looveh.blog_web.controller.admin.blogs.dto.PageBlogDto;
import com.looveh.blog_web.dao.BlogsMapper;
import com.looveh.blog_web.entity.Blogs;
import com.looveh.blog_web.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Looveh
 * @Date 2019/6/14/014 14:35
 * @Version 1.0
 * @Desc TODO
 **/
@Service
public class BlogServiceImpl implements BlogsService {

    @Autowired
    BlogsMapper blogsMapper;

    @Override
    public PageBlogDto findList(Blogs blogs) {
        List<Blogs> blogs1 = blogsMapper.selectByBlogs(blogs);


        return blogsMapper.selectByBlogs(blogs);
    }

    @Override
    public Integer createBlog(Blogs blogs) {
        blogsMapper.insert(blogs);
        return blogs.getId();
    }
}
